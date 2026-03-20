#define VL_SAMPLES 256 // Bắn 256 tia trên mỗi pixel
#define VL_SHARPNESS 15.0

vec3 GetExtremeModernVL(vec3 nViewPos, float lViewPos1, float dither) {
    vec3 vl = vec3(0.0);
    float stepSize = lViewPos1 / float(VL_SAMPLES);
    vec3 rayStep = nViewPos * stepSize;
    vec3 currentPos = cameraPosition + rayStep * dither;

    for(int i = 0; i < VL_SAMPLES; i++) {
        vec3 shadowPos = GetShadowSpace(currentPos - cameraPosition); // Hàm tọa độ shadow của ông
        float shadow = CalculateExtremeVPS(shadowPos).r; // Ăn thẳng vào PCSS hạng nặng bên trên

        if(shadow > 0.0) {
            // Tán xạ Rayleigh cho style Modern (bầu trời trong vắt)
            float cosTheta = dot(nViewPos, lightVec);
            float phase = 3.0 / (16.0 * 3.1415) * (1.0 + cosTheta * cosTheta);
            
            // Lấy thêm ánh sáng màu từ Voxel (Colored Light)
            vec3 voxelPos = SceneToVoxel(currentPos - cameraPosition);
            vec3 coloredLight = GetLightVolume(voxelPos).rgb; //

            vl += (sunColor * shadow + coloredLight * 2.0) * phase;
        }
        currentPos += rayStep;
    }
    return (vl / float(VL_SAMPLES)) * 0.5;
}