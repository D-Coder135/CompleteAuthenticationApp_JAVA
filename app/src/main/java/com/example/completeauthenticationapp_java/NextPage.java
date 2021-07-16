package com.example.completeauthenticationapp_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

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
                        signInWithCredential(credential);
                    }
                }
            }
        });
    }
    private void generateOTP() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobileNumber,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        OTP = s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {
                        Toast.makeText(NextPage.this, "INVALID OTP!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(NextPage.this, "Database Updated!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NextPage.this, WelcomePage.class);
                }
            }
        });
    }
}