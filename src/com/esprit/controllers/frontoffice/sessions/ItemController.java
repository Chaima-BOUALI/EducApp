/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.frontoffice.sessions;

import com.esprit.models.Abonnement;
import com.esprit.models.Session;
import com.esprit.services.impl.ServiceAbonnementImpl;
import com.esprit.tests.PIDEVGUI;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class ItemController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label description;
    @FXML
    private Label from;
    @FXML
    private Label to;
    private Session staticSession =new Session();
    private ServiceAbonnementImpl serviceAbonnement=new ServiceAbonnementImpl();
    @FXML
    private Button btnSubs;
    private boolean flag=false;
    @FXML
    private ImageView im;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     public void setData(Session get) {
         im.setVisible(false);
        nom.setText(get.getNom());
        description.setText(get.getDescription());
        description.setWrapText(true);
        from.setText("De "+get.getStartDate().toString());
        to.setText("à "+get.getEndDate().toString());
        staticSession=get;
        
        if(serviceAbonnement.findBySessionAndUser(1, staticSession.getId()).size()>0){
            btnSubs.setVisible(false);
            im.setVisible(true);
            flag=true;
            ByteArrayOutputStream out = QRCode.from("Abonnement pour [1"+staticSession.getId()+"]").to(ImageType.PNG).withSize(200, 200).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Image image = new Image(in);
        im.setImage(image);
        }
        else{
            btnSubs.setVisible(true);
            im.setVisible(false);
            flag=true;
        }
        //Image im = new Image(get.getUrl_image());
        //image.setImage(im);
    }
    @FXML
    private void subscribe(ActionEvent event) throws IOException {
       
        serviceAbonnement.ajouter(new Abonnement("Blue", 1, staticSession.getId()));
        JOptionPane.showMessageDialog(null, "Abonnement effectué avec succés  !");
         Parent root = FXMLLoader.load(getClass().getResource("../../../views/frontoffice/sessions/index.fxml"));
            Scene scene = new Scene(root);
            PIDEVGUI.pStage.setScene(scene);
            PIDEVGUI.pStage.show();
       

    }
    
}
