package com.regenerationforrged.world.worldgen.cell.continent.simple;

import com.regenerationforrged.world.worldgen.GeneratorContext;
import com.regenerationforrged.world.worldgen.util.Seed;

public class MultiContinentGenerator extends ContinentGenerator {
	
    public MultiContinentGenerator(Seed seed, GeneratorContext context) {
        super(seed, context);
    }

	@Override
	@Override
public void apply(Cell cell, float x, float y) {
    // 1. Lấy settings từ context (đã có sẵn trong class cha)
    var continentSettings = context.preset.world().continent;
    
    // 2. Warp tọa độ (giữ nguyên logic dùng this.warp.get() của bạn)
    float wx = this.warp.getX(x, y, this.seed);
    float wy = this.warp.getY(x, y, this.seed);
    float px = wx * this.frequency;
    float py = wy * this.frequency;

    // 3. Tìm tọa độ ô lục địa (cellX, cellZ) - Logic gốc của bạn
    int xi = NoiseUtil.floor(px);
    int yi = NoiseUtil.floor(py);

    // --- BẮT ĐẦU CHÈN LOGIC SLIDER MỚI ---
    
    // Tạo một số ngẫu nhiên (hash) dựa trên tọa độ ô
    float hash = NoiseUtil.hash2D(xi, yi);

    // A. Xử lý Continent Skipping (Nếu hash thấp hơn slider thì bỏ qua)
    if (hash < continentSettings.continentSkipping) {
        cell.continentEdge = 0; // Biến thành đại dương
        return;
    }

    // B. Xử lý Size Variance (Thay đổi độ lệch ngẫu nhiên cho từng ô)
    // Thay vì dùng cố định this.offsetAlpha, ta cộng thêm variance từ slider
    float currentJitter = this.offsetAlpha + (hash * continentSettings.sizeVariance);
    
    // --- TIẾP TỤC LOGIC GỐC VỚI currentJitter ---
    
    // Trong vòng lặp tìm điểm gần nhất (Voronoi), bạn thay this.offsetAlpha bằng currentJitter
    // Ví dụ: 
    // float cxf = cx + vec.x() * currentJitter;
    // float czf = cz + vec.y() * currentJitter;
    
    // ... phần còn lại của hàm apply giữ nguyên ...
}
}
