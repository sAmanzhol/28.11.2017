package com.example.mk123_pc.khan;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mk123_pc.khan.dto.PayloadDTO;
import com.example.mk123_pc.khan.dto.TokenDTO;
import com.example.mk123_pc.khan.model.User;
import com.example.mk123_pc.khan.util.Global;
import com.example.mk123_pc.khan.util.RequestManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.textInputEditTextTelNum) TextInputEditText etNum;
    @BindView(R.id.textInputEditTextPassword)TextInputEditText etPassword;
    @BindView(R.id.appCompatButtonLogin) AppCompatButton btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




//        User user = User.getInstance();
//        if (user == null) {
//
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etNum.getText().toString();
                String password = etPassword.getText().toString();
//                String userDetails=preferences.getString(num+password,"Telephone number or password is incorrect!");
                sendRequest(number, password);

            }
        });


        etNum.setText("77089888731");
        etPassword.setText("123456789");
//        btnLogin.performClick();
    }

    private void sendRequest(String phoneNumber, String password) {
        RequestManager requestManager = new RequestManager(this);
        mProgressBar.setVisibility(View.VISIBLE);
        requestManager.setOnStatusListener(new RequestManager.OnStatusListener() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "data: " + data);

                // json parsing
                Gson gson = new GsonBuilder().create();
                TokenDTO tokenDTO = gson.fromJson(data, TokenDTO.class);

                // get payload
                String accessToken = tokenDTO.getAccessToken();
                String[] split = accessToken.split("\\.");
                String payload = split[1];

                // decode payload
                String payloadJson = new String(Base64.decode(payload, Base64.DEFAULT));

                // parse payload json
                PayloadDTO payloadDTO = gson.fromJson(payloadJson, PayloadDTO.class);
                int userId = payloadDTO.getSub();
                int personId = payloadDTO.getPersonId();
                Global.setTerminalsId(payloadDTO.getPersonId());
                Global.ACCESS_TOKEN=tokenDTO.getAccessToken();
                Global.REFRESH_TOKEN=tokenDTO.getRefreshToken();
                /*
                tokenDTO.getAccessToken()
                tokenDTO.getRefreshToken()
                tokenDTO.getDeviceId();
                userId
                personId
                 */

                User.login(MainActivity.this,data);
                mProgressBar.setVisibility(View.GONE);
                Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }

            @Override
            public void onFailure(int errorCode, String error) {
                Log.e(TAG, "onFailure: " + error);
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Telephone number or password is incorrect",Toast.LENGTH_SHORT).show();
            }
        });
        requestManager.post(Global.URL_AUTHENTICATION, getCredentialJson(phoneNumber, password));
    }

    private JSONObject getCredentialJson(String phone, String password) {
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("phone", phone);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
