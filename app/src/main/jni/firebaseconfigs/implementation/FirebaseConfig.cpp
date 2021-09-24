#include "../header/FirebaseConfig.h"

jstring FirebaseConfig::getApiKey() {
    return this->apiKey;
}

jstring FirebaseConfig::getAppId() {
    return this->appId;
}

jstring FirebaseConfig::getDbUrl() {
    return this->dbUrl;
}

jstring FirebaseConfig::getGcmSenderId() {
    return this->gcmSenderId;
}

jstring FirebaseConfig::getProjectId() {
    return this->projectId;
}

jstring FirebaseConfig::getStorageBucket() {
    return this->storageBucket;
}

jstring FirebaseConfig::getGaTrackingId() {
    return this->gaTrackingId;
}