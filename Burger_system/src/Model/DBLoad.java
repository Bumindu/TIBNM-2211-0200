package Model;

import static Model.DBconect.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBLoad {
    
    public ResultSet loadCustomers() {
       
        ResultSet rs = null;
        
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM customers";
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
