/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Promotion;
import com.esprit.models.Ressource;
import com.esprit.services.IServices;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author 21650
 */
public class ServicePromotionImpl implements IServices<Promotion> {

    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Promotion t) {
     try {

			String requete = "INSERT INTO `promotion`(`id_promotion`, `date_debut_promotion`, `date_fin_promotion`, `id_session`, `pourcentage`) VALUES (?,?,?,?,?)";
			PreparedStatement pst = cnx.prepareStatement(requete);
                        pst.setInt(1, t.getIdPromotion());
			pst.setDate(2, t.getDateDebutPromotion());
                        pst.setDate(3, t.getDateFinPromotion());
                        pst.setInt(4, t.getIdSession());
                        pst.setString(5, t.getPourcentage());
			pst.executeUpdate();
			System.out.println("Promotion ajouté avec succés!");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
    }
        

    @Override
    public void supprimer(Promotion t) {
    try {
			String requete = "DELETE FROM promotion WHERE id_promotion =" + t.getIdPromotion();
			Statement st = cnx.createStatement();
			st.executeUpdate(requete);
			System.out.println("Promotion supprimé !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
    }
       

    @Override
    public void modifier(Promotion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List <Promotion> afficher() {
       List<Promotion> list = new ArrayList<>();

		try {
			String requete = "SELECT * FROM Promotion";
			PreparedStatement pst = cnx.prepareStatement(requete);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
			list.add (new Promotion(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
    }
        
}
   

