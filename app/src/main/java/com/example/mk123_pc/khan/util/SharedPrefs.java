package com.example.mk123_pc.khan.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by MK123-PC on 19.10.2017.
 */
public class SharedPrefs {
    private static final String PREFIX = "khan_";
    private static final String USER_DETAILS = PREFIX + "user_details";


  public static void saveUserInfo(Context context, String phone, String password) {
      SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
      SharedPreferences.Editor editor=preferences.edit();
       editor.putString("phone", phone);
       editor.putString("password", password);
       editor.apply();
   }

   public static String getPhone(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(USER_DETAILS, MODE_PRIVATE);
        return preferences.getString("phone", null);
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


}
