
package Controller;

import Model.DBInsert;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author amila
 */
public class InsertController {
    
    
    public void InsertCustomer(String id, String name, String contact_number, String email){
        if(id.equals("") || name.equals("") || contact_number.equals("") || email.equals("")){
            JOptionPane.showMessageDialog(null,"Not Inserted");
        }
        else {
            new DBInsert().InsertCustomer(id,name,contact_number,email);
            JOptionPane.showMessageDialog(null, "Inserted");                
        }
    }
    
    
    public void InsertUsers(String username,  String password, String role){
        if(username.equals("") || password.equals("") || role.equals("")){
            JOptionPane.showMessageDialog(null,"Not Inserted");
        }
        else {
            new DBInsert().InsertUsers(username,password,role);
            JOptionPane.showMessageDialog(null, "Inserted");
        }
    }
    
     public void InsertProducts(String id, String name,  String category, double price, int quantity){
        if(id.equals("") || name.equals("") || category.equals("") || price==0.0 || quantity==0){
            JOptionPane.showMessageDialog(null,"Not Inserted");
        }
        else {
            new DBInsert().InsertProducts(id,name,category,price,quantity);
            JOptionPane.showMessageDialog(null, "Inserted");
        }
    }
    
     public void InsertOrders(String id, String customer_id,  String date, double amount){
        if(id.equals("") || customer_id.equals("") || date.equals("") || amount==0.0){
            JOptionPane.showMessageDialog(null,"Not Inserted");
        }
        else {
            new DBInsert().InsertOrders(id,customer_id,date,amount);
            JOptionPane.showMessageDialog(null, "Inserted");
        }
    }
     
     public void InsertOrderDetails(String orderDetailsId, String orderId, String productId, int quantity, double price){
        if(orderDetailsId.equals("") || orderId.equals("") || productId.equals("") || quantity==0|| price==0.0){
            JOptionPane.showMessageDialog(null,"Not Inserted");
        }
        else {
            new DBInsert().InsertOrderDetails(orderDetailsId, orderId, productId, quantity, price);
            JOptionPane.showMessageDialog(null, "Inserted");
        }
    }
     
}


