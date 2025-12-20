package com.regenerationforrged;

import net.fabricmc.api.ModInitializer;

import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RGFInit implements ModInitializer {
    public static final String MOD_ID = "regenerationforrged";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
    public void onInitialize() {
		RGFBuiltInRegistries.bootstrap();
		TemplatePlacement.bootstrap();
		TemplateDecorators.bootstrap();
		RGFChanceModifiers.bootstrap();
		RGFPlacementModifiers.bootstrap();

        LOGGER.info("Hello Fabric world!");
    }
}
