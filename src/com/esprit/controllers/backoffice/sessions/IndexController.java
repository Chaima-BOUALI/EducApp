/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.sessions;

import com.esprit.models.Abonnement;
import com.esprit.models.Category;
import com.esprit.models.Session;
import com.esprit.services.impl.ServiceAbonnementImpl;
import com.esprit.services.impl.ServiceSessionImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class IndexController implements Initializable {
    @FXML
    private TextField tfrecherche;
    @FXML
    private TableView<Session> sessions;
    @FXML
    private TableColumn<Session, String> nom;
    @FXML
    private TableColumn<Session, Date> start_Date;
    @FXML
    private TableColumn<Session, Date> end_Date;
    @FXML
    private TableColumn<Session, Integer> place_disponible;
    @FXML
    private TableColumn<Session, String> category;
    @FXML
    private ImageView image;
    @FXML
    private Label description;
    
    @FXML
    private TableView<Abonnement> users;
    @FXML
    private TableColumn<Abonnement, String> user_nom;
    @FXML
    private TableColumn<Abonnement, String> user_prenom;
    @FXML
    private TableColumn<Abonnement, String> user_mail;
    
    private ServiceSessionImpl serviceSession=new ServiceSessionImpl();
    private ServiceAbonnementImpl serviceAbonnement=new ServiceAbonnementImpl();
    
    private Session staticSession=new Session();
    private List<Abonnement> staticAbonnements=new ArrayList<>();
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList OL = FXCollections.observableArrayList(serviceSession.afficher());
        sessions.setItems(OL);
        nom.setCellValueFactory(new PropertyValueFactory<Session, String>("nom"));
        category.setCellValueFactory(new PropertyValueFactory<Session, String>("catgeory"));
        start_Date.setCellValueFactory(new PropertyValueFactory<Session, Date>("startDate"));
        end_Date.setCellValueFactory(new PropertyValueFactory<Session, Date>("endDate"));
        place_disponible.setCellValueFactory(new PropertyValueFactory<Session, Integer>("placeDisponible"));    
        staticSession=serviceSession.afficher().get(0);
        description.setText(staticSession.getDescription());
        description.setWrapText(true);
        //Image im = new Image(staticSession.getUrl_image());
        //image.setImage(im);
        
        staticAbonnements=serviceAbonnement.findBySession(staticSession.getId());
        ObservableList OL1 = FXCollections.observableArrayList(staticAbonnements);
        users.setItems(OL1);
        user_nom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("nom"));
        user_prenom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("prenom"));
        user_mail.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("email"));
    }    

    @FXML
    private void SelectItem(MouseEvent event) {
        staticSession = sessions.getSelectionModel().getSelectedItem();
        description.setText(staticSession.getDescription());
        //Image im = new Image(staticSession.getUrl_image());
        //image.setImage(im);
        staticAbonnements=serviceAbonnement.findBySession(staticSession.getId());
        ObservableList OL1 = FXCollections.observableArrayList(staticAbonnements);
        users.setItems(OL1);
        user_nom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("nom"));
        user_prenom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("prenom"));
        user_mail.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("email"));
    }


    @FXML
    private void Delete(ActionEvent event) {
         int reply = JOptionPane.showConfirmDialog(null, "Do you want delete this item?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            
            serviceSession.supprimer(staticSession);
            this.initialize(null, null);
            JOptionPane.showMessageDialog(null, "Session supprimée !");
        }
    }

    @FXML
    private void Edit(ActionEvent event) throws IOException {
         FormController form=new FormController();
        form.setStaticSession(staticSession);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/sessions/form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    @FXML
    private void Search(KeyEvent event) {
        String rech=tfrecherche.getText(); 
        ObservableList OL = FXCollections.observableArrayList(serviceSession.findByName(rech));
        sessions.setItems(OL);
        
        if(serviceSession.findByName(rech).size()>0){
        staticSession=serviceSession.findByName(rech).get(0);
        staticAbonnements=serviceAbonnement.findBySession(staticSession.getId());
        ObservableList OL1 = FXCollections.observableArrayList(staticAbonnements);
        users.setItems(OL1);
        user_nom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("nom"));
        user_prenom.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("prenom"));
        user_mail.setCellValueFactory(new PropertyValueFactory<Abonnement, String>("email"));
        }
       
    }

    @FXML
    private void redirectTonewSession(ActionEvent event) throws IOException {
        FormController form=new FormController();
        form.setStaticSession(null);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/sessions/form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
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
