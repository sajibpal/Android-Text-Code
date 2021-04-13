package com.example.sajibpal.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

       if(item.getItemId()==R.id.back){

           Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
       }
       if(item.getItemId()==R.id.about){

           Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
       }
       if(item.getItemId()==R.id.setting){

           Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
       }
       if(item.getItemId()==R.id.share){

           Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
       }
       return super.onOptionsItemSelected(item);
   }
}
