package com.example.sajibpal.sharesettingstore;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear= (LinearLayout) findViewById(R.id.layout);

        if(loadcolor()!=getResources().getColor(R.color.colorPrimary)){

            linear.setBackgroundColor(loadcolor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.red){

         linear.setBackgroundColor(getResources().getColor(R.color.redcolor));
         storecolor(getResources().getColor(R.color.redcolor));
        }
        if(item.getItemId()==R.id.dark){

            linear.setBackgroundColor(getResources().getColor(R.color.darkcolor));
            storecolor(getResources().getColor(R.color.darkcolor));
        }
        if(item.getItemId()==R.id.blue){

            linear.setBackgroundColor(getResources().getColor(R.color.bluecolor));
            storecolor(getResources().getColor(R.color.bluecolor));
        }
        return super.onOptionsItemSelected(item);
    }
  public void storecolor(int color){

      SharedPreferences share=getSharedPreferences("color", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor=share.edit();
      editor.putInt("change",color);
      editor.commit();
   }
   public  int loadcolor(){

       SharedPreferences share=getSharedPreferences("color", Context.MODE_PRIVATE);
       int color=share.getInt("change",getResources().getColor(R.color.colorPrimary));
       return color;
   }
}
