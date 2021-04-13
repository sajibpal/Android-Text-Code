package com.example.sajibpal.volleysessionlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
public class VolleyRegister extends AppCompatActivity {

    Button reg_bn;
    EditText Name,Password, emailtxt;
    String name, password, emailaddress;
    AlertDialog.Builder builder;
    String reg_url = "http://192.168.0.105/phpbasic/VollyLoginRegister.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_register);

        reg_bn = (Button)findViewById(R.id.bn_reg);
        Name = (EditText)findViewById(R.id.reg_name);
        Password = (EditText)findViewById(R.id.reg_password);
        emailtxt = (EditText)findViewById(R.id.email);
        builder = new AlertDialog.Builder(VolleyRegister.this);

        reg_bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Fetch the values.
                name = Name.getText().toString();
                password = Password.getText().toString();
                emailaddress = emailtxt.getText().toString();
                if (name.equals("")||password.equals("")||emailaddress.equals("")){
                    builder.setTitle("Error");
                    builder.setMessage("Please fill up all the fields.");
                    displayAlert("input_error");
                }
                else{

                    //Register user
                        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                                reg_url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Handle response.
                                try {
                                    JSONArray jsonArray = new JSONArray(response);
                                    JSONObject jsonObject = jsonArray.getJSONObject(0); //0=Index
                                    //Fetch data from server
                                    String code = jsonObject.getString("code");
                                    String message = jsonObject.getString("message");
                                    builder.setTitle("Server response");
                                    builder.setMessage(message);
                                    displayAlert(code); //Method we defined.
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            //Override a method called get params to pass data.

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> params = new HashMap<String, String>();
                                //The keys must match the keys on $_POST on SSS.
                                params.put("uname",name);
                                params.put("email",emailaddress);
                                params.put("password", password);
                                return params; //Return the MAP.
                            }
                        };
                        //Add this string request to request queue.
                        MySingleton.getInstance(VolleyRegister.this).addToRequestque(stringRequest);

                }
            }
        });
    }
    public void displayAlert(final String code){
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (code.equals("register sucessfull")){
                    finish(); //Finish activity
                }
                if(code.equals("Login fails")){
                    //Reset all input.
                    Name.setText("");
                    emailtxt.setText("");
                    Password.setText("");

                }
            }
        });
        //Display the alert dialog.
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
