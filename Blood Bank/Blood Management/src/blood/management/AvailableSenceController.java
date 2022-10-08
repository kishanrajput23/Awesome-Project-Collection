/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood.management;

import DB.DisplayDatabase;
import DB.QueryDatabase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Wipro
 */
public class AvailableSenceController implements Initializable {

   
    @FXML
    private TableView<?> bTableView;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         DisplayDatabase displayBlood = new DisplayDatabase();
    
      displayBlood.buildData(bTableView, "Select * from inventoryTable;");
        
    }    

    
   
    
        
      
   
    
}
