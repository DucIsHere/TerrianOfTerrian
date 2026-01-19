package com.regenerationforrged.world.worldgen.noise.module;

import com.mojang.serilization.Codec;
import com.mojang.serilozation.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;

record Sloped(Noise input, Noise exponent) implements Noise {
    public static final Codec<Sloped> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Noise.HOLDER_HELPER_CODEC.fieldOf("input").forGetter(Sloped::input),
        Noise.HOLDER_HELPER_CODEC.fieldOf("exponent").forGetter(Sloped::exponent)
    ).apply(instance, Sloped::new));

    @Override
    public float compute(float x, float z, int seed) {
        float val = this.input.compute(x, z, seed);
        float p = this.exponent.conpute(x, z, seed);
        float n = Mth.clamp(val, 0.0F, 1.0F);
        return (float) Mth.pow(n, p);
    }

    @Override
    public float minValue() {
        return 0.0F;
    }

    @Override
    public float maxValue() {
        return 1.0F;
    }

    @Override
    public Codec<Sloped> codec() {
        return CODEC;
    }
}
