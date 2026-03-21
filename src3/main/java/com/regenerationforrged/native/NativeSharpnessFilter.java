package com.regenerationforrged.native;

public class NativeSharpnessFilter implements Filter {
    @Override
    public void apply(Tile tile, boolean applyOptional) {
        float[] data = tile.getRawHeightData();
        NativeEngine.processTerrain(data, 1.8f);
    }
}