package com.example.sajibpal.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.button);
    }
    public void menu(View v) {

        PopupMenu popmenu= new PopupMenu(this,v);
        popmenu.inflate(R.menu.menu_item);
        popmenu.show();
        popmenu.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){

            case R.id.share:
                Toast.makeText(this,"Share Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.delete:
                Toast.makeText(this,"Delete Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return false;
        }
    }
}
