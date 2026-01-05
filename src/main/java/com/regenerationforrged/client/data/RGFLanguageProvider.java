package com.regenerationforrged.client.data;

import net.minecraft.data.PackOutput;
import com.regenerationforrged.RGFInit;
import com.regenerationforrged.client.gui.Tooltips;

// TODO add some more languages
public final class RGFLanguageProvider {
	
	public static final class EnglishUS extends LanguageProvider {

		public EnglishUS(PackOutput output) {
			super(output, RGFInit.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			this.add(RGFTranslationKeys.METADATA_DESCRIPTION, "ReTerraForged resources");
			this.add(RGFTranslationKeys.PRESET_METADATA_DESCRIPTION, "ReTerraForged preset");
			this.add(RGFTranslationKeys.MUD_SWAMPS_METADATA_DESCRIPTION, "Changes the swamp material to mud");
			this.add(RGFTranslationKeys.NO_ERROR_MESSAGE, "{No error message}");
			
			this.add(RGFTranslationKeys.GUI_INPUT_PROMPT, "Type preset name");
			
			this.add(RGFTranslationKeys.GUI_SELECT_PRESET_MISSING_LEGACY_PRESETS, "Couldn't find any legacy presets");
			this.add(RGFTranslationKeys.GUI_SELECT_PRESET_TITLE, "Presets & Defaults");
			this.add(RGFTranslationKeys.GUI_DEFAULT_PRESET_NAME, "Default");
			this.add(RGFTranslationKeys.GUI_BEAUTIFUL_PRESET_NAME, "TerraForged - Beautiful (Legacy)");
			this.add(RGFTranslationKeys.GUI_HUGE_BIOMES_PRESET_NAME, "TerraForged - Huge Biomes (Legacy)");
			this.add(RGFTranslationKeys.GUI_LITE_PRESET_NAME, "TerraForged - Lite (Legacy)");
			this.add(RGFTranslationKeys.GUI_VANILLAISH_PRESET_NAME, "TerraForged - Vanilla-ish (Legacy)");
			this.add(RGFTranslationKeys.GUI_WORLD_SETTINGS_TITLE, "World Settings");
			this.add(RGFTranslationKeys.GUI_CAVE_SETTINGS_TITLE, "Cave Settings (Experimental)");
			this.add(RGFTranslationKeys.GUI_CLIMATE_SETTINGS_TITLE, "Climate Settings");
			this.add(RGFTranslationKeys.GUI_TERRAIN_SETTINGS_TITLE, "Terrain Settings");
			this.add(RGFTranslationKeys.GUI_RIVER_SETTINGS_TITLE, "River Settings");
			this.add(RGFTranslationKeys.GUI_FILTER_SETTINGS_TITLE, "Filter Settings");
			this.add(RGFTranslationKeys.GUI_STRUCTURE_SETTINGS_TITLE, "Structure Settings");
			this.add(RGFTranslationKeys.GUI_MISCELLANEOUS_SETTINGS_TITLE, "Miscellaneous Settings");

			this.add(RGFTranslationKeys.GUI_BUTTON_TRUE, "true");
this.add(RGFTranslationKeys.GUI_BUTTON_FALSE, "false");
this.add(RGFTranslationKeys.GUI_BUTTON_CREATE, "Create");
this.add(RGFTranslationKeys.GUI_BUTTON_COPY, "Copy");
this.add(RGFTranslationKeys.GUI_BUTTON_DELETE, "Delete");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_PRESET_FOLDER, "Open Preset Folder");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_EXPORT_FOLDER, "Open Export Folder");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK, "Export As Datapack");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_SUCCESS, "Exported Preset");
this.add(RGFTranslationKeys.GUI_BUTTON_SEED, "Seed");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE, "Continent Type");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE, "Continent Shape");
this.add(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE, "Spawn Type");
this.add(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS, "Large Ore Veins");
this.add(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION, "Legacy Carver Distribution");
this.add(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET, "Seed Offset");
this.add(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE, "Type");
this.add(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET, "Terrain Seed Offset");
this.add(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS, "Fancy Mountains");
this.add(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET, "Seed Offset");
this.add(RGFTranslationKeys.GUI_BUTTON_SALT, "Salt");
this.add(RGFTranslationKeys.GUI_BUTTON_DISABLED, "Disabled");
this.add(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR, "Smooth Layer Decorator");
this.add(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR, "Strata Decorator");
this.add(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY, "Ore Compatible Stone Only");
this.add(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR, "Erosion Decorator");
this.add(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION, "Plain Stone Erosion");
this.add(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR, "Natural Snow Decorator");
this.add(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES, "Custom Biome Features");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS, "Vanilla Springs");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES, "Vanilla Lava Lakes");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS, "Vanilla Lava Springs");

this.add(RGFTranslationKeys.GUI_SLIDER_ZOOM, "Zoom");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE, "Continent Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER, "Continent Jitter");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING, "Continent Skipping");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE, "Continent Size Variance");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES , "Continent Noise Octaves");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN, "Continent Noise Gain");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY, "Continent Noise Lacunarity");
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND, "Mushroom Fields Inland");
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST, "Mushroom Fields Coast");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN, "Deep Ocean");
this.add(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN, "Shallow Ocean");
this.add(RGFTranslationKeys.GUI_SLIDER_BEACH, "Beach");
this.add(RGFTranslationKeys.GUI_SLIDER_COAST, "Coast");
this.add(RGFTranslationKeys.GUI_SLIDER_INLAND, "Inland");
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT, "World Height");
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH, "World Depth");
this.add(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL, "Sea Level");
this.add(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL, "Lava Level");
this.add(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY, "Entrance Cave Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET, "Cheese Cave Depth Offset");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY, "Cheese Cave Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY, "Spaghetti Cave Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY, "Noodle Cave Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY, "Cave Carver Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY, "Deep Cave Carver Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY, "Ravine Carver Probability");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE, "Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF, "Falloff");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN, "Min");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX, "Max");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS, "Bias");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE, "Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF, "Falloff");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN, "Min");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX, "Max");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS, "Bias");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE, "Biome Size");
this.add(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE, "Macro Noise Size");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE, "Biome Warp Size");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH, "Biome Warp Strength");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE, "Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES, "Octaves");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN, "Gain");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY, "Lacunarity");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH, "Strength");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE, "Terrain Region Size");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE, "Global Vertical Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE, "Global Horizontal Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT, "Weight");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE, "Base Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE, "Vertical Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE, "Horizontal Scale");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT, "River Count");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH, "Bed Depth");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT, "Min Bank Height");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT, "Max Bank Height");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH, "Bed width");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH, "Bank width");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE, "Fade");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE, "Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE, "Min Start Distance");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE, "Max Start Distance");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH, "Depth");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN, "Size Min");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX, "Size Max");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT, "Min Bank Height");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT, "Max Bank Height");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE, "Chance");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN, "Size Min");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX, "Size Max");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK, "Droplets Per Chunk");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME, "Droplet Lifetime");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME, "Droplet Volume");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY, "Droplet Velocity");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE, "Erosion Rate");
this.add(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE, "Deposite Rate");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS, "Smoothing Iterations");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS, "Smoothing Radius");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE, "Smoothing Rate");
this.add(RGFTranslationKeys.GUI_SLIDER_SPACING, "Spacing");
this.add(RGFTranslationKeys.GUI_SLIDER_SEPARATION, "Separation");
this.add(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE, "Strata Region Size");
this.add(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE, "Mountain Biome Usage");
this.add(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE, "Volcano Biome Usage");

