package com.example.mk123_pc.khan.util.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mk123_pc.khan.PaymentActivity;
import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Payment;
import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentAdapter extends ArrayAdapter<Payment> {
    private static final String TAG = TerminalAdapter.class.getSimpleName();

    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public PaymentAdapter(Context context, int resource, List<Payment> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PaymentAdapter.PaymentViewHolder pvh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            pvh = new PaymentAdapter.PaymentViewHolder(convertView);
            convertView.setTag(pvh);
        } else {
            pvh = (PaymentAdapter.PaymentViewHolder) convertView.getTag();
        }
        // Assign the appropriate data from our alert object above
        Payment payment = getItem(position);
        pvh.tvId.setText("Id: "+payment.getId());
       pvh.tvState.setText("State: "+payment.getState());
       pvh.tvRegisterTime.setText("RegisterTime: "+payment.getRegisterTime());
       pvh.tvTerminalTitle.setText("Terminal Name: "+payment.getTerminalTitle());
       pvh.tvServiceTitle.setText("ServiceId Name: "+payment.getServiceTitle());
       pvh.tvAccount.setText("Account: "+payment.getAccount());
       pvh.tvPaidAmount.setText("PaidAmount: "+payment.getPaidAmount());
       pvh.tvUserAmount.setText("UserAmount: "+payment.getUserAmount());
        Global.setTerminalId(payment.getTerminalId());
        return convertView;


    }

    class PaymentViewHolder {
        @BindView(R.id.id) TextView tvId;
        @BindView(R.id.state) TextView tvState;
        @BindView(R.id.registerTime) TextView tvRegisterTime;
        @BindView(R.id.terminalTitle) TextView tvTerminalTitle;
        @BindView(R.id.serviceTitle) TextView tvServiceTitle;
        @BindView(R.id.account) TextView tvAccount;
        @BindView(R.id.paidAmount) TextView tvPaidAmount;
        @BindView(R.id.userAmount) TextView tvUserAmount;
        public PaymentViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}



