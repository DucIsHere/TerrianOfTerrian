#if !defined LIGHTING_VREF
#define LIGHTING_VREF

#include "/lib/util/spaceConversion.glsl"
#include "/lib/voxelization/reflectionVoxelData.glsl"

// 5090: Dò tia cực xa để phản chiếu toàn cảnh Medieval
#define REF_STEPS 160
#define REF_STEP_SIZE 0.4

vec3 GetVoxelReflection(vec3 viewPos, vec3 normal, float roughness) {
    vec3 rayDir = reflect(normalize(viewPos), normal);
    vec3 playerPos = ViewToPlayer(viewPos);
    vec3 voxelOrigin = playerToSceneVoxel(playerPos + normal * 0.1);
    
    vec3 currentPos = voxelOrigin;
    vec3 reflection = vec3(0.0);

    for(int i = 0; i < REF_STEPS; i++) {
        currentPos += rayDir * REF_STEP_SIZE;
        ivec3 iPos = ivec3(floor(currentPos));

        // Check va chạm trong wsrSSBO bitmasks của ông
        if (checkVoxelAt(iPos)) {
            faceData data = getFaceData(iPos, -rayDir);
            
            // Lấy màu sắc tại điểm va chạm
            reflection = data.glColor * data.lightmap.y;
            
            // Nếu là vật liệu nhám (PBR), làm mờ màu phản chiếu
            reflection = mix(reflection, reflection * 0.5, roughness);
            break;
        }
        
        // Thoát nếu tia bay ra ngoài vùng Voxel
        if (!CheckInsideSceneVoxelVolume(currentPos)) break;
    }

    return reflection;
}
#endif