// TODO move the trailing colon and space to PresetEditorPage
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_AREA, "Area: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_TERRAIN, "Terrain: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_BIOME, "Biome: ");
this.add(RGFTranslationKeys.GUI_LABEL_CONTINENT, "Continent");
this.add(RGFTranslationKeys.GUI_LABEL_CONTROL_POINTS, "Control Points");
this.add(RGFTranslationKeys.GUI_LABEL_PROPERTIES, "Properties");
this.add(RGFTranslationKeys.GUI_LABEL_NOISE_CAVES, "Noise Caves");
this.add(RGFTranslationKeys.GUI_LABEL_CARVERS, "Carvers");
this.add(RGFTranslationKeys.GUI_LABEL_TEMPERATURE, "Temperature");
this.add(RGFTranslationKeys.GUI_LABEL_MOISTURE, "Moisture");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_SHAPE, "Biome Shape");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_EDGE_SHAPE, "Biome Edge Shape");
this.add(RGFTranslationKeys.GUI_LABEL_GENERAL, "General");
this.add(RGFTranslationKeys.GUI_LABEL_STEPPE, "Steppe");
this.add(RGFTranslationKeys.GUI_LABEL_PLAINS, "Plains");
this.add(RGFTranslationKeys.GUI_LABEL_HILLS, "Hills");
this.add(RGFTranslationKeys.GUI_LABEL_DALES, "Dales");
this.add(RGFTranslationKeys.GUI_LABEL_PLATEAU, "Plateau");
this.add(RGFTranslationKeys.GUI_LABEL_BADLANDS, "Badlands");
this.add(RGFTranslationKeys.GUI_LABEL_TORRIDONIAN, "Torridonian");
this.add(RGFTranslationKeys.GUI_LABEL_MOUNTAINS, "Mountains");
this.add(RGFTranslationKeys.GUI_LABEL_VOLCANO, "Volcano");
this.add(RGFTranslationKeys.GUI_LABEL_MAIN_RIVERS, "Main Rivers");
this.add(RGFTranslationKeys.GUI_LABEL_BRANCH_RIVERS, "Branch Rivers");
this.add(RGFTranslationKeys.GUI_LABEL_LAKES, "Lakes");
this.add(RGFTranslationKeys.GUI_LABEL_WETLANDS, "Wetlands");
this.add(RGFTranslationKeys.GUI_LABEL_EROSION, "Erosion");
this.add(RGFTranslationKeys.GUI_LABEL_SMOOTHING, "Smoothing");

this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_CREATE), "Failed to create preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_COPY), "Failed to copy preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_DELETE), "Failed to delete preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK), "Failed to export preset");

			this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SEED), "Controls the world seed");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE), "Controls the continent generator type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE), "Controls how continent shapes are calculated. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE), "Set whether spawn should be close to x=0,z=0 or the centre of the nearest continent");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS), "Set whether large ore veins spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION), "Set whether carvers use 1.16 distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET), "A seed offset used to randomise climate distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE), "The noise type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET), "A seed offset used to randomise terrain distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS), "Carries out extra processing on mountains to make them look even nicer. Can be disabled to improve performance slightly.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET), "A seed offset used to randomise river distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SALT), "A random seed value for the structure.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_DISABLED), "Prevent this structure from generating.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR), "Modifies layer block levels (ie snow) to fit the terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR), "Generates strata (rock layers) instead of just stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY), "Only use stone types that ores can generate in");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR), "Replace surface materials where erosion has occurred");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION), "Changes most exposed rock surfaces to plain stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR), "Removes snow from the terrain where it shouldn't naturally settle");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES), "Use custom biome features in place of vanilla ones (such as trees)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS), "Allow vanilla springs (water source blocks) to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES), "Allow vanilla lava-lakes to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS), "Allow vanilla springs (lava source blocks) to generate");

