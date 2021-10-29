/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.sessions;

import com.esprit.models.Session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class ItemController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label nom;
    @FXML
    private Label description;
    @FXML
    private Label from;
    @FXML
    private Label to;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setData(Session get) {
        nom.setText(get.getNom());
        description.setWrapText(true);
        description.setText(get.getDescription());
        from.setText("De "+get.getStartDate().toString());
        to.setText("à "+get.getEndDate().toString());
        //Image im = new Image(get.getUrl_image());
        //image.setImage(im);
    }
    
}
