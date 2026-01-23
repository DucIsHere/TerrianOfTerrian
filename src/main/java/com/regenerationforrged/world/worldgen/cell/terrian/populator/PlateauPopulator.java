package com.regenerationforrged.world.worldgen.cell.terrain.populator;

import com.regenerationforrged.world.worldgen.cell.Cell;
import com.regenerationforrged.world.worldgen.cell.CellPopulator;
import com.regenerationforrged.world.worldgen.noise.NoiseUtil;

public record PlateauPopulator(
    CellPopulator source, 
    float minHeight, // Bắt đầu làm phẳng từ độ cao nào (ví dụ 0.5F)
    float maxHeight, // Giới hạn độ cao tối đa của cao nguyên (ví dụ 0.65F)
    float smoothness // Độ dốc của cạnh cao nguyên
) implements CellPopulator {

    @Override
    public void apply(Cell cell, float x, float z) {
    float baseVal = this.base.compute(x, z, 0) * this.baseScale;
    float heightVal = this.height.compute(x, z, 0) * this.heightScale;
    float mountainDelta = (this.mountain != null) ? this.mountain.compute(x, z, 0) : 0.0F;

    float totalHeight = baseVal + heightVal + mountainDelta;

    // LOGIC PLATEAU MỚI:
    // Nếu plateauHeight > 0, ta sẽ bắt đầu "nén" các vùng cao hơn mức này
    if (this.plateauHeight > 0.0F && totalHeight > this.plateauHeight) {
        float overflow = totalHeight - this.plateauHeight;
        // Làm phẳng phần vượt ngưỡng (ví dụ: chỉ cho phép tăng thêm 10% độ cao thực tế)
        totalHeight = this.plateauHeight + (overflow * 0.1F);
    }

    cell.terrain = this.type;
    cell.height = Math.max(totalHeight, 0.0F);
    cell.erosion = this.erosion.compute(x, z, 0);
    cell.weirdness = this.weirdness.compute(x, z, 0);
    }
}
