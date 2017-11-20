package com.example.mk123_pc.khan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String personId;
    private String name;

    public Agent(String personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Agent> getAgentList(String JSONAgent) {
        List<Agent> agents = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(JSONAgent);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray nestedArray = jsonArray.getJSONArray(i);
                String personId = null, name = null;
                for (int j = 0; j < nestedArray.length(); j++) {
                    JSONObject object = (JSONObject) nestedArray.get(j);
                    if (object.opt("personId") != null) {
                        personId = object.getString("personId");
                    } else if (object.opt("name") != null) {
                        name = object.getString("name");
                    }
                }

//                JSONObject object = jsonArray.getJSONObject(i);
//                String personId = object.getString("personId");
//                String name = object.getString("name");
                agents.add(new Agent(personId, name));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return agents;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
