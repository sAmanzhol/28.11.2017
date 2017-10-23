package com.example.mk123_pc.khan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ListView;

import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Adapter;
import com.example.mk123_pc.khan.util.SharedPrefs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();

    private AppCompatTextView tvWelcome;
    private AppCompatTextView tvTerminals;
    private ListView lv;
    private String jsonData = "{" +
            "\"terminals\": [" +
            "{\"id\": \"1\",\"name\": \"Terminal1\",\"cursum\": \"3000\",\"status\": \"OK\",\"lastPaymentDay\": \"20.10.2016\"}, " +
            "{\"id\": \"2\",\"name\": \"Terminal2\",\"cursum\": \"3000\",\"status\": \"OK\",\"lastPaymentDay\": \"21.10.2016\"}, " +
            "{\"id\": \"3\",\"name\": \"Terminal3\",\"cursum\": \"3000\",\"status\": \"OK\",\"lastPaymentDay\": \"22.10.2016\"}" +
            "]" +
            "}";
    List<Terminal> terminalList = new ArrayList<>();
    Adapter arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        tvWelcome = (AppCompatTextView) findViewById(R.id.textViewHome);
        tvTerminals = (AppCompatTextView) findViewById(R.id.textViewTerminals);
        lv = (ListView) findViewById(R.id.listView);
        String savedPhone = SharedPrefs.getPhone(HomeActivity.this);
        tvWelcome.setText("Your number is " + savedPhone);
        tvTerminals.setText("List of your terminals: ");
        try {
            populateList();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void populateList() throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray jsonArray = jsonObject.getJSONArray("terminals");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            int id = object.getInt("id");
            String name = object.getString("name");
            int curSum = object.getInt("cursum");
            String status = object.getString("status");
            String lastPaymentDay = object.getString("lastPaymentDay");
            terminalList.add(new Terminal(id, name, curSum, status, lastPaymentDay));

        }
        arrayAdapter = new Adapter(HomeActivity.this, R.layout.item_terminal, terminalList);

        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }


}
