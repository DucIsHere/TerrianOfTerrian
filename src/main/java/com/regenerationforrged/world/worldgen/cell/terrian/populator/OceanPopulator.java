package com.regenerationforrged.world.worldgen.cell.terrain.populator;

import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.cell.CellPopulator;
import com.regenerationforrged.world.worldgen.cell.terrain.Terrain;
import com.regenerationforrged.world.worldgen.noise.module.Noise;

public record OceanPopulator(Terrain terrainType, Noise height) implements CellPopulator {

	@Override
	public void apply(Cell cell, float x, float z) {
		cell.terrain = this.terrainType;
		cell.height = Math.max(this.height.compute(x, z, 0), 0.0F);
		cell.erosion = -1.1F;
		cell.weirdness = -1.1F;
	}
}