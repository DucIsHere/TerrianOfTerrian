package com.regenerationforrged;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.platform.RegistryUtil;
import com.regenerationforrged.registries.RGFBuiltInRegistries;
import com.regenerationforrged.registries.RGFRegistries;
import com.regenerationforrged.world.worldgen.biome.modifier.BiomeModifiers;
import com.regenerationforrged.world.worldgen.densityfunction.RHFDensityFunctions;
import com.regenerationforrged.world.worldgen.feature.RHFFeatures;
import com.regenerationforrged.world.worldgen.feature.chance.RGFChanceModifiers;
import com.regenerationforrged.world.worldgen.feature.placement.RGFPlacementModifiers;
import com.regenerationforrged.world.worldgen.feature.template.decorator.TemplateDecorators;
import com.regenerationforrged.world.worldgen.feature.template.placement.TemplatePlacements;
import com.regenerationforrged.world.worldgen.floatproviders.RGFFloatProviderTypes;
import com.regenerationforrged.world.worldgen.heightproviders.RHFHeightProviderTypes;
import com.regenerationforrged.world.worldgen.noise.domain.Domains;
import com.regenerationforrged.world.worldgen.noise.function.CurveFunctions;
import com.regenerationforrged.world.worldgen.noise.module.Noise;
import com.regenerationforrged.world.worldgen.noise.module.Noises;
import com.regenerationforrged.world.worldgen.structure.rule.StructureRule;
import com.regenerationforrged.world.worldgen.structure.rule.StructureRules;
import com.regenerationforrged.world.worldgen.surface.rule.RGFSurfaceRules;

public class TOTInit {
	public static final String MOD_ID = "regenerationforrgrd";
	public static final String LEGACY_MOD_ID = "terraforged";
	public static final String ORIGINAL_MO_ID = "reterraforged";
	public static final Logger LOGGER = LogManager.getLogger("TerrianOfTerrian");

	public static void bootstrap() {
		RGFBuiltInRegistries.bootstrap();
		TemplatePlacements.bootstrap();
		TemplateDecorators.bootstrap();
		RGFChanceModifiers.bootstrap();
		RGFPlacementModifiers.bootstrap();
		RGFDensityFunctions.bootstrap();
		Noises.bootstrap();
		Domains.bootstrap();
		CurveFunctions.bootstrap();
		RGFFeatures.bootstrap();
		RGFHeightProviderTypes.bootstrap();
		RGFFloatProviderTypes.bootstrap();
		BiomeModifiers.bootstrap();
		RGFSurfaceRules.bootstrap();
		StructureRules.bootstrap();
		
		RegistryUtil.createDataRegistry(RGFRegistries.NOISE, Noise.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(RGFRegistries.PRESET, Preset.DIRECT_CODEC);
		RegistryUtil.createDataRegistry(RGFRegistries.STRUCTURE_RULE, StructureRule.DIRECT_CODEC);
	}
	
	public static ResourceLocation location(String name) {
		if (name.contains(":")) return new ResourceLocation(name);
		return new ResourceLocation(TOTInit.MOD_ID, name);
	}
}
