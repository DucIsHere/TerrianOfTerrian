package com.regenerationforrged.mixin;

import com.regenerationforrged.engine.EngineControl;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import java.util.List;
import java.util.Set;

public class TOTMixinPlugin implements IMixinConfigPlugin {
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        // Kiểm tra nếu Mixin thuộc về RTF Legacy (Racoonman)
        if (mixinClassName.contains("racoonman.reterraforged")) {
            return EngineControl.isLegacy();
        }
        
        // Kiểm tra nếu Mixin thuộc về ToT Engine chính của bạn
        if (mixinClassName.contains("com.tot.engine")) {
            return EngineControl.isToT();
        }

        return true; // Các mixin hệ thống khác vẫn cho chạy bình thường
    }

    // Các hàm bắt buộc khác (để trống)
    @Override public void onLoad(String mixinPackage) {}
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String target, ClassNode targetClass, String mixin, IMixinInfo info) {}
    @Override public void postApply(String target, ClassNode targetClass, String mixin, IMixinInfo info) {}
}
