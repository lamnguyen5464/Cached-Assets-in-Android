#include <jni.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_MainActivity_getNativeKey(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "");
}

jstring getKey(){

    return "THIS_IS_PRIVATE_CODE";
}

char* convertFromString(jstring str){
    int length;
}