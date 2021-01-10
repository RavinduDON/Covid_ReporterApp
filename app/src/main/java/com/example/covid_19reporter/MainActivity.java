package com.example.covid_19reporter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        frameLayout=findViewById(R.id.fragment_container);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        navigationView=findViewById(R.id.nav_view);
        //View view=navigationView.inflateHeaderView(R.layout.nav_header);
        navigationView.setNavigationItemSelectedListener((menuItem)-> {
            onNavigationItemSelected(menuItem);
            return false;
        });
//        if(savedInstanceState==null){
//            setContentView(R.layout.home);
//            navigationView.setCheckedItem(R.id.nav_home);
//        }


    }

    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_local:
                //setContentView(R.layout.local_cases_hospitals);
                startActivity(new Intent(MainActivity.this,LocalCases_hospitalsFragment.class));
                break;
            case R.id.nav_global:
                //setContentView(R.layout.global_cases);
                startActivity(new Intent(MainActivity.this,GlobalCasesFragment.class));
                break;
            case R.id.nav_localCases:
                //setContentView(R.layout.home);
                startActivity(new Intent(MainActivity.this,LocalCasesFragment.class));
                break;
            case R.id.nav_home:
                //setContentView(R.layout.local_cases);
                startActivity(new Intent(MainActivity.this,LocalCasesFragment.class));
                break;
            case R.id.nav_emg:
                //setContentView(R.layout.emergency);
                startActivity(new Intent(MainActivity.this,EmergencyFragment.class));
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
