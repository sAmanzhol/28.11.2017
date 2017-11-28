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

    private String name;
    private String address;

    private Date lastPing;

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

    public Date getLastPing() {
        return lastPing;
    }

    public void setLastPing(Date lastPing) {
        this.lastPing = lastPing;
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

    public Terminal(String id, String state, String name, String address, Date lastPing) {
        this.id = id;
        this.state = state;
        this.name = name;
        this.address = address;
        this.lastPing = lastPing;
    }

    public static List<Terminal> getList(String jsonTerminal) {
        List<Terminal> terminals = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonTerminal);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("id");
                String state = object.getString("state");

                String name= object.getString("name");
                String address= object.getString("address");

                Date lastPing = new Date(object.getLong("lastPing"));

                terminals.add(new Terminal(id,state,name,address,lastPing) );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return terminals;
    }

    public static List<Terminal> getTerminalList(String jsonTerminal) {
        List<Terminal> terminals = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonTerminal);
            terminals.add(new Terminal(null,"Все"));
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

