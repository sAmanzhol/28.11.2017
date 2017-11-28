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
import com.example.mk123_pc.khan.model.Service;
import com.example.mk123_pc.khan.model.Terminal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerServiceAdapter  extends ArrayAdapter<Service> {
    private static final String TAG = TerminalAdapter.class.getSimpleName();



    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public SpinnerServiceAdapter(Context context, int resource, List<Service> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SpinnerServiceAdapter.SpinnerServiceViewHolder ssvh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            ssvh = new SpinnerServiceAdapter.SpinnerServiceViewHolder(convertView);
            convertView.setTag(ssvh);
        } else {
            ssvh = (SpinnerServiceAdapter.SpinnerServiceViewHolder) convertView.getTag();
        }

        // Assign the appropriate data from our alert object above

       Service service = getItem(position);

        ssvh.tvName.setText(service.getFullName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    class SpinnerServiceViewHolder {

        @BindView(R.id.nameS) TextView tvName;

        public SpinnerServiceViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}



