package com.regenerationforrged.world.worldgen.cell.terrian.populator;

import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.noise.Noise;
import com.regenerationforrged.world.worldgen.noise.NoiseUtil;

public class FloatingIslandPopulator implements CellPopulator {
    private final Noise islandNoise;
    private final float threshold;
    private final int minHeight;
    private final float islandScale;
    private final boolean enabled;

    public FloatingIslandPopulator(
            Noise islandNoise,
            float threshold,
            int minHeight,
            float islandScale,
            boolean enabled
    ) {
        this.islandNoise = islandNoise;
        this.threshold = threshold;
        this.minHeight = minHeight;
        this.islandScale = islandScale;
        this.enabled = enabled;
    }

    @Override
    public void apply(Cell cell, float x, float z) {
        if (!enabled) return;

        if (cell.height < minHeight) {
            return;
        }

        float n = islandNoise.compute(x, z, 0);

        if (n <= threshold) {
            return;
        }

        float elevation = (n - threshold) / (1.0F - threshold);
        elevation = elevation * islandScale;

        float islandHeight = minHeight + elevation;

        if (islandHeight > cell.height) {
            cell.height = islandHeight;

            cell.terrain = null;

            cell.erosion *= 0.5F;
            cell.weirdness *= 0.4F;
        }
    }
}
