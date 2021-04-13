package com.example.sajibpal.feedbackmenuitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }
    public  boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==R.id.feed){

         Intent intent=new Intent(MainActivity.this,Mail.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
