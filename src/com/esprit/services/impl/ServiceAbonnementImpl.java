package com.esprit.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.esprit.models.Abonnement;
import com.esprit.services.IServiceAbonnement;
import com.esprit.utils.DataSource;

public class ServiceAbonnementImpl implements IServiceAbonnement {

    Connection cnx = DataSource.getInstance().getCnx();

	@Override
	public void ajouter(Abonnement t) {
		try {

			String requete = "INSERT INTO abonnement (type,id_user,id_session) VALUES (?,?,?)";
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, t.getType());
			pst.setInt(2, t.getId_user());
			pst.setInt(3, t.getId_session());
			pst.executeUpdate();
			System.out.println("Abonnement ajouté !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public void supprimer(Abonnement t) {
		try {
			String requete = "DELETE FROM abonnement WHERE id=" + t.getId();
			Statement st = cnx.createStatement();
			st.executeUpdate(requete);
			System.out.println("Abonnement supprimé !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}		
	}

	@Override
	public void modifier(Abonnement t) {
		try {
			String requete = "UPDATE abonnement SET type=?,id_user=?,id_session=? WHERE id=?";
			PreparedStatement pst = cnx.prepareStatement(requete);
			pst.setString(1, t.getType());
			pst.setInt(2, t.getId_user());
			pst.setInt(3, t.getId_session());
			pst.setInt(4, t.getId());
			pst.executeUpdate();

			System.out.println("Abonnement modifié !");

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public List<Abonnement> afficher() {
		List<Abonnement> list = new ArrayList<>();

		try {
			String requete = "SELECT * FROM abonnement";
			PreparedStatement pst = cnx.prepareStatement(requete);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Abonnement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),getFirstName(rs.getInt(4)),getLastName(rs.getInt(4)),getEmail(rs.getInt(4))));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public List<Abonnement> findByUser(int id) {
		List<Abonnement> list = new ArrayList<>();

		try {
			String requete = "select * from abonnement WHERE id_user=" + id;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Abonnement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),getFirstName(rs.getInt(4)),getLastName(rs.getInt(4)),getEmail(rs.getInt(4))));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public List<Abonnement> findBySession(int id) {
		List<Abonnement> list = new ArrayList<>();

		try {
			String requete = "select * from abonnement WHERE id_session=" + id;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Abonnement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),getFirstName(rs.getInt(4)),getLastName(rs.getInt(4)),getEmail(rs.getInt(4))));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
	}
        
         public String getFirstName(int id) {
        String title = "";
        try {
            String requete = "SELECT prenom FROM user where id=?";
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
         
         public String getLastName(int id) {
        String title = "";
        try {
            String requete = "SELECT nom FROM user where id=?";
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
      public String getEmail(int id) {
        String title = "";
        try {
            String requete = "SELECT mail FROM user where id=?";
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

    @Override
    public List<Abonnement> findBySessionAndUser(int id_user, int id_session) {
        List<Abonnement> list = new ArrayList<>();

		try {
			String requete = "select * from abonnement WHERE id_session=" + id_session + " and id_user="+id_user;
			PreparedStatement pst = cnx.prepareStatement(requete);
			cnx.prepareStatement(requete).executeQuery();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Abonnement(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5),getFirstName(rs.getInt(4)),getLastName(rs.getInt(4)),getEmail(rs.getInt(4))));
			}

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return list;
    }

}
