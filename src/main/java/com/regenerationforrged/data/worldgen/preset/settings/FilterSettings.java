package com.regenerationforrged.data.worldgen.preset.settings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.regenerationforrged.world.worldgen.densityfunction.tile.filter.AdvancedSubsurfaceFlow;

public class FilterSettings {
    public static final Codec<FilterSettings> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        Erosion.CODEC.fieldOf("erosion").forGetter(o -> o.erosion),
        GlacialErosion.CODEC.fieldOf("glacial").forGetter(o -> o.glacial),
        SoilFluction.CODEC.fieldOf("soilFluction").forGetter(o -> o.soilFluction),
        Smoothing.CODEC.fieldOf("smoothing").forGetter(o -> o.smoothing)
    ).apply(instance, FilterSettings::new));

    public Erosion erosion;
    public GlacialErosion glacial;
    public SoilFluction soilFluction;
    public AdvancedSubsurfaceFlow advancedSubsurfaceFlow;
    public Aquifer aquifer;
    public Smoothing smoothing;

    public FilterSettings(Erosion erosion, GlacialErosion glacial, SoilFluction soilFluction, AdvancedSubsurfaceFlow advancedSubsurfaceFlow, Aquifer aquifer, Smoothing smoothing) {
        this.erosion = erosion;
        this.glacial = glacial;
        this.soilFluction = soilFluction;
        this.advancedSubsurfaceFlow = advancedSubsurfaceFlow;
        this.aquifer = aquifer;
        this.smoothing = smoothing;
    }

    public FilterSettings copy() {
        return new FilterSettings(
            this.erosion.copy(),
            this.glacial.copy(),
            this.soilFluction.copy(),
            this.advancedSubsurfaceFlow.copy(),
            this.aquifer.copy(),
            this.smoothing.copy()
        );
    }

    // ================= EROSION =================
    public static class Erosion {
        public static final Codec<Erosion> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("dropletsPerChunk").forGetter(o -> o.dropletsPerChunk),
            Codec.INT.fieldOf("dropletLifetime").forGetter(o -> o.dropletLifetime),
            Codec.FLOAT.fieldOf("dropletVolume").forGetter(o -> o.dropletVolume),
            Codec.FLOAT.fieldOf("dropletVelocity").forGetter(o -> o.dropletVelocity),
            Codec.FLOAT.fieldOf("erosionRate").forGetter(o -> o.erosionRate),
            Codec.FLOAT.fieldOf("depositeRate").forGetter(o -> o.depositeRate)
        ).apply(instance, Erosion::new));

        public int dropletsPerChunk;
        public int dropletLifetime;
        public float dropletVolume;
        public float dropletVelocity;
        public float erosionRate;
        public float depositeRate;

        public Erosion(int dropletsPerChunk, int dropletLifetime, float dropletVolume,
                       float dropletVelocity, float erosionRate, float depositeRate) {
            this.dropletsPerChunk = dropletsPerChunk;
            this.dropletLifetime = dropletLifetime;
            this.dropletVolume = dropletVolume;
            this.dropletVelocity = dropletVelocity;
            this.erosionRate = erosionRate;
            this.depositeRate = depositeRate;
        }

        public Erosion copy() {
            return new Erosion(dropletsPerChunk, dropletLifetime, dropletVolume,
                               dropletVelocity, erosionRate, depositeRate);
        }
    }

    // ================= GLACIAL =================
    public static class GlacialErosion {
        public static final Codec<GlacialErosion> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("iterations").forGetter(o -> o.iterations),
            Codec.FLOAT.fieldOf("abrasionRate").forGetter(o -> o.abrasionRate),
            Codec.FLOAT.fieldOf("depositSpeed").forGetter(o -> o.depositSpeed),
            Codec.FLOAT.fieldOf("accumulationRate").forGetter(o -> o.accumulationRate),
            Codec.FLOAT.fieldOf("meltRate").forGetter(o -> o.meltRate),
            Codec.FLOAT.fieldOf("viscosity").forGetter(o -> o.viscosity),
            Codec.FLOAT.fieldOf("pluckingProbability").forGetter(o -> o.pluckingProbability),
            Codec.FLOAT.fieldOf("pluckingRate").forGetter(o -> o.pluckingRate),
            Codec.FLOAT.fieldOf("initialSpeed").forGetter(o -> o.initialSpeed),
            Codec.FLOAT.fieldOf("initialIceVolume").forGetter(o -> o.initialIceVolume),
            Codec.INT.fieldOf("maxLifeTime").forGetter(o -> o.maxLifeTime)
        ).apply(instance, GlacialErosion::new));

        public int iterations;
        public float abrasionRate;
        public float depositSpeed;
        public float accumulationRate;
        public float meltRate;
        public float viscosity;
        public float pluckingProbability;
        public float pluckingRate;
        public float initialSpeed;
        public float initialIceVolume;
        public int maxLifeTime;

        public GlacialErosion(int iterations, float abrasionRate, float depositSpeed,
                              float accumulationRate, float meltRate, float viscosity,
                              float pluckingProbability, float pluckingRate,
                              float initialSpeed, float initialIceVolume, int maxLifeTime) {

            this.iterations = iterations;
            this.abrasionRate = abrasionRate;
            this.depositSpeed = depositSpeed;
            this.accumulationRate = accumulationRate;
            this.meltRate = meltRate;
            this.viscosity = viscosity;
            this.pluckingProbability = pluckingProbability;
            this.pluckingRate = pluckingRate;
            this.initialSpeed = initialSpeed;
            this.initialIceVolume = initialIceVolume;
            this.maxLifeTime = maxLifeTime;
        }

        public GlacialErosion copy() {
            return new GlacialErosion(iterations, abrasionRate, depositSpeed,
                accumulationRate, meltRate, viscosity,
                pluckingProbability, pluckingRate,
                initialSpeed, initialIceVolume, maxLifeTime);
        }
    }

    // ================= SOIL =================
    public static class SoilFluction {
        public static final Codec<SoilFluction> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("iterations").forGetter(o -> o.iterations),
            Codec.FLOAT.fieldOf("flowRate").forGetter(o -> o.flowRate),
            Codec.FLOAT.fieldOf("maxSedimentFlow").forGetter(o -> o.maxSedimentFlow),
            Codec.FLOAT.fieldOf("weatheringRate").forGetter(o -> o.weatheringRate),
            Codec.FLOAT.fieldOf("lobeFriction").forGetter(o -> o.lobeFriction)
        ).apply(instance, SoilFluction::new));

        public int iterations;
        public float flowRate;
        public float maxSedimentFlow;
        public float weatheringRate;
        public float lobeFriction;

        public SoilFluction(int iterations, float flowRate, float maxSedimentFlow,
                            float weatheringRate, float lobeFriction) {
            this.iterations = iterations;
            this.flowRate = flowRate;
            this.maxSedimentFlow = maxSedimentFlow;
            this.weatheringRate = weatheringRate;
            this.lobeFriction = lobeFriction;
        }

        public SoilFluction copy() {
            return new SoilFluction(iterations, flowRate, maxSedimentFlow, weatheringRate, lobeFriction);
        }
    }

    public static class AdvancedSubsurfaceFlow {
        public static final Codec<AdvancedSubsurfaceFlow> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("baseViscosity").forGetter(o -> o.baseViscosity),
            Codec.FLOAT.fieldOf("solubility").forGetter(o -> o.solubility),
            Codec.FLOAT.fieldOf("riverThreshold").forGetter(o -> o.riverThreshold),
            Codec.FLOAT.fieldOf("flowMomentum").forGetter(o -> o.flowMomentum),
            Codec.FLOAT.fieldOf("infiltrationRate").forGetter(o -> o.infiltrationRate),
            Codec.INT.fieldOf("iterations").forGetter(o -> o.iterations)
        ).apply(instance, AdvancedSubsurfaceFlow::new));

        public float baseVisvosity;
        public float solubility;
        public float riverThreshold;
        public float flowMomentum;
        public float infiltrationRate;
        public int iterations;

        public AdvancedSubsurfaceFlow(float baseViscosity, float solubility, float riverThreshold, float flowMomentum, float infiltrationRate, int iterations) {
            this.baseVisvosity = baseViscosity;
            this.solubility = solubility;
            this.riverThreshold = riverThreshold;
            this.flowMomentum = flowMomentum;
            this.infiltrationRate = infiltrationRate;
            this.iterations = iterations;
        }

        public AdvancedSubsurfaceFlow copy() {
            return new AdvancedSubsurfaceFlow(baseVisvosity, solubility, riverThreshold, flowMomentum, infiltrationRate, iterations);
        }
    }

    public static class Aquifer {
        public static final Codec<Aquifer> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("basePorosity").forGetter(o -> o.basePorosity),
            Codec.FLOAT.fieldOf("permeabilityScale").forGetter(o -> o.permeabilityScale),
            Codec.FLOAT.fieldOf("rechargeRate").forGetter(o -> o.rechargeRate),
            Codec.FLOAT.fieldOf("pressureFactor").forGetter(o -> o.pressureFactor),
            Codec.BOOL.OptionalFieldOf("simulateFlow").forGetter(o -> o.simulateFlow)
        ).apply(instance, Aquifer::new));

        public float basePorosity;
        public float permeabilityScale;
        public float rechargeRate;
        public float pressureFactor;
        public Boolean simulateFlow;

        public Aquifer(float basePorosity, float permeabilityScale, float rechargeRate, float pressureFactor, Boolean simulateFlow) {
            this.basePorosity = basePorosity;
            this.permeabilityScale = permeabilityScale;
            this.rechargeRate = rechargeRate;
            this.pressureFactor = pressureFactor;
            this.simulateFlow = simulateFlow;
        }

        public Aquifer copy() {
            return new Aquifer(basePorosity, permeabilityScale, rechargeRate, pressureFactor, simulateFlow);
        }
    }

    // ================= SMOOTHING =================
    public static class Smoothing {
        public static final Codec<Smoothing> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("iterations").forGetter(o -> o.iterations),
            Codec.FLOAT.fieldOf("smoothingRadius").forGetter(o -> o.smoothingRadius),
            Codec.FLOAT.fieldOf("smoothingRate").forGetter(o -> o.smoothingRate)
        ).apply(instance, Smoothing::new));

        public int iterations;
        public float smoothingRadius;
        public float smoothingRate;

        public Smoothing(int iterations, float smoothingRadius, float smoothingRate) {
            this.iterations = iterations;
            this.smoothingRadius = smoothingRadius;
            this.smoothingRate = smoothingRate;
        }

        public Smoothing copy() {
            return new Smoothing(iterations, smoothingRadius, smoothingRate);
        }
    }
}