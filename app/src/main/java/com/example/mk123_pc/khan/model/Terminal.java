package com.example.mk123_pc.khan.model;

/**
 * Created by MK123-PC on 20.10.2017.
 */

public class Terminal {
    public Terminal(int id, String name, int curSum, String status, String lastPaymentDay) {
        this.id = id;
        this.name = name;
        this.curSum = curSum;
        this.status = status;
        this.lastPaymentDay = lastPaymentDay;
    }

    public int id;
    public String name;
    public int curSum;
    public String status;
    public String lastPaymentDay;
}

