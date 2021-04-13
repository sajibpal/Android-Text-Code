package com.example.sajibpal.vollylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText eamil,password;
    Button logins;
    String url="http://192.168.0.106/phpbasic/androidlogin.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eamil = (EditText) findViewById(R.id.emailtext);
        password= (EditText) findViewById(R.id.passwordtext);
        logins= (Button) findViewById(R.id.login);

        logins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                              if(response.contains("1")){

                                  startActivity(new Intent(MainActivity.this,Login.class));

                              }
                              else{

                                  Toast.makeText(MainActivity.this, "Email and Password wrong", Toast.LENGTH_SHORT).show();
                              }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                  { //for login data send from Input field

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError { //getParams write korle methode cole asobe

                        Map<String, String> params =new HashMap<>();
                        params.put("email1",eamil.getText().toString().trim());
                        params.put("password1",password.getText().toString().trim());
                        return params;
                     }
                 };
                requestQueue.add(stringRequest);
            }
        });

    }
}
