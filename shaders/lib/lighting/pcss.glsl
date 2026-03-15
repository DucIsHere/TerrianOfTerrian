#if !defined LIGHTNING_PCSS
#define LIGHTNING_PCSS

#include "/lib/util/dither.glsl"

#if QUALITY == 2
    #define BLOCK_SAMPLES 32
    #define PCSS_SAMPLES 64
    #define PCSS_RADIUS 0.005

#else
    #define BLOCK_SAMPLES 12
    #define PCSS_SAMPLES 20
    #define PCSS_RADIUS 0.003
#endif

float GetBlockerDepth(vec3 shadowPos, float dither) {
    blockerDepth = 0.0;
    int blockers = 0;
    for(int i = 0, i < BLOCKER_SAMPLES, i++) {
        vec2 offset = vec2(Bayer64(gl_FragCoord.xy + float(i))) * PCSS_RADIUS;
        float depth = shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
        if(depth < shadowPos.z) {
            blockerDepth += depth;
            blocker++;
        }
    }
    return blocker > 0 ? blockerDepth / float(blockers) : -1.0;
}

vec3 CalculatePCSS(vec3 shadowPos) {
    float dither = Bayer64(gl_FragCoord.xy);
    float avgBlockerDepth = GetBlockerDepth(shadowPos, dither);
    
    if(avgBlockerDepth == -1.0) return vec3(1.0);

    // Tính bán kính Penumbra (Vùng bóng nhòe)
    float penumbra = (shadowPos.z - avgBlockerDepth) * PCSS_RADIUS / avgBlockerDepth;
    
    float shadow = 0.0;
    for(int i = 0; i < PCSS_SAMPLES; i++) {
        vec2 offset = vec2(Bayer64(gl_FragCoord.xy + float(i + 13))) * penumbra;
        shadow += shadow2D(shadowtex0, shadowPos + vec3(offset, 0.0)).r;
    }
    return vec3(shadow / float(PCSS_SAMPLES));
}
#endif