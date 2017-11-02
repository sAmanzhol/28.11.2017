package com.example.mk123_pc.khan.util;



public class Global {
    public static String URL = "http://192.168.1.200:8080";
//    public static String URL = "http://khan.kz";
    public static String URL_AUTHENTICATION = URL + "/api/auth/signin";
    public static String URL_TERMINALS=URL+"/api/terminal/?person_id=";
    public static void setTerminalsId(int userId) {
        URL_TERMINALS=URL+"/api/terminal/?person_id=" + userId;
    }

    public static  String ACCESS_TOKEN;
    public static  String REFRESH_TOKEN;

}
