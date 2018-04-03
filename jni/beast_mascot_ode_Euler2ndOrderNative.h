/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class beast_mascot_ode_Euler2ndOrderNative */

#ifndef _Included_beast_mascot_ode_Euler2ndOrderNative
#define _Included_beast_mascot_ode_Euler2ndOrderNative
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    setup
 * Signature: (IIDD)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_setup
  (JNIEnv *, jobject, jint, jint, jdouble, jdouble);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    init
 * Signature: ([D[DI)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_init
  (JNIEnv *, jobject, jdoubleArray, jdoubleArray, jint);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    initWithIndicators
 * Signature: ([D[I[DI)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_initWithIndicators
  (JNIEnv *, jobject, jdoubleArray, jintArray, jdoubleArray, jint);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    calculateValues
 * Signature: (D[DI)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_calculateValues
  (JNIEnv *, jobject, jdouble, jdoubleArray, jint);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    initAndcalculateValues
 * Signature: ([D[DID[DI)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_initAndcalculateValues___3D_3DID_3DI
  (JNIEnv *, jobject, jdoubleArray, jdoubleArray, jint, jdouble, jdoubleArray, jint);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    initAndcalculateValues
 * Signature: (IID[DI)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_initAndcalculateValues__IID_3DI
  (JNIEnv *, jobject, jint, jint, jdouble, jdoubleArray, jint);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    setUpDynamics
 * Signature: ([D[D[D)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_setUpDynamics___3D_3D_3D
  (JNIEnv *, jobject, jdoubleArray, jdoubleArray, jdoubleArray);

/*
 * Class:     beast_mascot_ode_Euler2ndOrderNative
 * Method:    setUpDynamics
 * Signature: ([D[D[I[D)V
 */
JNIEXPORT void JNICALL Java_beast_mascot_ode_Euler2ndOrderNative_setUpDynamics___3D_3D_3I_3D
  (JNIEnv *, jobject, jdoubleArray, jdoubleArray, jintArray, jdoubleArray);

#ifdef __cplusplus
}
#endif
#endif
