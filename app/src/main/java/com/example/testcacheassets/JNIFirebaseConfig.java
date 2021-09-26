package com.example.testcacheassets;

public class JNIFirebaseConfig {
    public static final int DEVELOPMENT = 0;
    public static final int STAGING = 1;
    public static final int PRODUCTION = 2;

    private int appEnvironmentCode = 0;

    JNIFirebaseConfig(int appEnvironmentCode){
        setAppEnvironmentCode(appEnvironmentCode);
    }

    public void setAppEnvironmentCode(int appEnvironmentCode){
        this.appEnvironmentCode = appEnvironmentCode;
    }

    public String getApiKey(){
        return getApiKey(this.appEnvironmentCode);
    }

    public String getAppId(){
        return getAppId(this.appEnvironmentCode);
    }

    public String getDbUrl(){
        return getDbUrl(this.appEnvironmentCode);
    }

    public String getGcmSenderId(){
        return getGcmSenderId(this.appEnvironmentCode);
    }

    public String getProjectId(){
        return getProjectId(this.appEnvironmentCode);
    }

    public String getStorageBucket(){
        return getStorageBucket(this.appEnvironmentCode);
    }

    public String getGaTrackingId(){
        return getGaTrackingId(this.appEnvironmentCode);
    }



    //Java-native-interface (JNI) call
    static {
        System.loadLibrary("jni-firebase-config");
    }
    private native String getApiKey(int appEnvironmentCode);
    private native String getAppId(int appEnvironmentCode);
    private native String getDbUrl(int appEnvironmentCode);
    private native String getGcmSenderId(int appEnvironmentCode);
    private native String getProjectId(int appEnvironmentCode);
    private native String getStorageBucket(int appEnvironmentCode);
    private native String getGaTrackingId(int appEnvironmentCode);
}
