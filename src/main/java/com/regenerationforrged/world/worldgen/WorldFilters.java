package com.regenerationforrged.world.worldgen;

import java.util.function.IntFunction;

import com.regenerationforrged.world.worldgen.densityfunction.tile.Modifier;

import com.regenerationforrged.data.worldgen.preset.settings.FilterSettings;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Tile;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.AeroErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.ThermalErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.BeachDetect;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Erosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Filterable;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.GlacialEros;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.NoiseCorrection;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Smoothing;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Steepness;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.AdvancedSoilFluction;

public class WorldFilters {
    private Smoothing smoothing;
    private Steepness steepness;
    private BeachDetect beach;
    private NoiseCorrection corrections;
    private FilterSettings settings;
    private WorldErosion<Erosion> erosion;
    
    private final WorldErosion<ForceErosion> forceErosion;
    private final WorldErosion<AeroErosion> aeroErosion;
    private final WorldErosion<GlacialErosionFull> glacialErosion;
    private final WorldErosion<Erosion> hydraulicErosion;
    private final WorldErosion<ThermalErosion> thermalErosion;
    private final WorldErosion<LandSlide> landSlide;
    private final WorldErosion<AdvancedSoilFluction> soilFluction;

    private final int erosionIterations;
    private final int smoothingIterations;
    private final int glacialIterations;
    private final int soilIterations;
    
    public WorldFilters(GeneratorContext context) {
        this.settings = context.preset.filters();

        this.beach = BeachDetect.make(context);
        this.smoothing = Smoothing.make(context.preset.filters().smoothing, context.levels);
        this.steepness = Steepness.make(1, 10.0F, context.levels);
        this.corrections = new NoiseCorrection(context.levels);
        
        IntFunction<HydraulicErosion> hydraulicFactory = Erosion.factory(context);
        
        IntFunction<AeroErosion> aeroFactory = (size) -> new AeroErosion(
            size, context.windX, context.windZ, 0.015F, 0.3F,
            context.levels.water + 1.0F,
            Modifier.range(context.levels.ground, context.levels.ground(120)).invert()
        );

        IntFunction<ThermalErosion> thermalFactory = (size) -> 
            new ThermalErosion(size, 0.15F, 0.5F, Modifier.DEFAULT);

        IntFunction<ForceErosion> forceFactory = (size) -> 
            new ForceErosion(size, context.faultNoise, 15.0F, 0.8F, 3.0F, 
                             context.upliftNoise, 35.0F, 0.6F, Modifier.DEFAULT);

        IntFunction<LandSlide> landSlideFactory = (size) -> 
            new LandSlide(size, context.stabilityNoise, 0.25F, Modifier.DEFAULT);

        IntFunction<GlacialErosion> glacialFactory = (size) -> 
            new GlacialErosion(size, settings.glacial, context.seed);

        IntFunction<AdvancedSoilFluction> soilFactory = (size) ->
            new AdvancedSoilFluction(size, context.soilFluctionNoise, settings.soilFluction, context.seed);

        this.forceErosion = new WorldErosion<>(context.forceErosionFactory, (f, size) -> f.getSize() == size);
        this.aeroErosion = new WorldErosion<>(context.aeroErosionFactory, (a, size) -> a.getSize() == size);
        this.glacialErosion = new WorldErosion<>(context.glacialErosionFactory, (g, size) -> g.getSize() == size);
        this.hydraulicErosion = new WorldErosion<>(context.hydraulicErosionFactory, (e, size) -> e.getSize() == size);
        this.thermalErosion = new WorldErosion<>(context.thermalErosionFactory, (t, size) -> t.getSize() == size);
        this.landSlide = new WorldErosion<>(context.landSlideFactory, (l, size) -> l.getSize() == size);
        this.soilFluction = new WorldErosion<>(AdvancedSoilFluction.factory(context), (s, size) -> s.getSize() == size);
        this.soilIterations = settings.soilFluction.iterations;

        this.erosionIterations = context.preset.filters().erosion.dropletsPerChunk;
        this.smoothingIterations = context.preset.filters().smoothing.iterations;
    }
    
    public FilterSettings getSettings() {
        return this.settings;
    }
    
    public void apply(Tile tile, boolean optionalFilters) {
        int regionX = tile.getX();
        int regionZ = tile.getZ();
        
        if (optionalFilters) {
            this.applyOptionalFilters(tile, regionX, regionZ);
        }
        this.applyRequiredFilters(tile, regionX, regionZ);

        this.applyRequiredFilters(tile, regionX, regionZ);

        if(optionalFilters) {
        	this.applyCorrections(tile, regionX, regionZ);
        }
    }
    
    private void applyRequiredFilters(Filterable map, int seedX, int seedZ) {
        this.steepness.apply(map, seedX, seedZ, 1);
        this.beach.apply(map, seedX, seedZ, 1);
    }
    
    private void applyOptionalFilters(Filterable map, int seedX, int seedZ) {
        // Lấy kích thước tổng (total size) của Tile hiện tại để request Cache
        int size = map.getBlockSize().total();

        // ============================================================
        // BƯỚC 1: KIẾN TẠO NỘI LỰC (FORCE)
        // Tạo nếp gấp núi (Uplift) và hẻm vực đứt gãy (Faulting).
        // ============================================================
        this.forceErosion.get(size).apply(map, seedX, seedZ, 1);
        
        // ============================================================
        // BƯỚC 2: KHÍ QUYỂN (AERO)
        // Gió thổi bay và bào mòn các đỉnh núi nhọn hoắt do noise tạo ra.
        // ============================================================
        this.aeroErosion.get(size).apply(map, seedX, seedZ, 4);
        
        // ============================================================
        // BƯỚC 3: BĂNG HÀ (GLACIAL)
        // Khối lượng băng khổng lồ trượt xuống nạo vét các thung lũng chữ U lớn.
        // Phải chạy trước nước để tạo không gian rộng cho sông ngòi.
        // ============================================================
        this.glacialErosion.get(size).apply(map, seedX, seedZ, this.glacialIterations);

        // ============================================================
        // BƯỚC 4: THỦY VĂN (HYDRAULIC)
        // Nước mưa rơi xuống, hội tụ thành suối và xẻ rãnh chữ V bên trong thung lũng.
        // ============================================================
        Erosion erosion = this.erosion.get(map.getBlockSize().total());
        erosion.apply(map, seedX, seedZ, this.erosionIterations);

        // ============================================================
        // BƯỚC 5: TRỌNG LỰC & SỤP ĐỔ (THERMAL & LANDSLIDE)
        // Đất đá bị nước/băng nạo vét trở nên mất ổn định. 
        // Thermal cân bằng lại góc nghiêng (Talus). Landslide kích hoạt sạt lở mảng lớn.
        // ============================================================
        this.thermalErosion.get(size).apply(map, seedX, seedZ, 2);
        this.landSlide.get(size).apply(map, seedX, seedZ, 1);

        this.soilFluction.get(size).apply(map, seedX, seedZ, 4);
        
        // ============================================================
        // BƯỚC 6: LÀM MƯỢT (SMOOTHING)
        // Xóa bỏ các gai nhiễu (spikes) cuối cùng trước khi chuyển sang Voxel.
        // ============================================================
        this.smoothing.apply(map, seedX, seedZ, this.smoothingIterations);
    }
    
    public void applyCorrections(Filterable map, int seedX, int seedZ) {
        this.corrections.apply(map, seedX, seedZ, 1);
    }
}
