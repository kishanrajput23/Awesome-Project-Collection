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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Wipro
 */
public class Doctor implements Initializable {

    @FXML
    private TextField dName;
    @FXML
    private TextField dContact;
    @FXML
    private Button addBtn;
    @FXML
    private TableView<?> dTableView;
    @FXML
    private TextField dAddress;
   
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      displayDoctor.buildData(dTableView, "Select * from DoctorTable Order By(Id) desc;");  
    }    

    String name="";
    String contact="";
    String address="";
     DisplayDatabase displayDoctor = new DisplayDatabase();
     
    @FXML
    private void addDoctor(ActionEvent event) {
        name = dName.getText();
        contact = dContact.getText();
        address = dAddress.getText();
        
         if(name==null || name.isEmpty()){
        dName.requestFocus();
        return;
        }
         if(contact==null || contact.isEmpty()){
        dContact.requestFocus();
        return;
        }
         if(address==null || address.isEmpty()){
        dAddress.requestFocus();
        return;
        }
         
         Connection c;
         try{
            c = DBConnection.connect();
            
            String query = "insert into Doctortable (Name,Contact,Address) values ('"+name+"','"+contact+"','"+address+"');";
            c.createStatement().execute(query);
            c.close();
            
            dName.clear();
            dContact.clear();
            dAddress.clear();
            displayDoctor.buildData(dTableView, "Select * from DoctorTable Order By(Id) desc;");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
         
    }

    @FXML
    private void mDeleteDoc(ActionEvent event) {
        
        int index = dTableView.getSelectionModel().getSelectedIndex();
        ObservableList<ObservableList> data = displayDoctor.getData();
        ObservableList<String> row = data.get(index);
        DeleteDatabase.deleteRecord(Integer.parseInt(row.get(0)), "DoctorTable");
        displayDoctor.buildData(dTableView, "Select * from DoctorTable Order By(Id) desc;");
    }
    
}
