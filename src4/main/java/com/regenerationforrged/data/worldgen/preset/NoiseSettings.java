package com.regenerationforrged.data.worldgen.preset;

public record NoiseSettings(double baseFreq, double warpStrength, double amplifyFactor) {
    public static NoiseSettings defaults() { return new NoiseSettings(0.01, 8.0, 2.8); }
}
