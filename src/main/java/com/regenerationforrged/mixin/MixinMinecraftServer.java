package com.regenerationforrged.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.storage.ServerLevelData;
import com.regenerationforrged.data.worldgen.preset.settings.Preset;
import com.regenerationforrged.registries.RTFRegistries;

@Mixin(MinecraftServer.class)
class MixinMinecraftServer {

	@Inject(at = @At("HEAD"), method = "setInitialSpawn")
    private static void findSpawnPosition(ServerLevel serverLevel, ...) {
    serverLevel.registryAccess().lookup(RTFRegistries.PRESET).flatMap(r -> r.get(Preset.KEY)).ifPresent(preset -> {
        // Kiểm tra ID của Preset để chốt Mode
        if (preset.key().location().getPath().contains("json_style")) {
            EngineState.currentType = EngineState.Type.JSON;
            EngineState.isAmpOn = true;
        } else {
            EngineState.currentType = EngineState.Type.JAVA;
            EngineState.isAmpOn = false;
        }
    });
}
}
