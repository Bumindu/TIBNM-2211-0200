
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBDelete {
    Statement stmt = null;

    public void DeleteCustomer(String id) {
        String query = String.format("DELETE FROM customers WHERE id='%s'", id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteUsers(String id) {
        String query = String.format("DELETE FROM users WHERE id='%s'", id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void DeleteProducts(String id) {
        String query = String.format("DELETE FROM products WHERE id='%s'", id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void DeleteOrders(String id) {
        String query = String.format("DELETE FROM orders WHERE id='%s'", id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void DeleteOrderDetails(String order_detail_id) {
        String query = String.format("DELETE FROM order_details WHERE order_detail_id='%s'", order_detail_id);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
