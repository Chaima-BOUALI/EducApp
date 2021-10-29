/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Administrateur;
import com.esprit.services.IServiceAdministrateur;
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
public class ServiceAdministrateurImpl implements IServiceAdministrateur {
        Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public List<Administrateur> findByUtilisateur(int id_utilisateur) {
        List<Administrateur> list = new ArrayList<>();

        try {
            String requete = "select * from Administrateur WHERE id_utilisateur=" +id_utilisateur;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Administrateur ( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;

    }

    @Override
    public void ajouter(Administrateur t) {
try {
            String requete = "INSERT INTO `administrateur`(`id_utilisateur`, `username`, `mot_de_passe`, `nom`, `prenom`, `adresse_mail`, `sexe`, `num_carte_bancaire`, `num_tel`, `role`,`poste`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getPoste());
            pst.setInt(2, t.getIdUtilisateur());
            pst.setString(3, t.getUsername());
            pst.setString(4, t.getMotDePasse());
            pst.setString(5, t.getNom());
            pst.setString(6, t.getPrenom());
            pst.setString(7, t.getAdresseMail());
            pst.setString(8, t.getSexe());
            pst.setString(9, t.getNumCarteBancaire());
            pst.setString(10, t.getNumTel());
            pst.setString(11, t.getRole());
            pst.executeUpdate();
            System.out.println("Administrateur ajouté avec succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Administrateur t) {
try {
	            String requete = "DELETE FROM Administrateur WHERE id_utilisateur =" + t.getIdUtilisateur();
	            Statement st = cnx.createStatement();
	            st.executeUpdate(requete);
	            System.out.println("Administrateur supprimée !");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }
    }

    @Override
    public void modifier(Administrateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List afficher() {
List<Administrateur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM administrateur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add (new Administrateur ( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11) ));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;    
    }
}