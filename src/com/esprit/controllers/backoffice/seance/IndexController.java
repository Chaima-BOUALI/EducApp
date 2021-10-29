/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers.backoffice.seance;

import static com.esprit.controllers.backoffice.seance.FormController.staticSeance;
import com.esprit.models.Seance;
import com.esprit.services.impl.ServiceSeanceImpl;
import com.esprit.tests.PIDEVGUI;
import com.esprit.utils.DataSource;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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

    private static Seance staticSeance;

    @FXML
    private TableView<Seance> tvASeance;
    @FXML
    private TableColumn<Seance, String> colnom;
    @FXML
    private TableColumn<Seance, Integer> colidSeance;
    @FXML
    private TableColumn<Seance, String> coldatePicker;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField tfrecherche;

    private ServiceSeanceImpl serviceSeance = new ServiceSeanceImpl();
    DataSource DataSource;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList OL = FXCollections.observableArrayList(serviceSeance.afficher());
        tvASeance.setItems(OL);
        colidSeance.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("idSeance"));
        colnom.setCellValueFactory(new PropertyValueFactory<Seance, String>("nom"));
        coldatePicker.setCellValueFactory(new PropertyValueFactory<Seance, String>("dateSeance"));

    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        FormController form = new com.esprit.controllers.backoffice.seance.FormController();
        form.setStaticSeance(staticSeance);
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/backoffice/seance/form.fxml"));
        Scene scene = new Scene(root);
        PIDEVGUI.pStage.setScene(scene);
        PIDEVGUI.pStage.show();
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        int reply = JOptionPane.showConfirmDialog(null, "Do you want delete this item?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            serviceSeance.supprimer(staticSeance);
            JOptionPane.showMessageDialog(null, "Séance  supprimée avec succès!");
                    this.initialize(null, null);

        }
        
    }

    public static Seance getStaticSeance() {
        Seance staticSeance = null;
        return staticSeance;
    }

    public static void setStaticSeance(Seance staticSeance) {
        com.esprit.controllers.backoffice.seance.IndexController.staticSeance = staticSeance;
    }

    @FXML
    private void SelectItem(MouseEvent event) {
        Seance staticSeance = tvASeance.getSelectionModel().getSelectedItem();
        System.out.println(staticSeance);
    }

    @FXML
    private void Rechercher(KeyEvent event) {
        String rech=tfrecherche.getText(); 
        System.out.println(rech);
        ObservableList OL = FXCollections.observableArrayList(serviceSeance.findByName(rech));
        tvASeance.setItems(OL);
    }
}
