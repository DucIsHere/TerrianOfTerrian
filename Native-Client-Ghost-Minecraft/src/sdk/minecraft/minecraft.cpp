#include "minecraft.h"
#include <cmath>

namespace Minecraft {

    // Thuật toán đẩy núi cao 5000m
    void applySharpness(float* data, int length, float multiplier) {
        for (int i = 0; i < length; i++) {
            if (data[i] > SEA_LEVEL) {
                // Công thức: Chiều cao mới = Mực nước + (Độ chênh lệch * Hệ số nhọn)
                float diff = data[i] - SEA_LEVEL;
                data[i] = SEA_LEVEL + (diff * multiplier);
            }
        }
    }

    // Đảm bảo dữ liệu không làm crash Render của Minecraft
    void validateTerrain(float* data, int length) {
        for (int i = 0; i < length; i++) {
            // Cắt cụt nếu vượt quá giới hạn chuẩn hóa 1.0f
            data[i] = std::clamp(data[i], 0.0f, 1.0f);
        }
    }
}