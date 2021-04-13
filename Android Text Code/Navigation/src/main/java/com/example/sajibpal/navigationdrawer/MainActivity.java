package com.example.sajibpal.navigationdrawer;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawer;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar=(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        drawer=(DrawerLayout) findViewById(R.id.draw);
        NavigationView navigation=(NavigationView) findViewById(R.id.nav);
        navigation.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.open_navigation,R.string.close_navigation);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    public  void onBackPressed(){

      if(drawer.isDrawerOpen(GravityCompat.START)){

          drawer.closeDrawer(GravityCompat.START);
      }
      else{
          super.onBackPressed();
      }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.message:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new MessageFragmeni()).commit();
                break;
            case R.id.mail:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new MailFragmeni()).commit();
                break;
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new ProfileFragmeni()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
