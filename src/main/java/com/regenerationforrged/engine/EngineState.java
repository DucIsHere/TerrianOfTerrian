package com.regenerationforrged.engine;

public class EngineState {
    public enum Type { JAVA, JSON }
    public static Type currentType = Type.JAVA;
    public static boolean isAmpOn = false; // Trạng thái cho mode JSON
}
