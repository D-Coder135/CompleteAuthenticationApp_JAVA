package com.example.completeauthenticationapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class NextPage extends AppCompatActivity {
    EditText OTPField;
    Button submitButton;
    FirebaseAuth firebaseAuth;
    String mobileNumber, OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
        mobileNumber = getIntent().getStringExtra("mobileNumber");
        OTPField = findViewById(R.id.editText51);
        submitButton = findViewById(R.id.button9);
        firebaseAuth = FirebaseAuth.getInstance();

        generateOTP();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OTPField.getText().toString().isEmpty()) {
                    Toast.makeText(NextPage.this, "ENTER THE OTP!", Toast.LENGTH_SHORT).show();
                } else {
                    if (OTPField.getText().toString().length() != 6) {
                        Toast.makeText(NextPage.this, "INVALID OTP!", Toast.LENGTH_SHORT).show();
                    } else {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP, OTPField.getText().toString());
                    }
                }
            }
        });
    }
}