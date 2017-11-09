package com.example.mk123_pc.khan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Payment {

    private String id;
    private String state;
    private String stateDetails;
    private String registerTime;
    private String submitTime;
    private String processTime;
    private String lastEventStatus;
    private String receiptTime;
    private String terminalId;
    private String providerSubmitInfo;
    private String receiptNo;
    private String extras;
    private String serviceId;
    private String providerId;
    private String account;
    private String currency;
    private String paidAmount;
    private String userAmount;
    private String agentFee;
    private String parentAgentFee;
    private String processingFee;
    private String paidAmountFtxId;
    private String mainFtxId;
    private String sysFeeFtxId;
    private String agentFeeFtxId;
    private String parentAgentFeeFtxId;

    public Payment(String id, String state, String stateDetails, String registerTime, String submitTime, String processTime, String lastEventStatus, String receiptTime, String terminalId, String providerSubmitInfo, String receiptNo, String extras, String serviceId, String providerId, String account, String currency, String paidAmount, String userAmount, String agentFee, String parentAgentFee, String processingFee, String paidAmountFtxId, String mainFtxId, String sysFeeFtxId, String agentFeeFtxId, String parentAgentFeeFtxId) {
        this.id = id;
        this.state = state;
        this.stateDetails = stateDetails;
        this.registerTime = registerTime;
        this.submitTime = submitTime;
        this.processTime = processTime;
        this.lastEventStatus = lastEventStatus;
        this.receiptTime = receiptTime;
        this.terminalId = terminalId;
        this.providerSubmitInfo = providerSubmitInfo;
        this.receiptNo = receiptNo;
        this.extras = extras;
        this.serviceId = serviceId;
        this.providerId = providerId;
        this.account = account;
        this.currency = currency;
        this.paidAmount = paidAmount;
        this.userAmount = userAmount;
        this.agentFee = agentFee;
        this.parentAgentFee = parentAgentFee;
        this.processingFee = processingFee;
        this.paidAmountFtxId = paidAmountFtxId;
        this.mainFtxId = mainFtxId;
        this.sysFeeFtxId = sysFeeFtxId;
        this.agentFeeFtxId = agentFeeFtxId;
        this.parentAgentFeeFtxId = parentAgentFeeFtxId;
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

    public String getStateDetails() {
        return stateDetails;
    }

    public void setStateDetails(String stateDetails) {
        this.stateDetails = stateDetails;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getLastEventStatus() {
        return lastEventStatus;
    }

    public void setLastEventStatus(String lastEventStatus) {
        this.lastEventStatus = lastEventStatus;
    }

    public String getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(String receiptTime) {
        this.receiptTime = receiptTime;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getProviderSubmitInfo() {
        return providerSubmitInfo;
    }

    public void setProviderSubmitInfo(String providerSubmitInfo) {
        this.providerSubmitInfo = providerSubmitInfo;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(String agentFee) {
        this.agentFee = agentFee;
    }

    public String getParentAgentFee() {
        return parentAgentFee;
    }

    public void setParentAgentFee(String parentAgentFee) {
        this.parentAgentFee = parentAgentFee;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
    }

    public String getPaidAmountFtxId() {
        return paidAmountFtxId;
    }

    public void setPaidAmountFtxId(String paidAmountFtxId) {
        this.paidAmountFtxId = paidAmountFtxId;
    }

    public String getMainFtxId() {
        return mainFtxId;
    }

    public void setMainFtxId(String mainFtxId) {
        this.mainFtxId = mainFtxId;
    }

    public String getSysFeeFtxId() {
        return sysFeeFtxId;
    }

    public void setSysFeeFtxId(String sysFeeFtxId) {
        this.sysFeeFtxId = sysFeeFtxId;
    }

    public String getAgentFeeFtxId() {
        return agentFeeFtxId;
    }

    public void setAgentFeeFtxId(String agentFeeFtxId) {
        this.agentFeeFtxId = agentFeeFtxId;
    }

    public String getParentAgentFeeFtxId() {
        return parentAgentFeeFtxId;
    }

    public void setParentAgentFeeFtxId(String parentAgentFeeFtxId) {
        this.parentAgentFeeFtxId = parentAgentFeeFtxId;
    }

    public static List<Payment> getList(String jsonPayment){
        List<Payment> payments=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(jsonPayment);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                String id=object.getString("id");
                String state=object.getString("state");
                String stateDetails=object.getString("stateDetails");
                String registerTime=object.getString("registerTime");
                String submitTime=object.getString("submitTime");
                String processTime=object.getString("processTime");
                String lastEventStatus=object.getString("lastEventStatus");
                String receiptTime=object.getString("receiptTime");
                String terminalId=object.getString("terminalId");
                String providerSubmitInfo=object.getString("providerSubmitInfo");
                String receiptNo=object.getString("receiptNo");
                String extras=object.getString("extras");
                String serviceId=object.getString("serviceId");
                String providerId=object.getString("providerId");
                String account=object.getString("account");
                String currency=object.getString("currency");
                String paidAmount=object.getString("paidAmount");
                String userAmount=object.getString("userAmount");
                String agentFee=object.getString("agentFee");
                String parentAgentFee=object.getString("parentAgentFee");
                String processingFee=object.getString("processingFee");
                String paidAmountFtxId=object.getString("paidAmountFtxId");
                String mainFtxId=object.getString("mainFtxId");
                String sysFeeFtxId=object.getString("sysFeeFtxId");
                String agentFeeFtxId=object.getString("agentFeeFtxId");
                String parentAgentFeeFtxId=object.getString("parentAgentFeeFtxId");
                payments.add(new Payment(id,state,stateDetails,registerTime,submitTime,processTime,lastEventStatus,receiptTime,terminalId,providerSubmitInfo,receiptNo,extras, serviceId, providerId, account, currency,paidAmount, userAmount, agentFee, parentAgentFee,  processingFee, paidAmountFtxId, mainFtxId, sysFeeFtxId, agentFeeFtxId, parentAgentFeeFtxId));


            }


        }catch (JSONException e){
            e.printStackTrace();
        }

        return payments;


    }
}
