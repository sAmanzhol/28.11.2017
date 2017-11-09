package com.example.mk123_pc.khan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MenuActivity extends Activity {
    @BindView(R.id.btnTerminal) Button btnTerminal;
    @BindView (R.id.btnPayments) Button btnPayments;
    @BindView (R.id.btnEncashment)Button btnEncashment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ButterKnife.bind(this);

        btnTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),TerminalActivity.class);
                startActivity(intent);
            }
        });
        btnPayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), PaymentFormActivity.class);
                startActivity(intent);
            }
        });
        btnEncashment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), PaymentFormActivity.class);
                startActivity(intent);
            }
        });


    }
}
