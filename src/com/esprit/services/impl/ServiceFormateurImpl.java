/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Formateur;
import com.esprit.services.IServiceFormateur;
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
public class ServiceFormateurImpl implements IServiceFormateur {
        Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Formateur> findByUtilisateur(int id_utilisateur) {
List<Formateur> list = new ArrayList<>();

        try {
            String requete = "select * from Formateur WHERE id_utilisateur=" +id_utilisateur;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Formateur (rs.getString(1),rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
	}
    

    @Override
    public void ajouter(Formateur t) {
try {
            String requete = "INSERT INTO `formateur`( `cv`, `experience`,`id_utilisateur`, `username`, `mot_de_passe`, `nom`, `prenom`, `adresse_mail`, `sexe`, `num_carte_bancaire`, `num_tel`, `role`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getCv());
            pst.setString(2, t.getExperience());
            pst.setInt(3, t.getIdUtilisateur());
            pst.setString(4, t.getUsername());
            pst.setString(5, t.getMotDePasse());
            pst.setString(6, t.getNom());
            pst.setString(7, t.getPrenom());
            pst.setString(8, t.getAdresseMail());
            pst.setString(9, t.getSexe());
            pst.setString(10, t.getNumCarteBancaire());
            pst.setString(11, t.getNumTel());
            pst.setString(12, t.getRole());
            
            pst.executeUpdate();
            System.out.println("Formateur ajouté avec succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Formateur t) {
try {
	            String requete = "DELETE FROM Utilisateur WHERE id_utilisateur =" + t.getIdUtilisateur();
	            Statement st = cnx.createStatement();
	            st.executeUpdate(requete);
	            System.out.println("Formateur supprimée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
    }

    @Override
    public void modifier(Formateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formateur> afficher() {
List<Formateur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM formateur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add (new Formateur ( rs.getString(1),rs.getString(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;    
    }

    
}