this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ZOOM), "Controls the zoom level of the preview map");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE), "Controls the size of continents. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER), "Controls how much continent centers are offset from the underlying noise grid.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING), "Reduces the number of continents to create more vast oceans.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE), "Increases the variance of continent sizes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES), "The number of octaves of noise used to distort the continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN), "The contribution strength of each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY), "The frequency multiplier for each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND), "Controls the point below which mushroom fields coasts transition into mushroom fields. The greater the gap to the mushroom fields coasts slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST), "Controls the point below which deep oceans transition into mushroom fields coasts. The greater the gap to the deep ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN), "Controls the point above which deep oceans transition into shallow oceans. The greater the gap to the shallow ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN), "Controls the point above which shallow oceans transition into coastal terrain. The greater the gap to the coast slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BEACH), "Controls how much of the coastal terrain is assigned to beach biomes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_COAST), "Controls the size of coastal regions and is also the point below which inland terrain transitions into oceans. Certain biomes such as Mushroom Fields only generate in coastal areas.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_INLAND), "Controls the overall transition from ocean to inland terrain.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT), "Controls the world height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH), "Controls the minimum y level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL), "Controls the sea level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL), "Controls the lava level.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY), "Controls the probability that an entrance cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET), "Controls the depth at which cheese caves start to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY), "Controls probability that a cheese cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY), "Controls the probability that a spaghetti cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY), "Controls probability that a noodle cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY), "Controls the probability that a cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY), "Controls the probability that a deep cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY), "Controls the probability that a ravine carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE), "Controls the size of individual biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE), "Macro noise is used to group large areas of biomes into a single type (such as deserts)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE), "Controls the scale of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH), "Controls the strength of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE), "Controls the scale of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES), "Controls the number of noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN), "Controls the gain subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY), "Controls the lacunarity of subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH), "Controls the strength of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE), "Controls the size of terrain regions");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE), "Globally controls the vertical scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE), "Globally controls the horizontal scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT), "Controls how common this terrain type is");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE), "Controls the base height of this terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE), "Stretches or compresses the terrain vertically");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE), "Stretches or compresses the terrain horizontally");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT), "Controls the number of main rivers per continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH), "Controls the depth of the river");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH), "Controls the river-bed width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH), "Controls the river-banks width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE), "Controls how much rivers taper");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE), "Controls the chance of a lake spawning");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE), "The minimum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE), "The maximum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH), "The max depth of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN), "The minimum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX), "The maximum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT), "The minimum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT), "The maximum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE), "Controls how common wetlands are");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN), "The minimum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX), "The maximum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK), "The average number of water droplets to simulate per chunk");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME), "Controls the number of iterations that a single water droplet is simulated for");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME), "Controls the starting volume of water that a simulated water droplet carries");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY), "Controls the starting velocity of the simulated water droplet");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE), "Controls how quickly material dissolves (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE), "Controls how quickly material is deposited (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS), "Controls the number of smoothing iterations");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS), "Controls the smoothing radius");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE), "Controls how strongly smoothing is applied");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPACING),
      "Controls the size of the grid used to generate the structure. "
    + "Structures will attempt to generate once per grid cell. Larger "
    + "spacing values will make the structure appear less frequently."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEPARATION),
      "Controls the minimum distance between instances of the structure. "
    + "Larger values guarantee larger distances between structures of the "
    + "same type but cause them to generate more 'grid-aligned'. "
    + "Lower values will produce a more random distribution but may allow "
    + "instances to generate closer together."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE),
    "The probability that mountainous terrain will be set to a mountain biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on mountain biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE),
    "The probability that volcano terrain will be set to a volcano biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on volcano biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE), "Controls the size of strata regions");

		}
	};

	public static final class VietnamVN extends LanguageProvider {

		public VietnamVN(PackOutput output) {
			super(output, RGFInit.MOD_ID, "vi_vn");
		}

		@Override
		protected void addTrandlations {
			this.add(RGFTranslationKeys.METADATA_DESCRIPTION, "ReGenerationForged resources");
			this.add(RGFTranslationKeys.PRESET_METADATA_DESCRIPTION, "ReGenerationForged preset");
			this.add(RGFTranslationKeys.MUD_SWAMPS_METADATA_DESCRIPTION, "Changes the swamp material to mud");
			this.add(RGFTranslationKeys.NO_ERORR_MESSAGE, "{No Erorr Message}");

this.add(RGFTranslationKeys.GUI_INPUT_PROMPT, "type preset name");

this.add(RGFTranslationKeys.GUI_SELECT_PRESET_MISSING_LEGACY_PRESETS, "Couldn't find any legacy presets");
			this.add(RGFTranslationKeys.GUI_SELECT_PRESET_TITLE, "Presets & Defaults");
			this.add(RGFTranslationKeys.GUI_DEFAULT_PRESET_NAME, "Default");
			this.add(RGFTranslationKeys.GUI_BEAUTIFUL_PRESET_NAME, "TerraForged - Beautiful (Legacy)");
			this.add(RGFTranslationKeys.GUI_HUGE_BIOMES_PRESET_NAME, "TerraForged - Huge Biomes (Legacy)");
			this.add(RGFTranslationKeys.GUI_LITE_PRESET_NAME, "TerraForged - Lite (Legacy)");
			this.add(RGFTranslationKeys.GUI_VANILLAISH_PRESET_NAME, "TerraForged - Vanilla-ish (Legacy)");
			this.add(RGFTranslationKeys.GUI_WORLD_SETTINGS_TITLE, "World Settings");
			this.add(RGFTranslationKeys.GUI_CAVE_SETTINGS_TITLE, "Cave Settings (Experimental)");
			this.add(RGFTranslationKeys.GUI_CLIMATE_SETTINGS_TITLE, "Climate Settings");
			this.add(RGFTranslationKeys.GUI_TERRAIN_SETTINGS_TITLE, "Terrain Settings");
			this.add(RGFTranslationKeys.GUI_RIVER_SETTINGS_TITLE, "River Settings");
			this.add(RGFTranslationKeys.GUI_FILTER_SETTINGS_TITLE, "Filter Settings");
			this.add(RGFTranslationKeys.GUI_STRUCTURE_SETTINGS_TITLE, "Structure Settings");
			this.add(RGFTranslationKeys.GUI_MISCELLANEOUS_SETTINGS_TITLE, "Miscellaneous Settings");

this.add(RGFTranslationKeys.GUI_BUTTON_TRUE, "Bật");
this.add(RGFTranslationKeys.GUI_BUTTON_FALSE, "Tắt");
this.add(RGFTranslationKeys.GUI_BUTTON_CREATE, "Tạo mới");
this.add(RGFTranslationKeys.GUI_BUTTON_COPY, "Sao chép");
this.add(RGFTranslationKeys.GUI_BUTTON_DELETE, "Xóa");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_PRESET_FOLDER, "Mở thư mục Cấu hình");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_EXPORT_FOLDER, "Mở thư mục Xuất");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK, "Xuất thành Datapack");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_SUCCESS, "Đã xuất Cấu hình thành công");
this.add(RGFTranslationKeys.GUI_BUTTON_SEED, "Hạt giống");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE, "Kiểu Lục địa");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE, "Hình dạng Lục địa");
this.add(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE, "Kiểu Xuất hiện");
this.add(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS, "Mạch quặng khổng lồ");
this.add(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION, "Phân phối Carver cũ");
this.add(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET, "Độ lệch Hạt giống");
this.add(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE, "Kiểu");
this.add(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET, "Độ lệch Hạt giống Địa hình");
this.add(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS, "Núi non Hùng vĩ");
this.add(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET, "Độ lệch Hạt giống");
this.add(RGFTranslationKeys.GUI_BUTTON_SALT, "Chỉ số Salt");
this.add(RGFTranslationKeys.GUI_BUTTON_DISABLED, "Đã vô hiệu hóa");
this.add(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR, "Trang trí Lớp mượt");
this.add(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR, "Trang trí Địa tầng");
this.add(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY, "Chỉ đá tương thích quặng");
this.add(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR, "Trang trí Bào mòn");
this.add(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION, "Bào mòn đá trơn");
this.add(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR, "Trang trí Tuyết tự nhiên");
this.add(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES, "Tính năng Quần xã tùy chỉnh");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS, "Nguồn nước Vanilla");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES, "Hồ dung nham Vanilla");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS, "Nguồn dung nham Vanilla");

