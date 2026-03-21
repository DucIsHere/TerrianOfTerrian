#include <jni.h>

#ifndef _Include_com_regenerationforrged_native_NativeEngine
#define _Include_com_regenerationforrged_native_NativeEngine
#ifdef __cplusplus

extern "C"
{
#endif

/*
 * Class:     com_regenerationforrged_NativeEngine
 * Method:    processTerrain
 * Signature: ([FF)V
 */

JNIEXPORT void JNICALL Java_com_regenerationforrged_native_NativeEngine_processTerrain
(JNIEnv *, jclass, jfloatArray, jfloat);

#ifdef __cplusplus
}
#endif
#endif
