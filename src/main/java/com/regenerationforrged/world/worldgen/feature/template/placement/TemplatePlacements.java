package com.regenerationforrged.world.worldgen.feature.template.placement;

import com.mojang.serialization.Codec;

import com.regenerationforrged.platform.RegistryUtil;
import com.regenerationforrged.registries.RTFBuiltInRegistries;

public class TemplatePlacements {

	public static void bootstrap() {
		register("any", AnyPlacement.CODEC);
		register("tree", TreePlacement.CODEC);
	}
	
	public static AnyPlacement any() {
		return new AnyPlacement();
	}	
	
	public static TreePlacement tree() {
		return new TreePlacement();
	}
	
	private static void register(String name, Codec<? extends TemplatePlacement<?>> placement) {
		RegistryUtil.register(RTFBuiltInRegistries.TEMPLATE_PLACEMENT_TYPE, name, placement);
	}
}
