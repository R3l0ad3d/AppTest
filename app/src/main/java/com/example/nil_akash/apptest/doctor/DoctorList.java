package com.example.nil_akash.apptest.doctor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.medicine.MedicineInfoAddEdit;

public class DoctorList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        getSupportActionBar().setTitle("Doctor List");
    }

    public void addDoctor(View view) {
        Intent intent = new Intent(getApplicationContext(),MedicineInfoAddEdit.class);
        intent.putExtra("flag","add");
        startActivity(intent);
    }
}