// --- Cài đặt Lục địa & Nhiễu (Noise) ---
this.add(RGFTranslationKeys.GUI_SLIDER_ZOOM, "Độ Thu Phóng");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE, "Quy Mô Lục Địa");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER, "Độ Mấp Mô Lục Địa");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING, "Độ Đứt Gãy Lục Địa");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE, "Độ Biến Thiên Kích Thước");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES , "Bậc Nhiễu Lục Địa");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN, "Độ Lợi Nhiễu Lục Địa");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY, "Độ Hổng Nhiễu Lục Địa");

// --- Các Vùng Sinh Thái ---
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND, "Cánh Đồng Nấm (Nội địa)");
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST, "Cánh Đồng Nấm (Ven biển)");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN, "Đại Dương Sâu");
this.add(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN, "Đại Dương Nông");
this.add(RGFTranslationKeys.GUI_SLIDER_BEACH, "Bãi Biển");
this.add(RGFTranslationKeys.GUI_SLIDER_COAST, "Vùng Duyên Hải");
this.add(RGFTranslationKeys.GUI_SLIDER_INLAND, "Vùng Nội Địa");

// --- Thông Số Thế Giới ---
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT, "Chiều Cao Thế Giới");
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH, "Độ Sâu Thế Giới");
this.add(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL, "Mực Nước Biển");
this.add(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL, "Mực Dung Nham");

// --- Hang Động (Caves) ---
this.add(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY, "Tỷ Lệ Cửa Hang");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET, "Độ Lệch Sâu Hang Cheese");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY, "Tỷ Lệ Hang Cheese");
this.add(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY, "Tỷ Lệ Hang Spaghetti");
this.add(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY, "Tỷ Lệ Hang Noodle");
this.add(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY, "Tỷ Lệ Hang Đục Khoét");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY, "Tỷ Lệ Hang Sâu");
this.add(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY, "Tỷ Lệ Khe Núi");

// --- Khí Hậu (Climate) ---
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE, "Tỷ Lệ Nhiệt Độ");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF, "Độ Sụt Giảm Nhiệt Độ");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN, "Nhiệt Độ Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX, "Nhiệt Độ Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS, "Độ Thiên Kiến Nhiệt Độ");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE, "Tỷ Lệ Độ Ẩm");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF, "Độ Sụt Giảm Độ Ẩm");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN, "Độ Ẩm Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX, "Độ Ẩm Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS, "Độ Thiên Kiến Độ Ẩm");

// --- Quần Xã & Địa Hình (Biomes & Terrain) ---
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE, "Kích Thước Quần Xã");
this.add(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE, "Kích Thước Nhiễu Vĩ Mô");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE, "Tỷ Lệ Biến Dạng Quần Xã");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH, "Cường Độ Biến Dạng Quần Xã");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE, "Tỷ Lệ Đường Biên");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES, "Bậc Nhiễu Đường Biên");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN, "Độ Lợi Đường Biên");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY, "Độ Hổng Đường Biên");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH, "Cường Độ Đường Biên");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE, "Kích Thước Vùng Địa Hình");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE, "Tỷ Lệ Dọc Tổng Thể");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE, "Tỷ Lệ Ngang Tổng Thể");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT, "Trọng Số Địa Hình");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE, "Tỷ Lệ Nền Địa Hình");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE, "Tỷ Lệ Dọc Địa Hình");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE, "Tỷ Lệ Ngang Địa Hình");

// --- Sông & Hồ (Rivers & Lakes) ---
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT, "Số Lượng Sông");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH, "Độ Sâu Lòng Sông");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT, "Chiều Cao Bờ Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT, "Chiều Cao Bờ Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH, "Chiều Rộng Lòng Sông");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH, "Chiều Rộng Bờ Sông");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE, "Độ Mờ Biên Sông");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE, "Tỷ Lệ Có Hồ");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE, "Khoảng Cách Bắt Đầu Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE, "Khoảng Cách Bắt Đầu Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH, "Độ Sâu Hồ");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN, "Kích Thước Hồ Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX, "Kích Thước Hồ Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT, "Bờ Hồ Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT, "Bờ Hồ Tối Đa");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE, "Tỷ Lệ Đầm Lầy");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN, "Đầm Lầy Tối Thiểu");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX, "Đầm Lầy Tối Đa");

// --- Bào Mòn & Làm Mượt (Erosion & Smoothing) ---
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK, "Số Giọt Nước Mỗi Chunk");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME, "Vòng Đời Giọt Nước");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME, "Thể Tích Giọt Nước");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY, "Vận Tốc Giọt Nước");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE, "Tốc Độ Bào Mòn");
this.add(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE, "Tốc Độ Bồi Tụ");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS, "Số Lần Lặp Làm Mượt");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS, "Bán Kính Làm Mượt");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE, "Tỷ Lệ Làm Mượt");

// --- Khác ---
this.add(RGFTranslationKeys.GUI_SLIDER_SPACING, "Khoảng Cách");
this.add(RGFTranslationKeys.GUI_SLIDER_SEPARATION, "Độ Phân Tách");
this.add(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE, "Kích Thước Vùng Địa Tầng");
this.add(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE, "Tần Suất Quần Xã Núi");
this.add(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE, "Tần Suất Quần Xã Núi Lửa");

