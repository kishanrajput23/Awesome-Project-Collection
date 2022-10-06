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
import java.time.format.DateTimeFormatter;
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
public class AddbloodSence implements Initializable {

    @FXML
    private TextField aName;
    @FXML
    private ComboBox<String> aGroup;
    @FXML
    private ComboBox<String> aGender;
    @FXML
    private TextField aAddress;
 
    @FXML
    DatePicker date;
    @FXML
    private TextField aAmount;
    @FXML
    private ComboBox<String> aEid;
   
    @FXML
    private TextField aQty;
    @FXML
    private TableView<?> atableView;

    /**
     * Initializes the controller class.
     */ String name="";
        String bGroup="";
        String gender="";
        String address="";
        String amount="";
        
        String qty="";
        String eid="";
        
      
        DisplayDatabase displayBloodData = new DisplayDatabase();
        LocalDate aDate;
    @FXML
    private Button addBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<String> eList = FXCollections.observableArrayList();
     ObservableList<String> gList = FXCollections.observableArrayList();
     
     gList.add("Male");
     gList.add("Female");
     gList.add("Other");
     aGender.setItems(gList);
     
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
        
        aEid.setItems(eList);
           date.setValue(LocalDate.now());
           
        ObservableList<String> groupList = FXCollections.observableArrayList();
     
     groupList.add("O +ve");
     groupList.add("A +ve");
     groupList.add("b +ve");
     groupList.add("Ab +ve");
     groupList.add("O -ve");
     groupList.add("A -ve");
     groupList.add("b -ve");
     groupList.add("Ab -ve");
     aGroup.setItems(groupList);   
           
     displayBloodData.buildData(atableView, "Select * from BloodDonorTable Order By(Id) desc;");   // TODO
    }  
      
    @FXML
    private void addBlood(ActionEvent event) {
        name = aName.getText();
        bGroup = aGroup.getValue();
        gender = aGender.getValue();
        address = aAddress.getText();
        aDate = date.getValue();
        amount = aAmount.getText();
      
        qty = aQty.getText();
        eid = aEid.getValue();
     
        
         if(name==null || name.isEmpty()){
        aName.requestFocus();
        return;
        }
          if(bGroup==null || bGroup.isEmpty()){
        aGroup.requestFocus();
        return;
        }
         if(address==null || address.isEmpty()){
        aAddress.requestFocus();
        return;
    }
   
        
         
         if(qty==null || qty.isEmpty()){
        aQty.requestFocus();
        return;
        }
         
         if(eid==null || eid.isEmpty()){
        aEid.requestFocus();
        return;
        }
         
         Connection c;
         String query;
         try{
             if(!update){
            c = DBConnection.connect();
            
             query = "insert into BloodDonorTable (Name,Gender,Address,date,BloodGroup,EID,QTY,Amount) values ('"+name+"','"+gender+"','"+address+"','"+aDate+"','"+bGroup+"','"+eid+"','"+qty+"','"+amount+"');";
            c.createStatement().execute(query);
            }else{
              c = DBConnection.connect();
            query = "Update BloodDonorTable set Name='"+name+"',Gender='"+gender+"',Address='"+address+"',"
                   + "date='"+aDate+"',BloodGroup='"+bGroup+"',EID='"+eid+"',QTY='"+qty+"',Amount='"+amount+"' Where Id='"+id+"';";
                  System.out.println(query);
           c.createStatement().executeUpdate(query);
          } if(update){
                
                
                qty=String.valueOf(Double.parseDouble(qty)-Double.parseDouble(oldQty));
                query = "Update inventoryTable set QTY=qty+"+qty+" where  bloodgroup='"+bGroup+"';";
                c.createStatement().executeUpdate(query);
                       
             
            }else{
            ResultSet rs = QueryDatabase.query("Select bloodGroup from inventorytable where bloodgroup='"+bGroup+"';");
            if(rs==null){
                query = "insert into InventoryTable (bloodGroup,Qty) values ('"+bGroup+"','"+qty+"');";
                c.createStatement().execute(query);
            }else{
                if(!rs.next()){
                     query = "insert into InventoryTable (bloodGroup,Qty) values ('"+bGroup+"','"+qty+"');";
                    c.createStatement().execute(query);
                }else{
                 query = "Update InventoryTable set Qty=Qty+"+qty+" where bloodgroup='"+bGroup+"';";
                c.createStatement().execute(query);
                }
               }
            
            }
            
            
            c.close();
            
            aName.clear();
            aGroup.setValue("");
            aGender.setValue("");
            aAddress.clear();
            aAmount.clear(); 
            aQty.clear();
            aEid.setValue("");
            date.setValue(LocalDate.now());
           update = false;
      addBtn.setText("Add");
            displayBloodData.buildData(atableView, "Select * from BloodDonorTable Order By(Id) desc;");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AddbloodSence.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
         
    }

    @FXML
    private void mDeleteDonor(ActionEvent event) {
         int index = atableView.getSelectionModel().getSelectedIndex();
        ObservableList<ObservableList> data = displayBloodData.getData();
        ObservableList<String> row = data.get(index);
        DeleteDatabase.deleteRecord(Integer.parseInt(row.get(0)), "BloodDonorTable");
        displayBloodData.buildData(atableView, "Select * from BloodDonorTable Order By(Id) desc;");
        
         Connection c;
         try{
            c = DBConnection.connect();
               String query = "Update InventoryTable set Qty=Qty-"+Integer.parseInt(row.get(7))+" where bloodgroup='"+row.get(5)+"';";
                c.createStatement().execute(query);
               c.close();
        
    }   catch (SQLException ex) {
            Logger.getLogger(AddbloodSence.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
boolean update = false;
    int id;
     String oldQty="0";
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @FXML
    private void mUpdateDonor(ActionEvent event) {
         int index = atableView.getSelectionModel().getFocusedIndex();
      ObservableList<ObservableList> data = displayBloodData.getData();
      ObservableList<String> itemData = data.get(index);
      
      
      id = Integer.parseInt(itemData.get(0));
      aName.setText(itemData.get(1));
        aGroup.setValue(itemData.get(5));
        aGender.setValue(itemData.get(2));
        aAddress.setText(itemData.get(3));
        aAmount.setText(itemData.get(8));
        aQty.setText(itemData.get(7));
        aEid.setValue(itemData.get(6));
        date.setValue(LocalDate.parse(itemData.get(4)));
        
        update=true;
        addBtn.setText("Update");
    }
    
}

