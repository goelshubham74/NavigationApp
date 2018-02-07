package com.example.shubham.navigationapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
 NavigationView navigationview;
   FragmentTransaction fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdrawerlayout=(DrawerLayout)findViewById(R.id.drawer);
        //code for navigation
        mtoggle=new ActionBarDrawerToggle(this,mdrawerlayout,R.string.open,R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       navigationview=(NavigationView)findViewById(R.id.navigation);
        //till here
        fm=getSupportFragmentManager().beginTransaction();
        fm.add(R.id.drawer,new Mainfragment());
        fm.commit();
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.login:
                        fm=getSupportFragmentManager().beginTransaction();
                        fm.replace(R.id.drawer,new Login());
                        fm.commit();
                        mdrawerlayout.closeDrawers();
                        break;
                    case R.id.registeration:
                        fm=getSupportFragmentManager().beginTransaction();
                        fm.replace(R.id.drawer,new Registeration());
                        fm.commit();
                        mdrawerlayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
