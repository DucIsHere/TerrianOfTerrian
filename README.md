# Regeneration: Advanced Terrain Systems
Regeneration is a next-generation world generation engine that bypasses standard limitations to create hyper-realistic, mathematically driven landscapes. Built on a hybrid architecture, it leverages raw C++ performance via DLL injection to handle complex terrain simulations in real-time.

---

## 🚀 Key Features
### 1. Hybrid Computation Engine

Unlike traditional mods that rely solely on the JVM, Regeneration offloads heavy noise sampling to a custom-built C++ DLL.

-**Native Performance:** Utilizes SIMD instructions for rapid noise generation.

-**FastNoiseLite Integration:** High-speed implementation of OpenSimplex2 and Cellular noise.

### 2. Multi-Layered Terrain Sculpting

The terrain isn't just "generated"—it's sculpted through a sequence of advanced filters:

-**Parametric Mountains:** Mathematically defined ridges and peaks.

-**Sharpness Filter:** Dynamic exponent-based sharpening of terrain peaks.

-**Hydraulic Erosion:** Simulated water runoff patterns for realistic valley formations.

### 3. Data-Driven Customization

Users can completely redefine the world without touching a single line of code.

-**JSON Presets:** Fine-tune every aspect from verticalScale to erosionPersistence.

-**Dynamic Loading:** Inject custom terrain profiles via external configuration files.

### 4. Global Accessibility

Built with a worldwide audience in mind, the system features a robust DataGen-powered localization engine supporting:

**🇺🇸 English (US/UK) | 🇻🇳 Vietnamese | 🇨🇳 Chinese (Simplified) | 🇷🇺 Russian | 🇯🇵 Japanese | 🇪🇸 Spanish | 🇫🇷 French**

## 🛠 Technical Architecture
The project is structured into modular components to ensure scalability and high precision:

-**com.regenerationforrged.world:** The core simulation logic, including Sharpness and Levels processing.

-**FNL & FastNoiseCal2:** The bridge between Java and the native C++ DLL.

-**RGFLanguageProvider:** Automated localization management for multilingual support.

-**TerrainSettings:** The central data hub for all procedural parameters.

## 📖 Configuration
To customize your world, modify the terrain_settings.json file. Example snippet:

