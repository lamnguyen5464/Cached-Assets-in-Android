#include <jni.h>
#include "firebaseconfigs/FirebaseConfigInstance/FirebaseConfigInstance.cpp"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getApiKey(JNIEnv *env, __unused jobject thiz,
                                                             jint app_environment_code) {
    // TODO: implement getApiKey()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getApiKey();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getAppId(JNIEnv *env, __unused jobject thiz,
                                                            jint app_environment_code) {
    // TODO: implement getAppId()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getAppId();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getDbUrl(JNIEnv *env, __unused jobject thiz,
                                                            jint app_environment_code) {
    // TODO: implement getDbUrl()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getDbUrl();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getGcmSenderId(JNIEnv *env, __unused jobject thiz,
                                                                  jint app_environment_code) {
    // TODO: implement getGcmSenderId()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getGcmSenderId();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getProjectId(JNIEnv *env, __unused jobject thiz,
                                                                jint app_environment_code) {
    // TODO: implement getProjectId()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getProjectId();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getStorageBucket(JNIEnv *env, __unused jobject thiz,
                                                                    jint app_environment_code) {
    // TODO: implement getStorageBucket()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getStorageBucket();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_testcacheassets_JNIFirebaseConfig_getGaTrackingId(JNIEnv *env, __unused jobject thiz,
                                                                   jint app_environment_code) {
    // TODO: implement getGaTrackingId()
    auto config = FirebaseConfigInstance::getInstance(app_environment_code);
    jstring key = config->getGaTrackingId();
    return env->NewStringUTF(reinterpret_cast<const char *>(key));
}