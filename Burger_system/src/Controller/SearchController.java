
package Controller;

import Model.DBSearch;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchController {
    public void SearchCustomer(String id) {
        if(id.equals("")) {
         
           
        } else {
            ResultSet rs = new DBSearch().SearchCustomer(id);
            try {
               while(rs.next()) {
                    String name = rs.getString("name");
                    int contact_number = rs.getInt("contact_number");
                    String email = rs.getString("email");
                    
                    
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Not Searched.");
                
            }
        }
    }
    
    
}
