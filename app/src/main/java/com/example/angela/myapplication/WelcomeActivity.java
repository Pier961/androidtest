package com.example.angela.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class WelcomeActivity  extends AppCompatActivity implements View.OnClickListener {


    TextView welcomeET;
    Button plus1;
    RecyclerView rec;
    ArrayList<Elements> data = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_welcome);
        super.onCreate(savedInstanceState);
        welcomeET=findViewById(R.id.welcome_et);
        welcomeET.setOnClickListener(this);




    if(getIntent().getStringExtra("welcome")!=null){

        welcomeET.setText(getIntent().getStringExtra("welcome"));
        Log.i("Main", "pd");
    }else {
        Intent openedBy = getIntent();
        String openedEmail="";
        openedEmail=openedBy.getData().toString().substring(7);
        openedEmail=Uri.decode(openedEmail);
        welcomeET.setText(openedEmail);
        Log.i("Main", "pdl");
    }
    data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));
        data.add(new Elements("Pippo","5","0"));

    rec=findViewById(R.id.rv);
    rec.setLayoutManager(new LinearLayoutManager(this));
    rec.setAdapter(new FoodlistAdapter(this,data));

    }




    public void onClick(View view) {
        if (view.getId() == R.id.welcome_et) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", getIntent().getStringExtra("welcome"), null));
            startActivity(Intent.createChooser(i, "Choose an Email client :"));
        }
    }
}



