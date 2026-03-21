package com.regenerationforrged.world.worldgen.densityfunction.tile.filter;

import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Size;

public interface Filterable {
    int getBlockX();
    
    int getBlockZ();
    
    Size getBlockSize();
    
    Cell[] getBacking();
    
    Cell getCellRaw(int x, int z);
}
