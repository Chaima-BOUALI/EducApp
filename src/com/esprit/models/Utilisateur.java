/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.util.Properties;
import javafx.collections.ObservableList;
import javax.mail.Authenticator;

/**
 *
 * @author stef info
 */
public class Utilisateur {

    public static Utilisateur getInstance(Properties props, Authenticator authenticator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public int idUtilisateur;
    public String username;
    public String motDePasse;
    public String nom;
    public String prenom;
    public String adresseMail;
    public String sexe;
    public String numCarteBancaire;
    public String numTel;
    public String role; 

    public Utilisateur(int idUtilisateur, String username, String motDePasse, String nom, String prenom, String adresseMail, String sexe, String numCarteBancaire, String numTel, String role) {
        this.idUtilisateur = idUtilisateur;
        this.username = username;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.sexe = sexe;
        this.numCarteBancaire = numCarteBancaire;
        this.numTel = numTel;
        this.role = role;
    }

    public Utilisateur(String id, String description) {
        this.idUtilisateur = idUtilisateur;
        this.role = role;
    }

    public Utilisateur() {
        
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
        return "Utilisateur [id_utilisateur = " + idUtilisateur +   ", username=" + username + ", mot_de_passe=" + motDePasse + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail=" + adresseMail + ", sexe=" + sexe + ", num_carte_bancaire=" + numCarteBancaire + ", numm_tel=" + numTel + ", role=" + role + "]";
    }

    public String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
