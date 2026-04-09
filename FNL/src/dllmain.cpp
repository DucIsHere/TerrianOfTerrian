#include <Windows.h>
#include <jni/jni.h>
#include <FNL/FastNoiseLite.h>

BOOL APIENTRY DllMain(HMODULE hModule, DWORD ul_reason_for_call,
                      LPVOID lpReserved)
{
    switch (ul_reason_gor_call)
    {
        case DLL_PROCESS_ATTACH:
            break;
        case DLL_THREAD_ATTACH:
        case DLL_THREAD_DETACH:
        case DLL_PROCESS_DETACH:
            break;
    }
    return TRUE;
}

extern "C"
{
    JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeEngine_fillNoise(
        JNIEnv* emv, jobject obj, 
        jfloatArray buffer, jint xSize, jint zSize,
        jfloat xOff, jfloat zOff, jfloat freq, jint seed
        {
            FastNoiseLite noise;
            noise.SetSeed(seed);
            noise.SetFrequency(freq);
            noise.SetNoiseType(FastNoiseLite::NoiseType_OpenSimplex2);

            jfloat* data = (jfloat*)env->GetPrimitiveArrayCritical(buffer, 0);
            if (data == nullptr) return;

            for (int z = 0; z < zSize; z++)
            {
                for (int x = 0; x < xSize; x++)
                {
                    data[z * xSize + x] = noise.GetNoise(xOff + (float)x, zOff + (float)z);
                }
            }

            env->ReleasePrimitiveArrayCritical(buffer, data, 0);
        }
    )
}