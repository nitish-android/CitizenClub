package com.tanzible.sampleproject;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Handler;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public String CURRENT_TAG;
    private Toolbar toolbar;
    public int navItemIndex = 0;
    String ProductType;
    SharedPreferences pref;

    ConnectivityManager c;

    public final String KEY_NAME;
    private final String PREF_NAME;
    private final String TAG_HOME;

    private Handler mHandler;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    public MainActivity() {
        String str = "home";
        this.TAG_HOME = str;
        this.CURRENT_TAG = str;

        this.KEY_NAME = "name";
        this.PREF_NAME = "AndroidHivePref";

        this.ProductType = "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                    new HomeFragment()).commit();
            // navigationView.setCheckedItem(R.id.);

        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();




        switch (id) {
            case R.id.home:
                MainActivity homeActivity = MainActivity.this;

                break;

            case R.id.club_history:

                Intent intent2 = new Intent(MainActivity.this, ClubHistory.class);
                // intent2.putExtra(str3, "Flight Search");
                //intent2.putExtra(str4, MainActivity.this.ProductType);
                startActivity(intent2);
                break;


            case R.id.member_list:
                //  MainActivity.this.closeDrawer();
                //  MainActivity homeActivity5 = MainActivity.this;
                //  homeActivity5.ProductType = "Cab";
                Intent intent5 = new Intent(MainActivity.this, MemberList.class);
                // intent5.putExtra(str3, "Cab Search");
                // intent5.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent5);

                break;
            case R.id.event_list:
                //  MainActivity.this.closeDrawer();
                //  MainActivity homeActivity5 = MainActivity.this;
                //  homeActivity5.ProductType = "Cab";
                Intent intent6 = new Intent(MainActivity.this, EventListActivity.class);
                // intent5.putExtra(str3, "Cab Search");
                // intent5.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent6);

                break;
            case R.id.your_locality:
                //  MainActivity.this.closeDrawer();
                //  MainActivity homeActivity5 = MainActivity.this;
                //  homeActivity5.ProductType = "Cab";
                Intent intent7 = new Intent(MainActivity.this, YourLocationActivity.class);
                // intent5.putExtra(str3, "Cab Search");
                // intent5.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent7);

                break;
            case R.id.donation_list:
                //  MainActivity.this.closeDrawer();
                //   MainActivity homeActivity6 = MainActivity.this;
                //   homeActivity6.ProductType = "Holiday";
                Intent intent8 = new Intent(MainActivity.this, DonationList.class);
                //intent6.putExtra(str3, "Holiday Search");
                // intent6.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent8);

                break;

            case R.id.feedback:
                // MainActivity.this.closeDrawer();
                //  MainActivity homeActivity4 = MainActivity.this;
                //   homeActivity4.ProductType = "bus";
                Intent intent4 = new Intent(MainActivity.this, Feedback.class);
                // intent4.putExtra(str3, "Bus Search");
                // intent4.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent4);

                break;

            case R.id.privacy_policy:
                //  MainActivity.this.closeDrawer();
                //   MainActivity homeActivity3 = MainActivity.this;
                //   homeActivity3.ProductType = "hotels";
                Intent intent3 = new Intent(MainActivity.this, Privacypolicy.class);
                //intent3.putExtra(str3, "Hotels Search");
                //  intent3.putExtra(str4, MainActivity.this.ProductType);
                MainActivity.this.startActivity(intent3);
                break;




        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



}





