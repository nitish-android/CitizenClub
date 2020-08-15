package com.tanzible.sampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ClubHistory extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    private LinearLayout home_layout;
    private LinearLayout registration_layout;
    private LinearLayout gallery_layout;
    private LinearLayout profile_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_history);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Club History");

        this.home_layout = (LinearLayout) this.findViewById(R.id.home_layout);
        this.registration_layout = (LinearLayout) this.findViewById(R.id.registraion_layout);
        this.gallery_layout = (LinearLayout) this.findViewById(R.id.gallery_layout);
        this.profile_layout = (LinearLayout) this.findViewById(R.id.profile_layout);


        home_layout.setOnClickListener(this);
        registration_layout.setOnClickListener(this);
        gallery_layout.setOnClickListener(this);
        profile_layout.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view2) {

        switch (view2.getId()) {
            case R.id.home_layout /*2131297833*/:

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                break;


            case R.id.registraion_layout /*2131297873*/:

                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();

                break;

            case R.id.gallery_layout /*2131297908*/:

                startActivity(new Intent(getApplicationContext(), Gallery.class));
                finish();
                break;

            case R.id.profile_layout /*2131297910*/:

                startActivity(new Intent(getApplicationContext(), Profile.class));
                finish();
                break;


        }
    }

}
