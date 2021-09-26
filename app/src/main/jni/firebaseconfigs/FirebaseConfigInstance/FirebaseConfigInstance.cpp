#include "FirebaseConfigInstance.h"

ConfigBase *FirebaseConfigInstance::instance = nullptr;

ConfigBase *FirebaseConfigInstance::getInstance(int appEnvCode) {
    if (instance == nullptr) {
        instance = FirebaseConfigFactory().getConfig(appEnvCode);
    }
    return instance;
}

void FirebaseConfigInstance::deleteInstance() {
    if (instance != nullptr) {
        delete instance;
    }
}

FirebaseConfigInstance::FirebaseConfigInstance() {}
