package com.regenerationforrged.world.worldgen;

import java.util.function.IntFunction;

import javax.lang.model.element.Modifier;

import com.regenerationforrged.data.worldgen.preset.settings.FilterSettings;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Tile;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.AeroErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.ThermalErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.BeachDetect;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.HydraulicErosion;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Filterable;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.NoiseCorrection;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Smoothing;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.Steepness;

public class WorldFilters {
    private Smoothing smoothing;
    private Steepness steepness;
    private BeachDetect beach;
    private NoiseCorrection corrections;
    private FilterSettings settings;
    private WorldErosion<Erosion> erosion;
    private int erosionIterations;
    private int smoothingIterations;
    private AeroErosion aeroErosion;
    private ThermalErosion thermalErosion;
    
    public WorldFilters(GeneratorContext context) {
        IntFunction<Erosion> factory = Erosion.factory(context);
        this.settings = context.preset.filters();
        this.areoErosion = new AeroErosion(context.windX, context.windZ, 0.015F, 0.3F,
            context.level.water + 1.0F,
            Modifier.range(context.level.ground, context.level.ground(120)).invert()
        );
        this.thetmalErosion = new ThermalErosion(0.15F, 0.5F, Modifier.DEFAULT);
        this.beach = BeachDetect.make(context);
        this.smoothing = Smoothing.make(context.preset.filters().smoothing, context.levels);
        this.steepness = Steepness.make(1, 10.0F, context.levels);
        this.corrections = new NoiseCorrection(context.levels);
        this.erosion = new WorldErosion<>(factory, (e, size) -> e.getSize() == size);
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
        if(optionalFilters) {
        	this.applyCorrections(tile, regionX, regionZ);
        }
    }
    
    private void applyRequiredFilters(Filterable map, int seedX, int seedZ) {
        this.steepness.apply(map, seedX, seedZ, 1);
        this.beach.apply(map, seedX, seedZ, 1);
    }
    
    private void applyOptionalFilters(Filterable map, int seedX, int seedZ) {
        Erosion erosion = this.erosion.get(map.getBlockSize().total());
        erosion.apply(map, seedX, seedZ, this.erosionIterations);
        this.aeroErosion(map, seedX, seedZ, 4);
        this.ThermalErosion(map, seedX, seedZ, 2);
        this.smoothing.apply(map, seedX, seedZ, this.smoothingIterations);
    }
    
    public void applyCorrections(Filterable map, int seedX, int seedZ) {
        this.corrections.apply(map, seedX, seedZ, 1);
    }
}
