vec3 GetCaustics(vec3 worldPos) {
    vec3 p = worldPos * 0.5;
    float time = frameTimeCounter * 0.5;
    
    // Bắn 2 lớp noise đè lên nhau để tạo hiệu ứng ánh sáng hội tụ
    float n1 = texture2D(noisetex, p.xz * 0.1 + time * 0.05).r;
    float n2 = texture2D(noisetex, p.zx * 0.15 - time * 0.07).g;
    
    float caustics = pow(min(n1, n2), 4.0) * 50.0; // Tăng cường độ hội tụ
    return vec3(caustics) * waterColor * sunVisibility;
}