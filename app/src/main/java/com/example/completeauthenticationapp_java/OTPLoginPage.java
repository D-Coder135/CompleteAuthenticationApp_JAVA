package com.example.completeauthenticationapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.hbb20.CountryCodePicker;

public class OTPLoginPage extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    Button sendOTPButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin_page);
    }
}