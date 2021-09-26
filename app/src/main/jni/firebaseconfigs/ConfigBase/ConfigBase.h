#ifndef TESTCACHEASSETS_CONFIGBASE_H
#define TESTCACHEASSETS_CONFIGBASE_H

#include <jni.h>

class ConfigBase {
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


#endif //TESTCACHEASSETS_CONFIGBASE_H
