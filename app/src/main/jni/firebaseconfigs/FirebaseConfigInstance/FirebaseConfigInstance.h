//
// Created by Lam Nguyen on 9/26/21.
//

#ifndef TESTCACHEASSETS_FIREBASECONFIGINSTANCE_H
#define TESTCACHEASSETS_FIREBASECONFIGINSTANCE_H

#include "../FirebaseConfigFactory/FirebaseConfigFactory.cpp"

class FirebaseConfigInstance {
private:
    FirebaseConfigInstance();   //avoid trigger Constructor
    static ConfigBase *instance;
public:
    static ConfigBase *getInstance(int appEnvCode);

    static void deleteInstance();
};


#endif //TESTCACHEASSETS_FIREBASECONFIGINSTANCE_H
