package com.regenerationforrged.engine;

public class EngineControl {
    // 0: ToT Engine (Java), 1: RTF Legacy (Shadow), 2: JSON Engine
    public static int engineMode = 0; 

    public static boolean isJava() { return engineMode == 0; }
    public static boolean isLegacy() { return engineMode == 1; }
}
