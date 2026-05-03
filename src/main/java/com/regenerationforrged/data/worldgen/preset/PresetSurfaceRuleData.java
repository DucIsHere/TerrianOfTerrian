package com.regenerationforrged.data.worldgen.preset;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;

import com.regenerationforrged.Common;
import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.registries.RGFRegistries;
import com.regenerationforrged.world.worldgen.cell.terrain.TerrainType;
import com.regenerationforrged.world.worldgen.structure.rule.StructureRule;
import com.regenerationforrged.world.worldgen.structure.rule.StructureRules;

public class PresetStructureRuleData {
	public static final ResourceKey<StructureRule> CELL_TEST = createKey("cell_test");
	
	public static void bootstrap(Preset preset, BootstapContext<StructureRule> ctx) {
		ctx.register(CELL_TEST, StructureRules.cellTest(0.225F, TerrainType.MOUNTAIN_CHAIN, TerrainType.MOUNTAINS_1, TerrainType.MOUNTAINS_2, TerrainType.MOUNTAINS_3));
	}
	
	private static ResourceKey<StructureRule> createKey(String name) {
        return ResourceKey.create(RTFRegistries.STRUCTURE_RULE, RTFCommon.location(name));
	}
}