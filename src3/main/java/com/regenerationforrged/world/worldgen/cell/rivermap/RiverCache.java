package com.regenerationforrged.world.worldgen.cell.rivermap;

import java.util.concurrent.TimeUnit;

import com.regenerationforrged.concurrent.cache.Cache;
import com.regenerationforrged.concurrent.cache.map.StampedLongMap;
import com.regenerationforrged.world.worldgen.util.PosUtil;

public class RiverCache {
    protected RiverGenerator generator;
    protected Cache<Rivermap> cache;
    
    public RiverCache(RiverGenerator generator) {
        this.cache = new Cache<>(32, 5L, 1L, TimeUnit.MINUTES, StampedLongMap::new);
        this.generator = generator;
    }
    
    public Rivermap getRivers(int x, int z) {
        return this.cache.computeIfAbsent(PosUtil.pack(x, z), id -> {
        	return this.generator.generateRivers(PosUtil.unpackLeft(id), PosUtil.unpackRight(id), id);
        });
    }
}
