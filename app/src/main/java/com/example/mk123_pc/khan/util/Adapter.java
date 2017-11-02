package com.example.mk123_pc.khan.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Terminal;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter extends ArrayAdapter<Terminal> {
    private static final String TAG = Adapter.class.getSimpleName();



    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public Adapter(Context context, int resource, List<Terminal> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TerminalViewHolder tvh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            tvh = new TerminalViewHolder(convertView);
            convertView.setTag(tvh);
        } else {
            tvh = (TerminalViewHolder) convertView.getTag();
        }

        // Assign the appropriate data from our alert object above

        Terminal terminal = getItem(position);

        tvh.tvId.setText("Id: "+terminal.getId());
        tvh.tvState.setText("State: "+terminal.getState());
        tvh.tvAgentId.setText("AgentId: "+terminal.getAgentId());
        tvh.tvFeeProfileId.setText("FeeProfileId: "+terminal.getFeeProfileId());
        tvh.tvCreateTime.setText("CreateTime: "+terminal.getCreateTime());
        tvh.tvName.setText("Name: "+terminal.getName());
        tvh.tvAddress.setText("Address: "+terminal.getAddress());
        tvh.tvAddInfo.setText("AddInfo: "+terminal.getAddInfo());
        tvh.tvOperationMode.setText("OperationMode: "+terminal.getOperationMode());
        tvh.tvNds.setText("Nds: "+terminal.getNds());
        tvh.tvRnm.setText("Rnm: "+terminal.getRnm());
        tvh.tvSimNumber.setText("SimNumber: "+terminal.getSimNumber());
        tvh.tvMaxBillsCount.setText("MaxBillsCount: "+terminal.getMaxBillsCount());
        tvh.tvRegionId.setText("RegionId: "+terminal.getRegionId());
        tvh.tvLocationId.setText("LocationId: "+terminal.getLocationId());
        tvh.tvTaxCommitteeId.setText("TaxCommitteeId: "+terminal.getTaxCommitteeId());
        tvh.tvComments.setText("Comments: "+terminal.getComments());
        tvh.tvLastPing.setText("LastPing: "+terminal.getLastPing());
        tvh.tvLastIp.setText("LastIp: "+terminal.getLastIp());
        tvh.tvCustomNetwork.setText("CustomNetwork: "+terminal.getCustomNetwork());
        tvh.tvCliVersion.setText("CliVersion: "+terminal.getCliVersion());
        tvh.tvCliVersionLastUpdate.setText("CliVersionLastUpdate: "+terminal.getCliVersionLastUpdate());
        tvh.tvSslCert.setText("SslCert: "+terminal.getSslCert());
        tvh.tvSslPrivKey.setText("SslPrivKey: "+terminal.getSslPrivKey());
        tvh.tvMaxAmountPerDay.setText("MaxAmountPerDay: "+terminal.getMaxAmountPerDay());
        tvh.tvAmountToday.setText("AmountToday: "+terminal.getAmountToday());
        tvh.tvAmountTodayRefreshedTime.setText("AmountTodayRefreshedTime: "+terminal.getAmountTodayRefreshedTime());
        return convertView;
    }

    class TerminalViewHolder {

        @BindView(R.id.id) TextView tvId;
        @BindView(R.id.state) TextView tvState;
        @BindView(R.id.agentId) TextView tvAgentId;
        @BindView(R.id.feeProfileId) TextView tvFeeProfileId;
        @BindView(R.id.createTime) TextView tvCreateTime;
        @BindView(R.id.name) TextView tvName;
        @BindView(R.id.address) TextView tvAddress;
        @BindView(R.id.addInfo) TextView tvAddInfo;
        @BindView(R.id.operationMode) TextView tvOperationMode;
        @BindView(R.id.nds) TextView tvNds;
        @BindView(R.id.rnm) TextView tvRnm;
        @BindView(R.id.simNumber) TextView tvSimNumber;
        @BindView(R.id.maxBillsCount) TextView tvMaxBillsCount;
        @BindView(R.id.regionId) TextView tvRegionId;
        @BindView(R.id.locationId) TextView tvLocationId;
        @BindView(R.id.taxCommitteeId) TextView tvTaxCommitteeId;
        @BindView(R.id.comments) TextView tvComments;
        @BindView(R.id.lastPing) TextView tvLastPing;
        @BindView(R.id.lastIp) TextView tvLastIp;
        @BindView(R.id.customNetwork) TextView tvCustomNetwork;
        @BindView(R.id.cliVersion) TextView tvCliVersion;
        @BindView(R.id.cliVersionLastUpdate) TextView tvCliVersionLastUpdate;
        @BindView(R.id.sslCert) TextView tvSslCert;
        @BindView(R.id.sslPrivKey) TextView tvSslPrivKey;
        @BindView(R.id.maxAmountPerDay) TextView tvMaxAmountPerDay;
        @BindView(R.id.amountToday) TextView tvAmountToday;
        @BindView(R.id.amountTodayRefreshedTime) TextView tvAmountTodayRefreshedTime;

        public TerminalViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}


