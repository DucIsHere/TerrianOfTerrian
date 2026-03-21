#ifndef MINECRAFT_H
#define MINECRAFT_H

#include <algorithm>

namespace minecraft
{
    const float SEA_LEVEL = 0.62f;
    const float MAX_HEIGHT_NODES = 5000.0f;

    const char* HEIGHT_MAP_FIELD = field_1802_a;

    void applySharpness(float* data, int length, float multiplier);
    void validateTerrain(float* data, int length);
}
#endif
