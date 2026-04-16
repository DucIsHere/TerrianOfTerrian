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
        final Size size = map.getBlockSize();
        final int total = size.total();
        final int worldX = map.getBlockX();
        final int worldZ = map.getBlockZ();

        for (int z = 0; z < total; z++) {
            for (int x = 0; x < total; x++) {
                Cell cell = map.getCellRaw(x, z);

                float wx = worldX + x;
                float wz = worldZ + z;

                float faultVal = this.faultNoise.compute(wx, wz, seedX);
                float ridgeFault = 1.0 - Math.abs(faultVal);

                if (ridgeFault > this.faultThreshold) {
                    float intensity = (ridgeFault - this.faultThreshold) / (1.0 - this.faultThreshold);
                    float displacement = (float) Math.pow(intensity, this.faultPower) * this.faultPower;

                    displacement = this.modifier.modify(cell, displacement);

                    cell.height -= displacement;
                    cell.heightErosion += displacement;

                    if (intensity > 0.4F) {
                        cell.erosionMask = true;
                    }
                }

                float upliftVal = this.upliftNoise.compute(wx, wz, seedZ);
                float ridgeUplift = 1.0 - Math.abs(upliftVal);

                if (ridgeUplift > this.upliftThreshold) {
                    float intensity = (ridgeUplift - this.upliftThreshold) / (1.0f - this.upliftThreshold);
                    float smoothIntensity = intensity * intensity * (3.0f - 2.0f * intensity);
                    float elevation = smoothIntensity * this.upliftHeight;

                    elevation = this.modifier.modify(cell, elevation);

                    cell.height += elevation;
                    cell.sediment = Math.max(0.0f, cell.sediment - (elevation * 0.1f));
                }
            }
        }
    }
}