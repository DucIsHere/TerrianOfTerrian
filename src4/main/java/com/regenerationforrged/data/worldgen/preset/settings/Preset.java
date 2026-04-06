package com.regenerationforrged.data.worldgen.preset.settings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import com.regenerationforrged.data.worldgen.preset.PresetBiomeModifierData;
import com.regenerationforrged.data.worldgen.preset.PresetNoiseData;
import com.regenerationforrged.data.worldgen.preset.PresetBiomeData;
import com.regenerationforrgeddata.worldgen.preset.PresetConfiguredCarvers;
import com.regenerationforrged.data.worldgen.preset.PresetConfiguredFeatures;
import com.regenerationforrged.data.worldgen.preset.PresetDimensionTypes;
import com.regenerationforrged.data.worldgen.preset.PresetNoiseGeneratorSettings;
import com.regenerationforrged.data.worldgen.preset.PresetNoiseRouterData;
import com.regenerationforrged.data.worldgen.preset.PresetPlacedFeatures;
import com.regenerationforrged.data.worldgen.preset.PresetStructureRuleData;
import com.regenerationforrged.registries.RTFRegistries;

public record Preset(WorldSettings world, CaveSettings caves, ClimateSettings climate, TerrainSettings terrain, RiverSettings rivers, FilterSettings filters, StructureSettings structures, MiscellaneousSettings miscellaneous) {
	public static final Codec<Preset> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
		WorldSettings.CODEC.fieldOf("world").forGetter(Preset::world),
		CaveSettings.CODEC.optionalFieldOf("caves", new CaveSettings(0.0F, 1.5625F, 1.0F, 1.0F, 1.0F, 0.14285715F, 0.07F, 0.02F, true, false)).forGetter((o) -> o.caves),
		ClimateSettings.CODEC.fieldOf("climate").forGetter(Preset::climate),
		TerrainSettings.CODEC.fieldOf("terrain").forGetter(Preset::terrain),
		RiverSettings.CODEC.fieldOf("rivers").forGetter(Preset::rivers),
		FilterSettings.CODEC.fieldOf("filters").forGetter(Preset::filters),
		StructureSettings.CODEC.fieldOf("structures").forGetter(Preset::structures),
		MiscellaneousSettings.CODEC.fieldOf("miscellaneous").forGetter(Preset::miscellaneous)
	).apply(instance, Preset::new));
	
	@Deprecated
	public static final ResourceKey<Preset> KEY = RTFRegistries.createKey(RTFRegistries.PRESET, "preset");
	
	public Preset copy() {
		return new Preset(this.world.copy(), this.caves.copy(), this.climate.copy(), this.terrain.copy(), this.rivers.copy(), this.filters.copy(), this.structures.copy(), this.miscellaneous.copy());
	}

	public HolderLookup.Provider buildPatch(RegistryAccess registries) {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		this.addPatch(builder, RTFRegistries.PRESET, (preset, ctx) -> ctx.register(KEY, preset));
		this.addPatch(builder, RTFRegistries.NOISE, PresetNoiseData::bootstrap);
		this.addPatch(builder, RTFRegistries.BIOME_MODIFIER, PresetBiomeModifierData::bootstrap);
		this.addPatch(builder, RTFRegistries.STRUCTURE_RULE, PresetStructureRuleData::bootstrap);
		this.addPatch(builder, Registries.CONFIGURED_FEATURE, (preset, ctx) -> {
			PresetConfiguredFeatures.bootstrap(preset, ctx);
		});
		this.addPatch(builder, Registries.CONFIGURED_CARVER, (preset, ctx) -> {
			PresetConfiguredCarvers.bootstrap(preset, ctx);	
		});
		this.addPatch(builder, Registries.PLACED_FEATURE, PresetPlacedFeatures::bootstrap);
		this.addPatch(builder, Registries.BIOME, PresetBiomeData::bootstrap);
		this.addPatch(builder, Registries.DIMENSION_TYPE, PresetDimensionTypes::bootstrap);
		this.addPatch(builder, Registries.DENSITY_FUNCTION, PresetNoiseRouterData::bootstrap);
		this.addPatch(builder, Registries.NOISE_SETTINGS, PresetNoiseGeneratorSettings::bootstrap);
		return builder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), registries);
	}
	
	private <T> void addPatch(RegistrySetBuilder builder, ResourceKey<? extends Registry<T>> key, Patch<T> patch) {
    	builder.add(key, (ctx) -> {
    		patch.apply(this, ctx);
    	});
    }
    
	private interface Patch<T> {
        void apply(Preset preset, BootstapContext<T> ctx);
	}
}
