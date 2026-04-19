package com.regenerationforrged.world.worldgen;

import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

import net.minecraft.core.HolderGetter;

import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.world.worldgen.cell.heightmap.Heightmap;
import com.regenerationforrged.world.worldgen.cell.heightmap.Levels;
import com.regenerationforrged.world.worldgen.cell.heightmap.WorldLookup;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Size;
import com.regenerationforrged.world.worldgen.densityfunction.tile.TileCache;
import com.regenerationforrged.world.worldgen.densityfunction.tile.generation.TileGenerator;
import com.regenerationforrged.world.worldgen.noise.module.Noise;
import com.regenerationforrged.world.worldgen.noise.module.Noises;
import com.regenerationforrged.world.worldgen.util.Seed;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.AeroErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.GlacialErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.HydarulicErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.ForceErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.ThermalErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.LandSlide;

public class GeneratorContext {
    public Seed seed;
    public Levels levels;
    public Preset preset;
    public HolderGetter<Noise> noiseLookup;
    public TileGenerator generator;
    @Nullable
    public TileCache cache;
    public WorldLookup lookup;
    // CLASS GEOLOGY NOISES
    public Noise windX;
    public Noise windZ;
    public Noise faultNoise;
    public Noise upliftNoise;
    public Noise stabilityNoise;
    // FACTORY METHOS (LAZY-LOADING)
    public final IntFunction<ForceErosion> forceErosionFactory;
    public final IntFunction<AeroErosion> aeroErosionFactory;
    public final IntFunction<GlacialErosionFull> glacialErosionFactory;
    public final IntFunction<Erosion> hydraulicErosionFactory;
    public final IntFunction<ThermalErosion> thermalErosionFactory;
    public final IntFunction<LandSlide> landSlideFactory;
    
    public GeneratorContext(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int tileBorder, int batchCount, @Nullable TileCache cache) {
        this.preset = preset;
        this.noiseLookup = noiseLookup;
        this.seed = new Seed(seed);
        this.levels = new Levels(preset.world().properties.terrainScaler(), preset.world().properties.seaLevel);

        this.windX = Noises.perlin(this.seed.next(), 1500, 1);
        this.windZ = Noises.perlin(this.seed.next(), 1500, 1);

        Noise faultNoise = Noises.perlin(this.seed.next(), 1500, 2);
        this.faultNoise = Noises.warpPerlin(baseFault, this.seed.next(), 300, 2, 200.0F);

        Noise baseUplift = Noises.perlin(this.seed.next(), 2000, 3);
        this.upliftNoise = Noises.warpPerlin(baseUplift, this.seed.next(), 400, 3, 350.0F);

        this.forceErosionFactory = ForceErosion.factory(this);

        this.aeroErosionFactory = AeroErosion.factory(this);

        this.glacialErosionFactory = GlacialErosionFull.factory(this);

        this.hydraulicErosionFactory = Erosion.factory(this);

        this.thermalErosionFactory = ThermalErosion.factory(this);
        
        this.landSlideFactory = LandSlide.factory(this);

        this.generator = new TileGenerator(heightMap.make(this), new worldFilters(this), tileSize, tileBorder, batchCount);
        this.cache = cache;
        this.lookup = new WorldLookup(this);
        this.stabilityNoise = Noises.cellular(this.seed.next(), 250);
    }

    public static GeneratorContext makeCached(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int batchCount, boolean queue) {
    	GeneratorContext ctx = makeUncached(preset, noiseLookup, seed, tileSize, Math.min(2, Math.max(1, preset.filters().erosion.dropletLifetime / 16)), batchCount);
    	ctx.cache = new TileCache(tileSize, queue, ctx.generator);
    	ctx.lookup = new WorldLookup(ctx);
    	return ctx;
    }
    
    public static GeneratorContext makeUncached(Preset preset, HolderGetter<Noise> noiseLookup, int seed, int tileSize, int tileBorder, int batchCount) {
    	return new GeneratorContext(preset, noiseLookup, seed, tileSize, tileBorder, batchCount, null);
    }
}