// TODO move the trailing colon and space to PresetEditorPage
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_AREA, "Khu vực: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_TERRAIN, "Địa hình: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_BIOME, "Quần xã: ");
this.add(RGFTranslationKeys.GUI_LABEL_CONTINENT, "Lục địa");
this.add(RGFTranslationKeys.GUI_LABEL_CONTROL_POINTS, "Điểm kiểm soát");
this.add(RGFTranslationKeys.GUI_LABEL_PROPERTIES, "Thuộc tính");
this.add(RGFTranslationKeys.GUI_LABEL_NOISE_CAVES, "Hang động Noise");
this.add(RGFTranslationKeys.GUI_LABEL_CARVERS, "Hang động Đục khoét");
this.add(RGFTranslationKeys.GUI_LABEL_TEMPERATURE, "Nhiệt độ");
this.add(RGFTranslationKeys.GUI_LABEL_MOISTURE, "Độ ẩm");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_SHAPE, "Hình dạng Quần xã");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_EDGE_SHAPE, "Hình dạng Đường biên");
this.add(RGFTranslationKeys.GUI_LABEL_GENERAL, "Chung");
this.add(RGFTranslationKeys.GUI_LABEL_STEPPE, "Thảo nguyên");
this.add(RGFTranslationKeys.GUI_LABEL_PLAINS, "Đồng bằng");
this.add(RGFTranslationKeys.GUI_LABEL_HILLS, "Đồi núi");
this.add(RGFTranslationKeys.GUI_LABEL_DALES, "Thung lũng (Dales)");
this.add(RGFTranslationKeys.GUI_LABEL_PLATEAU, "Cao nguyên");
this.add(RGFTranslationKeys.GUI_LABEL_BADLANDS, "Vùng đất xấu (Badlands)");
this.add(RGFTranslationKeys.GUI_LABEL_TORRIDONIAN, "Địa hình Torridonian");
this.add(RGFTranslationKeys.GUI_LABEL_MOUNTAINS, "Núi non");
this.add(RGFTranslationKeys.GUI_LABEL_VOLCANO, "Núi lửa");
this.add(RGFTranslationKeys.GUI_LABEL_MAIN_RIVERS, "Sông chính");
this.add(RGFTranslationKeys.GUI_LABEL_BRANCH_RIVERS, "Nhánh sông");
this.add(RGFTranslationKeys.GUI_LABEL_LAKES, "Hồ nước");
this.add(RGFTranslationKeys.GUI_LABEL_WETLANDS, "Vùng ngập nước");
this.add(RGFTranslationKeys.GUI_LABEL_EROSION, "Bào mòn");
this.add(RGFTranslationKeys.GUI_LABEL_SMOOTHING, "Làm mượt");
			
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_CREATE), "Failed to create preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_COPY), "Failed to copy preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_DELETE), "Failed to delete preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK), "Failed to export preset");

			this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SEED), "Controls the world seed");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE), "Controls the continent generator type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE), "Controls how continent shapes are calculated. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE), "Set whether spawn should be close to x=0,z=0 or the centre of the nearest continent");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS), "Set whether large ore veins spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION), "Set whether carvers use 1.16 distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET), "A seed offset used to randomise climate distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE), "The noise type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET), "A seed offset used to randomise terrain distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS), "Carries out extra processing on mountains to make them look even nicer. Can be disabled to improve performance slightly.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET), "A seed offset used to randomise river distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SALT), "A random seed value for the structure.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_DISABLED), "Prevent this structure from generating.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR), "Modifies layer block levels (ie snow) to fit the terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR), "Generates strata (rock layers) instead of just stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY), "Only use stone types that ores can generate in");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR), "Replace surface materials where erosion has occurred");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION), "Changes most exposed rock surfaces to plain stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR), "Removes snow from the terrain where it shouldn't naturally settle");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES), "Use custom biome features in place of vanilla ones (such as trees)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS), "Allow vanilla springs (water source blocks) to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES), "Allow vanilla lava-lakes to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS), "Allow vanilla springs (lava source blocks) to generate");

