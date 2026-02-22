package com.regenerationforrged.world.worldgen.noise.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ValleySpreader(
    Noise input, 
    float valleyLevel, // Ngưỡng bắt đầu làm Valley (vd: 350-450)
    float flatness     // Độ bằng phẳng của đáy (0.0 -> 1.0)
) implements Noise {
    public static final Codec<ValleySpreader> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Noise.HOLDER_HELPER_CODEC.fieldOf("input").forGetter(ValleySpreader::input),
        Codec.FLOAT.fieldOf("valley_level").forGetter(ValleySpreader::valleyLevel),
        Codec.FLOAT.fieldOf("flatness").forGetter(ValleySpreader::flatness)
    ).apply(instance, ValleySpreader::new));

    @Override
    public float compute(float x, float z, int seed) {
        float h = this.input.compute(x, z, seed);
        
        // Nếu độ cao thấp hơn mức valleyLevel, ta bắt đầu bóp méo để làm rộng đáy
        if (h < valleyLevel) {
            float alpha = h / valleyLevel;
            // Dùng hàm Power để kéo dài phần đáy (Flat bottom)
            float flatH = (float) Math.pow(alpha, 1.0f + flatness) * valleyLevel;
            return flatH;
        }
        return h;
    }

    @Override public float minValue() { return 0; }
    @Override public float maxValue() { return input.maxValue(); }
    @Override public Codec<? extends Noise> codec() { return CODEC; }
    @Override public Noise mapAll(Visitor visitor) { return new ValleySpreader(visitor.apply(input), valleyLevel, flatness); }
}
