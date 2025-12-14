package com.regenerationgorrged.world.worldgen.cell.heightmap;

import net.minecraft.core.HolderGetter;

import com.regenerationgorrged.data.worldgen.preset.PresetNoiseData;
import com.regenerationgorrged.data.worldgen.preset.PresetTerrainTypeNoise;
import com.regenerationgorrged.data.worldgen.preset.settings.Preset;
import com.regenerationgorrged.data.worldgen.preset.settings.TerrainSettings;
import com.regenerationgorrged.data.worldgen.preset.settings.WorldSettings;

import com.regenerationgorrged.world.worldgen.GeneratorContext;
import com.regenerationgorrged.world.worldgen.biome.Erosion;
import com.regenerationgorrged.world.worldgen.biome.Weirdness;
import com.regenerationgorrged.world.worldgen.cell.Cell;
import com.regenerationgorrged.world.worldgen.cell.CellPopulator;
import com.regenerationgorrged.world.worldgen.cell.climate.Climate;
import com.regenerationgorrged.world.worldgen.cell.continent.Continent;
import com.regenerationgorrged.world.worldgen.cell.continent.ContinentLerper2;
import com.regenerationgorrged.world.worldgen.cell.continent.ContinentLerper3;
import com.regenerationgorrged.world.worldgen.cell.rivermap.Rivermap;
import com.regenerationgorrged.world.worldgen.cell.terrain.Blender;
import com.regenerationgorrged.world.worldgen.cell.terrain.Populators;
import com.regenerationgorrged.world.worldgen.cell.terrain.TerrainType;
import com.regenerationgorrged.world.worldgen.cell.terrain.populator.VolcanoPopulator;
import com.regenerationgorrged.world.worldgen.cell.terrain.provider.TerrainProvider;
import com.regenerationgorrged.world.worldgen.cell.terrain.region.RegionLerper;
import com.regenerationgorrged.world.worldgen.cell.terrain.region.RegionModule;
import com.regenerationgorrged.world.worldgen.cell.terrain.region.RegionSelector;
import com.regenerationgorrged.world.worldgen.noise.function.DistanceFunction;
import com.regenerationgorrged.world.worldgen.noise.function.EdgeFunction;
import com.regenerationgorrged.world.worldgen.noise.function.Interpolation;
import com.regenerationgorrged.world.worldgen.noise.module.Noise;
import com.regenerationgorrged.world.worldgen.noise.module.Noises;
import com.regenerationgorrged.world.worldgen.util.Seed;

