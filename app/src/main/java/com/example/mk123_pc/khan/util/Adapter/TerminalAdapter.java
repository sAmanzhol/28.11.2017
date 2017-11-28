package com.example.mk123_pc.khan.util.Adapter;

import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Terminal;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TerminalAdapter extends ArrayAdapter<Terminal> {
    private static final String TAG = TerminalAdapter.class.getSimpleName();



    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public TerminalAdapter(Context context, int resource, List<Terminal> items) {
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
            tvh.tvState.setText("State: " + terminal.getState());
            tvh.tvName.setText("Name: " + terminal.getName());
            tvh.tvAddress.setText("Address: " + terminal.getAddress());

        return convertView;
    }

    class TerminalViewHolder {

        @BindView(R.id.id) TextView tvId;
        @BindView(R.id.state) TextView tvState;
        @BindView(R.id.name) TextView tvName;
        @BindView(R.id.address) TextView tvAddress;

        public TerminalViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}


