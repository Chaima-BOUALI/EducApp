/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.sessions;

import com.esprit.models.Session;
import com.esprit.services.impl.ServiceCategoryImpl;
import com.esprit.services.impl.ServiceSessionImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.UUID;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    private ComboBox<String> cbCategory;
    @FXML
    private DatePicker datepickerfrom;
    @FXML
    private DatePicker datepickerto;
    @FXML
    private Label ltitre;
    @FXML
    private ImageView ImagePub;
    @FXML
    private TextField Imagepath;
    @FXML
    private Label nomError;
    @FXML
    private Label categoryError;
    @FXML
    private Label descriptionError;
    @FXML
    private Label imageerror;

    private static Session staticSession=new Session();
    private ServiceSessionImpl serviceSession=new ServiceSessionImpl();
        private ServiceCategoryImpl serviceCategory=new ServiceCategoryImpl();


    String filename="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbCategory.getItems().addAll(serviceCategory.getCategoryNameAndId());
        nomError.setVisible(false);
        categoryError.setVisible(false);
        descriptionError.setVisible(false);
        imageerror.setVisible(false);
        if(staticSession!=null){
            filename=staticSession.getUrl_image();
            ltitre.setText("Modifier une session");
            tfNom.setText(staticSession.getNom());
            tfDescription.setText(staticSession.getDescription());
            datepickerfrom.setValue(staticSession.getStartDate().toLocalDate());
            datepickerto.setValue(staticSession.getEndDate().toLocalDate());
            if (staticSession.getId_category()!= 0) {
            cbCategory.setValue(staticSession.getId_category()+ "-" + staticSession.getCatgeory());
            }
           //Image im = new Image("http://localhost/educapp/sessions/" + filename);
            //ImagePub.setImage(im);
        }
        
    }    

    @FXML
    private void SaveSession(ActionEvent event) throws IOException {
        if(this.checkFields()){
            int categorie_id = Integer.valueOf(cbCategory.getValue().substring(0, cbCategory.getValue().indexOf("-")));
            
            if (staticSession == null) {     
            serviceSession.ajouter(new Session(Date.valueOf(datepickerfrom.getValue()), Date.valueOf(datepickerto.getValue()), tfNom.getText(), 10, tfDescription.getText(), filename, categorie_id));
            JOptionPane.showMessageDialog(null, "Session ajoutée !");
        }else{
            serviceSession.modifier(new Session(staticSession.getId(),Date.valueOf(datepickerfrom.getValue()), Date.valueOf(datepickerto.getValue()), tfNom.getText(), 10, tfDescription.getText(), filename, categorie_id));
            JOptionPane.showMessageDialog(null, "Session modifiée !");
        }
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/sessions/index.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();

        }
    }

    @FXML
    private void OpenFileMan(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            filename = UUID.randomUUID().toString() + ".png";

            Imagepath.setText(file.getAbsolutePath());
            Path source = Paths.get(Imagepath.getText());
            Path dest = Paths.get("C:\\wamp64\\www\\educapp\\sessions\\" + filename);
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
            //Image im = new Image("http://localhost/educapp/sessions/" + filename);
            //ImagePub.setImage(im);
        }
    }
    
      public boolean checkFields() {
        nomError.setVisible(false);
        categoryError.setVisible(false);
        descriptionError.setVisible(false);
        imageerror.setVisible(false);
        Boolean isvalid = true;
        if (tfNom.getText().isEmpty()) {
            nomError.setVisible(true);
            isvalid = false;
        }
        if (tfDescription.getText().isEmpty()) {
            descriptionError.setVisible(true);
            isvalid = false;
        }
        if (cbCategory.getValue() == null) {
            categoryError.setVisible(true);
            isvalid = false;
        }
        if (filename.isEmpty()) {
            imageerror.setVisible(true);
            isvalid = false;

        }

        return isvalid;
    }

    public static Session getStaticSession() {
        return staticSession;
    }

    public static void setStaticSession(Session staticSession) {
        FormController.staticSession = staticSession;
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
