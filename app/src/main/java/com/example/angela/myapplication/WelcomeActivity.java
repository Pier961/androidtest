package com.example.angela.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity  extends AppCompatActivity implements View.OnClickListener {
    TextView welcomeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_welcome);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeET=findViewById(R.id.welcome_et);
        welcomeET.setText(getIntent().getStringExtra("welcome"));


    }
    public void onClick(View view){
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",getIntent().getStringExtra("welcome"), null));
        startActivity(Intent.createChooser(i, "Choose an Email client :"));
    }
}
