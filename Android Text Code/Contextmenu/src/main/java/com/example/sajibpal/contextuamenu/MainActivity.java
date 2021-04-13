package com.example.sajibpal.contextuamenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt;

   private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= (TextView)findViewById(R.id.tex);
        txt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode!=null){

                   return false;
                }
                actionMode=startSupportActionMode(callback);
                return true;
            }
        });
    }
   private ActionMode.Callback callback= new ActionMode.Callback() {
       @Override
       public boolean onCreateActionMode(ActionMode mode, Menu menu) {
           mode.getMenuInflater().inflate(R.menu.item_layout,menu);
           mode.setTitle("chose your option");
           return true;
       }

       @Override
       public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
           return false;
       }

       @Override
       public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
           switch (item.getItemId()){
               case R.id.share:
                   Toast.makeText(MainActivity.this, "share selected", Toast.LENGTH_SHORT).show();
                   mode.finish();
                   return  true;
               case R.id.ball:
                   Toast.makeText(MainActivity.this, "ball selected", Toast.LENGTH_SHORT).show();
                   mode.finish();
                   return  true;
               default:
                   return false;
           }

       }

       @Override
       public void onDestroyActionMode(ActionMode mode) {
           actionMode=null;
       }
   };
}