this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ZOOM), "Controls the zoom level of the preview map");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE), "Controls the size of continents. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER), "Controls how much continent centers are offset from the underlying noise grid.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING), "Reduces the number of continents to create more vast oceans.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE), "Increases the variance of continent sizes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES), "The number of octaves of noise used to distort the continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN), "The contribution strength of each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY), "The frequency multiplier for each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND), "Controls the point below which mushroom fields coasts transition into mushroom fields. The greater the gap to the mushroom fields coasts slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST), "Controls the point below which deep oceans transition into mushroom fields coasts. The greater the gap to the deep ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN), "Controls the point above which deep oceans transition into shallow oceans. The greater the gap to the shallow ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN), "Controls the point above which shallow oceans transition into coastal terrain. The greater the gap to the coast slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BEACH), "Controls how much of the coastal terrain is assigned to beach biomes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_COAST), "Controls the size of coastal regions and is also the point below which inland terrain transitions into oceans. Certain biomes such as Mushroom Fields only generate in coastal areas.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_INLAND), "Controls the overall transition from ocean to inland terrain.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT), "Controls the world height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH), "Controls the minimum y level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL), "Controls the sea level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL), "Controls the lava level.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY), "Controls the probability that an entrance cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET), "Controls the depth at which cheese caves start to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY), "Controls probability that a cheese cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY), "Controls the probability that a spaghetti cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY), "Controls probability that a noodle cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY), "Controls the probability that a cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY), "Controls the probability that a deep cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY), "Controls the probability that a ravine carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE), "Controls the size of individual biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE), "Macro noise is used to group large areas of biomes into a single type (such as deserts)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE), "Controls the scale of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH), "Controls the strength of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE), "Controls the scale of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES), "Controls the number of noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN), "Controls the gain subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY), "Controls the lacunarity of subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH), "Controls the strength of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE), "Controls the size of terrain regions");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE), "Globally controls the vertical scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE), "Globally controls the horizontal scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT), "Controls how common this terrain type is");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE), "Controls the base height of this terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE), "Stretches or compresses the terrain vertically");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE), "Stretches or compresses the terrain horizontally");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT), "Controls the number of main rivers per continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH), "Controls the depth of the river");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH), "Controls the river-bed width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH), "Controls the river-banks width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE), "Controls how much rivers taper");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE), "Controls the chance of a lake spawning");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE), "The minimum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE), "The maximum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH), "The max depth of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN), "The minimum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX), "The maximum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT), "The minimum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT), "The maximum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE), "Controls how common wetlands are");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN), "The minimum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX), "The maximum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK), "The average number of water droplets to simulate per chunk");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME), "Controls the number of iterations that a single water droplet is simulated for");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME), "Controls the starting volume of water that a simulated water droplet carries");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY), "Controls the starting velocity of the simulated water droplet");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE), "Controls how quickly material dissolves (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE), "Controls how quickly material is deposited (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS), "Controls the number of smoothing iterations");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS), "Controls the smoothing radius");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE), "Controls how strongly smoothing is applied");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPACING),
      "Controls the size of the grid used to generate the structure. "
    + "Structures will attempt to generate once per grid cell. Larger "
    + "spacing values will make the structure appear less frequently."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEPARATION),
      "Controls the minimum distance between instances of the structure. "
    + "Larger values guarantee larger distances between structures of the "
    + "same type but cause them to generate more 'grid-aligned'. "
    + "Lower values will produce a more random distribution but may allow "
    + "instances to generate closer together."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE),
    "The probability that mountainous terrain will be set to a mountain biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on mountain biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE),
    "The probability that volcano terrain will be set to a volcano biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on volcano biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE), "Controls the size of strata regions");

		}
	};

	public static final class ChineseSimplified extends LanguageProvider {

		public ChineseSimplified(PackOutput output) {
			super(output, RGFInit.MOD_ID, "zh_cn");
		}

		@Override
		protected void addTranslations() {
			this.add(RGFTranslationKeys.METADATA_DESCRIPTION, "ReTerraForged resources");
			this.add(RGFTranslationKeys.PRESET_METADATA_DESCRIPTION, "ReTerraForged preset");
			this.add(RGFTranslationKeys.MUD_SWAMPS_METADATA_DESCRIPTION, "Changes the swamp material to mud");
			this.add(RGFTranslationKeys.NO_ERROR_MESSAGE, "{No error message}");
			
			this.add(RGFTranslationKeys.GUI_INPUT_PROMPT, "Type preset name");
			
			this.add(RGFTranslationKeys.GUI_SELECT_PRESET_MISSING_LEGACY_PRESETS, "Couldn't find any legacy presets");
			this.add(RGFTranslationKeys.GUI_SELECT_PRESET_TITLE, "Presets & Defaults");
			this.add(RGFTranslationKeys.GUI_DEFAULT_PRESET_NAME, "Default");
			this.add(RGFTranslationKeys.GUI_BEAUTIFUL_PRESET_NAME, "TerraForged - Beautiful (Legacy)");
			this.add(RGFTranslationKeys.GUI_HUGE_BIOMES_PRESET_NAME, "TerraForged - Huge Biomes (Legacy)");
			this.add(RGFTranslationKeys.GUI_LITE_PRESET_NAME, "TerraForged - Lite (Legacy)");
			this.add(RGFTranslationKeys.GUI_VANILLAISH_PRESET_NAME, "TerraForged - Vanilla-ish (Legacy)");
			this.add(RGFTranslationKeys.GUI_WORLD_SETTINGS_TITLE, "World Settings");
			this.add(RGFTranslationKeys.GUI_CAVE_SETTINGS_TITLE, "Cave Settings (Experimental)");
			this.add(RGFTranslationKeys.GUI_CLIMATE_SETTINGS_TITLE, "Climate Settings");
			this.add(RGFTranslationKeys.GUI_TERRAIN_SETTINGS_TITLE, "Terrain Settings");
			this.add(RGFTranslationKeys.GUI_RIVER_SETTINGS_TITLE, "River Settings");
			this.add(RGFTranslationKeys.GUI_FILTER_SETTINGS_TITLE, "Filter Settings");
			this.add(RGFTranslationKeys.GUI_STRUCTURE_SETTINGS_TITLE, "Structure Settings");
			this.add(RGFTranslationKeys.GUI_MISCELLANEOUS_SETTINGS_TITLE, "Miscellaneous Settings");

			// --- Buttons ---
this.add(RGFTranslationKeys.GUI_BUTTON_TRUE, "开启");
this.add(RGFTranslationKeys.GUI_BUTTON_FALSE, "关闭");
this.add(RGFTranslationKeys.GUI_BUTTON_CREATE, "创建");
this.add(RGFTranslationKeys.GUI_BUTTON_COPY, "复制");
this.add(RGFTranslationKeys.GUI_BUTTON_DELETE, "删除");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_PRESET_FOLDER, "打开预设文件夹");
this.add(RGFTranslationKeys.GUI_BUTTON_OPEN_EXPORT_FOLDER, "打开导出文件夹");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK, "导出为数据包");
this.add(RGFTranslationKeys.GUI_BUTTON_EXPORT_SUCCESS, "预设导出成功");
this.add(RGFTranslationKeys.GUI_BUTTON_SEED, "种子");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE, "大陆类型");
this.add(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE, "大陆形状");
this.add(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE, "出生点类型");
this.add(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS, "巨型矿脉");
this.add(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION, "旧版雕刻器分布");
this.add(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET, "种子偏移");
this.add(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE, "类型");
this.add(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET, "地形种子偏移");
this.add(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS, "华丽山脉");
this.add(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET, "种子偏移");
this.add(RGFTranslationKeys.GUI_BUTTON_SALT, "盐值");
this.add(RGFTranslationKeys.GUI_BUTTON_DISABLED, "已禁用");
this.add(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR, "平滑层装饰器");
this.add(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR, "岩层装饰器");
this.add(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY, "仅限矿石兼容石头");
this.add(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR, "侵蚀装饰器");
this.add(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION, "普通石头侵蚀");
this.add(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR, "自然积雪装饰器");
this.add(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES, "自定义生物群系特征");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS, "原版泉水");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES, "原版岩浆湖");
this.add(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS, "原版岩浆泉");

