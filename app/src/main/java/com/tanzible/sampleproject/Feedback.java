package com.tanzible.sampleproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Feedback extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    private LinearLayout home_layout;
    private LinearLayout registration_layout;
    private LinearLayout gallery_layout;
    private LinearLayout profile_layout;
    EditText etName,etMobile,etFeedback;
    Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Feedback");


        this.home_layout = (LinearLayout) this.findViewById(R.id.home_layout);
        this.registration_layout = (LinearLayout) this.findViewById(R.id.registraion_layout);
        this.gallery_layout = (LinearLayout) this.findViewById(R.id.gallery_layout);
        this.profile_layout = (LinearLayout) this.findViewById(R.id.profile_layout);

        etName = (EditText) this.findViewById(R.id.edtName);
        etMobile = (EditText) this.findViewById(R.id.edtMobile);
        etFeedback = (EditText) this.findViewById(R.id.edtfeedback);
        btnSubmit = (Button) this.findViewById(R.id.btn_submit);

        home_layout.setOnClickListener(this);
        registration_layout.setOnClickListener(this);
        gallery_layout.setOnClickListener(this);
        profile_layout.setOnClickListener(this);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().equals( ""))
                etName.setError("Name is Mandatory");

                else if (etMobile.getText().toString().equals( ""))
                etName.setError("Mobile Number is Mandatory");

               else if (etFeedback.getText().toString().equals( ""))
                etName.setError("Message is Mandatory");

               else
                {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"nitishkr979803@gmail.com"});
                    intent.putExtra(Intent.EXTRA_TEXT, " Nitish,\n"
                    +etMobile.getText().toString() +"\n"
                    + etFeedback.getText().toString());


                    try {
                        startActivity(Intent.createChooser(intent,"Send Feedback"));
                    } catch (android.content.ActivityNotFoundException ex){
                        Toast.makeText(getApplicationContext(), "no mail app found", Toast.LENGTH_SHORT).show();
                    }
                    catch(Exception ex )
                    {
                        Toast.makeText(getApplicationContext(),"unexpected error" + ex.toString(), Toast.LENGTH_SHORT).show();
                    }
                }





            }
        });
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
