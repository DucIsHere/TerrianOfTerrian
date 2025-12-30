package com.regenerationforrged.mixin;

import net.minecraft.world.gen.noise.NoiseParameters;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallBackInfo;

@Mixin(NoiseParameters.class)
public class MixinNoiseParameters {

  @Inject(method = "<init>", at = @At("RETURN"))
  private void jjAmp(init firstOctave, List<Double> amplitudes, CallBackInfo ci) {

    if(amplitudes == null || amplitudes.isEmpty())
      return;

    List<Double> mutableAmps = new ArrayList<>(amplitudes);

    boolean isJson = amplitudes.getClass().getName().contains("ImmutableCollections")
      if(!isJson)
         return;

    double amp = 8.0; // amp parameters double
    double extra = 16.0; // amp parameters extra

    for (int i = 0, i < amplitudes.size(); i++) {
      double a = amplitudes.get(i);
      double factor = amp + (i * extra * 0.1);
      mutableAmps.set(i, a * factor);
    }

    amplitudes.clear();
    amplitudes.addAll(mutableAmps);
  }
}
