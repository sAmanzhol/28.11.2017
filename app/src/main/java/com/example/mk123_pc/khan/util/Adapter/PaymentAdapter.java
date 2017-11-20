package com.example.mk123_pc.khan.util.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Payment;

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
       pvh.tvStateDetails.setText("StateDetails: "+payment.getStateDetails());
       pvh.tvRegisterTime.setText("RegisterTime: "+payment.getRegisterTime());
       pvh.tvSubmitTime.setText("SubmitTime: "+payment.getSubmitTime());
       pvh.tvProcessTime.setText("ProcessTime: "+payment.getProcessTime());
       pvh.tvLastEventStatus.setText("LastEventStatus: "+payment.getLastEventStatus());
       pvh.tvReceiptTime.setText("ReceiptTime: "+payment.getReceiptTime());
       pvh.tvTerminalId.setText("TerminalId: "+payment.getTerminalId());
       pvh.tvProviderSubmitInfo.setText("ProviderSubmitInfo: "+payment.getProviderSubmitInfo());
       pvh.tvReceiptNo.setText("ReceiptNo: "+payment.getReceiptNo());
       pvh.tvExtras.setText("Extras: "+payment.getExtras());
       pvh.tvServiceId.setText("ServiceId: "+payment.getServiceId());
       pvh.tvProviderId.setText("ProviderId: "+payment.getProviderId());
       pvh.tvAccount.setText("Account: "+payment.getAccount());
       pvh.tvCurrency.setText("Currency: "+payment.getCurrency());
       pvh.tvPaidAmount.setText("PaidAmount: "+payment.getPaidAmount());
       pvh.tvUserAmount.setText("UserAmount: "+payment.getUserAmount());
       pvh.tvAgentFee.setText("AgentFee: "+payment.getAgentFee());
       pvh.tvParentAgentFee.setText("ParentAgentFee: "+payment.getParentAgentFee());
       pvh.tvProcessingFee.setText("ProcessingFee: "+payment.getProcessingFee());
       pvh.tvPaidAmountFtxId.setText("PaidAmountFtxTd: "+payment.getPaidAmountFtxId());
       pvh.tvMainFtxId.setText("MainFtxId: "+payment.getMainFtxId());
       pvh.tvSysFeeFtxId.setText("SysFeeFtxId: "+payment.getSysFeeFtxId());
       pvh.tvAgentFeeFtxId.setText("AgentFeeFtxId: "+payment.getAgentFee());
       pvh.tvParentAgentFeeFtxId.setText("ParentAgentFeeFtxId: "+payment.getParentAgentFeeFtxId());
        return convertView;
    }

    class PaymentViewHolder {

        @BindView(R.id.id) TextView tvId;
        @BindView(R.id.state) TextView tvState;
        @BindView(R.id.stateDetails) TextView tvStateDetails;
        @BindView(R.id.registerTime) TextView tvRegisterTime;
        @BindView(R.id.submitTime) TextView tvSubmitTime;
        @BindView(R.id.processTime) TextView tvProcessTime;
        @BindView(R.id.lastEventStatus) TextView tvLastEventStatus;
        @BindView(R.id.receiptTime) TextView tvReceiptTime;
        @BindView(R.id.terminalId) TextView tvTerminalId;
        @BindView(R.id.providerSubmitInfo) TextView tvProviderSubmitInfo;
        @BindView(R.id.receiptNo) TextView tvReceiptNo;
        @BindView(R.id.extras) TextView tvExtras;
        @BindView(R.id.serviceId) TextView tvServiceId;

        @BindView(R.id.providerId) TextView tvProviderId;
        @BindView(R.id.account) TextView tvAccount;
        @BindView(R.id.currency) TextView tvCurrency;
        @BindView(R.id.paidAmount) TextView tvPaidAmount;
        @BindView(R.id.userAmount) TextView tvUserAmount;
        @BindView(R.id.agentFee) TextView tvAgentFee;
        @BindView(R.id.parentAgentFee) TextView tvParentAgentFee;
        @BindView(R.id.processingFee) TextView tvProcessingFee;
        @BindView(R.id.paidAmountFtxId) TextView tvPaidAmountFtxId;
        @BindView(R.id.mainFtxId) TextView tvMainFtxId;
        @BindView(R.id.sysFeeFtxId) TextView tvSysFeeFtxId;
        @BindView(R.id.agentFeeFtxId) TextView tvAgentFeeFtxId;
        @BindView(R.id.parentAgentFeeFtxId) TextView tvParentAgentFeeFtxId;



        public PaymentViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}



