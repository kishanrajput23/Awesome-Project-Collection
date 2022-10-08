/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood.management;

import DB.DBConnection;
import DB.DeleteDatabase;
import DB.DisplayDatabase;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wipro
 */
public class EmployeeController implements Initializable {

    @FXML
    private TextField eName;
    @FXML
    private TextField eId;
    @FXML
    private TextField eContact;
    @FXML
    private Button addBtn;
    @FXML
    private TableView<?> eTableView
;
    /**
     * Initializes the controller class.
     * 
     */ String name="";
        String eid="";
        String contact="";
    DisplayDatabase displayEmp = new DisplayDatabase();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayEmp.buildData(eTableView, "Select * from emptable;");
    }    
    
    
    @FXML
    private void addEmployee(ActionEvent event) {
        
        
        eid = eId.getText();
        name = eName.getText();
        contact = eContact.getText();
  
     if(eid==null || eid.isEmpty()){
        eId.requestFocus();
        return;
     }
     
       if(name==null || name.isEmpty()){
        eName.requestFocus();
        return;
        }
        if(contact==null || contact.isEmpty()){
        eContact.requestFocus();
        return;
        }
        
        Connection c;
         try{
            c = DBConnection.connect();
            
            String query = "insert into EMPTable (Name,EID,CONTACT) values ('"+name+"','"+eid+"','"+contact+"');";
            c.createStatement().execute(query);
            c.close();
            
            eId.clear();
            eName.clear();
            eContact.clear();
            
    
         } catch (SQLException ex) {
              Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        displayEmp.buildData(eTableView, "Select * from emptable;");
    }

    @FXML
    private void DeleteEmployee(ActionEvent event) {
        int index = eTableView.getSelectionModel().getSelectedIndex();
         ObservableList data = displayEmp.getData();
         ObservableList<String> items = (ObservableList) data.get(index);
         DeleteDatabase.deleteRecord(Integer.parseInt(items.get(0)), "emptable");
         
         displayEmp.buildData(eTableView, "Select * from emptable;");
    }
    
}

