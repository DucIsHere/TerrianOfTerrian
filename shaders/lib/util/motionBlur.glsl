#if !defined UTIL_MOTIONBLUR
#define UTIL_MOTIONBLUR

#include "/lib/util/spaceConversion.glsl"

// 5090: Chơi 32 samples để vết mờ mịn như phim, không bị bóng ma (ghosting)
#define MB_SAMPLES 32
#define MB_STRENGTH 0.5

vec3 ApplyMotionBlur(vec3 color, float depth, vec2 texCoord) {
    // 1. Lấy vị trí hiện tại trong không gian Clip (Clip Space)
    vec4 currentClipPos = vec4(texCoord * 2.0 - 1.0, depth * 2.0 - 1.0, 1.0);
    
    // 2. Chuyển về thế giới, sau đó dùng gbufferPreviousModelView/Projection 
    // để tìm xem pixel này ở đâu trong khung hình trước
    vec3 viewPos = ScreenToView(vec3(texCoord, depth));
    vec3 playerPos = ViewToPlayer(viewPos);
    
    // Giả lập vị trí cũ (cần khai báo các ma trận Previous trong shader chính)
    vec4 prevClipPos = gbufferPreviousProjection * (gbufferPreviousModelView * vec4(playerPos, 1.0));
    prevClipPos.xyz /= prevClipPos.w;
    
    // 3. Tính toán Vector vận tốc (Velocity Vector)
    vec2 velocity = (currentClipPos.xy - prevClipPos.xy) * MB_STRENGTH;
    
    // Giới hạn vận tốc để tránh mờ quá mức khi quay chuột nhanh
    velocity = clamp(velocity, -0.05, 0.05);

    // 4. Lấy mẫu màu dọc theo vector vận tốc
    vec3 blurColor = color;
    float dither = Bayer8(gl_FragCoord.xy); // Dùng dither của ông để làm mịn
    
    for (int i = 1; i < MB_SAMPLES; i++) {
        vec2 offset = velocity * (float(i) + dither) / float(MB_SAMPLES);
        blurColor += texture2D(colortex0, texCoord - offset).rgb;
    }

    return blurColor / float(MB_SAMPLES);
}
#endif