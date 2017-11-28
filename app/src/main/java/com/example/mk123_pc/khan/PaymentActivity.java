package com.example.mk123_pc.khan;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mk123_pc.khan.dto.PaymentDTO;
import com.example.mk123_pc.khan.model.Payment;
import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Adapter.SpinnerTerminalAdapter;
import com.example.mk123_pc.khan.util.Global;
;
import com.example.mk123_pc.khan.util.Adapter.PaymentAdapter;
import com.example.mk123_pc.khan.util.RequestManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class PaymentActivity extends Activity {
    @BindView(R.id.listViewPayments)
    ListView lvPayments;

    private static final String TAG = PaymentActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);
        ButterKnife.bind(this);
        sendRequest();
    }
    private void sendRequest() {

        RequestManager requestManager = new RequestManager(this);


         requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {

            @Override
            public void onSuccess(String data) {
                populateList(data);

            }
            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);

            }
        });
        requestManager.get(Global.URL_PAYMENTS);
    }

    List<Payment> paymentList= new ArrayList<>();
    PaymentAdapter arrayAdapter;
    private void populateList(String jsonData) {
        paymentList = Payment.getList(jsonData);
        arrayAdapter = new PaymentAdapter(PaymentActivity.this, R.layout.item_payment, paymentList);
        lvPayments.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }




}

