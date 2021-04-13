package com.example.sajibpal.authenticationfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    TextView txt1;
    EditText  mail1,pass1;
    Button btn1;
    ProgressBar progress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sing up Activity");

        mAuth = FirebaseAuth.getInstance();

        mail1= (EditText) findViewById(R.id.email1);
        pass1= (EditText) findViewById(R.id.password1);
        btn1= (Button) findViewById(R.id.logout);
        txt1= (TextView) findViewById(R.id.signup1);
        progress= (ProgressBar) findViewById(R.id.progresid);

        btn1.setOnClickListener(this);
        txt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.logout:
                register();
                break;

            case R.id.signup1:
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void register() {

        String eamil=mail1.getText().toString().trim();
        String password=pass1.getText().toString().trim();

        if(eamil.isEmpty()){

            mail1.setError("Enter a email address");
            mail1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(eamil).matches()){

            mail1.setError("Enter valid emaill");
            mail1.requestFocus();
            return;
        }
        if(password.isEmpty()){

            pass1.setError("Enter password ");
            pass1.requestFocus();
            return;
        }
        if(password.length()<6){

            pass1.setError("Mimimun five Lenght required password ");
            pass1.requestFocus();
            return;
        }
        progress.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(eamil, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progress.setVisibility(View.GONE);

                        if (task.isSuccessful()) {

                            finish();
                            Intent intent=new Intent(SignUp.this,MainActivity.class);
                            startActivity(intent);

                          //  Toast.makeText(SignUp.this, "Successfull", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {

                                Toast.makeText(SignUp.this, "User is already Registered", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(SignUp.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}
