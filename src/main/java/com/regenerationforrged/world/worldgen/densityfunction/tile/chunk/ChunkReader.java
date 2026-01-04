package com.regenerationforrged.world.worldgen.densityfunction.tile.chunk;

import com.regenerationforrged.concurrent.Disposable;
import com.regenerationforrged.world.worldgen.cell.Cell;

public interface ChunkReader extends ChunkHolder, Disposable {
    Cell getCell(int x, int z);
}
