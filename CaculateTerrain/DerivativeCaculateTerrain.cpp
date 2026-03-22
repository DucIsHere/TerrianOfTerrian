#include <iostream>
#include <vector>
#include <cmath>
#include <iomanip>

// Giả sử Terrain là lưới 2D (Width x Height)
using HeightMap = std::vector<std::vector<float>>;

struct TerrainAnalysis {
    float gradient;  // Độ dốc
    float curvature; // Độ cong (Lồi/Lõm)
};

// Hàm tính toán chi tiết cho 1 tọa độ (x, z)
TerrainAnalysis analyzePoint(const HeightMap& map, int x, int z) {
    // 1. Tính Gradient (Đạo hàm bậc 1)
    float dx = (map[x + 1][z] - map[x - 1][z]) / 2.0f;
    float dz = (map[x][z + 1] - map[x][z - 1]) / 2.0f;
    float grad = std::sqrt(dx * dx + dz * dz);

    // 2. Tính Curvature (Đạo hàm bậc 2 - Laplacian)
    float d2x = (map[x + 1][z] - 2 * map[x][z] + map[x - 1][z]);
    float d2z = (map[x][z + 1] - 2 * map[x][z] + map[x][z - 1]);
    float curv = d2x + d2z;

    return {grad, curv};
}

int main() {
    // Giả lập một ngọn đồi nhỏ (HeightMap 5x5)
    HeightMap myTerrain = {
        {0, 1, 2, 1, 0},
        {1, 3, 5, 3, 1},
        {2, 5, 8, 5, 2}, // Điểm (2,2) là đỉnh núi cao nhất (8)
        {1, 3, 5, 3, 1},
        {0, 1, 2, 1, 0}
    };

    // Phân tích điểm x=2, z=2 (Đỉnh núi)
    TerrainAnalysis result = analyzePoint(myTerrain, 2, 2);

    std::cout << "Tai dinh nui (2,2):" << std::endl;
    std::cout << "- Do doc (Gradient): " << result.gradient << " (Phang tai dinh)" << std::endl;
    std::cout << "- Do cong (Curvature): " << result.curvature << " (Am nghia la LOI)" << std::endl;

    return 0;
}