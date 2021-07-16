package com.example.completeauthenticationapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class OTPLoginPage extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    Button sendOTPButton, backButton;
    EditText mobileNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin_page);
        mobileNumberField = findViewById(R.id.editText50);
        countryCodePicker = findViewById(R.id.ccp);
        countryCodePicker.registerCarrierNumberEditText(mobileNumberField);
        sendOTPButton = findViewById(R.id.button7);
        backButton = findViewById(R.id.button8);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}