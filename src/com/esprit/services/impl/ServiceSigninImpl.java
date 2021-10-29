/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services.impl;

import com.esprit.models.Administrateur;
import com.esprit.models.Signin;
import com.esprit.services.IServiceSignin;
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
public class ServiceSigninImpl implements IServiceSignin{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Signin t) {
try {

            String requete = "INSERT INTO `signin`(`login`, `password`) VALUES(?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getLogin());
            pst.setString(2, t.getPassword());
             } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Signin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Signin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Signin> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
