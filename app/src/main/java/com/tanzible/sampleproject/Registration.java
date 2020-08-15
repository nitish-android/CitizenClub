package com.tanzible.sampleproject;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private LinearLayout home_layout;
    private LinearLayout registration_layout;
    private LinearLayout gallery_layout;
    private LinearLayout profile_layout;
    private Spinner spinner;
    private TextView txtRecipientlist;
    private EditText etName,etAddress,etCity,etGender,etMobile,etEmail,etPassword;
    private Button btnSubmit;
    DatabaseReference databaseReference;
    String gender = "";
    FirebaseAuth firebaseAuth;

    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registration");


        this.home_layout = (LinearLayout) this.findViewById(R.id.home_layout);
        this.registration_layout = (LinearLayout) this.findViewById(R.id.registraion_layout);
        this.gallery_layout = (LinearLayout) this.findViewById(R.id.gallery_layout);
        this.profile_layout = (LinearLayout) this.findViewById(R.id.profile_layout);
        this.spinner = (Spinner) this.findViewById(R.id.spinner);
        etName = (EditText) this.findViewById(R.id.edtName);
        etAddress = (EditText) this.findViewById(R.id.edtAddress);
        etCity = (EditText) this.findViewById(R.id.edtCity);
        etGender = (EditText) this.findViewById(R.id.edtGender);
        etMobile = (EditText) this.findViewById(R.id.edtMobile);
        btnSubmit = (Button) this.findViewById(R.id.btn_submit);
        etEmail = (EditText) this.findViewById(R.id.edtEmail);
        etPassword = (EditText) this.findViewById(R.id.edtPassword);
        txtRecipientlist = (TextView)this.findViewById(R.id.etreciprentmail);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        databaseReference = FirebaseDatabase.getInstance().getReference("Registration");
        firebaseAuth = FirebaseAuth.getInstance();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Pana, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        home_layout.setOnClickListener(this);
        registration_layout.setOnClickListener(this);
        gallery_layout.setOnClickListener(this);
        profile_layout.setOnClickListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             final String name = etName.getText().toString().trim();
                final String address = etAddress.getText().toString().trim();
              final String city = etCity.getText().toString().trim();
              final String spinnerText = spinner.getSelectedItem().toString().trim();
              final String gender = etGender.getText().toString().trim();
              final String mobile = etMobile.getText().toString().trim();
              final String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                databaseReference.push().setValue(name);
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    UserInfo information = new UserInfo(
                                            name,
                                            address,
                                            city,
                                            spinnerText,
                                            gender,
                                            mobile,
                                            email,
                                            gender

                                    );


                                    FirebaseDatabase.getInstance().getReference("Registration").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(Registration.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                            finish();

                                        }
                                    });

                                } else {

                                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                        Toast.makeText(Registration.this, "You are already Register", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(Registration.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }

                            }
                        });

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
