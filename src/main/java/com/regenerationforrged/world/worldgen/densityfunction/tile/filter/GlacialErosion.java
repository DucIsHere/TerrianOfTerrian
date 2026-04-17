package com.regenerationforrged.world.worldgen.densityfunction.tile.filter;

import java.util.Arrays;
import java.util.function.IntFunction;

import com.regenerationforrged.data.worldgen.preset.settings.FilterSettings;
import com.regenerationforrged.world.worldgen.GeneratorContext;
import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.cell.heightmap.Levels;
import com.regenerationforrged.world.worldgen.densityfunction.tile.Size;
import com.regenerationforrged.world.worldgen.noise.NoiseUtil;
import com.regenerationforrged.world.worldgen.util.FastRandom;

public class GlacialEros implements Filter {
    private final float erodeSpeed;
    private final float depositSpeed;
    private final float initialSpeed;
    private final float initialIceVolume;
    private final int maxIceLifetime;
    private final int[][] erosionBrushIndices;
    private final float[][] erosionBrushWeights;
    private final int seed;
    private final int mapSize;
    private final Modifier modifier;
    private final float snowLine; // Cao độ bắt đầu đóng băng

    public GlacialEros(final int seed, final int mapSize, final float erodeSpeed, final float depositSpeed, final float iceVolume, final int maxLifetime, final float snowLine, final Modifier modifier) {
        this.seed = seed;
        this.mapSize = mapSize;
        this.modifier = modifier;
        this.erodeSpeed = erodeSpeed;
        this.depositSpeed = depositSpeed;
        this.initialSpeed = 0.25f; // Băng trôi rất chậm so với nước
        this.initialIceVolume = iceVolume;
        this.maxIceLifetime = maxLifetime;
        this.snowLine = snowLine;
        
        this.erosionBrushIndices = new int[mapSize * mapSize][];
        this.erosionBrushWeights = new float[mapSize * mapSize][];
        
        // Khởi tạo cọ (brush) bào mòn, bán kính lớn hơn (6) để tạo thung lũng rộng
        this.initBrushes(mapSize, 6); 
    }

    public int getSize() {
        return this.mapSize;
    }

    @Override
    public void apply(Filterable map, int regionX, int regionZ, int iterationsPerChunk) {
        final int chunkX = map.getBlockX() >> 4;
        final int chunkZ = map.getBlockZ() >> 4;
        final int lengthChunks = map.getBlockSize().total() >> 4;
        final int borderChunks = map.getBlockSize().border() >> 4;
        final Size size = map.getBlockSize();
        final int mapSize = size.total();
        final float maxPos = (float)(mapSize - 2);

        final Cell[] cells = map.getBacking();
        final TerrainPos gradient1 = new TerrainPos();
        final TerrainPos gradient2 = new TerrainPos();
        final FastRandom random = new FastRandom();

        for (int i = 0; i < iterationsPerChunk; ++i) {
            final long iterationSeed = NoiseUtil.seed(this.seed, i);
            for (int cz = 0; cz < lengthChunks; ++cz) {
                final int relZ = cz << 4;
                final int seedZ = chunkZ + cz - borderChunks;
                for (int cx = 0; cx < lengthChunks; ++cx) {
                    final int relX = cx << 4;
                    final int seedX = chunkX + cx - borderChunks;

                    final long chunkSeed = NoiseUtil.seed(seedX, seedZ);
                    random.seed(chunkSeed, iterationSeed);

                    float posX = (float)(relX + random.nextInt(16));
                    float posZ = (float)(relZ + random.nextInt(16));

                    posX = NoiseUtil.clamp(posX, 1.0f, maxPos);
                    posZ = NoiseUtil.clamp(posZ, 1.0f, maxPos);

                    // Chỉ thả "khối băng" ở nơi có cao độ vượt quá snow line
                    int idx = ((int)posZ) * mapSize + (int)posX;
                    if (cells[idx].height >= this.snowLine) {
                        this.applyGlacierDrop(posX, posZ, cells, mapSize, gradient1, gradient2);
                    }
                }
            }
        }
    }