// --- Sliders ---
this.add(RGFTranslationKeys.GUI_SLIDER_ZOOM, "缩放");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE, "大陆规模");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER, "大陆抖动");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING, "大陆跳跃");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE, "大陆大小变异");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES , "大陆噪声倍频 (Octaves)");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN, "大陆噪声增益 (Gain)");
this.add(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY, "大陆噪声空隙度 (Lacunarity)");
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND, "蘑菇岛 (内陆)");
this.add(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST, "蘑菇岛 (海岸)");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN, "深海");
this.add(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN, "浅海");
this.add(RGFTranslationKeys.GUI_SLIDER_BEACH, "沙滩");
this.add(RGFTranslationKeys.GUI_SLIDER_COAST, "海岸");
this.add(RGFTranslationKeys.GUI_SLIDER_INLAND, "内陆");
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT, "世界高度");
this.add(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH, "世界深度");
this.add(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL, "海平面高度");
this.add(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL, "岩浆位面高度");
this.add(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY, "入口洞穴概率");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET, "奶酪洞穴深度偏移");
this.add(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY, "奶酪洞穴概率");
this.add(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY, "面条洞穴概率");
this.add(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY, "细面洞穴概率");
this.add(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY, "洞穴雕刻器概率");
this.add(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY, "深层洞穴雕刻器概率");
this.add(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY, "峡谷概率");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE, "温度规模");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF, "温度衰减");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN, "最低温度");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX, "最高温度");
this.add(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS, "温度偏置");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE, "湿度规模");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF, "湿度衰减");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN, "最低湿度");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX, "最高湿度");
this.add(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS, "湿度偏置");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE, "生物群系大小");
this.add(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE, "宏观噪声大小");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE, "生物群系扭曲规模");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH, "生物群系扭曲强度");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE, "边缘规模");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES, "边缘倍频");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN, "边缘增益");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY, "边缘空隙度");
this.add(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH, "边缘强度");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE, "地形区域大小");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE, "全局纵向比例");
this.add(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE, "全局横向比例");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT, "权重");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE, "基础比例");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE, "纵向比例");
this.add(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE, "横向比例");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT, "河流数量");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH, "河床深度");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT, "最小河岸高度");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT, "最大河岸高度");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH, "河床宽度");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH, "河岸宽度");
this.add(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE, "淡出距离");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE, "湖泊概率");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE, "最小起始距离");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE, "最大起始距离");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH, "湖泊深度");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN, "最小尺寸");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX, "最大尺寸");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT, "最小湖岸高度");
this.add(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT, "最大湖岸高度");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE, "湿地概率");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN, "湿地最小尺寸");
this.add(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX, "湿地最大尺寸");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK, "每区块侵蚀滴数");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME, "侵蚀滴寿命");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME, "侵蚀滴体积");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY, "侵蚀滴流速");
this.add(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE, "侵蚀率");
this.add(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE, "沉积率");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS, "平滑迭代次数");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS, "平滑半径");
this.add(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE, "平滑率");
this.add(RGFTranslationKeys.GUI_SLIDER_SPACING, "间距");
this.add(RGFTranslationKeys.GUI_SLIDER_SEPARATION, "分隔距离");
this.add(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE, "岩层区域大小");
this.add(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE, "山脉生物群系占比");
this.add(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE, "火山生物群系占比");

// --- Labels ---
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_AREA, "区域: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_TERRAIN, "地形: ");
this.add(RGFTranslationKeys.GUI_LABEL_PREVIEW_BIOME, "生物群系: ");
this.add(RGFTranslationKeys.GUI_LABEL_CONTINENT, "大陆");
this.add(RGFTranslationKeys.GUI_LABEL_CONTROL_POINTS, "控制点");
this.add(RGFTranslationKeys.GUI_LABEL_PROPERTIES, "属性");
this.add(RGFTranslationKeys.GUI_LABEL_NOISE_CAVES, "噪声洞穴");
this.add(RGFTranslationKeys.GUI_LABEL_CARVERS, "雕刻器");
this.add(RGFTranslationKeys.GUI_LABEL_TEMPERATURE, "温度");
this.add(RGFTranslationKeys.GUI_LABEL_MOISTURE, "湿度");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_SHAPE, "群系形状");
this.add(RGFTranslationKeys.GUI_LABEL_BIOME_EDGE_SHAPE, "群系边缘形状");
this.add(RGFTranslationKeys.GUI_LABEL_GENERAL, "通用");
this.add(RGFTranslationKeys.GUI_LABEL_STEPPE, "干草原");
this.add(RGFTranslationKeys.GUI_LABEL_PLAINS, "平原");
this.add(RGFTranslationKeys.GUI_LABEL_HILLS, "丘陵");
this.add(RGFTranslationKeys.GUI_LABEL_DALES, "河谷 (Dales)");
this.add(RGFTranslationKeys.GUI_LABEL_PLATEAU, "高原");
this.add(RGFTranslationKeys.GUI_LABEL_BADLANDS, "恶地");
this.add(RGFTranslationKeys.GUI_LABEL_TORRIDONIAN, "托里登 (Torridonian)");
this.add(RGFTranslationKeys.GUI_LABEL_MOUNTAINS, "山脉");
this.add(RGFTranslationKeys.GUI_LABEL_VOLCANO, "火山");
this.add(RGFTranslationKeys.GUI_LABEL_MAIN_RIVERS, "主流");
this.add(RGFTranslationKeys.GUI_LABEL_BRANCH_RIVERS, "支流");
this.add(RGFTranslationKeys.GUI_LABEL_LAKES, "湖泊");
this.add(RGFTranslationKeys.GUI_LABEL_WETLANDS, "湿地");
this.add(RGFTranslationKeys.GUI_LABEL_EROSION, "侵蚀");
this.add(RGFTranslationKeys.GUI_LABEL_SMOOTHING, "平滑");

this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_CREATE), "Failed to create preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_COPY), "Failed to copy preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_DELETE), "Failed to delete preset");
this.add(Tooltips.failTranslationKey(RGFTranslationKeys.GUI_BUTTON_EXPORT_AS_DATAPACK), "Failed to export preset");

			this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SEED), "Controls the world seed");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_TYPE), "Controls the continent generator type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CONTINENT_SHAPE), "Controls how continent shapes are calculated. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SPAWN_TYPE), "Set whether spawn should be close to x=0,z=0 or the centre of the nearest continent");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LARGE_ORE_VEINS), "Set whether large ore veins spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_LEGACY_CARVER_DISTRIBUTION), "Set whether carvers use 1.16 distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CLIMATE_SEED_OFFSET), "A seed offset used to randomise climate distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_BIOME_EDGE_TYPE), "The noise type");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_TERRAIN_SEED_OFFSET), "A seed offset used to randomise terrain distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_FANCY_MOUNTAINS), "Carries out extra processing on mountains to make them look even nicer. Can be disabled to improve performance slightly.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_RIVER_SEED_OFFSET), "A seed offset used to randomise river distribution");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SALT), "A random seed value for the structure.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_DISABLED), "Prevent this structure from generating.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_SMOOTH_LAYER_DECORATOR), "Modifies layer block levels (ie snow) to fit the terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_STRATA_DECORATOR), "Generates strata (rock layers) instead of just stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_ORE_COMPATIBLE_STONE_ONLY), "Only use stone types that ores can generate in");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_EROSION_DECORATOR), "Replace surface materials where erosion has occurred");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_PLAIN_STONE_EROSION), "Changes most exposed rock surfaces to plain stone");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_NATURAL_SNOW_DECORATOR), "Removes snow from the terrain where it shouldn't naturally settle");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_CUSTOM_BIOME_FEATURES), "Use custom biome features in place of vanilla ones (such as trees)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_SPRINGS), "Allow vanilla springs (water source blocks) to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_LAKES), "Allow vanilla lava-lakes to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_BUTTON_VANILLA_LAVA_SPRINGS), "Allow vanilla springs (lava source blocks) to generate");

