package com.example.mk123_pc.khan.util;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mk123_pc.khan.R;
import com.example.mk123_pc.khan.model.Terminal;


public class Adapter extends ArrayAdapter<Terminal> {
    private static final String TAG = Adapter.class.getSimpleName();

    int resource;
    String response;
    Context context;

    //Initialize adapter
    public Adapter(Context context, int resource, List<Terminal> items) {
        super(context, resource, items);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout terminalView;
        //Get the current alert object
        Terminal terminal = getItem(position);

        //Inflate the view
        if (convertView == null) {
            terminalView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, terminalView, true);
        } else {
            terminalView = (LinearLayout) convertView;
        }

        //Get the text boxes from the listitem.xml file
        TextView id = terminalView.findViewById(R.id.id);
        TextView name =  terminalView.findViewById(R.id.name);
        TextView cursum =  terminalView.findViewById(R.id.cursum);
        TextView status =  terminalView.findViewById(R.id.status);
        TextView last_payment_day =  terminalView.findViewById(R.id.lastPaymentDay);

        // Assign the appropriate data from our alert object above
        id.setText("Id: "+String.valueOf(terminal.id));
        name.setText("Name: "+terminal.name);
        cursum.setText("CurSum: "+String.valueOf(terminal.curSum));
        status.setText("Status: "+terminal.status);
        last_payment_day.setText("Last payment day: "+terminal.lastPaymentDay);
        return terminalView;
    }
}


