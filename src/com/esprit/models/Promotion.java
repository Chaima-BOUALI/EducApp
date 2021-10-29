/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.sql.Date;



/**
 *
 * @author 21650
 */
public class Promotion {
    private int idPromotion;
    private Date dateDebutPromotion;
    private Date dateFinPromotion;
    private int idSession;
    private String pourcentage;

    public Promotion(int idPromotion, Date dateDebutPromotion, Date dateFinPromotion, int idSession, String pourcentage) {
        this.idPromotion = idPromotion;
        this.dateDebutPromotion = dateDebutPromotion;
        this.dateFinPromotion = dateFinPromotion;
        this.idSession = idSession;
        this.pourcentage = pourcentage;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Date getDateDebutPromotion() {
        return dateDebutPromotion;
    }

    public void setDateDebutPromotion(Date dateDebutPromotion) {
        this.dateDebutPromotion = dateDebutPromotion;
    }

    public Date getDateFinPromotion() {
        return dateFinPromotion;
    }

    public void setDateFinPromotion(Date dateFinPromotion) {
        this.dateFinPromotion = dateFinPromotion;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public String getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(String pourcentage) {
        this.pourcentage = pourcentage;
    }

   

    @Override
    public String toString() {
        return "Promotion [idPromotion=" + idPromotion + ", dateDebutPromotion=" + dateDebutPromotion + ", dateFinPromotion=" + dateFinPromotion +", idSession=" + idSession + ", pourcentage=" + pourcentage + "]";
    }
    
}
