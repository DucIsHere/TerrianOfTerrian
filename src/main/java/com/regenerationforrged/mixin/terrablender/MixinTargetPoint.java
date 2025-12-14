package com.regenerationforrged.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.biome.Climate;
import com.regenerationforrged.world.worldgen.terrablender.TBTargetPoint;

@Mixin(Climate.TargetPoint.class)
@Implements(@Interface(iface = TBTargetPoint.class, prefix = "reterraforged$TBTargetPoint$"))
class MixinTargetPoint {
	private double uniqueness = Double.NaN;
	
	public void regenerationforrged$TBTargetPoint$setUniqueness(double uniqueness) {
		this.uniqueness = uniqueness;
	}
	
	@Nullable
	public void regenerationforrged$TBTargetPoint$getUniqueness() {
		return this.uniqueness;
	}
}
