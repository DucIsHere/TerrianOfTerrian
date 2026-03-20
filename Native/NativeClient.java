package com.regenerationforrged;

public class NativeClient {
    static {
        System.loadLibrary("reterra_core");
    }

    public static native void processTerrain(float[] data, float sharpness, float warp);
}