# Regeneration Forged
Regeneration Forrged is a high-performance Minecraft World Generation mod designed with a unique Dual-Engine architecture. It allows creators to toggle between complex, procedurally generated Java logic and optimized, data-driven JSON density functions.

# 🚀 Key Features
Hybrid Engine System:

**Java Engine: Leverages 17+ custom Mixins to handle advanced features like Sharpness, Jitter, and seamless TerraBlender integration.**

**JSON Engine: A lightweight, high-performance mode that relies on Vanilla-style Density Functions while applying a custom Amp Noise (x8 amplitude) multiplier.**

*Dynamic Preset Logic:* The engine automatically detects the world configuration and "kills" unnecessary code paths to save CPU cycles.

*Modular Settings:* Fully data-driven configuration for Terrains, Caves, Rivers, and Climates.

# 🛠 Architectural "Kill-Switch"
To ensure the Java logic (which is heavy on CPU) doesn't interfere with the JSON engine, the mod implements a global state-check.

*Detection:* On world load, MixinMinecraftServer reads the is_java_engine flag from the Preset.

*Redirection:* If false, the EngineState is set to JSON.

*Bypass:* 17+ Mixins (TerraBlender, Custom Carvers, etc.) hit a "Head Return" and stop execution immediately.

#📂 Project Structure
**com.regenerationforrged.mixin:** Core engine injection points.

**data/worldgen/preset:** JSON definitions for world structures.

**settings/:** Java POJO classes (Terrain, Cave, River) that are only processed when the Java Engine is active.

# 📝 Developer Usage
Adding a New Mixin

When adding new Java-based generation logic, always include the engine check at the top of your @Inject method to maintain JSON-mode compatibility:

**Java**
```java
if (EngineState.currentType == EngineState.Type.JSON) return;
```
Configuring Amp Noise

For **JSON** presets, you can adjust the terrain scale in MixinNoiseParameters. It targets ImmutableCollections to ensure it only modifies data-driven noise, leaving internal vanilla constants untouched.


***successor***
