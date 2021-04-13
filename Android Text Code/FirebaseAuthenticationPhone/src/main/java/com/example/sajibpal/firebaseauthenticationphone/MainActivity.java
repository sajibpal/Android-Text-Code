package com.example.sajibpal.firebaseauthenticationphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText1;
    Button btn,btn1;
    private FirebaseAuth mAuth;
    String codesend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        editText= (EditText) findViewById(R.id.text);
        editText1= (EditText) findViewById(R.id.text1);
        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Getvarification();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Signincode();
            }
        });
    }

    public  void  Getvarification(){

        String phone=editText.getText().toString().trim();

        if(phone.isEmpty()){

            editText.setError("Enter phone number");
            editText.requestFocus();
            return;
        }
        if(phone.length()<11){

            editText.setError("Please Enter valid phone number");
            editText.requestFocus();
            return;
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codesend=s;
        }
    };

    public void Signincode(){

        String smscode=editText1.getText().toString().trim();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential( codesend, smscode);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                            startActivity(intent);
                        }else {
                            // Sign in failed, display a message and update the UI

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {

                                Toast.makeText(MainActivity.this, "Verifications code Incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
    }
}
