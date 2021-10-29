/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Utilisateur;
import com.esprit.services.IServiceUtilisateur;
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
public class ServiceUtilisateurImpl implements IServiceUtilisateur{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Utilisateur> findByUsername(String username) {
    List<Utilisateur> list = new ArrayList<>();
     try {
            username="'%"+username+"%'";
            String requete = "select * from utilisateur WHERE username LIKE " +username;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<Utilisateur> findById(int idUtilisateur) {
List<Utilisateur> list = new ArrayList<>();

        try {
            String requete = "select * from utilisateur WHERE id_utilisateur=" + idUtilisateur;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Utilisateur (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    

    @Override
    public void ajouter(Utilisateur t) {
try {
            String requete = "INSERT INTO utilisateur (`id_utilisateur`, `username`, `mot_de_passe`, `nom`, `prenom`, `adresse_mail`, `sexe`, `num_carte_bancaire`, `num_tel`, `role`) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getIdUtilisateur());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getMotDePasse());
            pst.setString(4, t.getNom());
            pst.setString(5, t.getPrenom());
            pst.setString(6, t.getAdresseMail());
            pst.setString(7, t.getSexe());
            pst.setString(8, t.getNumCarteBancaire());
            pst.setString(9, t.getNumTel());
            pst.setString(10, t.getRole());
            pst.executeUpdate();
            System.out.println("Utilisateur ajouté avec succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur t) {
try {
	            String requete = "DELETE FROM utilisateur WHERE id_utilisateur =" + t.getIdUtilisateur();
	            Statement st = cnx.createStatement();
	            st.executeUpdate(requete);
	            System.out.println("Utilisateur supprimée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
    }

    @Override
    public void modifier(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> afficher() {
List<Utilisateur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM utilisateur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add (new Utilisateur (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}
