package com.regenerationforrged.world.worldgen.cell.advaced;

import com.regenerationforrged.data.worldgen.preset.settings.WorldSettings;
import com.regenerationforrged.world.worldgen.GeneratorContext;
import com.regenerationforrged.world.worldgen.cell.continent.SimpleContinent;
import com.regenerationforrged.world.worldgen.cell.continent.simple.SimpleRiverGenerator;
import com.regenerationforrged.world.worldgen.cell.heightmap.ControlPoints;
import com.regenerationforrged.world.worldgen.cell.rivermap.RiverCache;
import com.regenerationforrged.world.worldgen.noise.NoiseUtil;
import com.regenerationforrged.world.worldgen.util.PosUtil;
import com.regenerationforrged.world.worldgen.util.Seed;

public abstract class AbstractContinent implements SimpleContinent {
  protected int seed;
  protected int skippingSeed;
  protected int continentScale;
  protected float jitter;
  protected boolean hasSkipping;
  protected float skipThreshold;
  protected RiverCache riverCache;
  protected ControlPoints controlPoints;

  public AbstractContinent(Seed seed, GeneratorContext context) {
    WorldSettings settings = context.preset.world();
    this.seed = seed.next();
    this.skippingSeed = seed.next();
    this.ContinentScale = settings.continent.continentScale;
    this.jitter = settings.continent.continentJiiter;
    this.skipThreshold = settings.continent.continentSkipping;
    this.
  }
}
