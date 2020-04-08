#include "sample2_JNISampleApp.h"
#include <stdio.h>

/*
 * Class:     sample2_JNISampleApp
 * Method:    print
 * Signature: (IID)I
 */
JNIEXPORT jint JNICALL Java_sample2_JNISampleApp_print
  (JNIEnv *env, jclass cl, jint width, jint precision, jdouble x)
{
    char fmt[30];
    jint ret;
    sprintf (fmt, "%%%d.%df", width, precision);
    ret = printf(fmt, x);
    fflush(stdout);
    return ret;
}
