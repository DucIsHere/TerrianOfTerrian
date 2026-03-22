#include <vector>

float calculateCurvature(const std::vector<std::vector<float>>& map, int x, int z) {
    float center = map[x][z];
    float left   = map[x - 1][z];
    float right  = map[x + 1][z];
    float up     = map[x][z + 1];
    float down   = map[x][z - 1];

    // Đạo hàm bậc hai (Laplacian approximation)
    // Công thức: f''(x) ≈ (f(x+h) - 2f(x) + f(x-h)) / h^2
    float d2x = (right - 2 * center + left);
    float d2z = (up - 2 * center + down);

    return d2x + d2z; // Tổng độ cong tại điểm (x, z)
}