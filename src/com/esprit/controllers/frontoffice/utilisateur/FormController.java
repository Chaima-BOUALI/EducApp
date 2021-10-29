/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.frontoffice.utilisateur;

import static com.esprit.controllers.backoffice.utilisateur.FormController.staticSignin;
import com.esprit.models.Signin;
import com.esprit.models.Utilisateur;
import com.esprit.services.impl.ServiceSigninImpl;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author stef info
 */
public class FormController implements Initializable {

    @FXML
    private TextField tflogin;
    @FXML
    private PasswordField pfpassword;
    @FXML
    private Button btnSignIN;
    
    DataSource DateSource; 
    private ServiceSigninImpl serviceSignin=new ServiceSigninImpl();
    @FXML
    private Text ltitre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  if (com.esprit.controllers.backoffice.utilisateur.FormController.staticSignin != null) {
            ltitre.setText(" Sign in");
            tflogin.setText(com.esprit.controllers.backoffice.utilisateur.FormController.staticSignin.getText());
            pfpassword.setText(staticSignin.getText());
    }    

    }
    @FXML
    private void SignIN(ActionEvent event) throws IOException {
        if (checkFields()) {

            serviceSignin.ajouter(new Signin(tflogin.getText(), pfpassword.getText()));
            JOptionPane.showMessageDialog(null, "Signed in successfully  !");
        }

        Parent root = FXMLLoader.load(getClass().getResource("../../../views/frontoffice/utilisateur/Form.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

  
    

    private boolean checkFields() {
  ltitre.setVisible(false);
        Boolean isvalid = true;
        if (tflogin.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        if (pfpassword.getText().isEmpty()) {
            ltitre.setVisible(true);
            isvalid = false;
        }
        return isvalid;
    }
    
    public static Signin getStaticSignin() {
        Signin staticSignin = null;
        return staticSignin;
    }

    public static void setStaticSignin (Signin staticSignin) {
        com.esprit.controllers.backoffice.utilisateur.FormController.staticSignin = staticSignin;
    }
    
}
