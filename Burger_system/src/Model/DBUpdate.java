package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUpdate {
    Statement stmt = null;
    ResultSet rs = null;

    public void UpdateCustomer(String id, String name, String contact_number, String email) {
        String query = String.format("UPDATE customers SET name='%s', contact_number=%s, email='%s' WHERE id='%s'", 
                name, contact_number, email, id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void UpdateUsers(String id, String username, String password, String role) {
        String query = String.format("UPDATE users SET username='%s', password='%s', role='%s' WHERE id='%s'", 
                username, password, role, id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateProducts(String id, String name,  String category, double price, int quantity) {
        String query = String.format("UPDATE products SET name='%s', category='%s', price='%f', quantity='%d' WHERE id='%s'", 
                name, category, price, quantity,  id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void UpdateOrders(String id, String customer_id,  String date, double amount) {
        String query = String.format("UPDATE orders SET customer_id='%s', date='%s',  amount='%f' WHERE id='%s'", 
                customer_id, date, amount,  id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void UpdateOrderDetails(String order_detail_id, String order_id, String product_id, int quantity, double price) {
        String query = String.format("UPDATE order_details SET order_id='%s', product_id='%s', quantity='%d', price='%f' WHERE order_detail_id='%s'", 
               order_id,product_id,quantity,price, order_detail_id );
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
