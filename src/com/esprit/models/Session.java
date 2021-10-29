package com.esprit.models;

import java.sql.Date;

public class Session {

	private int id;
	private Date startDate;
	private Date endDate;
	private String nom;
        private int placeDisponible;
        private String description;
        private String url_image;
	private int id_category;
        private String catgeory;

    public Session() {
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

    public int getPlaceDisponible() {
        return placeDisponible;
    }

    public void setPlaceDisponible(int placeDisponible) {
        this.placeDisponible = placeDisponible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
        
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

    public String getCatgeory() {
        return catgeory;
    }

    public void setCatgeory(String catgeory) {
        this.catgeory = catgeory;
    }
        
        

    public Session(int id, Date startDate, Date endDate, String nom, int placeDisponible, String description, String url_image, int id_category) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nom = nom;
        this.placeDisponible = placeDisponible;
        this.description = description;
        this.url_image = url_image;
        this.id_category = id_category;
    }

    public Session(Date startDate, Date endDate, String nom, int placeDisponible, String description, String url_image, int id_category) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.nom = nom;
        this.placeDisponible = placeDisponible;
        this.description = description;
        this.url_image = url_image;
        this.id_category = id_category;
    }

    public Session(int id, Date startDate, Date endDate, String nom, int placeDisponible, String description, String url_image, int id_category, String catgeory) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nom = nom;
        this.placeDisponible = placeDisponible;
        this.description = description;
        this.url_image = url_image;
        this.id_category = id_category;
        this.catgeory = catgeory;
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", nom=" + nom + ", placeDisponible=" + placeDisponible + ", description=" + description + ", url_image=" + url_image + ", id_category=" + id_category + ", catgeory=" + catgeory + '}';
    }

   
	
	
}
