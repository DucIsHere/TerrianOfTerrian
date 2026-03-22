#ifndef MINECRAFT_H
#define MINECRAFT_H

#include <algorithm>

namespace minecraft
{
    struct NoiseConfig
    {
        float frequency;
        float octaves;
        float presistence;
    }

    const float SEA_LEVEL = 0.62f;
    const float MAX_HEIGHT_NODES = 5000.0f;

    const char* HEIGHT_MAP_FIELD = field_1802_a;

    void applySharpness(float* data, int length, float multiplier);
    void validateTerrain(float* data, int length);
    void computeFastNoise(float* data, int length, float sharpness, const NoiseConfig& config);
}
#endif
