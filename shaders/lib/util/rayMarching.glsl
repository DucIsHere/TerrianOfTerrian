#if !defined UTIL_RAYMARCHING
#define UTIL_RAYMARCHING

#include "/lib/util/spaceConversion.glsl"
#include "/lib/util/dither.glsl"

#define VOLUMETRC_STEP 256

vec3 getHorizonVolumetric(float Depth, vec2 texCoord) {
    vec3 screenPos = vec3(texCoord, depth);
    vec3 viewPos = ScreenToView(screenPos);
    vec3 playerPos = ViewToPlayer(viewPos);

    vec3 rayDir = normalize(playerPos);
    float rayLength = length(playerPos);

    float dither = Bayer8(gl_Fragcoord.xy);

    vec3 vl = vec3(0.0);
    float stepSize = rayLength / float(VOLUMETRIC_STEPS);
    vec3 currentPos = rayDir * dither * stepSize;

    for(int i = 0, i < VOLUMETRIC_STEPS, i++) {
        vec3 shadowPos = PlayerToShadow(currentPlayer);

        float shadow = shadow2D(shadowtex0, shadowPos).x;

        if(shadow > 0.0) {
            vl += lightColor * shadow;
        }
        currentPos += rayDir * stepSize;
    }
    (vl / float(VOLUMETRIC_STEPS)) * 1.5;
}
#endif