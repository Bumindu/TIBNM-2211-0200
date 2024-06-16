
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBInsert {
    Statement stmt = null;
    ResultSet rs = null;
    
    
    public void InsertCustomer(String id, String name, String contact_number, String email){
        String query = String.format("INSERT INTO customers (id, name, contact_number,email)"
                + "VALUES ('%s', '%s', '%s', '%s')", id,name,contact_number,email);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
 
    public void InsertUsers(String username, String password, String role){
        String query = String.format("INSERT INTO users ( username, password, role)"
                + "VALUES ('%s', '%s', '%s')", username,password,role);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    public void InsertProducts(String id, String name,  String category, double price, int quantity){
        String query = String.format("INSERT INTO products (id, name, category, price, quantity)"
                + "VALUES ('%s', '%s', '%s', '%f', '%d')", id,name,category,price,quantity);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    public void InsertOrders(String id, String customer_id,  String date, double amount){
        String query = String.format("INSERT INTO orders (id, customer_id, date, amount)"
                + "VALUES ('%s', '%s', '%s', '%f')", id, customer_id, date, amount);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
    
}    
 }
    
   public void InsertOrderDetails(String orderDetailsId, String orderId, String productId, int quantity, double price){
        String query = String.format("INSERT INTO order_details (order_detail_id,order_id,product_id,quantity,price) VALUES "
                + "('%s', '%s', '%s', '%d', '%f')", orderDetailsId,orderId,productId,quantity,price);
        stmt = DBconect.connect();
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBInsert.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
   
   
   
   public class DBQuery {
    public List<Object[]> getAllUsers() {
        List<Object[]> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection conn = (Connection) DBconect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                userList.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
}
       
    
    
}
        







