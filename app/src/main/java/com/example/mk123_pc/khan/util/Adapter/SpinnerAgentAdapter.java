package com.example.mk123_pc.khan.util.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Agent;
import com.example.mk123_pc.khan.model.Service;
import com.example.mk123_pc.khan.model.Terminal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerAgentAdapter  extends ArrayAdapter<Agent> {
    private static final String TAG = TerminalAdapter.class.getSimpleName();



    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public SpinnerAgentAdapter(Context context, int resource, List<Agent> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SpinnerAgentAdapter.SpinnerAgentViewHolder savh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            savh = new SpinnerAgentAdapter.SpinnerAgentViewHolder(convertView);
            convertView.setTag(savh);
        } else {
            savh = (SpinnerAgentAdapter.SpinnerAgentViewHolder) convertView.getTag();
        }

        // Assign the appropriate data from our alert object above

        Agent agent= getItem(position);

        savh.tvName.setText(agent.getName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    class SpinnerAgentViewHolder {

        @BindView(R.id.nameS) TextView tvName;

        public SpinnerAgentViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}



