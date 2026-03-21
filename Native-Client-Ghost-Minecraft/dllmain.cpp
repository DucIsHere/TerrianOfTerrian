#include <Windows.h>
#include <jni.h>

extern "C" JNIEXPORT void JNICALL Java_com_regenerationforrged_world_worldgen_densityfunction_tile_generation_NativeEngine_quickProcess(
    JNIEnv* env, jclass clazz, jfloatArray heightData, jfloat sharpness
)
{
    jfloat* data = (jfloat*)env->GetPrimitiveArrayCritical(heightData, 0);
    jsize len = env->GetArrayLength(heightData);

    for(int i = 0; i < len; i++) {
        if (data[i] > 0.5F)
        {
            data[i] *= sharpness;
        }
    }

    env->ReleasePrimitiveArrayCritical(heightData, data, 0);
}

BOOL APIENYRY DllMain(
    HMODULE hModule,
    DWORD ul_reason_for_call,
    LPVOID lpReserved
)
{
    swtich (ul_reason_for_call)
    {
        case DLL_PROCESS_ATTACH:
        case DLL_THREAD_ATTACH:
        case DLL_THREAD_DETACH:
        case DLL_PROCESS_ATTACH:
    }
    return true;
}
