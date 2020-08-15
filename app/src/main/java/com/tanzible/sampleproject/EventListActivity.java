package com.tanzible.sampleproject;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

public class EventListActivity extends AppCompatActivity {
    Toolbar toolbar;
    private LinearLayout home_layout;
    private LinearLayout registration_layout;
    private LinearLayout gallery_layout;
    private LinearLayout profile_layout;

    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event List");

        pdfView = (PDFView) this.findViewById(R.id.pdfReader);

        pdfView.fromAsset("eventlist.pdf").load();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    }
