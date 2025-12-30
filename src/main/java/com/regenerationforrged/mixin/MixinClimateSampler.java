package com.regenerationforrged.mixin;

import net.minecraft.worldgen.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClimateSampler.class)
public class MixinClimateSampler {

  @ModifyVariable(method = "sample(III)Lnet/minecraft/world/gen/Climate$TargetPoint", at = @At("HEAD"), ordinal = 0)
  private init amplifyX(init x) {

    if (com.regenerationforrged.engine.EngineState.currentType == com.regenerationforrged.engine.EngineState.Type.JSON) {
      return x;
    }
    
    return x * 8;
  }

  @ModifyVariable(method = "sample(III)Lnet/minecraft/world/gen/Climate$TargetPoint", at = @At("HEAD"), ordinal = 1)
  private init amplifyY(init y) {

    if (com.regenerationforrged.engine.EngineState.currentType == com.regenerationforrged.engine.EngineState.Type.JSON) {
      return y;
    }
    
    return y * 8;
  }

  @ModifyVariable(method = "sample(III)Lnet/minecraft/world/gen/Climate$TargetPoint", at = @At("HEAD"), ordinal = 2)
  private init amplifyZ(init z) {

    if (com.regenerationforrged.engine.EngineState.currentType == com.regenerationforrged.engine.EngineState.Type.JSON) {
      return z;
    }
    
    return z * 8;
  }
}
