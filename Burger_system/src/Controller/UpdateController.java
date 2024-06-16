

package Controller;

import Model.DBSearch;
import Model.DBUpdate;
import View.customers;
import View.orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class UpdateController {
    
    
    
    
   public void UpdateCustomer(String id, String name,  String contact_number, String email){
        if(id.equals("") || name.equals("") || contact_number.equals("") || email.equals("")){
            JOptionPane.showMessageDialog(null,"Not Update");
        }
        else {
            new DBUpdate().UpdateCustomer(id,name,contact_number,email);
            JOptionPane.showMessageDialog(null, "Updated");
        }
    }
   
   
    public void UpdateUsers(String id, String username, String password, String role){
        if(id.equals("") || username.equals("") || password.equals("") || role.equals("")){
            JOptionPane.showMessageDialog(null,"Not Update");
        }
        else {
            new DBUpdate().UpdateUsers(id,username,password,role);
            JOptionPane.showMessageDialog(null, "Updated");            
        }
    }
    
    public void UpdatProducts(String id, String name,  String category, double price, int quantity){
        if(id.equals("") || name.equals("") || category.equals("") || price==0.0 || quantity==00){
            JOptionPane.showMessageDialog(null,"Not Update");
        }
        else {
            new DBUpdate().UpdateProducts(id,name,category,price,quantity);
            JOptionPane.showMessageDialog(null, "Updated");
        }
    }
    
    public void UpdateOrders(String id, String customer_id,  String date, double amount){
        if(id.equals("") || customer_id.equals("") || date.equals("") || amount==0.0) {
            JOptionPane.showMessageDialog(null,"Not Update");
        }
        else {
            new DBUpdate().UpdateOrders(id,customer_id,date,amount);
            JOptionPane.showMessageDialog(null, "Updated");
        }
    }
    
    
    public void UpdateOrderDetails(String order_detail_id, String order_id, String product_id, int quantity, double price){
        if(order_detail_id.equals("") || order_id.equals("") || product_id.equals("") || quantity==00 || price==0.0) {
            JOptionPane.showMessageDialog(null,"Not Update");
        }
        else {
            new DBUpdate().UpdateOrderDetails(order_detail_id,order_id,product_id,quantity,price);
            JOptionPane.showMessageDialog(null, "Updated");
        }
    }
    

    public void updateCoustomerTable(JTable tabel){
       try {
           ResultSet rs = null;
           DefaultTableModel tbl = (DefaultTableModel)tabel.getModel();
           
           // Set up table model
            tbl = new DefaultTableModel(new Object[]{"ID", "Name", "Contact Number", "Email"}, 0);
            tabel.setModel(tbl);
            
            
           tbl.setRowCount(0);
           String id="", name="", telephone="", email="";
           rs= new DBSearch().SearchAllCustomer();
           while(rs.next()){
               id = rs.getString("id");
               name = rs.getString("name");
               telephone = rs.getString("contact_number");
               email = rs.getString("email");
               
               String tbData[] = {id, name, telephone, email};
               tbl.addRow(tbData);
           }
       } catch (SQLException ex) {
           Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void clearCustomer(){
        customers cus = new customers();
        cus.idbox1.setText("");
        cus.namebox1.setText("");
        cus.contactnumberbox1.setText("");
        cus.emailbox.setText("");
        
        
    }

  
    
    public void updateOrderTable(JTable tabe2){
       try {
           ResultSet rs = null;
           DefaultTableModel tbl = (DefaultTableModel)tabe2.getModel();
           
           // Set up table model
            tbl = new DefaultTableModel(new Object[]{"id", "customer_id", "date", "amount"}, 0);
            tabe2.setModel(tbl);
            
            
           tbl.setRowCount(0);
           String id="", customer_id="", date="", amount="";
           rs= new DBSearch().SearchAllOrders();
           while(rs.next()){
               id = rs.getString("id");
               customer_id = rs.getString("customer_id");
               date = rs.getString("date");
               amount = rs.getString("amount");
               
               String tbData[] = {id, customer_id, date, amount};
               tbl.addRow(tbData);
           }
       } catch (SQLException ex) {
           Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public void updateOrderDetailsTable(JTable tabe1){
       try {
           ResultSet rs = null;
           DefaultTableModel tbl = (DefaultTableModel)tabe1.getModel();
           
           // Set up table model
            tbl = new DefaultTableModel(new Object[]{"order_detail_id", "order_id", "product_id", "quantity", "price"}, 0);
            tabe1.setModel(tbl);
            
            
           tbl.setRowCount(0);
           String order_detail_id="", order_id="", product_id="", quantity="", price="";
           rs= new DBSearch().SearchAllCustomer();
           while(rs.next()){
               order_detail_id = rs.getString("order_detail_id");
               order_id = rs.getString("order_id");
               product_id = rs.getString("product_id");
               quantity = rs.getString("quantity");
               price = rs.getString("price");
               
               String tbData[] = {order_detail_id, order_id, product_id, quantity, price};
               tbl.addRow(tbData);
           }
       } catch (SQLException ex) {
           Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void updateProductTable(JTable table3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

