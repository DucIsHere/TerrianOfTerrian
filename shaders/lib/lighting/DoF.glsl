#define DOF_SAMPLES 128
#define FOCUS_SPEED 0.1

vec3 ApplyExtremeDOF(vec3 color, float z) {
    float linearDepth = GetDepth(z); //
    float focus = texture2D(depthtex1, vec2(0.5)).r; // Lấy nét vào tâm
    float targetFocus = GetDepth(focus);
    
    // Circle of Confusion (CoC)
    float coc = abs(linearDepth - targetFocus) / far * 50.0;
    coc = min(coc, 0.05); // Giới hạn độ nhòe

    if (coc < 0.001) return color;

    vec3 dofColor = vec3(0.0);
    float totalWeight = 0.0;

    for(int i = 0; i < DOF_SAMPLES; i++) {
        // Tạo hiệu ứng Bokeh hình lục giác (Modern Lens)
        float angle = float(i) * 2.39996 + frameTimeCounter;
        float r = sqrt(float(i)) * coc;
        vec2 offset = vec2(cos(angle), sin(angle)) * r;
        
        float weight = 1.0 + pow(length(texture2D(colortex0, texCoord + offset).rgb), 2.0); // Highlight Bokeh rực rỡ
        dofColor += texture2D(colortex0, texCoord + offset).rgb * weight;
        totalWeight += weight;
    }
    return dofColor / totalWeight;
}