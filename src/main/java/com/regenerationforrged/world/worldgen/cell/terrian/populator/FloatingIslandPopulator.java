package com.regenerationforrged.world.worldgen.cell.terrian.populator;

import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.noise.Noise;
import com.regenerationforrged.world.worldgen.noise.NoiseUtil;

public class FloatingIslandPopulator implements TerrainPopulator {
    private final Noise islandNoise;
    private final int minHeight;
    private final boolean enabled;

    public FloatingIslandPopulator(Noise islandNoise, int minHeight, boolean enabled) {
        this.islandNoise = islandNoise;
        this.minHeight = minHeight;
        this.enabled = enabled;
    }

    @Override
    public void apply(Cell cell, float x, float z) {
        if (!enabled) return;

        // Nếu height dưới ngưỡng → khỏi dựng đảo
        if (cell.height < minHeight) return;

        // Noise dạng blob / dome
        float n = islandNoise.getValue(x, z);

        if (n > 0.55F) {
            float islandHeight = NoiseUtil.map(n, 0.55F, 1.0F, minHeight + 10, minHeight + 80);
            cell.height = Math.max(cell.height, islandHeight);

            // optional mask nếu m muốn nó trông sloped
            cell.slope = Math.min(cell.slope, 0.2F);
        }
    }
}
