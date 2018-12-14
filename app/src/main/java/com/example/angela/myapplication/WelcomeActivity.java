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
        welcomeET=findViewById(R.id.welcome_et);



    if(getIntent().getStringExtra("welcome")!=null){

        welcomeET.setText(getIntent().getStringExtra("welcome"));

    }else {
        Intent openedBy = getIntent();
        String openedEmail="";
        openedEmail=openedBy.getData().toString().substring(7);
        openedEmail=Uri.decode(openedEmail);
        welcomeET.setText(openedEmail);
    }



    }
    public void onClick(View view){
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",getIntent().getStringExtra("welcome"), null));
        startActivity(Intent.createChooser(i, "Choose an Email client :"));
    }
}
