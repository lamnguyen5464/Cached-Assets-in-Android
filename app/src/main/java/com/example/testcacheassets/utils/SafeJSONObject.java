package com.example.testcacheassets.utils;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class SafeJSONObject extends JSONObject {

    public SafeJSONObject(@NonNull String json) throws JSONException {
        super(json);
    }

    public static SafeJSONObject parseSafe(String str) {
        try {
            return new SafeJSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getStringSafely(String field) {
        String value = "";
        if (this != null && this.has(field)) {
            try {
                value = this.getString(field);
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
        return value;
    }

    public void putStringSafely(String field, String value) {
        if (this != null) {
            try {
                this.put(field, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
