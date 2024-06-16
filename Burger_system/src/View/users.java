

package View;

import Controller.DeleteController;
import Controller.InsertController;
import Controller.UpdateController;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class users extends javax.swing.JFrame {

    private Connection connection;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;
    
    public users() {
        initComponents();
        connectToDatabase();
        loadData();
        addTableClickListener();
        addSearchFunctionality();
      
    }
    
    private void addSearchFunctionality() {
        rowSorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(rowSorter);

        searchbox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchbox.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchbox.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchbox.getText());
            }

            private void search(String searchText) {
                if (searchText.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1)); // Search in the "username" column
                }
            }

           
        });
    }
    
    private void connectToDatabase() {
        try {
            // Replace with your database details
            String url = "jdbc:mysql://localhost:3306/burger_system";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      
    public class PasswordCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Replace the actual password with asterisks
        if (value != null) {
            value = new String(new char[value.toString().length()]).replace("\0", "*");
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
    
    public void loadData() {
       try {
            String query = "SELECT id, username, password, role FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Set up table model
            tableModel = new DefaultTableModel(new Object[]{"ID", "Username", "password", "Role"}, 0);
            jTable1.setModel(tableModel);

            // Populate table
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");                
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                tableModel.addRow(new Object[]{id, username, password, role});
            }
            
            // Apply custom renderer for the password column
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new PasswordCellRenderer());

        } catch (SQLException e) {
           
            JOptionPane.showMessageDialog(this, "Failed to load data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    private void addTableClickListener() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    idbox.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    unsernamebox.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    passwordbox1.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    rolebox1.setText(tableModel.getValueAt(selectedRow, 3).toString());
                }
            }
        });
    }
    
    private void clearFields() {
        idbox.setText("");
        passwordbox1.setText("");
        unsernamebox.setText("");
        rolebox1.setText("");
        searchbox.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        idbox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        unsernamebox = new javax.swing.JTextField();
        rolebox1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        passwordbox1 = new javax.swing.JPasswordField();
        updatebtn1 = new javax.swing.JButton();
        deletebtn1 = new javax.swing.JButton();
        menubtn1 = new javax.swing.JButton();
        clearButon1 = new javax.swing.JButton();
        insertbtn1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idbox.setEditable(false);
        idbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idboxActionPerformed(evt);
            }
        });
        jPanel6.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 260, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ID");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Username");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        unsernamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unsernameboxActionPerformed(evt);
            }
        });
        jPanel6.add(unsernamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 260, 30));

        rolebox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolebox1ActionPerformed(evt);
            }
        });
        jPanel6.add(rolebox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 260, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Password");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Role");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        passwordbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordbox1ActionPerformed(evt);
            }
        });
        jPanel6.add(passwordbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 310, 330));

        updatebtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn1.setText("Update");
        updatebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        deletebtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn1.setText("Delete");
        deletebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        menubtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menubtn1.setText("Menu");
        menubtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(menubtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 77, -1));

        clearButon1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearButon1.setText("Clear");
        clearButon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButon1MouseClicked(evt);
            }
        });
        clearButon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButon1ActionPerformed(evt);
            }
        });
        jPanel1.add(clearButon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 76, -1));

        insertbtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn1.setText("Insert");
        insertbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 71, -1));

        jPanel7.setBackground(new java.awt.Color(255, 153, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 320, 260));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHAMA COMPUTERS\\Downloads\\Brown Organic Burger Presentation\\image (1).jpg")); // NOI18N
        jLabel10.setText("jLabel5");
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        setSize(new java.awt.Dimension(686, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idboxActionPerformed

    private void unsernameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unsernameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unsernameboxActionPerformed

    private void rolebox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolebox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rolebox1ActionPerformed

    private void passwordbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordbox1ActionPerformed

    private void updatebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn1ActionPerformed

        new UpdateController().UpdateUsers(idbox.getText(), unsernamebox.getText(), passwordbox1.getText(), rolebox1.getText());
        this.dispose();
        users f = new users();
        f.setVisible(true);

    }//GEN-LAST:event_updatebtn1ActionPerformed

    private void deletebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn1ActionPerformed

        new DeleteController().DeleteUsers(idbox.getText());
        this.dispose();
        users f = new users();
        f.setVisible(true);

    }//GEN-LAST:event_deletebtn1ActionPerformed

    private void menubtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn1ActionPerformed

        menu x = new menu();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubtn1ActionPerformed

    private void clearButon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButon1MouseClicked
        clearFields();        // TODO add your handling code here:
    }//GEN-LAST:event_clearButon1MouseClicked

    private void clearButon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButon1ActionPerformed

    }//GEN-LAST:event_clearButon1ActionPerformed

    private void insertbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn1ActionPerformed

        new InsertController().InsertUsers(unsernamebox.getText(), passwordbox1.getText(), rolebox1.getText());
        this.dispose();
        users f = new users();
        f.setVisible(true);

    }//GEN-LAST:event_insertbtn1ActionPerformed

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased

    }//GEN-LAST:event_searchboxKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButon1;
    private javax.swing.JButton deletebtn1;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertbtn1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton menubtn1;
    private javax.swing.JPasswordField passwordbox1;
    private javax.swing.JTextField rolebox1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField unsernamebox;
    private javax.swing.JButton updatebtn1;
    // End of variables declaration//GEN-END:variables
}
