package com.example.sajibpal.ratingpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RatingBar rting;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(TextView) findViewById(R.id.txt);
        rting=(RatingBar) findViewById(R.id.bar);
        text.setText("Rating value "+ rting.getRating());

        rting.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                text.setText("Rating value "+ rating);
            }
        });
    }
}
