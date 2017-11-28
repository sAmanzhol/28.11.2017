package com.example.mk123_pc.khan.util;


import android.util.Log;

import com.example.mk123_pc.khan.PaymentFormActivity;
import com.example.mk123_pc.khan.model.Agent;
import com.example.mk123_pc.khan.model.Terminal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Global {
    public static String URL = "http://192.168.1.200:8080";
//    public static String URL = "http://khan.kz";
    public static String URL_AGENTS = URL +"/api/persons/agents";
    public static String URL_AUTHENTICATION = URL + "/api/auth/signin";
    public static String URL_TERMINALS=URL+"/api/terminal/?person_id=";
    public static String URL_SERVICES=URL+"/api/services";
    public static void setTerminalsId(int userId) {
        URL_TERMINALS=URL+"/api/terminal/?person_id=" + userId;
    }
  public static String URL_PAYMENTS=URL+"/api/payment/list?fake=fake";
    public static void setPaymentsFilters(String dateFrom,String dateTo,String sumFrom,String sumTo,String terminal,String service,String status,String account,String agent ){
        URL_PAYMENTS=URL+"/api/payment/list?fake=fake";
        if (agent != null) {
            URL_PAYMENTS += "&agentId=" + agent;
        }
        if (dateFrom != null) {
            URL_PAYMENTS += "&dateFrom=" + dateFrom;
        }
        if (dateTo != null) {
            URL_PAYMENTS += "&dateTo=" + dateTo;
        }
        if (sumFrom != null) {
            URL_PAYMENTS += "&fromAmount=" + sumFrom;
        }
        if (sumTo!= null) {
            URL_PAYMENTS += "&toAmount=" + sumTo;
        }
        if (terminal!= null) {
            URL_PAYMENTS += "&terminalId=" + terminal;
        }
        if (service!= null) {
            URL_PAYMENTS += "&serviceId=" + service;
        }
        if (status!= null) {
            URL_PAYMENTS += "&state=" + status;
        }
        if (account!= null) {
            URL_PAYMENTS += "&account=" + account;
        }



//        "&dateTo=" + dateTo + "&fromAmount=" + sumFrom + "&toAmount=" + sumTo + "&terminalId=" + terminal+ "&serviceId=" + service+ "&account=" + account +"&state=" + status ;



    }
    public static  String ACCESS_TOKEN;
    public static  String REFRESH_TOKEN;
    public static String JSONData;
    public static void setJSONData(String data) {
        JSONData=data;
    }

    public static String DATE_FROM;
    public static void setDateFrom(String dateFrom){DATE_FROM=dateFrom;}
    public static String TIME_FROM;
    public static void setTimeFrom(String timeFrom){TIME_FROM=timeFrom;}

    public static String DATE_TO;
    public static void setDateTo(String dateTo){DATE_TO=dateTo;}
    public static String TIME_TO;
    public static void setTimeTo(String timeTo){TIME_TO=timeTo;}

    public static String TERMINAL_ID;
    public static void setTerminalId(String id) {
        TERMINAL_ID=id;
    }
}





