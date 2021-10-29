/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.ressource;

import com.esprit.models.Ressource;
import com.esprit.services.impl.ServiceRessourceImpl;
import com.esprit.tests.PIDEVGUI;
import com.esprit.utils.DataSource;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 21650
 */
public class IndexController implements Initializable {

    @FXML
    private Label lTitre;
    @FXML
    private Button btnModifier;
    @FXML
    private TableView<Ressource> tvRessource;
    @FXML
    private TableColumn<Ressource, String> colnom;
    @FXML
    private TableColumn<Ressource, Integer> colIdRessource;
    @FXML
    private TableColumn<Ressource, String> colTypeRessource;
    @FXML
    private TableColumn<Ressource, String> colUrl;
    @FXML
    private TableColumn<Ressource, Integer> colIdSeance;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button btnSupprimer;

        private static Ressource staticRessource;

     private ServiceRessourceImpl serviceRessource=new ServiceRessourceImpl();
      
    DataSource DataSource;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList OL = FXCollections.observableArrayList(serviceRessource.afficher());
         tvRessource.setItems(OL);
        colnom.setCellValueFactory(new PropertyValueFactory<Ressource, String>("nom"));
       colIdRessource.setCellValueFactory(new PropertyValueFactory<Ressource, Integer>("IdRessource"));
       colTypeRessource.setCellValueFactory(new PropertyValueFactory<Ressource, String>("TypeRessource"));
       colUrl.setCellValueFactory(new PropertyValueFactory<Ressource, String>("Url"));
       colIdSeance.setCellValueFactory(new PropertyValueFactory<Ressource, Integer>("IdSeance"));
       staticRessource=serviceRessource.afficher().get(0);
       
    }    

    @FXML
    private void Modifier (ActionEvent event) throws IOException {
         FormController form=new FormController();
        form.setStaticRessource(staticRessource);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/Ressource/Form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        
         int reply = JOptionPane.showConfirmDialog(null, "Do you want delete this item?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            
            serviceRessource.supprimer(staticRessource);
            this.initialize(null, null);
            JOptionPane.showMessageDialog(null, "Ressource supprimée !");
            this.initialize(null, null);
    }
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
         String rech=tfrecherche.getText();
        ObservableList OL = FXCollections.observableArrayList(serviceRessource.findByName(rech));
        tvRessource.setItems(OL);
                 
    }
         @FXML
    private void SelectItem(MouseEvent event) {
        staticRessource = tvRessource.getSelectionModel().getSelectedItem();
             System.out.println("aaaa");
    }
}
