package com.regenerationforrged.world.worldgen.surface.rule;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.util.KeyDispatchDataCodec;

import com.regenerationforrged.world.worldgen.noise.module.Noise;
import com.regenerationforrged.world.worldgen.RTFRandomState;
import com.regenerationforrged.world.worldgen.surface.RGFSurfaceSystem;

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
        throw new IllegalStateException("RGF Context is missing!");
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
        private int layers;

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

            // ĐIỂM QUAN TRỌNG: Lớp mượt bằng Layer (như trong ảnh bạn gửi)
            if (y == this.surfaceY) {
                return Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, this.layers);
            }

            // Lớp dày 9-15 block (Snow Block nguyên)
            if (y < this.surfaceY && y >= (this.surfaceY - this.snowDepth)) {
                return Blocks.SNOW_BLOCK.defaultBlockState();
            }

            return null;
        }

        private void update(int x, int z) {
            this.surfaceY = this.context.chunk.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x & 15, z & 15);
            
            // Logic BigGlobe: Tuyết dày dần từ base lên peak
            // surfaceY lúc này có thể lên tới 2048
            float heightAlpha = Math.max(0, (float)(this.surfaceY - 60) / 1000.0f); 
            float baseThickness = 7.0f + (heightAlpha * 8.0f); // Tăng dần lên 15 blocks
            
            float d = this.depthNoise.compute(x, z, 0);
            this.snowDepth = Math.round(baseThickness + d);

            // Tính toán độ mượt (1-8 lớp layer)
            // Bạn có thể dùng Noise để làm mặt tuyết gợn sóng như ảnh
            float l = this.layerNoise.compute(x, z, 1);
            this.layers = 1 + Math.round(Math.abs(l) * 7); // Trả về từ 1 đến 8 lớp
        }
    }
}