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
public class Publicity {
    private int idPub;
    private String descriptionPub;
    private String titlePub;
    private String picturePub;
    private String position;
    private String link;
    private String startDatePub;
    private String endDatePub;

    public Publicity(int idPub, String descriptionPub, String titlePub, String picturePub, String position, String link, String startDatePub, String endDatePub) {
        this.idPub = idPub;
        this.descriptionPub = descriptionPub;
        this.titlePub = titlePub;
        this.picturePub = picturePub;
        this.position = position;
        this.link = link;
        this.startDatePub = startDatePub;
        this.endDatePub = endDatePub;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public String getDescriptionPub() {
        return descriptionPub;
    }

    public void setDescriptionPub(String descriptionPub) {
        this.descriptionPub = descriptionPub;
    }

    public String getTitlePub() {
        return titlePub;
    }

    public void setTitlePub(String titlePub) {
        this.titlePub = titlePub;
    }

    public String getPicturePub() {
        return picturePub;
    }

    public void setPicturePub(String picturePub) {
        this.picturePub = picturePub;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStartDatePub() {
        return startDatePub;
    }

    public void setStartDatePub(String startDatePub) {
        this.startDatePub = startDatePub;
    }

    public String getEndDatePub() {
        return endDatePub;
    }

    public void setEndDatePub(String endDatePub) {
        this.endDatePub = endDatePub;
    }

    @Override
    public String toString() {
        return "Publicity[" + "idPub=" + idPub + ", descriptionPub=" + descriptionPub + ", titlePub=" + titlePub + ", picturePub=" + picturePub + ", position=" + position + ", link=" + link + ", startDatePub=" + startDatePub + ", endDatePub=" + endDatePub + "]";
    }

}
