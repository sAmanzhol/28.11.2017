package com.example.mk123_pc.khan.model;

import com.example.mk123_pc.khan.util.SharedPrefs;

/**
 * Created by MK123-PC on 19.10.2017.
 */

public class User {
    private static User sInstance;

    private int mId;
    private String mName;
    private String mPhone;


//    public static User getInstance() {
//        if (sInstance == null) {
//            if (SharedPrefs.isUserLoggedIn()) {
//                return new User();
//            } else {
//                return null;
//            }
//        } else {
//            return sInstance;
//        }
//    }

//    public User() {
//        mPhone = SharedPrefs.getPhone();
//    }


}
