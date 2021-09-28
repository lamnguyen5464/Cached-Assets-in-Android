LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := jni-firebase-config
LOCAL_SRC_FILES := main.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ConfigBase.h
LOCAL_SRC_FILES := firebaseconfigs/ConfigBase/ConfigBase.cpp
include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ConfigDevelopment.h
LOCAL_SRC_FILES := firebaseconfigs/ConfigDevelopment/ConfigDevelopment.cpp
include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ConfigStaging.h
LOCAL_SRC_FILES := firebaseconfigs/ConfigStaging/ConfigStaging.cpp
include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := ConfigProduction.h
LOCAL_SRC_FILES := firebaseconfigs/ConfigProduction/ConfigProduction.cpp
include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := FirebaseConfigFactory.h
LOCAL_SRC_FILES := firebaseconfigs/FirebaseConfigFactory/FirebaseConfigFactory.cpp
include $(BUILD_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := FirebaseConfigInstance.h
LOCAL_SRC_FILES := firebaseconfigs/FirebaseConfigInstance/FirebaseConfigInstance.cpp
include $(BUILD_STATIC_LIBRARY)



