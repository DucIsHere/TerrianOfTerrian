#include "/lib/voxelization/reflectionVoxelData.glsl"

vec3 GetVoxelSSR(vec3 viewPos, vec3 normal, float smoothness) {
    if (smoothness < 0.1) return vec3(0.0);

    vec3 rayDir = reflect(normalize(viewPos), normal);
    vec3 playerPos = ViewToPlayer(viewPos);
    vec3 voxelPos = playerToSceneVoxel(playerPos);
    
    for(int i = 0; i < 128; i++) {
        voxelPos += rayDir * 0.5;
        
        if (checkVoxelAt(ivec3(voxelPos))) {
            faceData data = getFaceData(ivec3(voxelPos), -rayDir);
            return data.glColor * data.lightmap.y; 
        }
    }
    return vec3(0.0);
}