package com.example.mi_drawerlayout_navigationview_toolbar;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout1;
    private NavigationView navigationView1;
    private Toolbar toolbar1; //revisar  import androidx.appcompat.widget.Toolbar;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout1 = findViewById(R.id.drawerlayout1);
        navigationView1 = findViewById(R.id.navigationview1);
        toolbar1=findViewById(R.id.toolbar1);

         ActionBarDrawerToggle actionBarDrawerToggle1 = new ActionBarDrawerToggle(this, drawerLayout1,toolbar1,0,0);
        drawerLayout1.addDrawerListener(actionBarDrawerToggle1);
        actionBarDrawerToggle1.syncState();

        getSupportFragmentManager().beginTransaction().add(R.id.frame1,new Fragmento1()).commit();

        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menufragmento1: getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragmento1()).commit();
                        break;
                    case R.id.menufragmento2: getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragmento2()).commit();
                        break;
                    case R.id.menufragmento3: getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragmento3()).commit();
                        break;
                }
                drawerLayout1.closeDrawers();
                return false;
            }
        });

    }
}