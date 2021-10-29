/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.utilisateur;

import com.esprit.models.Signin;
import com.esprit.models.Utilisateur;
import com.esprit.services.impl.ServiceUtilisateurImpl;
import com.esprit.tests.PIDEVGUI;
import com.esprit.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author stef info
 */
public class FormController implements Initializable {

    static Utilisateur staticUtilisateur;
    public static Signin staticSignin;

    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfpassword;
    @FXML
    private TextField tfnum;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfprenom;
    @FXML
    private Button btnSaveUtilisateur;
    @FXML
    private Button btnGOBACK;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField tfsexe;
    @FXML
    private TextField tfnumCB;
    @FXML
    private TextField tfrole;
    
    
    @FXML
    private Text ltitre;
    
    DataSource DataSource; 
   /* private static Utilisateur staticUtilisateur=new Utilisateur();*/
    private ServiceUtilisateurImpl serviceUtilisateur=new ServiceUtilisateurImpl();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (staticUtilisateur != null) {
            ltitre.setText(" Ajouter un utilisateur");
            tfusername.setText(staticUtilisateur.getUsername());
            tfid.setText(staticUtilisateur.getText());
            tfnum.setText(staticUtilisateur.getNumTel());
            tfnom.setText(staticUtilisateur.getNom());
            tfemail.setText(staticUtilisateur.getAdresseMail());
            tfprenom.setText(staticUtilisateur.getPrenom());
            tfsexe.setText(staticUtilisateur.getSexe());
            tfnumCB.setText(staticUtilisateur.getNumCarteBancaire());
            tfrole.setText(staticUtilisateur.getRole());

        }
    }

    @FXML
    private void SaveUtilisateur(ActionEvent event) throws IOException {
        if (checkFields()) {

            serviceUtilisateur.ajouter(new Utilisateur(0, tfusername.getText(), tfid.getText(), tfnom.getText(), tfprenom.getText(), tfemail.getText(), tfsexe.getText(), tfnumCB.getText(), tfnum.getText(), tfrole.getText()));
            JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès !");
        }

        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/utilisateur/Form.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

    @FXML
    private void GOBACK(ActionEvent event) throws IOException {
         FormController form=new FormController();
        form.setStaticUtilisateur(FormController.staticUtilisateur);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/utilisateur/Index.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
     FormController form=new FormController();
        form.setStaticUtilisateur(FormController.staticUtilisateur);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/frontoffice/utilisateur/Form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    private boolean checkFields() {
        ltitre.setVisible(false);
        Boolean isvalid = true;
        if (tfnom.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        if (tfprenom.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        return isvalid;
}

    public static Utilisateur getStaticUtilisateur() {
        Utilisateur staticUtilisateur = null;
        return staticUtilisateur;
    }

    public static void setStaticUtilisateur(Utilisateur staticUtilisateur) {
        FormController.staticUtilisateur = staticUtilisateur;
    }
}

