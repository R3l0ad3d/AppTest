package com.example.nil_akash.apptest.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nil_akash.apptest.R;

public class DoctorAdd extends AppCompatActivity {



    private String FLAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_add);



        FLAG = getIntent().getStringExtra("flag");

        if(FLAG.equals("add")){
            getSupportActionBar().setTitle("Add Doctor");

        }else{
            getSupportActionBar().setTitle("Edit Doctor");
        }

    }
}
