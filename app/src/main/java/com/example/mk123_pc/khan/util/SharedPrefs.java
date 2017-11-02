package com.example.mk123_pc.khan.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mk123_pc.khan.dto.PayloadDTO;

import static android.content.Context.MODE_PRIVATE;


public class SharedPrefs {
    private static final String PREFIX = "khan_";
    private static final String USER_DETAILS = PREFIX + "user_details";


   public static void saveUserInfo(Context context, String data) {
      SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
      SharedPreferences.Editor editor=preferences.edit();
       editor.putString("data", data);
       editor.apply();
   }

    public static void saveTerminalInfo(Context context, String terminal) {
        SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("terminal",terminal);
        editor.apply();
    }
    public static String getTerminalInfo(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
        return preferences.getString("terminal", null);
    }
   public static String getUserInfo(Context context) {
       // todo get saved info
       SharedPreferences preferences =context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
       return preferences.getString("data", null);
   }

    public static boolean checkUserCredentials(Context context, String phone, String password) {
        SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
        String savedPhone = preferences.getString("phone", null);
        String savedPass = preferences.getString("password", null);

        return savedPhone.equals(phone) && savedPass.equals(password);
    }

//    public static boolean isUserLoggedIn() {
//
//    }

    public static String getPhone(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
        return preferences.getString("phone", null);
    }
}
