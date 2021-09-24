#ifndef TESTCACHEASSETS_FIREBASECONFIGFACTORY_H
#define TESTCACHEASSETS_FIREBASECONFIGFACTORY_H

#include <jni.h>
#include "../implementation/FirebaseConfig.cpp"
#include "../implementation/DevFirebaseConfig.cpp"
#include "../implementation/StagingFirebaseConfig.cpp"
#include "../implementation/ProductionFirebaseConfig.cpp"

class FirebaseConfigFactory {
public:
    static FirebaseConfig *getConfig(char *env);
};

#endif //TESTCACHEASSETS_FIREBASECONFIGFACTORY_H
