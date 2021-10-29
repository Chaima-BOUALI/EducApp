/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.seance;

import com.esprit.models.Ressource;
import com.esprit.models.Seance;
import com.esprit.services.impl.ServiceSeanceImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 21650
 */
public class FormController implements Initializable {

    static Seance staticSeance;
    public static Ressource staticRessource;

    @FXML
    private Label lTitre;
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button btnEenregistrer;
    
    private ServiceSeanceImpl serviceSeance = new ServiceSeanceImpl();
   
    @FXML
    private TextField tfid;
    @FXML
    private Button btnDROP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (staticSeance != null) {
            lTitre.setText("Séance");
            tfnom.setText(staticSeance.getNom());
            tfid.setText(staticSeance.getIdSeance()+"");
            datePicker.setValue(staticSeance.getDateSeance().toLocalDate());
        }
    }

    @FXML
    private void saveSeance(ActionEvent event) throws IOException {
         if (staticSeance == null)  {
            serviceSeance.ajouter(new Seance(Integer.parseInt(tfid.getText()),tfnom.getText(),(Date.valueOf(datePicker.getValue()))));
            JOptionPane.showMessageDialog(null, "Séance ajoutée avec succès!");

        } 
        else {
            serviceSeance.modifier(new Seance(staticSeance.getIdSeance(),tfnom.getText(), (Date.valueOf(datePicker.getValue()))));
            JOptionPane.showMessageDialog(null, "Séance modifiée avec succès!");
        }

        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/seance/form.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

    public static Seance getStaticSeance() {
        Seance staticSeance = null;
        return staticSeance;
    }

    public static void setStaticSeance(Seance staticSeance) {
        com.esprit.controllers.backoffice.seance.FormController.staticSeance = staticSeance;
    }

    private boolean checkfields() {
 lTitre.setVisible(false);
        tfnom.setVisible(false);
        Boolean isvalid = true;
        if (tfnom.getText().isEmpty()) {
            lTitre.setVisible(true);
            isvalid = false;
        }
        return isvalid;
    }

    @FXML
    private void Retourversindex(ActionEvent event) throws IOException {
         FormController form = new com.esprit.controllers.backoffice.seance.FormController();
        form.setStaticSeance(staticSeance);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/seance/index.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

    
}
