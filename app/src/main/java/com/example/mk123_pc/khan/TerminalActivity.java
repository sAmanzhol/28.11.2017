package com.example.mk123_pc.khan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mk123_pc.khan.dto.PayloadDTO;
import com.example.mk123_pc.khan.dto.TokenDTO;
import com.example.mk123_pc.khan.model.Terminal;
import com.example.mk123_pc.khan.model.User;
import com.example.mk123_pc.khan.util.Adapter;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;
import com.example.mk123_pc.khan.util.SharedPrefs;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TerminalActivity extends AppCompatActivity {
    private static final String TAG = TerminalActivity.class.getSimpleName();

    private AppCompatTextView tvWelcome;
    private AppCompatTextView tvTerminals;
    private ListView lv;


    @BindView(R.id.noConnectionTextView)
    TextView mNoConnectionTextView;
    @BindView(R.id.noConnectionExpandableLayout)
    ExpandableLayout noConnectionExpandableLayout;
    @BindView(R.id.noConnectionTerminals)
    LinearLayout mNoConnectionTerminals;

    @BindView(R.id.noPaymentTextView)
    TextView mNoPaymentTextView;
    @BindView(R.id.noPaymentnExpandableLayout)
    ExpandableLayout noPaymentExpandableLayout;
    @BindView(R.id.noPaymentTerminals)
    LinearLayout mNoPaymentTerminals;

    @BindView(R.id.notWorkingTextView)
    TextView mNotWorkingTextView;
    @BindView(R.id.notWorkingExpandableLayout)
    ExpandableLayout notWorkingExpandableLayout;
    @BindView(R.id.notWorkingTerminals)
    LinearLayout mNotWorkingTerminals;

    @BindView(R.id.printerErrorTextView)
    TextView mPrinterErrorTextView;
    @BindView(R.id.printerErrorExpandableLayout)
    ExpandableLayout printerErrorExpandableLayout;
    @BindView(R.id.printerErrorTerminals)
    LinearLayout mPrinterErrorTerminals;


    @BindView(R.id.billAcceptorErrorTextView)
    TextView mBillAcceptorErrorTextView;
    @BindView(R.id.billAcceptorErrorExpandableLayout)
    ExpandableLayout billAcceptorErrorExpandableLayout;
    @BindView(R.id.billAcceptorErrorTerminals)
    LinearLayout mBillAcceptorErrorTerminals;


    @BindView(R.id.HDDErrorTextView)
    TextView mHDDErrorTextView;
    @BindView(R.id.HDDErrorExpandableLayout)
    ExpandableLayout HDDErrorExpandableLayout;
    @BindView(R.id.HDDErrorTerminals)
    LinearLayout mHDDErrorTerminals;


    @BindView(R.id.noPaperTextView)
    TextView mNoPaperTextView;
    @BindView(R.id.noPaperExpandableLayout)
    ExpandableLayout noPaperExpandableLayout;
    @BindView(R.id.noPaperTerminals)
    LinearLayout mNoPaperTerminals;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminal_layout);
        ButterKnife.bind(this);


        tvTerminals = findViewById(R.id.textViewTerminals);
        lv =  findViewById(R.id.listView);
        String savedPhone = SharedPrefs.getPhone(TerminalActivity.this);

        tvTerminals.setText("List of your terminals: ");

        sendRequest();

        //Show all terminals with no connection
        mNoConnectionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noConnectionExpandableLayout.toggle();
            }
        });
        populateNoConnectionTerminals();


        //Show all terminals with no payment
        mNoPaymentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noPaymentExpandableLayout.toggle();
            }
        });
        populateNoPaymentTerminals();



        //Show all terminals which are not working
        mNotWorkingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notWorkingExpandableLayout.toggle();
            }
        });
        populateNotWorkingTerminals();




        //Show all terminals with printer errors
        mPrinterErrorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printerErrorExpandableLayout.toggle();
            }
        });
        populatePrinterErrorTerminals();


        //Show all terminals with bill acceptor errors
        mBillAcceptorErrorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billAcceptorErrorExpandableLayout.toggle();
            }
        });
        populateBillAcceptorErrorTerminals();


        //Show all terminals with HDD error
        mHDDErrorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HDDErrorExpandableLayout.toggle();
            }
        });
        populateHDDErrorTerminals();

        //Show all terminals with no paper
        mNoPaperTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               noPaperExpandableLayout.toggle();
            }
        });
        populateNoPaperTerminals();
    }


    private void sendRequest() {
        RequestManager requestManager = new RequestManager(this);

        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);
                populateList(data);
            }

            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
            }
        });
        requestManager.get(Global.URL_TERMINALS);
    }

    List<Terminal> terminalList = new ArrayList<>();
    Adapter arrayAdapter;


// Populate Terminals
    private void populateNoConnectionTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mNoConnectionTerminals.addView(inflatedLayout);
        }
    }
    private void populateNoPaymentTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mNoPaymentTerminals.addView(inflatedLayout);
        }
    }
    private void populateNotWorkingTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mNotWorkingTerminals.addView(inflatedLayout);
        }
    }
    private void populatePrinterErrorTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mPrinterErrorTerminals.addView(inflatedLayout);
        }
    }
    private void populateBillAcceptorErrorTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mBillAcceptorErrorTerminals.addView(inflatedLayout);
        }
    }
    private void populateHDDErrorTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mHDDErrorTerminals.addView(inflatedLayout);
        }
    }
    private void populateNoPaperTerminals() {
        for (int i = 0; i < 3; i++) {
            View inflatedLayout = LayoutInflater.from(this).inflate(R.layout.item_terminal, null, false);
            TextView terminalId = inflatedLayout.findViewById(R.id.id);
            terminalId.setText(String.valueOf(i));

            final int finalI = i;
            inflatedLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TerminalActivity.this, "terminal with id: " + finalI + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            mNoPaperTerminals.addView(inflatedLayout);
        }
    }
    private void populateList(String jsonData) {
        terminalList = Terminal.getList(jsonData);

        arrayAdapter = new Adapter(TerminalActivity.this, R.layout.item_terminal, terminalList);

        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }





}
