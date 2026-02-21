package com.regenerationforrged.world.worldgen.surface.rule;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.util.KeyDispatchDataCodec;

import com.regenerationforrged.world.worldgen.noise.module.Noise;
import com.regenerationforrged.world.worldgen.RGFRandomState;
import com.regenerationforrged.world.worldgen.surface.RTFSurfaceSystem;

public record SnowStrataRule(Holder<Noise> depthNoise, Holder<Noise> layerNoise) implements SurfaceRules.RuleSource {
    public static final Codec<SnowStrataRule> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Noise.CODEC.fieldOf("depth_noise").forGetter(SnowStrataRule::depthNoise),
        Noise.CODEC.fieldOf("layer_noise").forGetter(SnowStrataRule::layerNoise)
    ).apply(instance, SnowStrataRule::new));

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context ctx) {
        if (ctx.system instanceof RTFSurfaceSystem && (Object) ctx.randomState instanceof RTFRandomState rtfRandomState) {
            return new Source(ctx, rtfRandomState.seed(this.depthNoise.value()), this.layerNoise.value());
        }
        throw new IllegalStateException("Missing RGF Context");
    }

    @Override
    public KeyDispatchDataCodec<SnowStrataRule> codec() {
        return new KeyDispatchDataCodec<>(CODEC);
    }

    private class Source implements SurfaceRules.SurfaceRule {
        private final SurfaceRules.Context context;
        private final Noise depthNoise;
        private final Noise layerNoise;
        private long lastXZ = Long.MIN_VALUE;
        private int surfaceY;
        private int snowDepth;
        private int layerCount;

        public Source(SurfaceRules.Context context, Noise depthNoise, Noise layerNoise) {
            this.context = context;
            this.depthNoise = depthNoise;
            this.layerNoise = layerNoise;
        }

        @Override
        public BlockState tryApply(int x, int y, int z) {
            if (this.lastXZ != this.context.lastUpdateXZ) {
                this.update(x, z);
                this.lastXZ = this.context.lastUpdateXZ;
            }

            // 1. Xử lý lớp Snow Layer trên cùng (Da)
            if (y == this.surfaceY) {
                return Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, this.layerCount);
            }

            // 2. Xử lý lớp Snow Block dày bên dưới (Thịt)
            // Lấp đầy từ surfaceY-1 xuống tới (surfaceY - snowDepth)
            if (y < this.surfaceY && y >= (this.surfaceY - this.snowDepth)) {
                return Blocks.SNOW_BLOCK.defaultBlockState();
            }

            return null;
        }

        private void update(int x, int z) {
            this.surfaceY = this.context.chunk.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x & 15, z & 15);
            
            // Tính toán độ dày dựa trên Noise (Bạn có thể map Y vào đây để Everest dày hơn)
            // Ví dụ: từ 6.0 đến 7.0 block
            float d = this.depthNoise.compute(x, z, 0); 
            this.snowDepth = Math.round(d);

            // Tính toán số layer (1-3) để làm mượt chân núi
            float l = this.layerNoise.compute(x, z, 1);
            this.layerCount = 1 + Math.round(l * 2); // Map 0..1 sang 1..3
        }
    }
}
