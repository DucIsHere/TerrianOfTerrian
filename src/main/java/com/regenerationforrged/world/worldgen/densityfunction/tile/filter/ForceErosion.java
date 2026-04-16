package com.regenerationforrged.world.worldgen.densityfunction.tile.filter;

import com.regenerationforrged.world.worldgen.GeneratorContext;
import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Size;
import com.regenerationforrged.world.worldgen.noise.module.Noise;

public class ForceErosion implements Filter {
    // Faulting - Cannyon
    private final Noise faultNoise;
    private final float faultDepth;
    private final float faultThreshold;
    private final float faultPower;

    // Orogeny - Uplift
    private final Noise upliftNoise;
    private final float upliftHeight;
    private final float upliftThreshold;

    private final Modifier modifier;

    public ForceErosion(Noise faultNoise, float faultDepth, float faultThreshold, float faultPower,
                    Noise upliftNoise, float upliftHeight, float upliftThreshold, Modifier modifier
    ) {
        this.faultNoise = faultNoise;
        this.faultDepth = faultDepth;
        this.faultPower = faultPower;
        this.faultThreshold = faultThreshold;
        this.upliftNoise = upliftNoise;
        this.upliftHeight = upliftHeight;
        this.upliftThreshold = upliftThreshold;
        this.modifier = modifier;
    }

    @Override
    public void apply(Filterable map, int seedX, int seedZ, int iterations) {
        final Size
    }

}