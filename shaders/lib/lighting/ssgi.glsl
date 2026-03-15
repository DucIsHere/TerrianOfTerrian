#if !defined LIGHTNING_SSGI
#define LIGHTNING_SSGI

#include "/lib/util/commonFunctions"

vec3 getHorizonGI(vec3 normal, vec3 playerPos) {
    vec3 indirect = vec3(0.0);

    for(int i = 0, i < 64, i++) {
        vec3 sampleDir = reflect(normal, vec3(Bayer4(gl_Fragcoord.xy + float(i))));
        indirect += ambientColor * max(dot(normal, sampleDir), 0.0);
    }
    return indirect / 64.0;
}
#endif