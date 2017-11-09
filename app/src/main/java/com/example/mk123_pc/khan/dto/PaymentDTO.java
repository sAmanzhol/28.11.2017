package com.example.mk123_pc.khan.dto;



public class PaymentDTO {
    private String dateFrom;
    private String dateTo;
    private String period;
    private  String sumFrom;
    private String sumTo;
    private String terminal;
    private String service;
    private String status;
    private String account;
    private String agent;

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getSumFrom() {
        return sumFrom;
    }

    public void setSumFrom(String sumFrom) {
        this.sumFrom = sumFrom;
    }

    public String getSumTo() {
        return sumTo;
    }

    public void setSumTo(String sumTo) {
        this.sumTo = sumTo;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }


}
