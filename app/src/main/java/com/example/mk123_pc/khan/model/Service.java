package com.example.mk123_pc.khan.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private String id;
    private String fullName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Service(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public static List<Service> getServiceList(String JSONService){
        List<Service> services = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(JSONService);
            services.add(new Service(null,"Все"));
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                String id=object.getString("id");
                String fullName=object.getString("fullName");
                services.add(new Service(id,fullName));
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        return services;
    }
    @Override
    public String toString() {
        return this.fullName;
    }

}
