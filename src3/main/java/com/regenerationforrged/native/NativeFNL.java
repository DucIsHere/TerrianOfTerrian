package com.regenerationforrged.native;

public class NativeFNL {
    static {
        try {
            // Mod Loader sẽ tự tìm trong các thư mục natives/ của JAR
            System.loadLibrary("reterra_fnl"); 
            System.out.println("[ReTerra] Native Engine Initialized!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("[ReTerra] Native library not found! Falling back to Java...");
        }
    }

    // Khai báo hàm Native
    public static native void fillNoise(float[] buffer, int xSize, int zSize, float xOff, float zOff, float freq, int seed);
}