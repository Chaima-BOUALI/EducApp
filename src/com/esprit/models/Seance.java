/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.sql.Date;
import javafx.collections.ObservableList;


/**
 *
 * @author 21650
 */
public class Seance {

    
    private String nom;
    private int idSeance;
    private Date dateSeance;

    public Seance(int idSeance,String nom , Date dateSeance) {
        this.nom = nom;
        this.idSeance = idSeance;
        this.dateSeance = dateSeance;
    }

    

   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

  

   


    @Override
    public String toString() {
        return "Seance[nom=" + nom + ",idSeance=" + idSeance +" dateSeance=" + dateSeance + "]";
    }

   
    }
    
    

