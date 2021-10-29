/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.frontoffice.ressource;

import com.esprit.controllers.backoffice.seance.FormController;
import com.esprit.models.Ressource;
import com.esprit.models.Seance;
import com.esprit.services.impl.ServiceRessourceImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author 21650
 */
public class IndexController implements Initializable {

    public IndexController() {
    }

    private static Ressource staticRessource;

    @FXML
    private TextField tfRechercher;
    @FXML
    private Label lTitre;
    @FXML
    private TableView<Ressource> tvARessource;
    @FXML
    private TableColumn<Ressource, String> colnom;
    @FXML
    private TableColumn<Ressource, String> colIdRessource;
    @FXML
    private TableColumn<Ressource, String> colTypeRessource;
    @FXML
    private TableColumn<Ressource, String> colUrl;
    
       private ServiceRessourceImpl serviceRessource=new ServiceRessourceImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList OL = FXCollections.observableArrayList(serviceRessource.afficher());
         tvARessource.setItems(OL);
        colnom.setCellValueFactory(new PropertyValueFactory<Ressource, String>("nom"));
        colIdRessource.setCellValueFactory(new PropertyValueFactory<Ressource, String>("idRessource"));
        colTypeRessource.setCellValueFactory(new PropertyValueFactory<Ressource, String >("typeRessource"));
        colUrl.setCellValueFactory(new PropertyValueFactory<Ressource, String >("url"));
       staticRessource=serviceRessource.afficher().get(0);
    }    

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
         IndexController form=new IndexController();
        form.setStaticRessource(null);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/ressource/form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }
     public static Ressource getStaticRessource() {
        Ressource staticRessource = null;
        return staticRessource;
    }

    public static void setStaticRessource(Ressource staticRessource) {
                FormController.staticRessource = staticRessource;

    }
    @FXML
    private void Rechercher(KeyEvent event) {
        String rech=tfRechercher.getText(); 
        System.out.println(rech);
        ObservableList OL = FXCollections.observableArrayList(serviceRessource.findByName(rech));
        tvARessource.setItems(OL);
    }
}

