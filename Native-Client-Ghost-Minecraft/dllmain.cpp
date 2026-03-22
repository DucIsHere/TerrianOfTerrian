#include <Windows.h>
#include <jni.h>
#include <immintrin.h> // Bắt buộc để dùng AVX2
#include <log/log_gz.cpp>

extern "C" 

JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeEngine_saveCommand(
    JNIEnv* env, jclass clazz, jstring command
)
{
    const char* cmdStr = env->GetStringUTFChars(commnd, nullptr);
    Logger::write("COMMAND: " + std::string(cmdStr));
    env->ReleaseStringUTFChars(command, cmdStr);
    
}

JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeEngine_logChunky(
    JNIEnv* env, jclass clazz, jboolean starting) {
    Logger::write(starting ? "CHUNKY: Pre-gen Started" : "CHUNKY: Pre-gen Finished");
}

JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeEngine_quickProcess(
    JNIEnv* env, jclass clazz, jfloatArray heightData, jfloat sharpness
)
{
    // Sử dụng GetPrimitiveArrayCritical để truy cập trực tiếp RAM Java
    jfloat* data = (jfloat*)env->GetPrimitiveArrayCritical(heightData, 0);
    jsize len = env->GetArrayLength(heightData);

    // Sử dụng SIMD AVX2 để xử lý 8 block cùng lúc
    int i = 0;
    __m256 v_sharp = _mm256_set1_ps(sharpness);
    __m256 v_threshold = _mm256_set1_ps(0.5f);

    for (; i <= len - 8; i += 8) {
        __m256 v_data = _mm256_load_ps(&data[i]);
        
        // Tạo mặt nạ: chỉ áp dụng nếu giá trị > 0.5
        __m256 mask = _mm256_cmp_ps(v_data, v_threshold, _CMP_GT_OQ);
        
        // Tính toán giá trị mới: data * sharpness
        __m256 v_mul = _mm256_mul_ps(v_data, v_sharp);
        
        // Kết hợp: Nếu > 0.5 dùng v_mul, ngược lại giữ nguyên v_data
        __m256 res = _mm256_blendv_ps(v_data, v_mul, mask);
        
        _mm256_store_ps(&data[i], res);
    }

    // Xử lý các phần tử dư thừa nếu len không chia hết cho 8
    for (; i < len; i++) {
        if (data[i] > 0.5f) data[i] *= sharpness;
    }

    env->ReleasePrimitiveArrayCritical(heightData, data, 0);
}

BOOL APIENTRY DllMain(HMODULE hModule, DWORD ul_reason_for_call, LPVOID lpReserved)
{
    if (ul_reason_for_call == DLL_PROCESS_ATTACH)
    {
        Logger::write("DLL Start")
    }
    switch (ul_reason_for_call)
    {
        case DLL_PROCESS_ATTACH:
        case DLL_THREAD_ATTACH:
        case DLL_THREAD_DETACH:
        case DLL_PROCESS_DETACH:
            break;
    }
    return TRUE;
};