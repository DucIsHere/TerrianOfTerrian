#if !defined LIGHTING_VGI
#define LIGHTING_VGI

#include "/lib/util/spaceConversion.glsl"
#include "/lib/util/dither.glsl"
#include "/lib/voxelization/reflectionVoxelData.glsl"

// 5090: Tăng số lượng tia để GI mịn, không cần khử nhiễu nhiều
#define GI_SAMPLES 16
#define GI_MAX_DIST 32.0

vec3 GetVoxelGI(vec3 worldPos, vec3 normal) {
    vec3 gi = vec3(0.0);
    vec3 voxelOrigin = playerToSceneVoxel(worldPos + normal * 0.1); // Offset để tránh tự va chạm
    float dither = Bayer64(gl_FragCoord.xy);

    for(int i = 0; i < GI_SAMPLES; i++) {
        // Tạo hướng tia ngẫu nhiên quanh pháp tuyến (Normal)
        vec3 rayDir = normalize(normal + RandomVector(float(i) + dither)); 
        vec3 currentPos = voxelOrigin;
        
        // Raymarching ngắn để tìm nguồn sáng gần nhất
        for(float dist = 0.0; dist < GI_MAX_DIST; dist += 0.5) {
            currentPos += rayDir * 0.5;
            ivec3 iPos = ivec3(floor(currentPos));

            if (checkVoxelAt(iPos)) {
                faceData data = getFaceData(iPos, -rayDir);
                // Công thức nảy bật: Màu Voxel * Độ sáng (Lightmap)
                gi += data.glColor * pow(data.lightmap.y, 2.0); 
                break; 
            }
        }
    }
    return (gi / float(GI_SAMPLES)) * 2.0; // HDR Boost
}
#endif