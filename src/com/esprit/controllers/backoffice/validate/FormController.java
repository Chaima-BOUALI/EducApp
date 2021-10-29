/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.validate;

import com.esprit.models.Validate;
import com.esprit.services.impl.ServiceValidateImpl;
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

    private static Validate staticValidate;

    private TextField tfNom;

    @FXML
    private Button btnvalidate;
    @FXML
    private Button btnDrop;

    /* private static Validate staticValidate=new Validate();*/
    private ServiceValidateImpl serviceValidate = new ServiceValidateImpl();
    @FXML
    private Text ltitre;
    @FXML
    private TextField tfvalidate;
    DataSource DataSource;
    @FXML
    private TextField tfUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (checkFields()) {
        if (staticValidate != null) {
            ltitre.setText("Consulter la validité du paiement ");
            tfUsername.setText(staticValidate.getUsername());
            tfvalidate.setText(staticValidate.getValidate());
        }
    }
    }

    @FXML
    private void SaveValidate(ActionEvent event) throws IOException {
        serviceValidate.ajouter(new Validate(tfvalidate.getText(), tfvalidate.getText()));
        JOptionPane.showMessageDialog(null, "Utilisateur validé avec succès !");
 Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/validate/Form.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

    @FXML
    private void DropValidate(ActionEvent event) throws IOException {
        com.esprit.controllers.backoffice.validate.FormController form=new com.esprit.controllers.backoffice.validate.FormController();
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/frontoffice/utilisateur/Form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();

    }

    public static Validate getStaticValidate() {
        Validate staticValidate = null;
        return staticValidate;
    }

    public static void setStaticValidate(Validate staticValidate) {
        FormController.staticValidate = staticValidate;
    }

    private boolean checkFields() {
 ltitre.setVisible(false);
        Boolean isvalid = true;
        if (tfUsername.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        if (tfvalidate.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        return isvalid;
    }

}
