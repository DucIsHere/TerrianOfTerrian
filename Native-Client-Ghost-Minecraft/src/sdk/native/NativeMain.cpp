#include "NativeBridge.h" // Nhớ include cái file vừa tạo ở Bước 2

JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeBridge_processHeightmap
(JNIEnv *env, jclass clazz, jfloatArray data, jfloat sharpness) {
    
    // 1. Lấy mảng từ Java mà không tốn RAM copy (Cực quan trọng cho iPhone 13)
    jfloat* hMap = (jfloat*)env->GetPrimitiveArrayCritical(data, 0);
    jsize len = env->GetArrayLength(data);

    // 2. Vòng lặp tính toán "Hardcore"
    for (int i = 0; i < len; i++) {
        // Nếu block cao trên 2500m (0.5f), làm nó nhọn lên (Sharpness)
        if (hMap[i] > 0.5f) {
            hMap[i] = hMap[i] * sharpness;
        }
    }

    // 3. Nhả mảng về cho Java
    env->ReleasePrimitiveArrayCritical(data, hMap, 0);
}
