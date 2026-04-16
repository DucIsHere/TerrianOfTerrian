package com.regenerationforrged.world.worldgen;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderGetter;
import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.world.worldgen.cell.heightmap.Heightmap;
import com.regenerationforrged.world.worldgen.cell.heightmap.Levels;
import com.regenerationforrged.world.worldgen.cell.heightmap.WorldLookup;
import com.regenerationforrged.world.worldgen.densityfunction.tile.TileCache;
import com.regenerationforrged.world.worldgen.densityfunction.tile.generation.TileGenerator;
import com.regenerationforrged.world.worldgen.noise.module.Noise;
import com.regenerationforrged.world.worldgen.noise.module.Noises;
import com.regenerationforrged.world.worldgen.util.Seed;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.*;

public class GeneratorContext {
    public Seed seed;
    public Levels levels;
    public Preset preset;
    public HolderGetter<Noise> noiseLookup;
    public TileGenerator generator;
    @Nullable
    public TileCache cache;
    public WorldLookup lookup;
    public Noise windX;
    public Noise windZ;
    public Noise faultNoise;
    public Noise upliftNoise;
    
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

        this.generator = new TileGenerator(heightMap.male(this), new worldFilters(this), tileSize, tileBorder, batchCount);
        this.cache = cache;
        this.lookup = new WorldLookup(this);
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
