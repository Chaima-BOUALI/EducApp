/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import javafx.collections.ObservableList;

/**
 *
 * @author 21650
 */
public class Ressource{

   

   public enum typeRessource {
  cours,
  tp,
  video,
  quiz
       }
    private String nom;
    private int idRessource;
    private String typeRessource;
    private String url;
    private int idSeance; 

    public Ressource(String nom, String typeRessource, String url, int idSeance) {
        this.nom = nom;
        this.typeRessource = typeRessource;
        this.url = url;
        this.idSeance = idSeance;
    }

    public Ressource(String nom, int idRessource, String typeRessource, String url, int idSeance) {
        this.nom = nom;
        this.idRessource = idRessource;
        this.typeRessource = typeRessource;
        this.url = url;
        this.idSeance = idSeance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getTypeRessource() {
        return typeRessource;
    }

    public void setTypeRessource(String typeRessource) {
        this.typeRessource = typeRessource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public Ressource(String nom, String typeRessource) {
        this.nom = nom;
        this.typeRessource = typeRessource;
    }

   
     

   
    
    @Override
    public String toString() {
        return "Ressource [nom=" + nom + "idRessource=" + idRessource + ", typeRessource=" + typeRessource + ", url=" + url +", idSeance=" + idSeance + "]";
    }
    
    
   public static void setItems(ObservableList OL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