public record Heightmap(
        CellPopulator terrain,
        CellPopulator region,
        Continent continent,
        Climate climate,
        Levels levels,
        ControlPoints controlPoints,
        float terrainFrequency,
        Noise beachNoise,
        WorldSettings world,
        TerrainSettings terrainSettings
) {

    /* ================= APPLY ================= */

    public void apply(Cell cell, float x, float z, boolean applyClimate) {
        applyTerrain(cell, x, z);
        applyRivers(cell, x, z, continent.getRivermap(cell));
        applyClimate(cell, x, z, applyClimate);
    }

    private void applyTerrain(Cell cell, float x, float z) {
        cell.terrain = TerrainType.FLATS;
        cell.beachNoise = beachNoise.compute(x, z, 0);

        continent.apply(cell, x, z);
        region.apply(cell, x, z);
        terrain.apply(cell, x * terrainFrequency, z * terrainFrequency);

        /* plateau clamp */
        if (cell.height > terrainSettings.plateauHeight()) {
            cell.height = terrainSettings.plateauHeight();
        }
    }

    private void applyRivers(Cell cell, float x, float z, Rivermap rivermap) {
        rivermap.apply(cell, x, z);
        VolcanoPopulator.modifyVolcanoType(cell, levels);
    }

    private void applyClimate(Cell cell, float x, float z, boolean applyClimate) {
        float riverValleyThreshold = world.riverValleyThreshold();
        float valleyDepth = terrainSettings.valleyDepth();
        float valleyWidth = terrainSettings.valleyWidth();

        if (cell.riverMask < riverValleyThreshold) {
            float k = 1.0F - (cell.riverMask / valleyWidth);
            cell.height -= k * valleyDepth;
            cell.erosion = world.valleyErosion();
            cell.weirdness = world.valleyWeirdness();
        }

        if (cell.terrain.isRiver()) {
            cell.erosion = world.riverErosion();
            cell.weirdness = world.riverWeirdness();
        }

        if (cell.terrain.isLake() && cell.height < levels.water) {
            cell.erosion = Erosion.LEVEL_4.mid();
            cell.weirdness = world.lakeWeirdness();
        }

        if (cell.terrain.isWetland()) {
            cell.erosion = Erosion.LEVEL_6.mid();
            cell.weirdness = Weirdness.VALLEY.mid();
        }

        climate.apply(cell, x, z, applyClimate);

        if (cell.riverMask >= riverValleyThreshold && cell.macroBiomeId > 0.5F) {
            cell.weirdness = -cell.weirdness;
        }
    }

    /* ================= BUILD ================= */

    public static Heightmap make(GeneratorContext context) {
        HolderGetter<Noise> noiseLookup = context.noiseLookup;

        Preset preset = context.preset;
        WorldSettings world = preset.world();
        TerrainSettings terrainSettings = preset.terrain();
        TerrainSettings.General general = terrainSettings.general;

        ControlPoints controlPoints = ControlPoints.make(world.controlPoints);
        Levels levels = context.levels;

        /* ---------- REGION ---------- */

        Seed regionWarp = context.seed.offset(8934);

        RegionConfig regionConfig = new RegionConfig(
                context.seed.root(),
                general.terrainRegionSize,
                Noises.simplex(regionWarp.next(), world.warpScale(), 1),
                Noises.simplex(regionWarp.next(), world.warpScale(), 1),
                world.warpStrength()
        );

        CellPopulator region = new RegionModule(regionConfig);

        /* ---------- MOUNTAINS ---------- */

        Seed mountainSeed = context.seed.offset(general.terrainSeedOffset);

        Noise mountainShape =
                Noises.worleyEdge(
                        mountainSeed.next(),
                        terrainSettings.mountainScale(),
                        EdgeFunction.DISTANCE_2_ADD,
                        DistanceFunction.EUCLIDEAN
                );

        mountainShape =
                Noises.warpPerlin(
                        mountainShape,
                        mountainSeed.next(),
                        terrainSettings.mountainWarpScale(),
                        2,
                        terrainSettings.mountainWarpStrength()
                );

        mountainShape =
                Noises.pow(mountainShape, terrainSettings.mountainSharpness());

        mountainShape =
                Noises.clamp(mountainShape, 0.0F, 1.0F);

        Noise ground =
                PresetNoiseData.getNoise(noiseLookup, PresetTerrainTypeNoise.GROUND);

        CellPopulator terrainRegions =
                new RegionSelector(
                        TerrainProvider.generateTerrain(
                                context.seed,
                                terrainSettings,
                                regionConfig,
                                levels,
                                noiseLookup
                        )
                );

        CellPopulator terrainRegionBorders =
                Populators.makeBorder(
                        context.seed,
                        ground,
                        terrainSettings.plains,
                        terrainSettings.steppe,
                        general.globalVerticalScale
                );

        CellPopulator terrainBlend =
                new RegionLerper(terrainRegionBorders, terrainRegions);

        CellPopulator mountains =
                Populators.makeMountainChain(
                        mountainSeed,
                        ground,
                        terrainSettings.mountains,
                        general.globalVerticalScale * terrainSettings.mountainHeightScale(),
                        general.fancyMountains
                );

        CellPopulator land =
                new Blender(
                        mountainShape,
                        terrainBlend,
                        mountains,
                        terrainSettings.blendLow(),
                        terrainSettings.blendMid(),
                        terrainSettings.blendHigh()
                );

        /* ---------- OCEANS ---------- */

        CellPopulator deepOcean =
                Populators.makeDeepOcean(context.seed.next(), levels.water);

        CellPopulator shallowOcean =
                Populators.makeShallowOcean(levels);

        CellPopulator coast =
                Populators.makeCoast(levels, world.coastSharpness());

        CellPopulator oceans =
                new ContinentLerper3(
                        deepOcean,
                        shallowOcean,
                        coast,
                        controlPoints.deepOcean(),
                        controlPoints.shallowOcean() * world.coastLineBlend(),
                        controlPoints.coast()
                );

        CellPopulator terrain =
                new ContinentLerper2(
                        oceans,
                        land,
                        controlPoints.shallowOcean(),
                        controlPoints.inland()
                );

        /* ---------- BEACH ---------- */

        Noise beachNoise =
                Noises.perlin2(
                        context.seed.next(),
                        world.beachNoiseScale(),
                        1
                );

        beachNoise =
                Noises.mul(beachNoise, levels.scale(world.beachHeight()));

        Continent continent =
                world.continent.continentType.create(context.seed, context);

        Climate climate =
                Climate.make(continent, context);

        float terrainFrequency =
                1.0F / general.globalHorizontalScale;

        return new Heightmap(
                terrain,
                region,
                continent,
                climate,
                levels,
                controlPoints,
                terrainFrequency,
                beachNoise,
                world,
                terrainSettings
        );
    }
}
