package com.regenerationforrged.data.worldgen.preset.settings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class FilterSettings {
	public static final Codec<FilterSettings> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Erosion.CODEC.fieldOf("erosion").forGetter((o) -> o.erosion),
		GlacialErosion.CODEC.fieldOf("glacial").forGetter((o) -> o.glacial),
		Smoothing.CODEC.fieldOf("smoothing").forGetter((o) -> o.smoothing)
	).apply(instance, FilterSettings::new));
	
    public Erosion erosion;
	public GlacialErosion glacial;
    public Smoothing smoothing;
    
    public FilterSettings(Erosion erosion, GlacialErosion glacial, Smoothing smoothing) {
    	this.erosion = erosion;
		this.glacial = glacial;
    	this.smoothing = smoothing;
    }
    
    public FilterSettings copy() {
    	return new FilterSettings(this.erosion.copy(), this.smoothing.copy(), this.glacial.copy());
    }
    
    public static class Erosion {
    	public static final Codec<Erosion> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		Codec.INT.fieldOf("dropletsPerChunk").forGetter((o) -> o.dropletsPerChunk),
    		Codec.INT.fieldOf("dropletLifetime").forGetter((o) -> o.dropletLifetime),
    		Codec.FLOAT.fieldOf("dropletVolume").forGetter((o) -> o.dropletVolume),
    		Codec.FLOAT.fieldOf("dropletVelocity").forGetter((o) -> o.dropletVelocity),
    		Codec.FLOAT.fieldOf("erosionRate").forGetter((o) -> o.erosionRate),
    		Codec.FLOAT.fieldOf("depositeRate").forGetter((o) -> o.depositeRate)
    	).apply(instance, Erosion::new));
    	
    	public int dropletsPerChunk;
        public int dropletLifetime;
        public float dropletVolume;
        public float dropletVelocity;
        public float erosionRate;
        public float depositeRate;
        
        public Erosion(int dropletsPerChunk, int dropletsLifetime, float dropletVolume, float dropletVelocity, float erosionRate, float depositeRate) {
        	this.dropletsPerChunk = dropletsPerChunk;
        	this.dropletLifetime = dropletsLifetime;
        	this.dropletVolume = dropletVolume;
        	this.dropletVelocity = dropletVelocity;
        	this.erosionRate = erosionRate;
        	this.depositeRate = depositeRate;
        }
        
        public Erosion copy() {
        	return new Erosion(this.dropletsPerChunk, this.dropletLifetime, this.dropletVolume, this.dropletVelocity, this.erosionRate, this.depositeRate);
        }
    }

	public static class Glacial {
		public static final Codec<GlacialErosion> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			Codec.INT.fieldOf("iterations").forGetter((o) -> o.iterations),
            Codec.FLOAT.fieldOf("abrasionRate").forGetter((o) -> o.abrasionRate),
            Codec.FLOAT.fieldOf("depositSpeed").forGetter((o) -> o.depositSpeed),
            Codec.FLOAT.fieldOf("accumulationRate").forGetter((o) -> o.accumulationRate),
            Codec.FLOAT.fieldOf("meltRate").forGetter((o) -> o.meltRate),
            Codec.FLOAT.fieldOf("viscosity").forGetter((o) -> o.viscosity),
            Codec.FLOAT.fieldOf("pluckingProbability").forGetter((o) -> o.pluckingProbability),
            Codec.FLOAT.fieldOf("pluckingRate").forGetter((o) -> o.pluckingRate),
            Codec.FLOAT.fieldOf("initialSpeed").forGetter((o) -> o.initialSpeed),
            Codec.FLOAT.fieldOf("initialIceVolume").forGetter((o) -> o.initialIceVolume),
            Codec.INT.fieldOf("maxLifeTime").forGetter((o) -> o.maxLifeTime)
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
			float pluckingProbability, float pluckingRate, float initalSpeed,
			float initalIceVolume, int maxLideTime
		) {
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
			return new GlacialErosion(iterations, abrasionRate, depositSpeed, accumulationRate, meltRate, viscosity, 
                                      pluckingProbability, pluckingRate, initialSpeed, initialIceVolume, maxLifeTime);
		}
	}
    
    public static class Smoothing {
    	public static final Codec<Smoothing> CODEC = RecordCodecBuilder.create(instance -> instance.group(
    		Codec.INT.fieldOf("iterations").forGetter((o) -> o.iterations),
    		Codec.FLOAT.fieldOf("smoothingRadius").forGetter((o) -> o.smoothingRadius),
    		Codec.FLOAT.fieldOf("smoothingRate").forGetter((o) -> o.smoothingRate)    		
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
        	return new Smoothing(this.iterations, this.smoothingRadius, this.smoothingRate);
        }
    }
}
