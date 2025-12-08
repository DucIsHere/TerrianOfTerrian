package com.regenerationforrged.worldgen.world.cell.terrain;

import com.regenerationforrged.data.worldgen.preset.settings.TerrianSettings;

public interface ITerrian {
    double sample(int x, int y, int z, TerrianSettings settings);
}
