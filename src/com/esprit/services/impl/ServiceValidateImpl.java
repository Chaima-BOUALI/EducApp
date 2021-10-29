/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Utilisateur;
import com.esprit.models.Validate;
import com.esprit.services.IServiceValidate;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stef info
 */
public class ServiceValidateImpl implements IServiceValidate{
            Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Validate> findByUsername (String username) {
List<Validate> list = new ArrayList<>();
     try {
            username="'%"+username+"%'";
            String requete = "select * from validate WHERE username LIKE " +username;
            PreparedStatement pst = cnx.prepareStatement(requete);
            cnx.prepareStatement(requete).executeQuery();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Validate(rs.getString(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;

  
    }

    @Override
    public void ajouter(Validate t) {
        try {
            String requete = "INSERT INTO `validate`(`id`, `validate`,`nom`) VALUES(?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);

            

            pst.setString(1, t.getValidate());
            pst.setString(2, t.getUsername());

            pst.executeUpdate();
            System.out.println("Paiement validé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Validate t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Validate t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Validate> afficher() {
       List<Validate> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM validate";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add (new Validate ( rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;    
    }

   

    
}
