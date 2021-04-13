package com.example.sajibpal.shareoption;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.w3c.dom.Text;

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

        if(item.getItemId()==R.id.share){

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plane");

            String subject="Text Message";
            String body="Hi this my first app \n Test is now ok ";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(intent.createChooser(intent,"Share with"));
        }

        return super.onOptionsItemSelected(item);
    }
}
