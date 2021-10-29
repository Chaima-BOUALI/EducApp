package com.esprit.services.impl;

import com.esprit.models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.esprit.models.Session;
import com.esprit.services.IServiceSession;
import com.esprit.utils.DataSource;

public class ServiceSessionImpl implements IServiceSession {

	Connection cnx = DataSource.getInstance().getCnx();

	@Override
	public void ajouter(Session t) {
		try {

			String requete = "INSERT INTO session (start_date,end_date,nom,place_disponible,description,url_image,id_category) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setDate(1, t.getStartDate());
			pst.setDate(2, t.getEndDate());
			pst.setString(3, t.getNom());
                        pst.setInt(4, t.getPlaceDisponible());
                        pst.setString(5, t.getDescription());
                        pst.setString(6, t.getUrl_image());
			pst.setInt(7, t.getId_category());
			pst.executeUpdate();
			System.out.println("Session ajoutée !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Override
	public void supprimer(Session t) {
		try {
			String requete = "DELETE FROM session WHERE id=" + t.getId();
			Statement st = cnx.createStatement();
			st.executeUpdate(requete);
			System.out.println("Session supprimée !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Override
	public void modifier(Session t) {
		try {
			String requete = "UPDATE session SET start_date=?,end_date=?,nom=?,place_disponible=?,description=?,url_image=?,id_category=? WHERE id=?";
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setDate(1, t.getStartDate());
			pst.setDate(2, t.getEndDate());
			pst.setString(3, t.getNom());
                        pst.setInt(4, t.getPlaceDisponible());
                        pst.setString(5, t.getDescription());
                        pst.setString(6, t.getUrl_image());
			pst.setInt(7, t.getId_category());
                        pst.setInt(8, t.getId());
			pst.executeUpdate();

			System.out.println("Session modifiée !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Override
	public List<Session> afficher() {
		List<Session> list = new ArrayList<>();

		try {
			String requete = "SELECT * FROM session";
			PreparedStatement pst = cnx.prepareStatement(requete);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Session(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),getCategoryName(rs.getInt(8))));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public List<Session> findByName(String name) {
		List<Session> list = new ArrayList<>();

		try {
			name = "'%" + name + "%'";
			String requete = "select * from session WHERE nom LIKE " + name;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Session(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),getCategoryName(rs.getInt(8))));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public List<Session> findByCategory(int category_id) {
		List<Session> list = new ArrayList<>();

		try {
			String requete = "select * from session WHERE id_category=" + category_id;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Session(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),getCategoryName(rs.getInt(8))));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}
        
        
        
     public String getCategoryName(int id) {
        String title = "";
        try {
            String requete = "SELECT nom FROM category where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                title = rs.getString(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return title;

    }
       

}
