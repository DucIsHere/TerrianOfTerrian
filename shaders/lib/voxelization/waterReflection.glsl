#define SSR_SAMPLES 200        // Số bước nhảy của tia phản chiếu
#define SSR_BINARY_STEPS 20    // Bước tinh chỉnh điểm va chạm để cực kỳ sắc nét
#define REFLECTION_ROUGHNESS 0.05 

vec4 GetWaterReflections(vec3 viewPos, vec3 normal, float dither) {
    vec3 rayDir = reflect(normalize(viewPos), normal);
    
    // Thuật toán Ray-marching trên không gian màn hình
    vec3 rayStep = rayDir * 0.2; // Độ dài mỗi bước
    vec3 currentPos = viewPos + rayStep * dither;
    
    vec4 reflectCol = vec4(0.0);
    bool hit = false;

    for(int i = 0; i < SSR_SAMPLES; i++) {
        currentPos += rayStep;
        vec4 screenPos = gbufferProjection * vec4(currentPos, 1.0);
        screenPos.xyz /= screenPos.w;
        screenPos.xyz = screenPos.xyz * 0.5 + 0.5;

        if(screenPos.x < 0.0 || screenPos.x > 1.0 || screenPos.y < 0.0 || screenPos.y > 1.0) break;

        float depth = texture2D(depthtex0, screenPos.xy).r;
        float linearDepth = GetLinearDepth(depth);
        float currentDepth = GetLinearDepth(screenPos.z);

        if(currentDepth > linearDepth) {
            // Binary Search để tìm vị trí va chạm chính xác (Tránh hiện tượng bóng ma)
            for(int j = 0; j < SSR_BINARY_STEPS; j++) {
                rayStep *= 0.5;
                if(currentDepth > linearDepth) currentPos -= rayStep;
                else currentPos += rayStep;

                screenPos = gbufferProjection * vec4(currentPos, 1.0);
                screenPos.xyz /= screenPos.w;
                screenPos.xyz = screenPos.xyz * 0.5 + 0.5;
                depth = texture2D(depthtex0, screenPos.xy).r;
                linearDepth = GetLinearDepth(depth);
                currentDepth = GetLinearDepth(screenPos.z);
            }
            reflectCol.rgb = texture2D(colortex0, screenPos.xy).rgb;
            reflectCol.a = 1.0;
            hit = true;
            break;
        }
    }
    return reflectCol;
}