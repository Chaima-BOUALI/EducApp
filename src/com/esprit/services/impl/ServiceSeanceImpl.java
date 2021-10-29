/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Ressource;
import com.esprit.models.Seance;
import com.esprit.services.IServiceSeance;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21650
 */
public class ServiceSeanceImpl implements IServiceSeance{
   
   
    Connection cnx = DataSource.getInstance().getCnx();
   
   
    @Override
    public List<Seance> findByName(String nom) {
        List<Seance> list = new ArrayList<>();

		try {
			nom = "'%" + nom + "%'";
			String requete = "select * from Seance WHERE nom LIKE " + nom;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Seance(rs.getInt(1),rs.getString(2), rs.getDate(3)));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
    }

    @Override
    public void ajouter(Seance t) {
    try {

			String requete = "INSERT INTO seance (`id_seance`,`nom`, `date_seance`) VALUES (?,?,?)";
			PreparedStatement pst = cnx.prepareStatement(requete);
                        pst.setString(1, t.getNom());
                        pst.setInt(2, t.getIdSeance());
			pst.setDate(3, t.getDateSeance());
			pst.executeUpdate();
			System.out.println("La séance est  ajouté avec succés!");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
    }
        

    @Override
    public void supprimer(Seance t) {
        try {
			String requete = "DELETE FROM seance WHERE nom =" + t.getNom();
			Statement st = cnx.createStatement();
			st.executeUpdate(requete);
			System.out.println("Seance supprimé !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
                }
        
    }

    @Override
    public void modifier(Seance t) {
     try {
			String requete = "UPDATE seance SET `nom`=?,`id_seance`=?,`date_seance`=? WHERE id_seance=" + t.getIdSeance();
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, t.getNom());
                        pst.setInt(2, t.getIdSeance());
			pst.setDate(3, t.getDateSeance());
			pst.executeUpdate();

			System.out.println(" Séance Modifié avec succés !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
    
    }
       

    @Override
    public List<Seance> afficher() {
        
        List<Seance> list = new ArrayList<>();

		try {
			String requete = "SELECT * FROM seance";
			PreparedStatement pst = cnx.prepareStatement(requete);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Seance(rs.getInt(1), rs.getString(2),rs.getDate(3)));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
        
         }
    
    
}
