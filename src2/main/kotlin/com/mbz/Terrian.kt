package com.mbz

import org.apache.logging.log4j.LogManager
import net.minecraft.resources.ResourceLocation

import com.mbz.data.worldgen.preset.settings.Preset
import com.mbz.platform.RegistryUtil
import com.mbz.registries.RGFBuiltInRegistries
import com.mbz.registries.RGFRegistries
import com.mbz.world.worldgen.biome.modifier.BiomeModifiers
import com.mbz.world.worldgen.densityfunction.RHFDensityFunctions
import com.mbz.world.worldgen.feature.RHFFeatures
import com.mbz.world.worldgen.feature.chance.RGFChanceModifiers
import com.mbz.world.worldgen.feature.placement.RGFPlacementModifiers
import com.mbz.world.worldgen.feature.template.decorator.TemplateDecorators
import com.mbz.world.worldgen.feature.template.placement.TemplatePlacements
import com.mbz.world.worldgen.floatproviders.RGFFloatProviderTypes
import com.mbz.world.worldgen.heightproviders.RHFHeightProviderTypes
import com.mbz.world.worldgen.noise.domain.Domains
import com.mbz.world.worldgen.noise.function.CurveFunctions
import com.mbz.world.worldgen.noise.module.Noise
import com.mbz.world.worldgen.noise.module.Noises
import com.mbz.world.worldgen.structure.rule.StructureRule
import com.mbz.world.worldgen.structure.rule.StructureRules
import com.mbz.world.worldgen.surface.rule.RGFSurfaceRules

object Terrian {
    const val MOD_ID = "mbz"
    val LOGGER = LogManager.getLogger("Terrian")

    @JvmStatic
    fun mbz() {
        RGFBuiltInRegistries.mbz()
        TemplatePlacements.mbz()
        TemplateDecorators.mbz()
        RGFChanceModifiers.mbz()
        RGFPlacementModifiers.mbz()
        RGFDensityFunctions.mbz()
        Noises.mbz()
        Domains.mbz()
        CurveFunctions.mbz()
        RHFFeatures.mbz()
        RHFHeightProviderTypes.mbz()
        RGFFloatProviderTypes.mbz()
        BiomeModifiers.mbz()
        RGFSurfaceRules.mbz()
        StructureRules.mbz()
        
        // Dang ky Registry
        RegistryUtil.createDataRegistry(RGFRegistries.NOISE, Noise.DIRECT_CODEC)
        RegistryUtil.createDataRegistry(RGFRegistries.PRESET, Preset.DIRECT_CODEC)
        RegistryUtil.createDataRegistry(RGFRegistries.STRUCTURE_RULE, StructureRule.DIRECT_CODEC)

    }

    @JvmStatic
    fun location(name: String) = if (name.contains(":")) ResourceLocation(name) else ResourceLocation(MOD_ID, name)
}
