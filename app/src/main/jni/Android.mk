LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := jni-firebase-config
LOCAL_SRC_FILES := main.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := FirebaseConfig.h
LOCAL_SRC_FILES := firebaseconfigs/implementation/FirebaseConfig.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := DevFirebaseConfig.h
LOCAL_SRC_FILES := firebaseconfigs/implementation/DevFirebaseConfig.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := StagingFirebaseConfig.h
LOCAL_SRC_FILES := firebaseconfigs/implementation/StagingFirebaseConfig.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ProductionFirebaseConfig.h
LOCAL_SRC_FILES := firebaseconfigs/implementation/ProductionFirebaseConfig.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := FirebaseConfigFactory.h
LOCAL_SRC_FILES := firebaseconfigs/implementation/FirebaseConfigFactory.cpp
include $(BUILD_SHARED_LIBRARY)



