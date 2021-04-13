package com.example.sajibpal.authenticationfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mauth=FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.logout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

         if(item.getItemId()==R.id.out){

             FirebaseAuth.getInstance().signOut();
             finish();
             Intent intent=new Intent(Home.this,MainActivity.class);
             startActivity(intent);
         }
        return super.onOptionsItemSelected(item);
    }
}
