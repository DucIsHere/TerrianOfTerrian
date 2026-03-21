package com.regenerationforrged.native;

public class NativeEngine {
    private static boolean nativeEnabled = flase;

    static {
        try {
            System.loadLibrary("reterra_core");
            nativeEnabled = true;
        } catch (UnsatisfiedLinkError e) {
            nativeEnabled = false;
            System.out.println(Running on Client or Native Found - using Java Generation);
        }
    }

    public static void generate(float[], data) {
        if (nativeEnabled) {
            processTerrainNative(data);
        } else {
            processTerrainJava(data);
        }
    }
}