this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ZOOM), "Controls the zoom level of the preview map");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SCALE), "Controls the size of continents. You may also need to adjust the transition points to ensure beaches etc still form.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_JITTER), "Controls how much continent centers are offset from the underlying noise grid.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SKIPPING), "Reduces the number of continents to create more vast oceans.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_SIZE_VARIANCE), "Increases the variance of continent sizes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_OCTAVES), "The number of octaves of noise used to distort the continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_GAIN), "The contribution strength of each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CONTINENT_NOISE_LACUNARITY), "The frequency multiplier for each noise octave.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_INLAND), "Controls the point below which mushroom fields coasts transition into mushroom fields. The greater the gap to the mushroom fields coasts slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MUSHROOM_FIELDS_COAST), "Controls the point below which deep oceans transition into mushroom fields coasts. The greater the gap to the deep ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_OCEAN), "Controls the point above which deep oceans transition into shallow oceans. The greater the gap to the shallow ocean slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SHALLOW_OCEAN), "Controls the point above which shallow oceans transition into coastal terrain. The greater the gap to the coast slider, the more gradual the transition.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BEACH), "Controls how much of the coastal terrain is assigned to beach biomes.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_COAST), "Controls the size of coastal regions and is also the point below which inland terrain transitions into oceans. Certain biomes such as Mushroom Fields only generate in coastal areas.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_INLAND), "Controls the overall transition from ocean to inland terrain.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_HEIGHT), "Controls the world height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WORLD_DEPTH), "Controls the minimum y level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEA_LEVEL), "Controls the sea level");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAVA_LEVEL), "Controls the lava level.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_ENTRANCE_CAVE_PROBABILITY), "Controls the probability that an entrance cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_DEPTH_OFFSET), "Controls the depth at which cheese caves start to generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CHEESE_CAVE_PROBABILITY), "Controls probability that a cheese cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPAGHETTI_CAVE_PROBABILITY), "Controls the probability that a spaghetti cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_NOODLE_CAVE_PROBABILITY), "Controls probability that a noodle cave will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_CAVE_CARVER_PROBABILITY), "Controls the probability that a cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEEP_CAVE_CARVER_PROBABILITY), "Controls the probability that a deep cave carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RAVINE_CARVER_PROBABILITY), "Controls the probability that a ravine carver will generate");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TEMPERATURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_SCALE), "The horizontal scale");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_FALLOFF), "How quickly values transition from an extremity");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MIN), "The lower limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_MAX), "The upper limit of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOISTURE_BIAS), "The bias towards either end of the range");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_SIZE), "Controls the size of individual biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MACRO_NOISE_SIZE), "Macro noise is used to group large areas of biomes into a single type (such as deserts)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_SCALE), "Controls the scale of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_WARP_STRENGTH), "Controls the strength of shape distortion for biomes");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_SCALE), "Controls the scale of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_OCTAVES), "Controls the number of noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_GAIN), "Controls the gain subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_LACUNARITY), "Controls the lacunarity of subsequent noise octaves");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_BIOME_EDGE_STRENGTH), "Controls the strength of the noise");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_REGION_SIZE), "Controls the size of terrain regions");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_VERTICAL_SCALE), "Globally controls the vertical scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_GLOBAL_HORIZONTAL_SCALE), "Globally controls the horizontal scaling of terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_WEIGHT), "Controls how common this terrain type is");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_BASE_SCALE), "Controls the base height of this terrain");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_VERTICAL_SCALE), "Stretches or compresses the terrain vertically");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_TERRAIN_HORIZONTAL_SCALE), "Stretches or compresses the terrain horizontally");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_COUNT), "Controls the number of main rivers per continent.");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_DEPTH), "Controls the depth of the river");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MIN_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_MAX_BANK_HEIGHT), "Controls the height of river banks");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BED_WIDTH), "Controls the river-bed width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_BANK_WIDTH), "Controls the river-banks width");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_RIVER_FADE), "Controls how much rivers taper");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_CHANCE), "Controls the chance of a lake spawning");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_START_DISTANCE), "The minimum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_START_DISTANCE), "The maximum distance along a river that a lake will spawn");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_DEPTH), "The max depth of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MIN), "The minimum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_SIZE_MAX), "The maximum size of the lake");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MIN_BANK_HEIGHT), "The minimum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_LAKE_MAX_BANK_HEIGHT), "The maximum bank height");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_CHANCE), "Controls how common wetlands are");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MIN), "The minimum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_WETLAND_SIZE_MAX), "The maximum size of the wetlands");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLETS_PER_CHUNK), "The average number of water droplets to simulate per chunk");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_LIFETIME), "Controls the number of iterations that a single water droplet is simulated for");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VOLUME), "Controls the starting volume of water that a simulated water droplet carries");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_DROPLET_VELOCITY), "Controls the starting velocity of the simulated water droplet");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_EROSION_RATE), "Controls how quickly material dissolves (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_DEPOSITE_RATE), "Controls how quickly material is deposited (during erosion)");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_ITERATIONS), "Controls the number of smoothing iterations");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RADIUS), "Controls the smoothing radius");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SMOOTHING_RATE), "Controls how strongly smoothing is applied");
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SPACING),
      "Controls the size of the grid used to generate the structure. "
    + "Structures will attempt to generate once per grid cell. Larger "
    + "spacing values will make the structure appear less frequently."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_SEPARATION),
      "Controls the minimum distance between instances of the structure. "
    + "Larger values guarantee larger distances between structures of the "
    + "same type but cause them to generate more 'grid-aligned'. "
    + "Lower values will produce a more random distribution but may allow "
    + "instances to generate closer together."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_MOUNTAIN_BIOME_USAGE),
    "The probability that mountainous terrain will be set to a mountain biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on mountain biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_VOLCANO_BIOME_USAGE),
    "The probability that volcano terrain will be set to a volcano biome type.\n" +
    "This may help improve compatibility with mods that rely exclusively on volcano biomes."
);
this.add(Tooltips.translationKey(RGFTranslationKeys.GUI_SLIDER_STRATA_REGION_SIZE), "Controls the size of strata regions");
		}
	}

	public static final class JapanJP extends LaguageProvider {

		public JapanJP(PackOutput output) {
			super(output, RGFInit.MOD_ID, "ja_jp")
		}

		@Override
		protected void addTranslations() {}
	}
}
