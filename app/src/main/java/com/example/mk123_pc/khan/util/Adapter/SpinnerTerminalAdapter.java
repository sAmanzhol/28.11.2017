package com.example.mk123_pc.khan.util.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Terminal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerTerminalAdapter  extends ArrayAdapter<Terminal> {
    private static final String TAG = TerminalAdapter.class.getSimpleName();



    int mResourceId;
    String response;
    Context mContext;

    //Initialize adapter
    public SpinnerTerminalAdapter(Context context, int resource, List<Terminal> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {
        SpinnerTerminalAdapter.SpinnerTerminalViewHolder stvh;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            stvh = new SpinnerTerminalAdapter.SpinnerTerminalViewHolder(convertView);
            convertView.setTag(stvh);
        } else {
            stvh = (SpinnerTerminalAdapter.SpinnerTerminalViewHolder) convertView.getTag();
        }

        // Assign the appropriate data from our alert object above

       Terminal terminal = getItem(position);
        stvh.tvName.setText( terminal.getName());
        return convertView;


    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    class SpinnerTerminalViewHolder {

        @BindView(R.id.nameS) TextView tvName;

        public SpinnerTerminalViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}



