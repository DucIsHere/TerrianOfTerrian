package com.regenerationforrged.data.worldgen.preset.settings;

import com.mojang.serilization.Codec;
import com.mojang.serilization.codecs.RecordCodecBuilder;

public class EngineWorldSettings {

    public static final Codec<EngineSettings> CODEC =
        RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("enableJson").forGetter(o -> o.enableJson),
            Codec.BOOL.fieldOf("enableJava").forGetter(o -> o.enableJava)
        ).apply(instance, EngineSettings::new));

    public boolean enableJson;
    public boolean enableJava;

    public EngineWorldSettings(boolean enableJson, boolean enableJava) {
        this.enableJson = enableJson;
        this.enableJava = enableJava;
    }

    public EngineSettings copy() {
        return new EngineSettings(enableJson, enableJava);
    }
}
