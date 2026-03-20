#define VPS_SAMPLES 128 // 5090 cân tốt
#define BLOCKER_SAMPLES 64
#define SHADOW_SOFTNESS 0.01

float GetBlockerDepth(vec3 shadowPos, float dither) {
    float blockerDepth = 0.0;
    int blockers = 0;
    for(int i = 0; i < BLOCKER_SAMPLES; i++) {
        vec2 offset = vec2(Bayer64(gl_FragCoord.xy + float(i))) * SHADOW_SOFTNESS;
        float d = shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
        if(d < shadowPos.z) {
            blockerDepth += d;
            blockers++;
        }
    }
    return blockers > 0 ? blockerDepth / float(blockers) : -1.0;
}

vec3 CalculateVPS(vec3 shadowPos) {
    float dither = Bayer64(gl_FragCoord.xy);
    float avgBlocker = GetBlockerDepth(shadowPos, dither);
    if(avgBlocker == -1.0) return vec3(1.0);

    // Tính bán kính Penumbra dựa trên khoảng cách thực tế
    float penumbra = (shadowPos.z - avgBlocker) * SHADOW_SOFTNESS / avgBlocker;
    penumbra = clamp(penumbra, 0.0, 0.02); 

    float shadow = 0.0;
    for(int i = 0; i < VPS_SAMPLES; i++) {
        // Sử dụng Blue Noise hoặc Vogel Disk để lấy mẫu tròn hoàn hảo
        vec2 offset = VogelDiskSample(i, VPS_SAMPLES, dither) * penumbra;
        shadow += shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
    }
    return vec3(shadow / float(VPS_SAMPLES));
}