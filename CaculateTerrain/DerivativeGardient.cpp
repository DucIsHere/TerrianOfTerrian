#include <iostream>
#include <vector>
#include <cmath>

struct Vector2 {
    float dx, dz;
    float magnitude() const { return std::sqrt(dx * dx + dz * dz); }
};

// Giả sử đây là hàm lấy độ cao từ Noise hoặc Map dữ liệu của bạn
float getHeight(int x, int z, const std::vector<std::vector<float>>& grid) {
    // Cần kiểm tra biên để tránh crash
    return grid[x][z];
}

int main() {
    // Giả sử một lưới địa hình 10x10
    std::vector<std::vector<float>> terrain(10, std::vector<float>(10, 0.0f));
    
    // Tọa độ điểm cần tính
    int x = 5, z = 5;
    float step = 1.0f; // Khoảng cách giữa các khối (Minecraft là 1.0)

    // 1. TÍNH GRADIENT (Đạo hàm bậc 1)
    // Sử dụng công thức Central Difference để chính xác hơn
    float dfdx = (getHeight(x + 1, z, terrain) - getHeight(x - 1, z, terrain)) / (2 * step);
    float dfdz = (getHeight(x, z + 1, terrain) - getHeight(x, z - 1, terrain)) / (2 * step);
    
    Vector2 gradient = {dfdx, dfdz};
    float slope = gradient.magnitude();

    // 2. TÍNH ĐỘ CONG (Curvature - Đạo hàm bậc 2)
    // Tính xấp xỉ toán tử Laplace (Laplacian)
    float d2fdx2 = (getHeight(x + 1, z, terrain) - 2 * getHeight(x, z, terrain) + getHeight(x - 1, z, terrain)) / (step * step);
    float d2fdz2 = (getHeight(x, z + 1, terrain) - 2 * getHeight(x, z, terrain) + getHeight(x, z - 1, terrain)) / (step * step);
    
    float curvature = d2fdx2 + d2fdz2;

    // 3. ỨNG DỤNG LOGIC
    std::cout << "Do doc (Slope): " << slope << std::endl;
    
    if (curvature > 0.5f) {
        std::cout << "Day la mot thung lung (Lom)" << std::endl;
    } else if (curvature < -0.5f) {
        std::cout << "Day la mot dinh doi (Loi)" << std::endl;
    }

    return 0;
}