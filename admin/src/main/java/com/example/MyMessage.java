package com.example;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MyMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private String ch;  
    private String date ; 


    public MyMessage() {
    }


    public MyMessage(String ch , String nom) {
        this.ch = ch;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        date = dtf.format(now);  
        this.nom = nom;
       
    }

    public String getCh() {
        return this.ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public String toString() {
        return "{" +
            " ch='" + getCh() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

    
}
