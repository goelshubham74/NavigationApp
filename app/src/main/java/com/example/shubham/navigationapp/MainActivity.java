package com.example.shubham.navigationapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
 NavigationView navigationview;
   FragmentTransaction fm;
    Button login,registeration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitialize();
        sideview();
        buttonclick();
    }

    public void onInitialize()
    {
        mdrawerlayout=(DrawerLayout)findViewById(R.id.drawer);
        navigationview=(NavigationView)findViewById(R.id.navigation);
        login=(Button)findViewById(R.id.login);
        registeration=(Button)findViewById(R.id.registeration);
    }
    public void sideview()
    {
        mtoggle=new ActionBarDrawerToggle(this,mdrawerlayout,R.string.open,R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.login:
                        fm=getSupportFragmentManager().beginTransaction();
                        fm.replace(R.id.fl,new LoginFragment(),"A");
                        fm.addToBackStack(null);
                        fm.commit();
                        mdrawerlayout.closeDrawers();
                        break;
                    case R.id.registeration:
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        ft.replace(R.id.fl,new RegisteratioinFragment());
                        ft.commit();
                        ft.addToBackStack(null);
                        mdrawerlayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }
    public void buttonclick()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm=getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fl,new LoginFragment(),"A");
                fm.addToBackStack(null);
                fm.commit();

            }
        });
        registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm=getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fl,new RegisteratioinFragment(),"A");
                fm.addToBackStack(null);
                fm.commit();
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
