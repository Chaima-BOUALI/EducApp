/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author stef info
 */
public class Formateur extends Utilisateur{
    private String cv; 
    private String experience; 

    public Formateur(String cv, String experience, int idUtilisateur, String username, String motDePasse, String nom, String prenom, String adresseMail, String sexe, String numCarteBancaire, String numTel, String role) {
        super(idUtilisateur, username, motDePasse, nom, prenom, adresseMail, sexe, numCarteBancaire, numTel, role);
        this.cv = cv;
        this.experience = experience;
        this.setRole("Formateur");
        
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumCarteBancaire() {
        return numCarteBancaire;
    }

    public void setNumCarteBancaire(String numCarteBancaire) {
        this.numCarteBancaire = numCarteBancaire;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Formateur[" + "cv=" + cv + ", experience=" + experience + "nom=" + nom + "prenom=" + prenom + "adresse_mail=" + adresseMail + "]";
    }

    
    

    

    
    
       
    }
    
    


  