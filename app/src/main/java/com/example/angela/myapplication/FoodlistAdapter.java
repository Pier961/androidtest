package com.example.angela.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

public class FoodlistAdapter extends RecyclerView.Adapter {
    private LayoutInflater mInfliter;
    private ArrayList<String> data;

    public FoodlistAdapter(Context  c, ArrayList<String> data){
        this.data=data;
        mInfliter=LayoutInflater.from(c);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mInfliter.inflate(R.layout.row,viewGroup,false);
        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView prodotto,prezzo,display;
        public Button piu,meno;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            prodotto=itemView.findViewById(R.id.sfondo);
            prezzo = itemView.findViewById(R.id.prezzomilk);
            display=itemView.findViewById(R.id.display_number);
            piu=itemView.findViewById(R.id.piu_btn1);
            meno=itemView.findViewById(R.id.meno_btn1);
            //TODO devi cambiare tutto!!!
        }

        @Override
        public void onClick(View v) {

        }
    }
}