    private void applyGlacierDrop(float posX, float posY, final Cell[] cells, final int mapSize, final TerrainPos gradient1, final TerrainPos gradient2) {
        float dirX = 0.0f;
        float dirY = 0.0f;
        float sediment = 0.0f;
        float speed = this.initialSpeed;
        float ice = this.initialIceVolume;
        
        gradient1.reset();
        gradient2.reset();

        for (int lifetime = 0; lifetime < this.maxIceLifetime; ++lifetime) {
            final int nodeX = (int)posX;
            final int nodeY = (int)posY;
            final int dropletIndex = nodeY * mapSize + nodeX;
            final float cellOffsetX = posX - nodeX;
            final float cellOffsetY = posY - nodeY;

            gradient1.at(cells, mapSize, posX, posY);

            // Băng có quán tính lớn, chuyển hướng chậm hơn nước
            dirX = dirX * 0.25f - gradient1.gradientX * 0.75f;
            dirY = dirY * 0.25f - gradient1.gradientY * 0.75f;

            float len = (float)Math.sqrt(dirX * dirX + dirY * dirY);
            if (Float.isNaN(len)) len = 0.0f;
            if (len != 0.0f) {
                dirX /= len;
                dirY /= len;
            }

            posX += dirX;
            posY += dirY;

            if ((dirX == 0.0f && dirY == 0.0f) || posX < 0.0f || posX >= mapSize - 1 || posY < 0.0f || posY >= mapSize - 1) {
                return;
            }

            final float newHeight = gradient2.at(cells, mapSize, posX, posY).height;
            final float deltaHeight = newHeight - gradient1.height;

            // Băng mang được lượng trầm tích cực kỳ lớn
            final float sedimentCapacity = Math.max(-deltaHeight * speed * ice * 8.0f, 0.05f);

            // Băng tan khi xuống độ cao thấp
            if (cells[dropletIndex].height < this.snowLine) {
                ice *= 0.85f; // Tan rất nhanh
            } else {
                ice *= 0.999f; // Thăng hoa rất chậm ở trên núi
            }

            if (sediment > sedimentCapacity || deltaHeight > 0.0f || ice < 0.01f) {
                // Nhả trầm tích (Tạo ra các bãi băng tích đá hộc - moraines)
                final float amountToDeposit = (deltaHeight > 0.0f) ? Math.min(deltaHeight, sediment) : ((sediment - sedimentCapacity) * this.depositSpeed);
                sediment -= amountToDeposit;

                this.deposit(cells[dropletIndex], amountToDeposit * (1.0f - cellOffsetX) * (1.0f - cellOffsetY));
                this.deposit(cells[dropletIndex + 1], amountToDeposit * cellOffsetX * (1.0f - cellOffsetY));
                this.deposit(cells[dropletIndex + mapSize], amountToDeposit * (1.0f - cellOffsetX) * cellOffsetY);
                this.deposit(cells[dropletIndex + mapSize + 1], amountToDeposit * cellOffsetX * cellOffsetY);
                
                if (ice < 0.01f) return; // Kết thúc chu trình vì băng tan hết
            } else {
                // Quá trình cày xới và mài mòn (Abrasion)
                final float amountToErode = Math.min((sedimentCapacity - sediment) * this.erodeSpeed, -deltaHeight);

                for (int brushPointIndex = 0; brushPointIndex < this.erosionBrushIndices[dropletIndex].length; ++brushPointIndex) {
                    final int nodeIndex = this.erosionBrushIndices[dropletIndex][brushPointIndex];
                    final Cell cell = cells[nodeIndex];
                    final float brushWeight = this.erosionBrushWeights[dropletIndex][brushPointIndex];
                    final float weighedErodeAmount = amountToErode * brushWeight;
                    final float deltaSediment = Math.min(cell.height, weighedErodeAmount);
                    this.erode(cell, deltaSediment);
                    sediment += deltaSediment;
                }
            }

            speed = (float)Math.sqrt(speed * speed + deltaHeight * 1.5f);
            if (Float.isNaN(speed)) speed = 0.0f;
        }
    }

