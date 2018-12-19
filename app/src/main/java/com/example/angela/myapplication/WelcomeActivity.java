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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WelcomeActivity  extends AppCompatActivity  implements View.OnClickListener , FoodlistAdapter.OnQuantityChange {


    TextView welcomeET;
    ArrayList<Elements> data = new ArrayList<>();
    int total = 0;
    TextView display;
    RecyclerView recyclerView;
    FoodlistAdapter adapter;
    LinearLayoutManager layoutManager;
    Button buy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_welcome);
        super.onCreate(savedInstanceState);
        welcomeET = findViewById(R.id.welcome_et);
        recyclerView=findViewById(R.id.rv);
        welcomeET.setOnClickListener(this);
        display = findViewById(R.id.zerototale);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        buy=findViewById(R.id.buy);
        getProducts();


        if (getIntent().getStringExtra("welcome") != null) {

            welcomeET.setText(getIntent().getStringExtra("welcome"));
            Log.i("Main", "pd");
        } else {
            Intent openedBy = getIntent();
            String openedEmail = "";
            openedEmail = openedBy.getData().toString().substring(7);
            openedEmail = Uri.decode(openedEmail);
            welcomeET.setText(openedEmail);
            Log.i("Main", "pdl");
        }


        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FoodlistAdapter(this));

    }


    public void onClick(View view) {
        if (view.getId() == R.id.welcome_et) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", getIntent().getStringExtra("welcome"), null));
            startActivity(Intent.createChooser(i, "Choose an Email client :"));
        }
    }

    @Override
    public void onItemAdded(int price) {

        total += price;
        display.setText("€" + toString().valueOf(total));
        enableButtonBuy();

    }

    @Override
    public void onItemRemoved(int price) {

        total -= price;
        display.setText("€" + toString().valueOf(total));
        enableButtonBuy();

    }

    public void enableButtonBuy(){
        if(total>=5){
            buy.setEnabled(true);
        }else {
            buy.setEnabled(false);
        }

    }

    private void getProducts() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://5ba19290ee710f0014dd764c.mockapi.io/Food";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response);
                        try {
                            JSONObject responseJSON = new JSONObject(response);
                            JSONArray jsonArray = responseJSON.getJSONArray("foods");

                            ArrayList<Elements> foodArrayList = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                Elements food = new Elements(jsonArray.getJSONObject(i));
                                foodArrayList.add(food);

                            }
                            adapter = new FoodlistAdapter(WelcomeActivity.this);
                            adapter.setOnQuantityChange(WelcomeActivity.this);
                            adapter.setData(foodArrayList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });

        queue.add(stringRequest);
    }
}



