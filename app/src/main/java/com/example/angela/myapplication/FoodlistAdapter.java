package com.example.angela.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodlistAdapter extends RecyclerView.Adapter {
    private LayoutInflater mInfliter;
    private ArrayList<Elements> data;


    public FoodlistAdapter(Context c, ArrayList<Elements> data) {
        this.data = data;
        mInfliter = LayoutInflater.from(c);

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mInfliter.inflate(R.layout.row, viewGroup, false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        FoodViewHolder f = (FoodViewHolder) viewHolder;
        f.display.setText(data.get(i).quantita);
        f.prodotto.setText(data.get(i).nomeArticolo);
        f.prezzo.setText(data.get(i).prezzoUnitario);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public TextView prodotto, prezzo, display;
        public Button piu, meno;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            prodotto = itemView.findViewById(R.id.nome);
            prezzo = itemView.findViewById(R.id.prezzomilk);
            display = itemView.findViewById(R.id.display_number);
            piu = itemView.findViewById(R.id.piu_btn1);
            meno = itemView.findViewById(R.id.meno_btn1);

            piu.setOnClickListener(this);
            meno.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
           if(v.getId()==R.id.piu_btn1){
            addValueButton();
           }else if(v.getId()==R.id.meno_btn1){
               minusValueButton();
           }
        }

        public void addValueButton() {
            int value;
            value = Integer.parseInt(display.getText().toString());
            value++;
            display.setText(String.valueOf(value));
            Log.i("FoodAdapt", "problema");
        }

        public void minusValueButton() {
            int value;
            value = Integer.parseInt(display.getText().toString());
            if(value>0){
                value--;
            }
            display.setText(String.valueOf(value));
            Log.i("FoodAdapt", "problema");
        }
    }

}