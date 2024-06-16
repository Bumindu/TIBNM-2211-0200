
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DBconect {
    static Connection conn = null;
    static Statement stmt = null;
    
    public static Statement connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/burger_system","root","");
            stmt = conn.createStatement();
        } catch (Exception e) {     
            JOptionPane.showMessageDialog(null, e);
        }
       return stmt;
       
    }

    public static void closeCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
