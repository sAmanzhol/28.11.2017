package com.example.mk123_pc.khan.util;



public class Global {
    public static String URL = "http://192.168.1.200:8080";
//    public static String URL = "http://khan.kz";
    public static String URL_AUTHENTICATION = URL + "/api/auth/signin";
    public static String URL_TERMINALS=URL+"/api/terminal/?person_id=";

    public static void setTerminalsId(int userId) {
        URL_TERMINALS=URL+"/api/terminal/?person_id=" + userId;
    }

    public static String URL_PAYMENTS=URL+"/api/payment/list?agentId=";
    public static void setPaymentsFilters(String dateFrom,String dateTo,String sumFrom,String sumTo,String terminal,String service,String status,String account,String agent ){
        URL_PAYMENTS=URL+"/api/payment/list?agentId=" + agent+ "&dateFrom=" + dateFrom + "&dateTo=" + dateTo + "&fromAmount=" + sumFrom + "&toAmount=" + sumTo + "&terminalId=" + terminal ;
    }
    public static  String ACCESS_TOKEN;
    public static  String REFRESH_TOKEN;
    public static String JSONData;
    public static void setJSONData(String data) {
        JSONData=data;
    }
}
//
//+ "&terminalId=" + terminal + "& serviceId=" + service + "&state=" + status + "&account" + account