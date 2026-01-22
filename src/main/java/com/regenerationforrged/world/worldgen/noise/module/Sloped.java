package com.regenerationforrged.world.worldgen.noise.module;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;

// Thêm biến enabled để làm công tắc
record Sloped(Noise input, Noise exponent, boolean enabled) implements Noise {
    public static final Codec<Sloped> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Noise.HOLDER_HELPER_CODEC.fieldOf("input").forGetter(Sloped::input),
        Noise.HOLDER_HELPER_CODEC.fieldOf("exponent").forGetter(Sloped::exponent),
        Codec.BOOL.optionalFieldOf("enabled", true).forGetter(Sloped::enabled) // Mặc định là true
    ).apply(instance, Sloped::new));

    @Override
    public float compute(float x, float z, int seed) {
        float val = this.input.compute(x, z, seed);
        
        // Nếu TẮT (Disable), trả về giá trị gốc không tính lũy thừa (không tạo dốc)
        if (!enabled) {
            return val;
        }

        float p = this.exponent.compute(x, z, seed); // Sửa lỗi conpute -> compute
        float n = Mth.clamp(val, 0.0F, 1.0F);
        return (float) Math.pow(n, p);
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
    public Noise mapAll(Visitor visitor) { // Sửa lỗi vistitor -> visitor
        return visitor.apply(new Sloped(this.input.mapAll(visitor), this.exponent.mapAll(visitor), this.enabled));
    }

    @Override
    public Codec<Sloped> codec() {
        return CODEC;
    }
}
