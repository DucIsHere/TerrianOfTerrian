#include <jni.h>

#ifndef _Inclued_NativeBridge
#define _Inclued_NativeBridge

extern "C"
{
    JNIEXPORT void JNICALL java_com_regenerationforrged_native_NativeClient_processHeightmap
    (JNIEnv *, jclass, jfloatArray, jfloat);
}
#endif