package com.example.mk123_pc.khan.model;

import android.content.Context;

import com.example.mk123_pc.khan.util.SharedPrefs;

import org.json.JSONException;
import org.json.JSONObject;


public class User {
    private static User sInstance;

    private int mId;
    private String mName;
    private String mPhone;
    private String mAccessToken;
    private String mRefreshToken;


    private User(String data) throws JSONException {
        JSONObject jsonObject = new JSONObject(data);
        mAccessToken = jsonObject.getString("accessToken");
    }

    public static User getInstance(Context context) {
        if (sInstance == null) {
            if (SharedPrefs.getUserInfo(context) != null) {
                try {
                    return new User(SharedPrefs.getUserInfo(context));
                } catch (JSONException e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return sInstance;
        }
    }

//    public User() {
//        mPhone = SharedPrefs.getPhone();
//    }

    public static User login(Context context, String data) {
        SharedPrefs.saveUserInfo(context, data);
        return User.getInstance(context);
    }

}