    private void initBrushes(final int size, final int radius) {
        final int[] xOffsets = new int[radius * radius * 4];
        final int[] yOffsets = new int[radius * radius * 4];
        final float[] weights = new float[radius * radius * 4];
        float weightSum = 0.0f;
        int addIndex = 0;

        for (int i = 0; i < this.erosionBrushIndices.length; ++i) {
            final int centreX = i % size;
            final int centreY = i / size;

            if (centreY <= radius || centreY >= size - radius || centreX <= radius + 1 || centreX >= size - radius) {
                weightSum = 0.0f;
                addIndex = 0;
                for (int y = -radius; y <= radius; ++y) {
                    for (int x = -radius; x <= radius; ++x) {
                        final float sqrDst = (float)(x * x + y * y);
                        if (sqrDst < radius * radius) {
                            final int coordX = centreX + x;
                            final int coordY = centreY + y;

                            if (coordX >= 0 && coordX < size && coordY >= 0 && coordY < size) {
                                // TẠO HÌNH CHỮ U (U-Shape Valley): Dùng Falloff bậc 2 để đáy thung lũng phẳng hơn
                                final float distanceNormalized = (float)Math.sqrt(sqrDst) / radius;
                                final float weight = 1.0f - (distanceNormalized * distanceNormalized);
                                weightSum += weight;
                                weights[addIndex] = weight;
                                xOffsets[addIndex] = x;
                                yOffsets[addIndex] = y;
                                ++addIndex;
                            }
                        }
                    }
                }
            }

            final int numEntries = addIndex;
            this.erosionBrushIndices[i] = new int[numEntries];
            this.erosionBrushWeights[i] = new float[numEntries];

            for (int j = 0; j < numEntries; ++j) {
                this.erosionBrushIndices[i][j] = (yOffsets[j] + centreY) * size + xOffsets[j] + centreX;
                this.erosionBrushWeights[i][j] = weights[j] / weightSum;
            }
        }
    }

    private void deposit(final Cell cell, final float amount) {
        if (!cell.erosionMask) {
            final float change = this.modifier.modify(cell, amount);
            cell.height += change;
            cell.sediment += change;
        }
    }

    private void erode(final Cell cell, final float amount) {
        if (!cell.erosionMask) {
            final float change = this.modifier.modify(cell, amount);
            cell.height -= change;
            cell.heightErosion -= change;
        }
    }

    private static class TerrainPos {
        private float height;
        private float gradientX;
        private float gradientY;

        private TerrainPos at(final Cell[] nodes, final int mapSize, final float posX, final float posY) {
            final int coordX = (int)posX;
            final int coordY = (int)posY;
            final float x = posX - coordX;
            final float y = posY - coordY;
            final int nodeIndexNW = coordY * mapSize + coordX;
            
            final float heightNW = nodes[nodeIndexNW].height;
            final float heightNE = nodes[nodeIndexNW + 1].height;
            final float heightSW = nodes[nodeIndexNW + mapSize].height;
            final float heightSE = nodes[nodeIndexNW + mapSize + 1].height;

            this.gradientX = (heightNE - heightNW) * (1.0f - y) + (heightSE - heightSW) * y;
            this.gradientY = (heightSW - heightNW) * (1.0f - x) + (heightSE - heightNE) * x;
            this.height = heightNW * (1.0f - x) * (1.0f - y) + heightNE * x * (1.0f - y) + heightSW * (1.0f - x) * y + heightSE * x * y;
            return this;
        }

        private void reset() {
            this.height = 0.0f;
            this.gradientX = 0.0f;
            this.gradientY = 0.0f;
        }
    }

    // Factory để WorldFilters gọi tạo Instance tự động khi block size thay đổi
    public static IntFunction<GlacialEros> factory(final GeneratorContext context) {
        return new Factory(context.seed.root(), context.levels);
    }

    private static class Factory implements IntFunction<GlacialEros> {
        private final int seed;
        private final Modifier modifier;
        private final float snowLine;

        private Factory(final int seed, final Levels levels) {
            this.seed = seed + 14567; // Tách seed ra khỏi thủy xói mòn
            this.modifier = Modifier.range(levels.ground, levels.ground(150)).invert();
            // Thiết lập tuyến băng mặc định (Có thể thay từ FilterSettings)
            this.snowLine = levels.ground(80); 
        }

        @Override
        public GlacialEros apply(final int size) {
            // Có thể truyền biến từ Preset (nhưng ở đây mình dùng các hằng số cứng chuẩn vật lý)
            return new GlacialEros(this.seed, size, 0.15f, 0.20f, 1.2f, 40, this.snowLine, this.modifier);
        }
    }
}