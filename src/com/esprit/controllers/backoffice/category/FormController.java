/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.category;

import com.esprit.models.Category;
import com.esprit.services.impl.ServiceCategoryImpl;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class FormController implements Initializable {

    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfNom;
    @FXML
    private Label ltitre;
    @FXML
    private ImageView ImagePub;
    @FXML
    private TextField Imagepath;
    @FXML
    private Label nomError;
    @FXML
    private Label descriptionError;
    
    private ServiceCategoryImpl serviceCategory=new ServiceCategoryImpl();
    private static Category staticCategory=new Category();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomError.setVisible(false);
        descriptionError.setVisible(false);
         if (staticCategory != null) {
            ltitre.setText("Modifier une categorie");
            tfNom.setText(staticCategory.getNom());
            tfDescription.setText(staticCategory.getDescription());
        }
    }    

    @FXML
    private void SaveCategory(ActionEvent event) throws IOException {
        if(checkFields()){
            if (staticCategory != null) {
                serviceCategory.modifier(new Category(staticCategory.getId(),tfNom.getText(),tfDescription.getText()));
                JOptionPane.showMessageDialog(null, "Categorie modifié !");
            } else {
                serviceCategory.ajouter(new Category(tfNom.getText(),tfDescription.getText()));
                JOptionPane.showMessageDialog(null, "Categorie ajouté !");
            }

            Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/category/index.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();   
        }
       
    }

    public static Category getStaticCategory() {
        return staticCategory;
    }

    public static void setStaticCategory(Category staticCategory) {
        FormController.staticCategory = staticCategory;
    }

    public boolean checkFields() {
        nomError.setVisible(false);
        descriptionError.setVisible(false);
        Boolean isvalid = true;
        if (tfNom.getText().isEmpty()) {
            nomError.setVisible(true);
            isvalid = false;
        }
        if (tfDescription.getText().isEmpty()) {
            descriptionError.setVisible(true);
            isvalid = false;
        }
        return isvalid;
    }

    @FXML
    private void ToSessionIndex(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/sessions/index.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    @FXML
    private void ToCategoryIndex(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/category/index.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }
}
