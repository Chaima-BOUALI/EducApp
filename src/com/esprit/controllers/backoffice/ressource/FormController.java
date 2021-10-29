/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.ressource;

import com.esprit.models.Ressource;
import com.esprit.services.impl.ServiceRessourceImpl;
import com.esprit.tests.PIDEVGUI;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 21650
 */
public class FormController implements Initializable {

    static Ressource staticRessource ;
    @FXML
    private Label lTitre;
    @FXML
    private TextField tfNom;
    @FXML
    private ComboBox cbTypeRessource;
    @FXML
    private TextField tfUrl;
    @FXML
    private TextField tfIdSeance;
    @FXML
    private Button btnEnregistrer;

      private ServiceRessourceImpl serviceRessource=new ServiceRessourceImpl();
      
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cbTypeRessource.getItems().addAll("cours","tp","vidéo","quiz");
         if(staticRessource!=null){
         lTitre.setText("Modifier une Ressource ");
         tfNom.setText(staticRessource.getNom());
               tfUrl.setText(staticRessource.getUrl());
         tfIdSeance.setText(staticRessource.getIdSeance()+"");
         cbTypeRessource.setValue(staticRessource.getTypeRessource());
         }
    }    

    @FXML
    private void saveRessource(ActionEvent event) throws IOException {
      
           
       if (staticRessource == null) {     
            serviceRessource.ajouter(new Ressource(tfNom.getText(), cbTypeRessource.getValue().toString(), tfUrl.getText(), Integer.parseInt(tfIdSeance.getText())));
            JOptionPane.showMessageDialog(null, "Ressource ajoutée avec succès!");
        
    }else{serviceRessource.modifier(new Ressource(tfNom.getText(), staticRessource.getIdRessource(), cbTypeRessource.getValue().toString(), tfUrl.getText(), Integer.parseInt(tfIdSeance.getText())));
            JOptionPane.showMessageDialog(null, "Ressource modifiée avec succès!");}
        
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/ressource/index.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
       }

    public static Ressource getStaticRessource() {
        return staticRessource;
    }

    public static void setStaticRessource(Ressource staticRessource) {
        FormController.staticRessource = staticRessource;
    }

   
    }
        
   

   


