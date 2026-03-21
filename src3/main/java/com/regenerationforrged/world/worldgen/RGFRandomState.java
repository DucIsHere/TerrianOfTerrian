package com.regenerationforrged.world.worldgen;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.levelgen.DensityFunction;
import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.world.worldgen.noise.module.Noise;

public interface RGFRandomState {
	void initialize(RegistryAccess registries);
	
	@Nullable
	Preset preset();

	@Nullable
	GeneratorContext generatorContext();
	
	DensityFunction wrap(DensityFunction function);

	Noise seed(Noise noise);
}
