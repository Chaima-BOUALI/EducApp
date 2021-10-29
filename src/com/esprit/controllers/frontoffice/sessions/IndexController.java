/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.frontoffice.sessions;

import com.esprit.models.Session;
import com.esprit.services.impl.ServiceCategoryImpl;
import com.esprit.services.impl.ServiceSessionImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jdk.nashorn.internal.objects.NativeArray;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class IndexController implements Initializable {

    @FXML
    private TextField tfrecherche;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private ServiceSessionImpl serviceSession=new ServiceSessionImpl();
    private ServiceCategoryImpl serviceCategory=new ServiceCategoryImpl();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
             
             int row = 1;
            for (int i = 0; i < serviceCategory.afficher().size(); i++) {
                
                

                if(serviceSession.findByCategory(serviceCategory.afficher().get(i).getId()).size()!=0){
                    int column = 1;
                    Label l =new Label();
                    l.setText(serviceCategory.afficher().get(i).getNom());
                    l.setTextFill(Color.web("red"));
                    l.setUnderline(true);
                     grid.add(l,0,row);
                     row++;

                       for(Session session : serviceSession.findByCategory(serviceCategory.afficher().get(i).getId())){
                           FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../../views/frontoffice/sessions/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                    ItemController itemController = fxmlLoader.getController();
                itemController.setData(session);
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
              
                row++;

                }
               
                
                

            }
        } catch (IOException e) {
              System.out.println( e.getMessage());
        }
    }    

  
    
}
