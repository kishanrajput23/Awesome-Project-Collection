/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood.management;

import DB.DBConnection;
import DB.DeleteDatabase;
import DB.DisplayDatabase;
import DB.QueryDatabase;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Wipro
 */
public class bloodRecieversence implements Initializable {

    @FXML
    private TextField rName;
    @FXML
    private ComboBox<String> rGroup;
    @FXML
    private ComboBox<String> rGender;
    @FXML
    private TextField rContact;
    @FXML
    private DatePicker rDate;
    @FXML
    private Button addBtn;
    @FXML
    private TextField rAmount;
      @FXML
    private TextField rQty;

    /**
     * Initializes the controller class.
     */
        
    DisplayDatabase displayBloodData = new DisplayDatabase();
    @FXML
    private TableView<?> rTableView;
    @FXML
    private TextField rDoctor;
    @FXML
    private ComboBox<String> rEid;
  
    
    String name="";
        String bGroup="";
        String gender="";
        String contact="";
        String amount="";
        String qty="";
        LocalDate date;
        String doctor="";
        String eid="";
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     ObservableList<String> eList = FXCollections.observableArrayList();
     ObservableList<String> gList = FXCollections.observableArrayList();
     
     gList.add("Male");
     gList.add("Female");
     gList.add("Other");
     rGender.setItems(gList);
     
      ResultSet rs = QueryDatabase.query("Select EID from EmpTable;");
        if(rs!=null){
            try {
                while(rs.next()){
                    eList.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddbloodSence.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        rEid.setItems(eList);
       
        rDate.setValue(LocalDate.now());
           
        ObservableList<String> groupList = FXCollections.observableArrayList();
     
     groupList.add("O +ve");
     groupList.add("A +ve");
     groupList.add("b +ve");
     groupList.add("Ab +ve");
     groupList.add("O -ve");
     groupList.add("A -ve");
     groupList.add("b -ve");
     groupList.add("Ab -ve");
     rGroup.setItems(groupList);   
           
       displayBloodData.buildData(rTableView, "Select * from recieverTable Order By(Id) desc;");
    }    

    @FXML
    private void addReciever(ActionEvent event) {
      
        name = rName.getText();
        bGroup = rGroup.getValue();
        gender = rGender.getValue();
        contact = rContact.getText();
        date = rDate.getValue();
        amount = rAmount.getText();
        qty = rQty.getText();
        doctor = rDoctor.getText();
        eid = rEid.getValue();
        
      if(name==null || name.isEmpty()){
        rName.requestFocus();
        return;
        }
          if(bGroup==null || bGroup.isEmpty()){
        rGroup.requestFocus();
        return;
        }
         if(contact==null || contact.isEmpty()){
        rContact.requestFocus();
        return;
    }
         
         if(amount==null || amount.isEmpty()){
        rAmount.requestFocus();
        return;
        }
         
         if(qty==null || qty.isEmpty()){
        rQty.requestFocus();
        return;
        }
         
           if(doctor==null || doctor.isEmpty()){
        rDoctor.requestFocus();
        return;
        }
             if(eid==null || eid.isEmpty()){
        rEid.requestFocus();
        return;
        }
         
         Connection c;
         try{
            c = DBConnection.connect();
            
            String query = "insert into RECIEVERTable (date,Name,BloodGroup,Gender,Amount,Qty,DoctorName,Eid,Contact) values ('"+date+"','"+name+"','"+bGroup+"','"+gender+"','"+amount+"','"+qty+"','"+doctor+"','"+eid+"','"+contact+"');";
            c.createStatement().execute(query);
            
            
            ResultSet rs = QueryDatabase.query("Select bloodGroup from inventorytable where bloodgroup='"+bGroup+"';");
            if(rs==null){
                query = "insert into InventoryTable (bloodGroup,Qty) values ('"+bGroup+"','"+0+"');";
                c.createStatement().execute(query);
            }else{
                if(!rs.next()){
                     query = "insert into InventoryTable (bloodGroup,Qty) values ('"+bGroup+"','"+0+"');";
                    c.createStatement().execute(query);
                }else{
                 query = "Update InventoryTable set Qty=Qty-"+qty+" where bloodgroup='"+bGroup+"';";
                c.createStatement().execute(query);
                }
               
            
            }
            
            
            c.close();
            rName.clear();
            rGroup.setValue("");
            rGender.setValue("");
            rContact.clear();
            rAmount.clear(); 
            rQty.clear();
            rDoctor.clear();
           rEid.setValue("");
           
            displayBloodData.buildData(rTableView, "Select * from recieverTable Order By(Id) desc;");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(bloodRecieversence.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }

    @FXML
    private void mDeleteRecord(ActionEvent event) {
        
        int index = rTableView.getSelectionModel().getSelectedIndex();
        ObservableList<ObservableList> data = displayBloodData.getData();
        ObservableList<String> row = data.get(index);
        DeleteDatabase.deleteRecord(Integer.parseInt(row.get(0)), "recieverTable");
          displayBloodData.buildData(rTableView, "Select * from recieverTable Order By(Id) desc;");
        
         Connection c;
         try{
            c = DBConnection.connect();
               String query = "Update InventoryTable set Qty=Qty+"+Integer.parseInt(row.get(8))+" where bloodgroup='"+row.get(3)+"';";
                c.createStatement().execute(query);
               c.close();
        
    }   catch (SQLException ex) {
            Logger.getLogger(AddbloodSence.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
