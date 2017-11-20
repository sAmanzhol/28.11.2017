package com.example.mk123_pc.khan.model;

import com.example.mk123_pc.khan.util.Global;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Terminal {
    private String id;
    private String state;
    private String agentId;
    private String feeProfileId;
    private String createTime;
    private String name;
    private String address;
    private String addInfo;
    private String operationMode;
    private String nds;
    private String rnm;
    private String simNumber;
    private String maxBillsCount;
    private String regionId;
    private String locationId;
    private String taxCommitteeId;
    private String comments;
    private Date lastPing;
    private String lastIp;
    private String customNetwork;
    private String cliVersion;
    private String cliVersionLastUpdate;
    private String sslCert;
    private String sslPrivKey;
    private String maxAmountPerDay;
    private String amountToday;
    private String amountTodayRefreshedTime;

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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getFeeProfileId() {
        return feeProfileId;
    }

    public void setFeeProfileId(String feeProfileId) {
        this.feeProfileId = feeProfileId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public String getNds() {
        return nds;
    }

    public void setNds(String nds) {
        this.nds = nds;
    }

    public String getRnm() {
        return rnm;
    }

    public void setRnm(String rnm) {
        this.rnm = rnm;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getMaxBillsCount() {
        return maxBillsCount;
    }

    public void setMaxBillsCount(String maxBillsCount) {
        this.maxBillsCount = maxBillsCount;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTaxCommitteeId() {
        return taxCommitteeId;
    }

    public void setTaxCommitteeId(String taxCommitteeId) {
        this.taxCommitteeId = taxCommitteeId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getLastPing() {
        return lastPing;
    }

    public void setLastPing(Date lastPing) {
        this.lastPing = lastPing;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getCustomNetwork() {
        return customNetwork;
    }

    public void setCustomNetwork(String customNetwork) {
        this.customNetwork = customNetwork;
    }

    public String getCliVersion() {
        return cliVersion;
    }

    public void setCliVersion(String cliVersion) {
        this.cliVersion = cliVersion;
    }

    public String getCliVersionLastUpdate() {
        return cliVersionLastUpdate;
    }

    public void setCliVersionLastUpdate(String cliVersionLastUpdate) {
        this.cliVersionLastUpdate = cliVersionLastUpdate;
    }

    public String getSslCert() {
        return sslCert;
    }

    public void setSslCert(String sslCert) {
        this.sslCert = sslCert;
    }

    public String getSslPrivKey() {
        return sslPrivKey;
    }

    public void setSslPrivKey(String sslPrivKey) {
        this.sslPrivKey = sslPrivKey;
    }

    public String getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(String maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public String getAmountToday() {
        return amountToday;
    }

    public void setAmountToday(String amountToday) {
        this.amountToday = amountToday;
    }

    public String getAmountTodayRefreshedTime() {
        return amountTodayRefreshedTime;
    }

    public void setAmountTodayRefreshedTime(String amountTodayRefreshedTime) {
        this.amountTodayRefreshedTime = amountTodayRefreshedTime;
    }

    public Terminal() {
    }

    public Terminal(String name) {
        this.name = name;
    }

    public Terminal(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Terminal(String id, String state, String agentId, String feeProfileId, String createTime, String name, String address, String addInfo, String operationMode, String nds, String rnm, String simNumber, String maxBillsCount, String regionId, String locationId, String taxCommitteeId, String comments, Date lastPing, String lastIp, String customNetwork, String cliVersion, String cliVersionLastUpdate, String sslCert, String sslPrivKey, String maxAmountPerDay, String amountToday, String amountTodayRefreshedTime) {
        this.id = id;
        this.state = state;
        this.agentId = agentId;
        this.feeProfileId = feeProfileId;
        this.createTime = createTime;
        this.name = name;
        this.address = address;
        this.addInfo = addInfo;
        this.operationMode = operationMode;
        this.nds = nds;
        this.rnm = rnm;
        this.simNumber = simNumber;
        this.maxBillsCount = maxBillsCount;
        this.regionId = regionId;
        this.locationId = locationId;
        this.taxCommitteeId = taxCommitteeId;
        this.comments = comments;
        this.lastPing = lastPing;
        this.lastIp = lastIp;
        this.customNetwork = customNetwork;
        this.cliVersion = cliVersion;
        this.cliVersionLastUpdate = cliVersionLastUpdate;
        this.sslCert = sslCert;
        this.sslPrivKey = sslPrivKey;
        this.maxAmountPerDay = maxAmountPerDay;
        this.amountToday = amountToday;
        this.amountTodayRefreshedTime = amountTodayRefreshedTime;
    }

    public static List<Terminal> getList(String jsonTerminal) {
        List<Terminal> terminals = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonTerminal);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("id");
                String state = object.getString("state");
                String agentId = object.getString("agentId");
                String feeProfileId = object.getString("feeProfileId");
                String createTime= object.getString("createTime");
                String name= object.getString("name");
                String address= object.getString("address");
                String addInfo= object.getString("addInfo");
                String operationMode= object.getString("operationMode");
                String nds= object.getString("nds");
                String rnm= object.getString("rnm");
                String simNumber= object.getString("simNumber");
                String maxBillsCount= object.getString("maxBillsCount");
                String regionId= object.getString("regionId");
                String locationId= object.getString("locationId");
                String taxCommitteeId= object.getString("taxCommitteeId");
                String comments= object.getString("comments");
                Date lastPing = new Date(object.getLong("lastPing"));
                String lastIp= object.getString("lastIp");
                String customNetwork= object.getString("customNetwork");
                String cliVersion= object.getString("cliVersion");
                String cliVersionLastUpdate= object.getString("cliVersionLastUpdate");
                String sslCert= object.getString("sslCert");
                String sslPrivKey= object.getString("sslPrivKey");
                String maxAmountPerDay= object.getString("maxAmountPerDay");
                String amountToday= object.getString("amountToday");
                String amountTodayRefreshedTime= object.getString("amountTodayRefreshedTime");
                terminals.add(new Terminal(id,state,agentId,feeProfileId,createTime, name,address, addInfo,operationMode,nds,rnm,simNumber,maxBillsCount,regionId,locationId,taxCommitteeId,comments,lastPing,lastIp,customNetwork,cliVersion,cliVersionLastUpdate,sslCert,sslPrivKey,maxAmountPerDay,amountToday,amountTodayRefreshedTime) );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return terminals;
    }

    public static List<Terminal> getTermianlList(String jsonTerminal) {
        List<Terminal> terminals = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonTerminal);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id=object.getString("id");
                String name = object.getString("name");


                terminals.add(new Terminal(id,name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return terminals;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

