#include <jni.h>
#include "firebaseconfigs/implementation/FirebaseConfigFactory.cpp"

extern "C" {
    JNIEXPORT jstring
    Java_com_example_testcacheassets_MainActivity_getNativeKey(JNIEnv *env, jobject activity,
                                                               jstring appEnv) {
        auto config = FirebaseConfigFactory().getConfig(reinterpret_cast<char *>(appEnv));
        jstring key = config->getApiKey();
        delete config;
        return env->NewStringUTF(reinterpret_cast<const char *>(key));
//        return env->NewStringUTF("argaeg");

    }
}