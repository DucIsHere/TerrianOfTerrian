// --- modernWater.glsl ---
#define WATER_SPEED 0.8
#define WATER_DETAIL 4.0 // Độ chi tiết của gợn sóng

vec3 GetModernWaterNormal(vec3 worldPos, float rainFactor) {
    float time = frameTimeCounter * WATER_SPEED;
    
    // Lớp 1: Sóng lớn (Base Waves)
    vec2 coord1 = worldPos.xz * 0.05 + vec2(time * 0.02, time * 0.01);
    vec3 n1 = texture2D(noisetex, coord1).rgb * 2.0 - 1.0;

    // Lớp 2: Gợn sóng nhỏ (Micro-ripples) - Cho cảm giác mặt nước trong vắt
    vec2 coord2 = worldPos.xz * 0.2 - vec2(time * 0.05, -time * 0.03);
    vec3 n2 = texture2D(noisetex, coord2).rgb * 2.0 - 1.0;

    // Lớp 3: Sóng do mưa (Nếu có)
    vec3 rainNormal = vec3(0.0);
    if (rainFactor > 0.01) {
        vec2 rainCoord = worldPos.xz * 0.5;
        rainNormal = texture2D(noisetex, rainCoord + time * 0.1).rgb * 2.0 - 1.0;
    }

    // Mix các lớp lại với nhau
    vec3 normal = normalize(vec3(n1.x + n2.x * 0.5, 15.0, n1.z + n2.z * 0.5));
    if (rainFactor > 0.01) normal = normalize(normal + rainNormal * rainFactor * 0.5);

    return normal;
}

// --- Tiếp tục trong modernWater.glsl ---
vec3 GetSkyReflection(vec3 viewDir, vec3 normal, float dither) {
    // 1. Tính toán hướng tia phản chiếu (Reflect vector)
    vec3 reflectDir = reflect(viewDir, normal);
    float VdotU = dot(reflectDir, upVec);
    float VdotS = dot(reflectDir, sunVec);

    // 2. Lấy màu trời (Sky & Moon) từ sky.glsl
    vec3 skyCol = GetSky(VdotU, VdotS, dither, true, true);

    // 3. Lấy Cực quang (Aurora) từ auroraBorealis.glsl
    vec3 auroraCol = vec3(0.0);
    #ifdef OVERWORLD
        // Gọi hàm aurora đã có trong pack của ông
        auroraCol = GetAuroraBorealis(reflectDir * 100.0, VdotU, dither);
    #endif

    // 4. Moon Reflection (Làm mặt trăng rực rỡ hơn trên nước)
    float moonGlow = pow(max(0.0, dot(reflectDir, -sunVec)), 512.0) * sunVisibility;
    vec3 moonCol = vec3(1.0, 0.9, 0.8) * moonGlow * 10.0;

    // Tổng hợp màu sắc phản chiếu
    vec3 finalReflection = skyCol + auroraCol + moonCol;

    return finalReflection;
}