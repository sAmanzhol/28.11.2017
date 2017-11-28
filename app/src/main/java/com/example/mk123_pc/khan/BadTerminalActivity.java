package com.example.mk123_pc.khan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.widget.ListView;

import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Adapter.TerminalAdapter;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class BadTerminalActivity extends AppCompatActivity {
    private static final String TAG = BadTerminalActivity.class.getSimpleName();
    private AppCompatTextView tvTerminals;
    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bad_terminal_layout);
        ButterKnife.bind(this);
        tvTerminals = findViewById(R.id.textViewTerminals);
        lv =  findViewById(R.id.listView);
        sendRequest();
    }

    private void sendRequest() {
        RequestManager requestManager = new RequestManager(this);

        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);
                populateList(data);
            }

            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_TERMINALS);
    }

    List<Terminal> terminalList = new ArrayList<>();
    TerminalAdapter arrayAdapter;

    private void populateList(String jsonData) {
        terminalList = Terminal.getList(jsonData);

        // last ping time > 5 min = BAD else OK

        List<Terminal> bad = new ArrayList<>();
        List<Terminal> ok = new ArrayList<>();

        for (Terminal terminal : terminalList) {

            long currentTIme = System.currentTimeMillis();
            long timeDiff = currentTIme - terminal.getLastPing().getTime();
            final int minute = 60 * 1000;

                if (timeDiff > 5 * minute) {

                    bad.add(terminal);
                } else {
                    ok.add(terminal);
                }
            }


        arrayAdapter = new TerminalAdapter(BadTerminalActivity.this, R.layout.item_terminal, bad);

        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }





}
