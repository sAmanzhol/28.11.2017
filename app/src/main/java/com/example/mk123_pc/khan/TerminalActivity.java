package com.example.mk123_pc.khan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerminalActivity extends Activity {

    @BindView (R.id.btnOkTerminal) Button btnOkTerminal;
    @BindView (R.id.btnBadTerminal)Button btnBadTerminal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminal_layout);
        ButterKnife.bind(this);

        btnOkTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),OkTerminalActivity.class);
                startActivity(intent);
            }
        });
        btnBadTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), BadTerminalActivity.class);
                startActivity(intent);
            }
        });



    }
}