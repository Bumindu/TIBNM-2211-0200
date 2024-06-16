package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBSearch {
    Statement stmt = null;
    ResultSet rs = null;

    public ResultSet SearchCustomer(String id) {
        String query = String.format("SELECT * FROM customers WHERE id='%s'", id);
        stmt = DBconect.connect();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet SearchAllCustomer() {
        String query = "SELECT * FROM customers";
        stmt = DBconect.connect();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
      public ResultSet SearchAllUsers() {
        String query = "SELECT * FROM users";
        stmt = DBconect.connect();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
      
      public ResultSet SearchAllOrders() {
        String query = "SELECT * FROM orders";
        stmt = DBconect.connect();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

      public ResultSet SearchAllOrederDetails() {
        String query = "SELECT * FROM order_details";
        stmt = DBconect.connect();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        
    }
    public ResultSet searchLogin(String usName) {
        try {
            stmt = DBconect.connect();
            String name = usName;
            //Execute the Query
            rs = stmt.executeQuery("SELECT * FROM users where username='" + name + "'");
        }
        catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    
}
