#include "FirebaseConfigFactory.h"
#include <string.h>
#include <stdio.h>

ConfigBase *FirebaseConfigFactory::getConfig(int appEnvCode) {
    switch (appEnvCode) {
        case (PRODUCTION):
            return new ConfigProduction();
        case (STAGING):
            return new ConfigStaging();
        default:
            return new ConfigDevelopment();
    }
}