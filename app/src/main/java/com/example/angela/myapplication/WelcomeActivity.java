package com.example.angela.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity  extends AppCompatActivity {
    TextView welcomeET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeET=findViewById(R.id.welcome_et);
        welcomeET.setText(getIntent().getStringExtra("welcome"));

    }
}
