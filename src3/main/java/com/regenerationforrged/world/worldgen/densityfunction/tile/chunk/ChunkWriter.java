package com.regenerationforrged.world.worldgen.densityfunction.tile.chunk;

import com.regenerationforrged.world.worldgen.cell.Cell;

public interface ChunkWriter extends ChunkHolder {
    Cell genCell(int x, int z);
}
