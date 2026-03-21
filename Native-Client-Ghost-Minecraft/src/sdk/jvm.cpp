#include <jni.h>
#include <Windows.h>
#include <math.h>
#include <algorithm>

#define JNI_FUNC(name) Java_com_regenerationforrged_native_NativeEngine_##name

extern "C"
{
    JNIEXPORT jboolean JNICALL JNI_FUNC(isReady)(JNI* env, jclass clazz)
    {
        return JNI_TRUE;
    }
    JNIEXPORT void JNICALL JNI_FUNC(processTerrain)(
        JNIEnv* env, 
        jclass clazz, 
        jfloatArray heightData, 
        jfloat sharpness, 
        jfloat seaLevel) {
        
        // 1. Truy cập mảng trực tiếp (Critical giúp khóa GC của Java lại để C++ chạy max tốc độ)
        jfloat* data = (jfloat*)env->GetPrimitiveArrayCritical(heightData, 0);
        if (!data) return;

        jsize len = env->GetArrayLength(heightData);
        
        Minecraft::applySharpness(data, len, sharpness);
        Minecraft::validateTerrain(data, len);

        // 2. Thuật toán sinh địa hình tối ưu cho i5-12400F
        for (int i = 0; i < len; i++) {
            float h = data[i];

            // Nếu cao độ trên mực nước biển (seaLevel)
            if (h > seaLevel) {
                // Công thức Sharpness: Làm dốc các vùng núi cao
                float diff = h - seaLevel;
                data[i] = seaLevel + (diff * sharpness);
            }
            
            // Giới hạn cứng để tránh lỗi văng game khi vượt quá 5000m (giá trị chuẩn hóa 0.0 -> 1.0)
            data[i] = std::clamp(data[i], 0.0f, 1.0f);
        }

        // 3. Giải phóng mảng về cho JVM quản lý tiếp
        env->ReleasePrimitiveArrayCritical(heightData, data, 0);
    }

}

// DllMain: Điểm vào của Windows DLL
BOOL APIENTRY DllMain(HMODULE hModule, DWORD ul_reason_for_call, LPVOID lpReserved) {
    switch (ul_reason_for_call) {
        case DLL_PROCESS_ATTACH:
        case DLL_THREAD_ATTACH:
        case DLL_THREAD_DETACH:
        case DLL_PROCESS_DETACH:
            break;
    }
    return TRUE;
}

