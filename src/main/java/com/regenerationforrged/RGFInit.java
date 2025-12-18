package com.regenerationforrged;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.level.levelgen.GeneratorType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;

import net.minecraft.world.level.levelgen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.level.levelgen.flat.FlatChunkGenerator;
import net.minecraft.world.level.levelgen.flat.FlatChunkGeneratorConfig;
import net.minecraft.world.level.levelgen.StructuresConfig;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RGFInit implements ModInitializer {
    public static final String MOD_ID = "regenerationforrged";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Custom GeneratorType VOID
    public static final GeneratorType VOID = new GeneratorType("void") {
        @Override
        protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
                                                   Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry,
                                                   long seed) {
            FlatChunkGeneratorConfig config = new FlatChunkGeneratorConfig(
                    new StructuresConfig(Optional.empty(), Collections.emptyMap()), biomeRegistry);
            config.updateLayerBlocks();
            return new FlatChunkGenerator(config);
        }
    };

    @Override
    public void onInitialize() {
		ChunkManager.register();

        LOGGER.info("Hello Fabric world!");
    }
}
