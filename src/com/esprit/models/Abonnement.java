package com.esprit.models;

import java.sql.Date;

public class Abonnement {

	private int id;
	private String type;
	private Date date_abonnement;
	private int id_user;
	private int id_session;
        private String nom;
        private String prenom;
        private String email;
        
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDate_abonnement() {
		return date_abonnement;
	}
	public void setDate_abonnement(Date date_abonnement) {
		this.date_abonnement = date_abonnement;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
        
	public Abonnement(int id, String type, Date date_abonnement, int id_user, int id_session) {
		super();
		this.id = id;
		this.type = type;
		this.date_abonnement = date_abonnement;
		this.id_user = id_user;
		this.id_session = id_session;
	}
	
	public Abonnement(String type, int id_user, int id_session) {
		super();
		this.type = type;
		this.id_user = id_user;
		this.id_session = id_session;
	}
	
	public Abonnement(int id, String type, int id_user, int id_session) {
		super();
		this.id = id;
		this.type = type;
		this.id_user = id_user;
		this.id_session = id_session;
	}

    public Abonnement(int id, String type, Date date_abonnement, int id_user, int id_session, String nom, String prenom, String email) {
        this.id = id;
        this.type = type;
        this.date_abonnement = date_abonnement;
        this.id_user = id_user;
        this.id_session = id_session;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
        
        
	public Abonnement() {
		super();
	}

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", type=" + type + ", date_abonnement=" + date_abonnement + ", id_user=" + id_user + ", id_session=" + id_session + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }
	
	
	
}
