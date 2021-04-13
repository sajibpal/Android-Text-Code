package com.example.sajibpal.staratbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar bar;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar=(SeekBar) findViewById(R.id.sbar);
        txt=(TextView) findViewById(R.id.text);
        txt.setText("Volume is: "+ bar.getProgress() +"/"+ bar.getMax());

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                txt.setText("Volume is: "+progress +"/"+ bar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this, "StartTracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this, "StopTracking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
