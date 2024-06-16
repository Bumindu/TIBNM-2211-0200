/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBSearch;
import Model.DBconect;
import View.login;
import View.menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author isuru
 */
public class LoginController {
    
    
    public static void login(String usName, String pass){
        try{
            String username = null; //initial value of the username
            String password = null; //initial value of the password

            ResultSet rs = new DBSearch().searchLogin(usName);

            while(rs.next()){
                username = rs.getString("username"); //assing database login name to the variable
                password = rs.getString("password");
            }
            if(username != null && password != null){
                if(password.equals(pass)){
                    menu m1 = new menu();
                    m1.setVisible(true);
                    login.getFrames()[0].dispose();
              
              JOptionPane.showMessageDialog(null, "Login Success");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please check the Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please check the cridentials", "Error", JOptionPane.ERROR_MESSAGE);
             }
             DBconect.closeCon();  
        }
        catch(SQLException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

   
}
