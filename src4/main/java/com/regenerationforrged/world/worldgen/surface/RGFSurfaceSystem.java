package com.regenerationforrged.world.worldgen.surface;

import java.util.List;
import java.util.function.Function;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import com.regenerationforrged.world.worldgen.surface.rule.StrataRule;

public interface RGFSurfaceSystem {
	List<List<StrataRule.Layer>> getOrCreateStrata(ResourceLocation name, Function<RandomSource, List<List<StrataRule.Layer>>> factory);
}
