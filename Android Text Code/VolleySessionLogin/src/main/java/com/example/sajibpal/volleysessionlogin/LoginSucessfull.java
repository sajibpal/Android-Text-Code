package com.example.sajibpal.volleysessionlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSucessfull extends AppCompatActivity {

    TextView nametxt,emailtxt;
    SharedPreferences prf;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sucessfull);

        nametxt= (TextView) findViewById(R.id.name);
        emailtxt= (TextView) findViewById(R.id.email);


        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        nametxt.setText("name "+prf.getString("username",null));
        emailtxt.setText("name "+prf.getString("email",null));
        intent = new Intent(LoginSucessfull.this,MainActivity.class);

        //when directed login by SharedPreferences then bundle not found tai bad jabe
       /* Bundle  bundle=getIntent().getExtras();
        nametxt.setText("welcome "+bundle.getString("name"));
        emailtxt.setText("Email "+bundle.getString("email"));*/

    }
    public void logout(View view){

        SharedPreferences.Editor editor = prf.edit();
        editor.clear();
        editor.commit();
        startActivity(intent);
    }
}
