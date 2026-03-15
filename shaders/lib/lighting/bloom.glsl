// HẠNG NẶNG: 7 lớp Blur chồng lên nhau để tạo quầng sáng mịn
// LIGHT: 3 lớp Blur cơ bản

vec3 ExtractHighBright(vec3 color) {
    // Chỉ lấy những vùng thực sự chói (HDR > 1.0)
    float luma = dot(color, vec3(0.2126, 0.7152, 0.0722));
    return color * max(0.0, luma - 1.0);
}

// Hàm Gaussian Blur theo trục
vec3 GaussianBlur(sampler2D tex, vec2 coord, vec2 dir) {
    vec3 col = texture2D(tex, coord).rgb * 0.227;
    vec2 offset = dir / viewWidth; // Độ lệch dựa trên độ phân giải
    
    #if QUALITY == 2 // HẠNG NẶNG: Tăng bán kính lấy mẫu
        col += texture2D(tex, coord + offset * 1.2).rgb * 0.194;
        col += texture2D(tex, coord - offset * 1.2).rgb * 0.194;
        col += texture2D(tex, coord + offset * 2.5).rgb * 0.121;
        col += texture2D(tex, coord - offset * 2.5).rgb * 0.121;
        col += texture2D(tex, coord + offset * 4.0).rgb * 0.054;
        col += texture2D(tex, coord - offset * 4.0).rgb * 0.054;
    #else // LIGHT: Giảm bước lấy mẫu
        col += texture2D(tex, coord + offset * 1.5).rgb * 0.31;
        col += texture2D(tex, coord - offset * 1.5).rgb * 0.31;
        col += texture2D(tex, coord + offset * 3.5).rgb * 0.07;
        col += texture2D(tex, coord - offset * 3.5).rgb * 0.07;
    #endif
    
    return col;
}