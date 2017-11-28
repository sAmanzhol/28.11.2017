package com.example.mk123_pc.khan.dto;


public class PayloadDTO {
    // user id
    private int sub;
    private int personId;

    enum Status {
        ADMIN, CLIENT
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
