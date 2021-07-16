package com.example.completeauthenticationapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class NextPage extends AppCompatActivity {
    EditText OTPField;
    Button submitButton;
    FirebaseAuth firebaseAuth;
    String mobileNumber, OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
    }
}