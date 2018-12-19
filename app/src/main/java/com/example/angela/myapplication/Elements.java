package com.example.angela.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Elements {
   private String nomeArticolo;
   private int  prezzoUnitario;
    private int quantita;

    public Elements(String nome , int prezzo , int quantita){
        this.nomeArticolo=nome;
        this.prezzoUnitario=prezzo;
        this.quantita=quantita;
    }

    public Elements(JSONObject jsonFood) throws JSONException {

        this.nomeArticolo = jsonFood.getString("name");
        this.prezzoUnitario = Integer.parseInt(jsonFood.getString("price"));


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
}
