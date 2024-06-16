
package Controller;

import Model.DBDelete;
import javax.swing.JOptionPane;

public class DeleteController {
   
    public void DeleteCustomer(String id) {
        if(id.equals("")) {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        } else {
            new DBDelete().DeleteCustomer(id);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }

      
    public void DeleteUsers(String id) {
        if(id.equals("")) {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        } else {
            new DBDelete().DeleteUsers(id);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }
    
      
    public void DeleteProducts(String id) {
        if(id.equals("")) {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        } else {
            new DBDelete().DeleteProducts(id);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }
    
    public void DeleteOrders(String id) {
        if(id.equals("")) {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        } else {
            new DBDelete().DeleteOrders(id);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }
    
    public void DeleteOrderDetails(String order_detail_id) {
        if(order_detail_id.equals("")) {
            JOptionPane.showMessageDialog(null, "Not Deleted");
        } else {
            new DBDelete().DeleteOrderDetails(order_detail_id);
            JOptionPane.showMessageDialog(null, "Deleted");
        }
    }
}