#include "../header/FirebaseConfigFactory.h"
#include <string.h>

FirebaseConfig *FirebaseConfigFactory::getConfig(char *env) {
    if (strcpy(env, "production")) return new ProductionFirebaseConfig();
    if (strcpy(env, "staging")) return new StagingFirebaseConfig();
    return new DevFirebaseConfig();
}