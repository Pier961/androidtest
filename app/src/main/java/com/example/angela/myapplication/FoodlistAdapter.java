package com.example.angela.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodlistAdapter extends RecyclerView.Adapter {
    private LayoutInflater mInfliter;

    private ArrayList<Elements> data = new ArrayList<>();
    private OnQuantityChange onQuantityChange;
    public FoodlistAdapter setOnQuantityChange(OnQuantityChange onQuantityChange) {
        this.onQuantityChange = onQuantityChange;
        return this;
    }

    public void setData(ArrayList<Elements> foodArrayList) {
        this.data=foodArrayList;
        notifyDataSetChanged();
    }

    public interface OnQuantityChange{
        public void onItemAdded(int price);
        public void onItemRemoved (int price);
    }



    public FoodlistAdapter(Context context ) {
        mInfliter=LayoutInflater.from(context);

    }

    public FoodlistAdapter(Context context , ArrayList<Elements> data){
        this.data = data;
        mInfliter=LayoutInflater.from(context);
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
        f.display.setText(String.valueOf(data.get(i).getQuantita()));
        f.prodotto.setText(data.get(i).getNomeArticolo());
        f.prezzo.setText(String.valueOf(data.get(i).getPrezzoUnitario()));

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

           Elements element = data.get(getAdapterPosition());
            element.increaseQuantita();
            notifyItemChanged(getAdapterPosition());
            onQuantityChange.onItemAdded(element.getPrezzoUnitario());

        }

        public void minusValueButton() {
            Elements element = data.get(getAdapterPosition());
            if(element.getQuantita()>0){
                element.decreaseQuantita();
                notifyItemChanged(getAdapterPosition());
                onQuantityChange.onItemRemoved(element.getPrezzoUnitario());
            }
        }
    }

}