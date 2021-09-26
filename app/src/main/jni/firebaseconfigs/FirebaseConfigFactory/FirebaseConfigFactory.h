#ifndef TESTCACHEASSETS_FIREBASECONFIGFACTORY_H
#define TESTCACHEASSETS_FIREBASECONFIGFACTORY_H

#include <jni.h>
#include "../ConfigBase/ConfigBase.cpp"
#include "../ConfigDevelopment/ConfigDevelopment.cpp"
#include "../ConfigStaging/ConfigStaging.cpp"
#include "../ConfigProduction/ConfigProduction.cpp"

class FirebaseConfigFactory {
public:
    static const int DEVELOPMENT = 0;
    static const int STAGING = 1;
    static const int PRODUCTION = 2;
    static ConfigBase *getConfig(int appEnvCode);
};

#endif //TESTCACHEASSETS_FIREBASECONFIGFACTORY_H
