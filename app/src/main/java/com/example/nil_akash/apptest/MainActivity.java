package com.example.nil_akash.apptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nil_akash.apptest.doctor.DoctorList;

public class MainActivity extends AppCompatActivity {

    private Button singinBtn;
    private EditText usernameET;
    private EditText passwordET;


    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Log In");

        singinBtn = (Button) findViewById(R.id.btnsingIn);
        usernameET = (EditText) findViewById(R.id.etuserName);
        passwordET = (EditText) findViewById(R.id.etpassword);

    }

    //Start Registration Activity for Registration
    public void registrationPage(View view) {
        Intent intent = new Intent(getApplicationContext(),UserRegistration.class);
        startActivity(intent);
    }

    //Sign In Button CLick
    public void signIn(View view) {
        userName = usernameET.getText().toString();
        password = passwordET.getText().toString();

        Intent intent = new Intent(getApplicationContext(),DoctorList.class);
        startActivity(intent);
    }
}
