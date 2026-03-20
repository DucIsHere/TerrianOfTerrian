#define VPS_SAMPLES 256        // Số lượng mẫu đổ bóng (Cực cao)
#define BLOCKER_SAMPLES 128    // Tìm vật cản để tính độ nhòe
#define SHADOW_SOFTNESS 0.015  // Độ nhòe tối đa
#define SEARCH_RADIUS 0.01

// Hàm lấy mẫu đĩa Vogel để phân phối mẫu tròn hoàn hảo
vec2 VogelDiskSample(int sampleIndex, int sampleCount, float dither) {
    float r = sqrt(float(sampleIndex) + 0.5) / sqrt(float(sampleCount));
    float theta = float(sampleIndex) * 2.39996322 + dither * 6.283185;
    return vec2(cos(theta), sin(theta)) * r;
}

float GetBlockerDepth(vec3 shadowPos, float dither) {
    float blockerDepth = 0.0;
    int blockers = 0;
    for(int i = 0; i < BLOCKER_SAMPLES; i++) {
        vec2 offset = VogelDiskSample(i, BLOCKER_SAMPLES, dither) * SEARCH_RADIUS;
        float d = shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
        if(d < shadowPos.z) {
            blockerDepth += d;
            blockers++;
        }
    }
    return blockers > 0 ? blockerDepth / float(blockers) : -1.0;
}

vec3 CalculateExtremeVPS(vec3 shadowPos) {
    float dither = InterleavedGradientNoiseForClouds(); // Tận dụng hàm noise có sẵn của ông
    float avgBlocker = GetBlockerDepth(shadowPos, dither);
    
    if(avgBlocker == -1.0) return vec3(1.0);

    // Tính bán kính Penumbra dựa trên khoảng cách thực tế từ vật cản
    float penumbra = (shadowPos.z - avgBlocker) * SHADOW_SOFTNESS / avgBlocker;
    penumbra = clamp(penumbra, 0.0001, 0.03); // Giữ bóng sắc ở gốc, nhòe ở xa

    float shadow = 0.0;
    for(int i = 0; i < VPS_SAMPLES; i++) {
        vec2 offset = VogelDiskSample(i, VPS_SAMPLES, dither) * penumbra;
        shadow += shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
    }
    return vec3(shadow / float(VPS_SAMPLES));
}