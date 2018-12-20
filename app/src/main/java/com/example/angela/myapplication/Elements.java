package com.example.angela.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Elements {
   private String nomeArticolo;
   private int  prezzoUnitario;
    private int quantita;
    private boolean avaiable;

    public Elements(String nome , int prezzo , int quantita,boolean avaiable){
        this.nomeArticolo=nome;
        this.prezzoUnitario=prezzo;
        this.quantita=quantita;
    }

    public Elements(JSONObject jsonFood) throws JSONException {

        this.nomeArticolo = jsonFood.getString("name");
        this.prezzoUnitario = Integer.parseInt(jsonFood.getString("price"));
        this.avaiable=jsonFood.getBoolean("available");


    }

    public String getNomeArticolo() {
        return nomeArticolo;
    }

    public void setNomeArticolo(String nomeArticolo) {
        this.nomeArticolo = nomeArticolo;
    }

    public int getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(int prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getQuantita() {
        return quantita;
    }

    public void increaseQuantita() {
        this.quantita ++;
    }
    public void decreaseQuantita() {
        this.quantita --;
    }

    public boolean getAvaiable() {
        return avaiable;
    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }
}
