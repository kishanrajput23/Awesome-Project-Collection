/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood.management;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Wipro
 */
public class Mainpage implements Initializable {

    @FXML
    private BorderPane rootLayout;
    @FXML
    private Button dnor;
    @FXML
    private Button reciever;
    @FXML
    private Button doctor;
    @FXML
    private Button employee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        changeScene("AddbloodSence.fxml");   // TODO
    }    

    @FXML
    private void addDonor(ActionEvent event) {
        changeScene ("AddbloodSence.fxml");
    }

    @FXML
    private void setReciever(ActionEvent event) {
        changeScene ("bloodRecieversence.fxml");
    }

    @FXML
    private void setdoctor(ActionEvent event) {
        changeScene ("Doctor.fxml");
    }

    @FXML
    private void setEmployee(ActionEvent event) {
        changeScene ("Employee.fxml");
    }

    private void setTrasaction(ActionEvent event) {
        changeScene ("Transaction.fxml");
    }
     public  void changeScene(String scenePath){
        
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource(scenePath));
        AnchorPane pane = new AnchorPane();
           
    try{
            pane = (AnchorPane) loader.load();
            rootLayout.setCenter(pane);
        }
        catch(Exception e){

        }
     
    }

    @FXML
    private void setavailableScene(ActionEvent event) {
     changeScene ("AvailableSence.fxml");
    }
}
