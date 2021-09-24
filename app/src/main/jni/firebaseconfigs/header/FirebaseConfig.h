#ifndef TESTCACHEASSETS_FIREBASECONFIG_H
#define TESTCACHEASSETS_FIREBASECONFIG_H

#include <jni.h>

class FirebaseConfig {
protected:
    jstring apiKey;
    jstring appId;
    jstring dbUrl;
    jstring gcmSenderId;
    jstring projectId;
    jstring storageBucket;
    jstring gaTrackingId;
public:
    jstring getApiKey();

    jstring getAppId();

    jstring getDbUrl();

    jstring getGcmSenderId();

    jstring getProjectId();

    jstring getStorageBucket();

    jstring getGaTrackingId();
};


#endif //TESTCACHEASSETS_FIREBASECONFIG_H
