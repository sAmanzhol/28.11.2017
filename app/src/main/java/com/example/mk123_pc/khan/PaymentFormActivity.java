package com.example.mk123_pc.khan;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;

import com.example.mk123_pc.khan.dto.PayloadDTO;
import com.example.mk123_pc.khan.dto.PaymentDTO;
import com.example.mk123_pc.khan.model.Agent;
import com.example.mk123_pc.khan.model.Service;
import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Adapter.SpinnerAgentAdapter;
import com.example.mk123_pc.khan.util.Adapter.SpinnerServiceAdapter;


import com.example.mk123_pc.khan.util.DateTime.DatePickerFragmentFrom;
import com.example.mk123_pc.khan.util.DateTime.DatePickerFragmentTo;
import com.example.mk123_pc.khan.util.DateTime.TimePickerFragmentTo;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;
import com.example.mk123_pc.khan.util.Adapter.SpinnerTerminalAdapter;
import com.example.mk123_pc.khan.util.DateTime.TimePickerFragmentFrom;


import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
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
    @BindView(R.id.textInputEditTextAccount)
    TextInputEditText etAccount;

    PaymentDTO payment = new PaymentDTO();
    PayloadDTO payloadDTO = new PayloadDTO();


    public enum Period {
        NOTHING("-"),
        DAY("1 day"),
        WEEK("1 week"),
        MONTH("1 month"),
        YEAR("1 year");
        private String value;
        Period(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_form_layout);
        ButterKnife.bind(this);
        setAdapter();
        sendTerminalRequest();
        sendServiceRequest();
        sendAgentRequest();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPaymentFilter();
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setSelectedPeriod() {
        Date now =new Date();
        String dateTo = new SimpleDateFormat("yyyy-MM-dd").format(now);
        Calendar c = Calendar.getInstance();
        String period = (String) spinnerPeriod.getSelectedItem().toString();
      if(period=="-"){
          etDateFrom.setText(Global.DATE_FROM+Global.TIME_FROM);
          etDateTo.setText(Global.DATE_TO+Global.TIME_TO);
      }else if (period=="1 day"){
          c.add(Calendar.DAY_OF_MONTH, -1);
          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
          String output = sdf1.format(c.getTime());
          etDateFrom.setText(output+"T10:00:00.000Z");
          etDateTo.setText(dateTo+"T10:00:00.000Z");
      }else if (period=="1 week"){
          c.add(Calendar.DAY_OF_MONTH, -7);
          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
          String output = sdf1.format(c.getTime());
          etDateFrom.setText(output+"T10:00:00.000Z");
          etDateTo.setText(dateTo+"T10:00:00.000Z");
      }else if (period=="1 month"){
          c.add(Calendar.MONTH, -1);
          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
          String output = sdf1.format(c.getTime());
          etDateFrom.setText(output+"T10:00:00.000Z");
          etDateTo.setText(dateTo+"T10:00:00.000Z");
      }else if (period=="1 year"){
          c.add(Calendar.YEAR, -1);
          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
          String output = sdf1.format(c.getTime());
          etDateFrom.setText(output+"T10:00:00.000Z");
          etDateTo.setText(dateTo+"T10:00:00.000Z");
      }
    }
    private void sendTerminalRequest() {
        RequestManager requestManager = new RequestManager(this);
        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);
                populateTerminalList(data);
            }
            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_TERMINALS);
    }
    private void sendServiceRequest() {
        RequestManager requestManager = new RequestManager(this);
        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);
                populateServiceList(data);
            }
            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_SERVICES);
    }
    private void sendAgentRequest() {
        RequestManager requestManager = new RequestManager(this);
        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);
                populateAgentList(data);
            }
            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_AGENTS);
    }

    public void populateTerminalList(String jsonData) {
        SpinnerTerminalAdapter arrayAdapter;
        List<Terminal> terminalList = Terminal.getTermianlList(jsonData);
        arrayAdapter = new SpinnerTerminalAdapter(PaymentFormActivity.this, R.layout.terminal_spinner_item_layout, terminalList);
        spinnerTerminal.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    public void populateServiceList(String jsonData) {
        SpinnerServiceAdapter arrayAdapter;
        List<Service> serviceList = Service.getServiceList(jsonData);
        arrayAdapter = new SpinnerServiceAdapter(PaymentFormActivity.this, R.layout.service_spinner_item_layout, serviceList);
        spinnerService.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    public void populateAgentList(String jsonData) {
        SpinnerAgentAdapter arrayAdapter;
        List<Agent> agentList = Agent.getAgentList(jsonData);
        arrayAdapter = new SpinnerAgentAdapter(PaymentFormActivity.this, R.layout.agent_spinner_item_layout, agentList);
        spinnerAgent.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
    private void setAdapter() {
        //Period Spinner
        spinnerPeriod.setAdapter(new ArrayAdapter<Period>(this, android.R.layout.simple_spinner_item, Period.values()));
        //Status Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.state_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);
    }

    public void setPaymentFilter()  {
        setSelectedPeriod();
        payment.setDateFrom(etDateFrom.getText().toString());
        payment.setDateTo(etDateTo.getText().toString());
        payment.setSumFrom(etSumFrom.getText().toString());
        payment.setSumTo(etSumTo.getText().toString());
        payment.setAccount(etAccount.getText().toString());
        Terminal terminal = (Terminal) spinnerTerminal.getSelectedItem();
        payment.setTerminal(terminal.getId());
        Service service = (Service) spinnerService.getSelectedItem();
        payment.setService(service.getId());
        if(payloadDTO.getPersonId()==1) {
            Agent agent = (Agent) spinnerAgent.getSelectedItem();
            payment.setAgent(agent.getPersonId());
        }else  payment.setAgent(String.valueOf(payloadDTO.getPersonId()));
        String status = (String) spinnerStatus.getSelectedItem().toString();
        payment.setStatus(status);
        Global.setPaymentsFilters(payment.getDateFrom(), payment.getDateTo(), payment.getSumFrom(), payment.getSumTo(), payment.getTerminal(), payment.getService(), payment.getStatus(), payment.getAccount(), payment.getAgent());
    }


    public void showDatePickerDialogFrom(View v) {
        DialogFragment newFragment = new DatePickerFragmentFrom();
        newFragment.show( getFragmentManager(), "datePicker");
    }
    public void showTimePickerDialogFrom(View v) {
        DialogFragment newFragment = new TimePickerFragmentFrom();
        newFragment.show(getFragmentManager(), "timePicker");
    }
    public void showDatePickerDialogTo(View v) {
        DialogFragment newFragment = new DatePickerFragmentTo();
        newFragment.show( getFragmentManager(), "datePicker");
    }
    public void showTimePickerDialogTo(View v) {
        DialogFragment newFragment = new TimePickerFragmentTo();
        newFragment.show(getFragmentManager(), "timePicker");
    }







}




