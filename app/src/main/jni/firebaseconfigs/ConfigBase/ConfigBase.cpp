#include "ConfigBase.h"

jstring ConfigBase::getApiKey() {
    return this->apiKey;
}

jstring ConfigBase::getAppId() {
    return this->appId;
}

jstring ConfigBase::getDbUrl() {
    return this->dbUrl;
}

jstring ConfigBase::getGcmSenderId() {
    return this->gcmSenderId;
}

jstring ConfigBase::getProjectId() {
    return this->projectId;
}

jstring ConfigBase::getStorageBucket() {
    return this->storageBucket;
}

jstring ConfigBase::getGaTrackingId() {
    return this->gaTrackingId;
}