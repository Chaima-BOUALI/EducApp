/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.category;

import com.esprit.controllers.backoffice.sessions.ItemController;
import com.esprit.models.Category;
import com.esprit.models.Session;
import com.esprit.services.impl.ServiceCategoryImpl;
import com.esprit.services.impl.ServiceSessionImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class IndexController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private TableColumn<Category, String> nom;
    @FXML
    private TextField tfrecherche;
    @FXML
    private ScrollPane scroll;
    @FXML
    private TableView<Category> categories;
    
    private ServiceCategoryImpl serviceCategory=new ServiceCategoryImpl();
    private ServiceSessionImpl serviceSession=new ServiceSessionImpl();

    static Category staticCategory=new Category();
    static List<Session> staticSessions=new ArrayList<Session>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList OL = FXCollections.observableArrayList(serviceCategory.afficher());
        categories.setItems(OL);
        nom.setCellValueFactory(new PropertyValueFactory<Category, String>("nom"));
        staticCategory=serviceCategory.afficher().get(0);
        staticSessions=serviceSession.findByCategory(staticCategory.getId());
        setGridChildren();
       
    }    

    @FXML
    private void SelectItem(MouseEvent event) {
          staticCategory = categories.getSelectionModel().getSelectedItem();
          staticSessions=serviceSession.findByCategory(staticCategory.getId());
          setGridChildren();
    }


    @FXML
    private void Delete(ActionEvent event) {
         int reply = JOptionPane.showConfirmDialog(null, "Do you want delete this item?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            
            serviceCategory.supprimer(staticCategory);
            this.initialize(null, null);
            JOptionPane.showMessageDialog(null, "Categorie supprimée !");
        }
    }
    
    
    @FXML
    private void redirectTonewCategorie(ActionEvent event) throws IOException {
        FormController form=new FormController();
        form.setStaticCategory(null);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/category/form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
    }
    

    @FXML
    private void Edit(ActionEvent event) throws IOException {
         if (staticCategory.getId() != 0) {
            FormController form=new FormController();
            form.setStaticCategory(staticCategory);
            Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/category/form.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
         }
    }

    @FXML
    private void Search(KeyEvent event) {
        String rech=tfrecherche.getText(); 
        ObservableList OL = FXCollections.observableArrayList(serviceCategory.findByName(rech));
        categories.setItems(OL);
        if(serviceCategory.findByName(rech).size()>0){
            staticCategory=serviceCategory.findByName(rech).get(0);
            staticSessions=serviceSession.findByCategory(staticCategory.getId());
            setGridChildren();
        }
        else{
            grid.getChildren().clear();
        }
    }

    public void setGridChildren(){
         grid.getChildren().clear();
         try {
             int column = 0;
             int row = 1;
            for (int i = 0; i < staticSessions.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../../views/backoffice/sessions/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(staticSessions.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
