package com.esprit.models;

public class Category {

	private int id;
	private String nom;
	private String description;

    public Category() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


    public Category(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public Category(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", nom=" + nom + ", description=" + description  + '}';
    }

  
	
	
	
	
}
