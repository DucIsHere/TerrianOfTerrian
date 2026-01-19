package com.regenerationforrged.world.worldgen.biome;

public enum SlopedScale implements BiomeParameter {
    PLAINS(0.0F, 0.4F),      // Phẳng lỳ
    LOWLAND(0.4F, 1.0F),     // Hơi dốc
    HIGHLAND(1.0F, 2.5F),    // Dốc núi thường
    EPIC(2.5F, 5.0F),        // Dốc cực gắt (Kiểu EpicTerrain)
    VOLCANIC(5.0F, 10.0F);   // Vách đứng hẻm núi

    private final float min;
    private final float max;

    SlopedScale(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public float min() {
        return this.min;
    }

    @Override
    public float max() {
        return this.max;
    }
}
