package com.example.a30daysdiet;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.a30daysdiet.Fragments.Days;
import com.example.a30daysdiet.Fragments.DietPlan;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.my_drawer_layout);
         navigationView = findViewById(R.id.navigation_view);
         frameLayout = findViewById(R.id.fragment_container);

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectDrawerItem(menuItem);
            return true;
        });

        Days days = new Days();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, days).commit();

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.nav_open,
                R.string.nav_close
        );

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void selectDrawerItem(MenuItem menuItem) {
        // Load the appropriate fragment into the frame layout based on the menu item selected
        switch (menuItem.getItemId()) {
            case R.id.nav_diet_plan: {
                DietPlan dietPlan = new DietPlan();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dietPlan).commit();
                getSupportActionBar().setTitle("Diet Plan");
                break;
            }

        }

        // Highlight the selected item in the navigation menu and close the drawer
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}