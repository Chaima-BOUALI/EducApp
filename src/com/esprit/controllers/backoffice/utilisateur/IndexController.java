/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.utilisateur;

import com.esprit.models.Utilisateur;
import com.esprit.services.impl.ServiceUtilisateurImpl;
import com.esprit.tests.PIDEVGUI;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author stef info
 */
public class IndexController implements Initializable {

    @FXML
    private TableView<Utilisateur> tvUtilisateur;
    @FXML
    private TableColumn<Utilisateur, String> Colusername;
    @FXML
    private TableColumn<Utilisateur, Integer> Colid;
    @FXML
    private TableColumn<Utilisateur, String> Colpassword;
    @FXML
    private TableColumn<Utilisateur, String> Colnom;
    @FXML
    private TableColumn<Utilisateur, String> Colsexe;
    @FXML
    private TableColumn<Utilisateur, String> ColnumCB;
    @FXML
    private TableColumn<Utilisateur, String> Colrole;
    @FXML
    private TableColumn<Utilisateur, String> Colemail;
    @FXML
    private TableColumn<Utilisateur, String> colnumTel;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnAnnuler;
        private ServiceUtilisateurImpl serviceUtilisateur=new ServiceUtilisateurImpl();
    private Utilisateur staticUtilisateur=new Utilisateur();
    DataSource DataSource; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList OL = FXCollections.observableArrayList(serviceUtilisateur.afficher());
        tvUtilisateur.setItems(OL);
        Colusername.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("username"));
       Colid.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("idUtilisateur"));
        Colpassword.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("motDePasse"));
        Colnom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        Colsexe.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("sexe"));
        ColnumCB.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("numCarteBancaire"));
        Colrole.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("role"));
        Colemail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adresseMail"));
        colnumTel.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("numTel"));
        
       
 
    }    




    @FXML
    private void Ajout(ActionEvent event) throws IOException {
         FormController form=new FormController();
        form.setStaticUtilisateur(null);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/utilisateur/Form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    @FXML
    private void Supprimer(ActionEvent event) {
          int reply = JOptionPane.showConfirmDialog(null, "Do you want delete this item?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            
            serviceUtilisateur.supprimer(staticUtilisateur);
            this.initialize(null, null);
            JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès !");
        }
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
     FormController form=new FormController();
        form.setStaticUtilisateur(FormController.staticUtilisateur);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/utilisateur/Form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
        }

    
    public static Utilisateur getStaticUtilisateur() {
        Utilisateur staticUtilisateur = null;
        return staticUtilisateur;
    }

    public static void setStaticUtilisateur(Utilisateur staticUtilisateur) {
        FormController.staticUtilisateur = staticUtilisateur;
    }

    

    @FXML
    private void Rechercher(KeyEvent event) {
        String rech = tfrecherche.getText();
        System.out.println(rech);
        ObservableList OL = FXCollections.observableArrayList(serviceUtilisateur.findByUsername(rech));
        tvUtilisateur.setItems(OL);
        
    }

    @FXML
    private void SelectItem(MouseEvent event) {
                staticUtilisateur = tvUtilisateur.getSelectionModel().getSelectedItem();
                System.out.println(staticUtilisateur);
    }


}
