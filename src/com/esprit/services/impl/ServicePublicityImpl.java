/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Publicity;
import com.esprit.models.Utilisateur;
import com.esprit.services.IServicePublicity;
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
 * @author stef info
 */
public class ServicePublicityImpl implements IServicePublicity{
        Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Publicity> findByIdPub(int idPub) {
            List<Publicity> list = new ArrayList<>();

        try {
            String requete = "select * from utilisateur WHERE id_utilisateur=" + idPub;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Publicity (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Publicity t) {
try {
            String requete = "INSERT INTO `publicity`(`id_pub`, `description_pub`, `title_pub`, `picture_pub`, `position`, `link`, `start_date_pub`, `end_date_pub`) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getIdPub());
            pst.setString(2, t.getDescriptionPub());
            pst.setString(3, t.getTitlePub());
            pst.setString(4, t.getPicturePub());
            pst.setString(5, t.getPosition());
            pst.setString(6, t.getLink());
            pst.setString(7, t.getStartDatePub());
            pst.setString(8, t.getEndDatePub());
          
            pst.executeUpdate();
            System.out.println("Publicité ajouté avec succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Publicity t) {
try {
	            String requete = "DELETE FROM Publicity WHERE id_pub =" + t.getIdPub();
	            Statement st = cnx.createStatement();
	            st.executeUpdate(requete);
	            System.out.println("Publicité supprimée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
    }

    @Override
    public void modifier(Publicity t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicity> afficher() {
    List<Publicity> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Publicity";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add (new Publicity (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    
}
