package com.example.mk123_pc.khan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.mk123_pc.khan.dto.PayloadDTO;
import com.example.mk123_pc.khan.dto.PaymentDTO;
import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;
import com.example.mk123_pc.khan.util.Adapter.SpinnerTerminalAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class PaymentFormActivity extends Activity {
    @BindView(R.id.spinnerPeriod)
    Spinner spinnerPeriod;
    @BindView(R.id.spinnerService)
    Spinner spinnerService;
    @BindView(R.id.spinnerTerminal)
    Spinner spinnerTerminal;
    @BindView(R.id.spinnerStatus)
    Spinner spinnerStatus;
    @BindView(R.id.spinnerAgent)
    Spinner spinnerAgent;
    @BindView(R.id.appCompatButtonShow)
    Button btnShow;
    @BindView(R.id.textInputEditTextDateFrom)
    TextInputEditText etDateFrom;
    @BindView(R.id.textInputEditTextDateTo)
    TextInputEditText etDateTo;
    @BindView(R.id.textInputEditTextSumFrom)
    TextInputEditText etSumFrom;
    @BindView(R.id.textInputEditTextSumTo)
    TextInputEditText etSumTo;
    PaymentDTO payment=new PaymentDTO();
    PayloadDTO payloadDTO=new PayloadDTO();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form_layout);
        ButterKnife.bind(this);
        setAdapter();
        sendRequest();






        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResponse();
                Intent intent=new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(intent);

            }
        });
        //Period spinner conditions
//        String text = spinnerPeriod.getSelectedItem().toString();
//        if (text.equals("1 day")){
//            etDateFrom.setText("2017-05-10T10:00:00.000Z");
//            etDateTo.setText("2017-09-10T10:00:00.000Z");
//        }else if(text.equals("1 weak")){
//            etDateFrom.setText("2017-05-10T10:00:00.000Z");
//            etDateTo.setText("2017-09-10T10:00:00.000Z");
//        }
//        else if(text.equals("1 month")){
//            etDateFrom.setText("2017-05-10T10:00:00.000Z");
//            etDateTo.setText("2017-09-10T10:00:00.000Z");
//        }
//        else if(text.equals("1 year")){
//            etDateFrom.setText("2017-05-10T10:00:00.000Z");
//            etDateTo.setText("2017-09-10T10:00:00.000Z");
//        }

    }
    private void sendRequest() {
        RequestManager requestManager = new RequestManager(this);

        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);

                populateNameList(data);
            }

            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_TERMINALS);
    }

    public void populateNameList(String jsonData) {
        SpinnerTerminalAdapter arrayAdapter;
        List<Terminal> terminalList = Terminal.getNameList(jsonData);
        arrayAdapter = new SpinnerTerminalAdapter(PaymentFormActivity.this, R.layout.terminal_spinner_item_layout,terminalList);

        spinnerTerminal.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    private void  setAdapter(){
        //Period Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.period_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPeriod.setAdapter(adapter);
        //Service Spinner
        adapter = ArrayAdapter.createFromResource(this,R.array.period_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerService.setAdapter(adapter);
        //Status Spinner
        adapter = ArrayAdapter.createFromResource(this,R.array.period_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);
        //Agent Spinner
        adapter = ArrayAdapter.createFromResource(this,R.array.period_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAgent.setAdapter(adapter);
    }

//    todo change the name
    public void onResponse() {
        etDateFrom.setText("2017-05-10T10:00:00.000Z");
        etDateTo.setText("2017-09-10T10:00:00.000Z");

        payment.setDateFrom(etDateFrom.getText().toString());
        payment.setDateTo(etDateTo.getText().toString());
        payment.setAgent(String.valueOf(payloadDTO.getPersonId()));
        payment.setSumFrom(etSumFrom.getText().toString());
        payment.setSumTo(etSumTo.getText().toString());
        Terminal terminal = (Terminal) spinnerTerminal.getSelectedItem();
        payment.setTerminal(terminal.getId());

        Global.setPaymentsFilters(payment.getDateFrom(),payment.getDateTo(),payment.getSumFrom(),payment.getSumTo(),payment.getTerminal(),payment.getService(),payment.getStatus(),payment.getAccount(),payment.getAgent());

    }
}
