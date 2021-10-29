package com.esprit.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.esprit.models.Category;
import com.esprit.services.IServiceCategroy;
import com.esprit.utils.DataSource;

public class ServiceCategoryImpl implements IServiceCategroy {

    Connection cnx = DataSource.getInstance().getCnx();

	@Override
	public void ajouter(Category t) {
		try {
            String requete = "INSERT INTO category (nom,description) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDescription());
            pst.executeUpdate();
            System.out.println("Categorie ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
		
	}

	@Override
	public void supprimer(Category t) {
		 try {
	            String requete = "DELETE FROM category WHERE id=" + t.getId();
	            Statement st = cnx.createStatement();
	            st.executeUpdate(requete);
	            System.out.println("Categorie supprimée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
		
	}

	@Override
	public void modifier(Category t) {
		 try {
	            ;

	            String requete = "UPDATE category SET nom=?,description=?  WHERE id=?";
	            PreparedStatement pst = cnx.prepareStatement(requete);
	            pst.setString(1, t.getNom());
	            pst.setString(2, t.getDescription());
	            pst.setInt(3, t.getId());
	            pst.executeUpdate();

	            System.out.println("Categorie modifiée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
		
	}

	@Override
	public List<Category> afficher() {
		List<Category> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM category";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
	}

	@Override
	public List<Category> findByName(String name) {
		List<Category> list = new ArrayList<>();

        try {
            name="'%"+name+"%'";
            String requete = "select * from category WHERE nom LIKE " +name;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
	}

	
 public List getCategoryNameAndId() {
        List<String> res = new ArrayList<>();
        try {
            String requete = "SELECT id,nom FROM category";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                res.add(rs.getString(1) + "-" + rs.getString(2));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return res;

    }
	

}
