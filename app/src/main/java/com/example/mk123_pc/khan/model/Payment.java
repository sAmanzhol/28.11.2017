package com.example.mk123_pc.khan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Payment {

    private String id;
    private String state;
    private String registerTime;
    private String terminalId;
    private String terminalTitle;
    private String serviceId;
    private String serviceTitle;
    private String account;
    private String paidAmount;
    private String userAmount;

    public Payment(String id, String state, String registerTime, String terminalId, String terminalTitle, String serviceId, String serviceTitle, String account, String paidAmount, String userAmount) {
        this.id = id;
        this.state = state;
        this.registerTime = registerTime;
        this.terminalId = terminalId;
        this.terminalTitle = terminalTitle;
        this.serviceId = serviceId;
        this.serviceTitle = serviceTitle;
        this.account = account;
        this.paidAmount = paidAmount;
        this.userAmount = userAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalTitle() {
        return terminalTitle;
    }

    public void setTerminalTitle(String terminalTitle) {
        this.terminalTitle = terminalTitle;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(String userAmount) {
        this.userAmount = userAmount;
    }

    public static List<Payment> getList(String jsonPayment){
        List<Payment> payments=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonPayment);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                String id=object.getString("id");
                String state=object.getString("state");
                String registerTime=object.getString("registerTime");
                String terminalId=object.getJSONObject("terminal").getString("id");
                String terminalTitle=object.getJSONObject("terminal").getString("title");
                String serviceId=object.getJSONObject("service").getString("id");
                String serviceTitle=object.getJSONObject("service").getString("title");
                String account=object.getString("account");

                String paidAmount=object.getString("paidAmount");
                String userAmount=object.getString("userAmount");

                payments.add(new Payment(id, state, registerTime, terminalId, terminalTitle, serviceId, serviceTitle, account, paidAmount,userAmount));


            }


        }catch (JSONException e){
            e.printStackTrace();
        }

        return payments;


    }
}
