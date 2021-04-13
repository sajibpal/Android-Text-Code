package com.example.sajibpal.country;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Bangladesh extends AppCompatActivity {

    ImageView iview;
    TextView  tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladesh);

        iview=(ImageView)findViewById(R.id.image);
        tview=(TextView) findViewById(R.id.text);

        Bundle bundle=getIntent().getExtras();
         if(bundle!=null){

             String country=bundle.getString("name");
             showcountry(country);
         }
    }
    public  void  showcountry(String cname){

        if(cname.equals("Bangladesh")){

            iview.setImageResource(R.drawable.index);
            tview.setText(R.string.bd);
        }
        if(cname.equals("India")){

            iview.setImageResource(R.drawable.india);
            tview.setText(R.string.india);
        }
    }
}
