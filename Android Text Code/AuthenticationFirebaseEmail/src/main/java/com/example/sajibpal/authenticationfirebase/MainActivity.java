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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    EditText  mail,pass;
    Button btn;
    ProgressBar progress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Login Activity");

        mail= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.password);
        btn= (Button) findViewById(R.id.login);
        txt= (TextView) findViewById(R.id.signup);
        progress= (ProgressBar) findViewById(R.id.progres);

        mAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(this);
        txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){

           case R.id.login:
                loginuser();
               break;

           case R.id.signup:
               Intent intent=new Intent(getApplicationContext(),SignUp.class);
               startActivity(intent);
               break;
       }
    }

    private void loginuser() {

        String eamil=mail.getText().toString().trim();
        String password=pass.getText().toString().trim();

        if(eamil.isEmpty()){

            mail.setError("Enter a email address");
            mail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(eamil).matches()){

            mail.setError("Enter valid emaill");
            mail.requestFocus();
            return;
        }
        if(password.isEmpty()){

            pass.setError("Enter password ");
            pass.requestFocus();
            return;
        }
        if(password.length()<6){

            pass.setError("Mimimun five Lenght required password ");
            pass.requestFocus();
            return;
        }

       progress.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(eamil, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progress.setVisibility(View.GONE);

                        if (task.isSuccessful()) {
                            finish();
                            Intent intent=new Intent(MainActivity.this,Home.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Login unsuccessfully", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}