JSON 
```json
{
  "filters": {
    "erosion": {
      "dropletVelocity": 0.6996134,
      "erosionRate": 0.30025774,
      "depositeRate": 0.29961342,
      "dropletsPerChunk": 250,
      "dropletLifetime": 18,
      "dropletVolume": 0.7003866
    },
    "smoothing": {
      "iterations": 3,
      "smoothingRadius": 3.501933,
      "smoothingRate": 0.90012884
    }
  },
  "structures": {
    "structures": {
      "nova_structures:witch_villa": {
        "spacing": 80,
        "separation": 20,
        "salt": 3042970,
        "disabled": false
      },
      "minecraft:woodland_mansions": {
        "spacing": 80,
        "separation": 20,
        "salt": 10387319,
        "disabled": false
      },
      "ctov:pillager_outposts": {
        "spacing": 32,
        "separation": 8,
        "salt": 165745296,
        "disabled": false
      },
      "nova_structures:wells": {
        "spacing": 40,
        "separation": 15,
        "salt": 430930,
        "disabled": false
      },
      "minecraft:swamp_huts": {
        "spacing": 32,
        "separation": 8,
        "salt": 14357620,
        "disabled": false
      },
      "minecraft:ancient_cities": {
        "spacing": 24,
        "separation": 8,
        "salt": 20083232,
        "disabled": false
      },
      "supplementaries:way_signs": {
        "spacing": 19,
        "separation": 10,
        "salt": 431041527,
        "disabled": false
      },
      "minecraft:jungle_temples": {
        "spacing": 32,
        "separation": 8,
        "salt": 14357619,
        "disabled": false
      },
      "nova_structures:illager_hideout": {
        "spacing": 200,
        "separation": 12,
        "salt": 3094032,
        "disabled": false
      },
      "minecraft:desert_pyramids": {
        "spacing": 32,
        "separation": 8,
        "salt": 14357617,
        "disabled": false
      },
      "towns_and_towers:towers": {
        "spacing": 48,
        "separation": 24,
        "salt": 205745294,
        "disabled": false
      },
      "nova_structures:underground_house": {
        "spacing": 20,
        "separation": 10,
        "salt": 23094,
        "disabled": false
      },
      "nova_structures:desert_ruins": {
        "spacing": 80,
        "separation": 12,
        "salt": 239021,
        "disabled": false
      },
      "nova_structures:stray_fort": {
        "spacing": 100,
        "separation": 16,
        "salt": 709971604,
        "disabled": false
      },
      "minecraft:pillager_outposts": {
        "spacing": 1000,
        "separation": 8,
        "salt": 165745296,
        "disabled": true
      },
      "nova_structures:badlands_miner_outpost": {
        "spacing": 90,
        "separation": 12,
        "salt": 783,
        "disabled": false
      },
      "ctov:villages": {
        "spacing": 302,
        "separation": 151,
        "salt": 153873121,
        "disabled": false
      },
      "nova_structures:creeping_crypt": {
        "spacing": 100,
        "separation": 10,
        "salt": 7498398,
        "disabled": false
      },
      "towns_and_towers:other": {
        "spacing": 32,
        "separation": 16,
        "salt": 30084234,
        "disabled": false
      },
      "minecraft:shipwrecks": {
        "spacing": 24,
        "separation": 4,
        "salt": 165745295,
        "disabled": false
      },
      "minecraft:trail_ruins": {
        "spacing": 34,
        "separation": 8,
        "salt": 83469867,
        "disabled": false
      },
      "nova_structures:taverns": {
        "spacing": 404,
        "separation": 205,
        "salt": 783,
        "disabled": false
      },
      "nova_structures:bunker": {
        "spacing": 50,
        "separation": 10,
        "salt": 679854,
        "disabled": false
      },
      "nova_structures:firewatch_towers": {
        "spacing": 50,
        "separation": 15,
        "salt": 123,
        "disabled": false
      },
      "nova_structures:mangrove_witch_hut": {
        "spacing": 32,
        "separation": 8,
        "salt": 594,
        "disabled": false
      },
      "minecraft:igloos": {
        "spacing": 32,
        "separation": 8,
        "salt": 14357618,
        "disabled": false
      },
      "minecraft:ruined_portals": {
        "spacing": 40,
        "separation": 15,
        "salt": 34222645,
        "disabled": false
      },
      "nova_structures:villages_swamp": {
        "spacing": 34,
        "separation": 8,
        "salt": 10387312,
        "disabled": false
      },
      "nova_structures:illager_camp": {
        "spacing": 26,
        "separation": 12,
        "salt": 4533232,
        "disabled": false
      },
      "minecraft:buried_treasures": {
        "spacing": 1,
        "separation": 0,
        "salt": 0,
        "disabled": false
      },
      "nova_structures:jungle_ruins": {
        "spacing": 80,
        "separation": 12,
        "salt": 239021,
        "disabled": false
      },
      "nova_structures:conduit_ruin": {
        "spacing": 140,
        "separation": 90,
        "salt": 394,
        "disabled": false
      },
      "minecraft:villages": {
        "spacing": 1000,
        "separation": 8,
        "salt": 10387312,
        "disabled": true
      },
      "nova_structures:wild_ruin": {
        "spacing": 23,
        "separation": 18,
        "salt": 75489234,
        "disabled": false
      },
      "nova_structures:ruin_town": {
        "spacing": 60,
        "separation": 12,
        "salt": 39043,
        "disabled": false
      },
      "minecraft:ocean_ruins": {
        "spacing": 20,
        "separation": 8,
        "salt": 14357621,
        "disabled": false
      },
      "minecraft:mineshafts": {
        "spacing": 1,
        "separation": 0,
        "salt": 0,
        "disabled": false
      },
      "nova_structures:villages_jungle": {
        "spacing": 34,
        "separation": 8,
        "salt": 10387312,
        "disabled": false
      },
      "nova_structures:undead_crypt": {
        "spacing": 100,
        "separation": 20,
        "salt": 96586859,
        "disabled": false
      },
      "minecraft:ocean_monuments": {
        "spacing": 32,
        "separation": 5,
        "salt": 10387313,
        "disabled": false
      },
      "towns_and_towers:towns": {
        "spacing": 48,
        "separation": 24,
        "salt": 10587309,
        "disabled": false
      }
    }
  },
  "miscellaneous": {
    "vanillaLavaLakes": false,
    "vanillaLavaSprings": false,
    "mountainBiomeUsage": 0.40012887,
    "volcanoBiomeUsage": 0.4,
    "naturalSnowDecorator": true,
    "customBiomeFeatures": true,
    "vanillaSprings": false,
    "oreCompatibleStoneOnly": true,
    "erosionDecorator": true,
    "plainStoneErosion": true,
    "smoothLayerDecorator": true,
    "strataRegionSize": 50,
    "strataDecorator": false
  },
  "terrain": {
    "torridonian": {
      "weight": 1.0244845,
      "baseScale": 1.5,
      "verticalScale": 1.0,
      "horizontalScale": 2.8930411
    },
    "mountains": {
      "weight": 1.6623712,
      "baseScale": 1.5,
      "verticalScale": 3.4664948,
      "horizontalScale": 10.0
    },
    "volcano": {
      "weight": 0.6185567,
      "baseScale": 1.0,
      "verticalScale": 1.0,
      "horizontalScale": 3.1121135
    },
    "plateau": {
      "weight": 0.0,
      "baseScale": 1.0,
      "verticalScale": 1.0,
      "horizontalScale": 1.0
    },
    "badlands": {
      "weight": 0.0,
      "baseScale": 1.0,
      "verticalScale": 1.0,
      "horizontalScale": 1.0
    },
    "plains": {
      "weight": 1.0567011,
      "baseScale": 1.5128866,
      "verticalScale": 1.5399485,
      "horizontalScale": 2.5515463
    },
    "hills": {
      "weight": 2.0,
      "baseScale": 1.4948454,
      "verticalScale": 1.8298969,
      "horizontalScale": 5.966495
    },
    "dales": {
      "weight": 1.5,
      "baseScale": 1.496134,
      "verticalScale": 2.0167525,
      "horizontalScale": 4.027062
    },
    "general": {
      "globalHorizontalScale": 1.804085,
      "fancyMountains": false,
      "terrainSeedOffset": 461441346,
      "terrainRegionSize": 2000,
      "globalVerticalScale": 1.0
    },
    "steppe": {
      "weight": 0.0,
      "baseScale": 1.0,
      "verticalScale": 1.0,
      "horizontalScale": 1.0
    }
  },
  "rivers": {
    "branchRivers": {
      "bankWidth": 45,
      "bedWidth": 18,
      "fade": 0.61275774,
      "bedDepth": 10,
      "minBankHeight": 1,
      "maxBankHeight": 1
    },
    "lakes": {
      "sizeMin": 54,
      "sizeMax": 500,
      "minBankHeight": 1,
      "maxBankHeight": 1,
      "chance": 0.3,
      "minStartDistance": 0.23775773,
      "maxStartDistance": 0.03,
      "depth": 20
    },
    "wetlands": {
      "chance": 0.6,
      "sizeMin": 175,
      "sizeMax": 225
    },
    "seedOffset": -104209537,
    "riverCount": 9,
    "mainRivers": {
      "bankWidth": 40,
      "bedWidth": 17,
      "fade": 0.5186856,
      "bedDepth": 10,
      "minBankHeight": 1,
      "maxBankHeight": 1
    }
  },
  "world": {
    "continent": {
      "continentType": "MULTI_IMPROVED",
      "continentScale": 7365,
      "continentJitter": 0.7
    },
    "controlPoints": {
      "shallowOcean": 0.25,
      "beach": 0.327,
      "coast": 0.448,
      "inland": 0.502,
      "deepOcean": 0.1
    },
    "properties": {
      "seaLevel": 63,
      "spawnType": "CONTINENT_CENTER",
      "worldHeight": 1024
    }
  },
  "surface": {
    "erosion": {
      "dirtMin": 265,
      "rockSteepness": 0.6881443,
      "dirtSteepness": 0.53350514,
      "screeSteepness": 0.4523196,
      "rockVariance": 21,
      "rockMin": 295,
      "dirtVariance": 19
    }
  },
  "caves": {
    "ravineCarverProbability": 0.0,
    "largeOreVeins": true,
    "legacyCarverDistribution": false,
    "caveCarverProbability": 0.0,
    "deepCaveCarverProbability": 0.0,
    "cheeseCaveProbability": 1.0,
    "spaghettiCaveProbability": 1.0,
    "noodleCaveProbability": 1.0,
    "entranceCaveProbability": 1.0,
    "cheeseCaveDepthOffset": 10.0
  },
  "climate": {
    "temperature": {
      "min": 0.0,
      "max": 0.4349227,
      "bias": 0.3208763,
      "seedOffset": 930814948,
      "scale": 7,
      "falloff": 3
    },
    "moisture": {
      "min": 0.19523196,
      "max": 0.7042526,
      "bias": 0.3943299,
      "seedOffset": 1099933728,
      "scale": 5,
      "falloff": 1
    },
    "biomeShape": {
      "biomeSize": 566,
      "macroNoiseSize": 15,
      "biomeWarpScale": 153,
      "biomeWarpStrength": 80
    },
    "biomeEdgeShape": {
      "gain": 0.5067655,
      "lacunarity": 2.65,
      "strength": 14,
      "type": "SIMPLEX",
      "scale": 24,
      "octaves": 2
    }
  }
}
```
## 🏗 Installation
Ensure you have the latest version of Minecraft Fabric installed.

Drop the Regeneration.jar into your mods folder.

Note: The mod automatically manages the required DLL dependencies for the C++ backend.

## 🤝 Contribution 
No contribution
Create&Development by Student Secondary School
