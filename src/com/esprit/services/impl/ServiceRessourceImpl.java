/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Ressource;
import com.esprit.services.IServiceRessource;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServiceRessourceImpl implements IServiceRessource {

     Connection cnx = DataSource.getInstance().getCnx();
    
    
    @Override 
	public List<Ressource> findByName(String nom) {
		List<Ressource> list = new ArrayList<>();

		try {
			nom = "'%" + nom + "%'";
			String requete = "select * from Ressource WHERE nom LIKE " + nom;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Ressource(rs.getString(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getInt(5)));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}

    @Override
    public List<Ressource> findByTypeRessource(String typeRessource) {
    
		List<Ressource> list = new ArrayList<>();

		try {
			String requete = "select * from ressource WHERE type_ressource=" + typeRessource;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Ressource(rs.getString(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getInt(5)));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
    
    
    
    
    
    }
       

    @Override
    public void ajouter(Ressource t) {
        try {

			String requete = "INSERT INTO ressource (`nom`,`id_ressource`, `type_ressource`, `url`,`id_seance`) VALUES (?,?,?,?,?)";
			PreparedStatement pst = cnx.prepareStatement(requete);
                        pst.setString(1, t.getNom());
                        pst.setInt(2, t.getIdRessource());
			pst.setString(3, t.getTypeRessource());
			pst.setString(4, t.getUrl());
                        pst.setInt(5, t.getIdSeance());

			pst.executeUpdate();
			System.out.println("Ressource ajouté !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
	}
        
        
        
        
   

    @Override
    public void supprimer(Ressource t) {
       try {
			String requete = "DELETE FROM ressource WHERE id_ressource =" + t.getIdRessource();
			Statement st = cnx.createStatement();
			st.executeUpdate(requete);
			System.out.println("Ressource supprimé !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}		
    }

    @Override
    public void modifier(Ressource t) {
    try {
			String requete = "UPDATE ressource SET `nom`=?,`id_ressource`=?,`type_ressource`=?,`url`=?,`id_seance`=? WHERE id_ressource=" + t.getIdRessource();
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, t.getNom());
                        pst.setInt(2, t.getIdRessource());
			pst.setString(3, t.getTypeRessource());
			pst.setString(4, t.getUrl());
                        pst.setInt(5, t.getIdSeance());

			pst.executeUpdate();

			System.out.println(" Modifié avec succés !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
    }
        
    @Override
    public List<Ressource> afficher() {
    
    List<Ressource> list = new ArrayList<>();

		try {
			String requete = "SELECT * FROM Ressource";
			PreparedStatement pst = cnx.prepareStatement(requete);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Ressource(rs.getString (1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
    }
        
public List<String> getUserEmail() {
        List<String> list = new ArrayList<>();

        try {
            String requete = "SELECT email FROM user";
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery().first();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
}
