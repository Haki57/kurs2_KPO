#include "sample1_JNIHelloWorld.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_sample1_JNIHelloWorld_printHelloWorld
    (JNIEnv *env, jobject obj)
{
    printf("Finally it happened: Hello World using JNI and MS VisualStudio C-compiler !!!\n ");
}


