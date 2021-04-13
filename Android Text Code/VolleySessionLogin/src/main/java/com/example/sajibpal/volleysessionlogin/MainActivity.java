package com.example.sajibpal.volleysessionlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editname,editpassword;
    String name,password;
    Button login;
    AlertDialog.Builder builder;
    String url="http://192.168.0.105/phpbasic/VollySignin.php";
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder=new AlertDialog.Builder(MainActivity.this);
        editname= (EditText) findViewById(R.id.name);
        editpassword= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        if (pref.contains("username") && pref.contains("email")) {
           Intent  intent = new Intent(MainActivity.this,LoginSucessfull.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //for Login method

                name=editname.getText().toString();
                password=editpassword.getText().toString();

                if(name.equals("")&& password.equals("")){
                    builder.setTitle("Something is Error");
                    StringAlert("Username and password not fill");
                }
                else{

                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {
                                        JSONArray jsonArray=new JSONArray(response);
                                        JSONObject jsonObject=jsonArray.getJSONObject(0);
                                        String code=jsonObject.getString("code");

                                        if(code.equals("Login Failed")){

                                            builder.setTitle("Login Error");
                                            StringAlert(jsonObject.getString("message"));
                                        }
                                        else{ //Login successfully and page email and name send for show

                                            Intent  intent = new Intent(MainActivity.this,LoginSucessfull.class);
                                             SharedPreferences.Editor editor = pref.edit();
                                             editor.putString("username",jsonObject.getString("name"));
                                             editor.putString("email",jsonObject.getString("email"));
                                             editor.commit();

                                            //when SharedPreferences not used then used bundle

                                             /* Bundle bundle=new Bundle();
                                              bundle.putString("name",jsonObject.getString("name"));
                                              bundle.putString("email",jsonObject.getString("email"));
                                              intent.putExtras(bundle);*/

                                              startActivity(intent);
                                        }

                                    } catch (JSONException e) {
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String> param=new HashMap<String, String>();
                            param.put("uname",name);
                            param.put("password",password);
                            return param;
                        }
                    };
                    MySingleton.getInstance(MainActivity.this).addToRequestque(stringRequest);

                }
            }
        });
    }

    public void Register(View v){

        startActivity(new Intent(MainActivity.this,VolleyRegister.class));
    }

    public  void StringAlert(String message){

        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                editname.setText("");
                editpassword.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
