package com.example.mk123_pc.khan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mk123_pc.khan.model.User;
import com.example.mk123_pc.khan.util.SharedPrefs;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    final TextInputEditText etNum=(TextInputEditText)findViewById(R.id.textInputEditTextTelNum);
    final TextInputEditText etPassword=(TextInputEditText)findViewById(R.id.textInputEditTextPassword);
    final AppCompatButton btnLogin=(AppCompatButton)findViewById(R.id.appCompatButtonLogin);



//        User user = User.getInstance();
//        if (user == null) {
//
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=etNum.getText().toString();
                String password=etPassword.getText().toString();
//                String userDetails=preferences.getString(num+password,"Telephone number or password is incorrect!");
                SharedPrefs.saveUserInfo(MainActivity.this,"8705","123");
                if(SharedPrefs.checkUserCredentials(MainActivity.this, num, password)==true){
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);

                startActivity(intent);
            }

            }
        });


    }

}
