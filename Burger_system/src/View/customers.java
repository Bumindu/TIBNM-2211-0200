
package View;

import Controller.DeleteController;
import Controller.InsertController;
import Controller.UpdateController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class customers extends javax.swing.JFrame {
    private Connection connection;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;
    
    public customers() {
        initComponents();
       
       connectToDatabase2();
       loadDatacustmer();
      // new UpdateController().updateCoustomerTable(jTable3);
       addTableClickListener2();
       addSearchFunctionality2();
    }
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        searchbox1 = new javax.swing.JTextField();
        clearbtn2 = new javax.swing.JButton();
        deletebtn2 = new javax.swing.JButton();
        updatebtn2 = new javax.swing.JButton();
        insertbtn2 = new javax.swing.JButton();
        menubtn2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        idbox1 = new javax.swing.JTextField();
        namebox1 = new javax.swing.JTextField();
        contactnumberbox1 = new javax.swing.JTextField();
        emailbox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 320, 270));

        jPanel6.setBackground(new java.awt.Color(255, 153, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        searchbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbox1ActionPerformed(evt);
            }
        });
        searchbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(searchbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        clearbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn2.setText("Clear");
        clearbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(clearbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 78, -1));

        deletebtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn2.setText("Delete");
        deletebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        updatebtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn2.setText("Update");
        updatebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        insertbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn2.setText("Insert");
        insertbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        menubtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menubtn2.setText("Menu");
        menubtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(menubtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 77, -1));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        emailbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Email");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("C. Number");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(idbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(namebox1))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contactnumberbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(emailbox))
                        .addComponent(jLabel9)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namebox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactnumberbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 310, 340));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHAMA COMPUTERS\\Downloads\\Brown Organic Burger Presentation\\image (1).jpg")); // NOI18N
        jLabel10.setText("jLabel5");
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        setSize(new java.awt.Dimension(684, 478));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void connectToDatabase2() {
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
    
     private void loadDatacustmer() {
       try {
            String query = "SELECT id, name, contact_number, email FROM customers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Set up table model
            tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Contact No", "Email"}, 0);
            jTable3.setModel(tableModel);

            // Populate table
            while (resultSet.next()) {
                String idcc = resultSet.getString("id");
                String named = resultSet.getString("name");                
                String contactno = resultSet.getString("contact_number");
                String email = resultSet.getString("email");
                tableModel.addRow(new Object[]{idcc, named, contactno, email});
            }
            
           

        } catch (SQLException e) {
           
            JOptionPane.showMessageDialog(this, "Failed to load data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addTableClickListener2() {
        jTable3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTable3.getSelectedRow();
                if (selectedRow != -1) {
                    idbox1.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    namebox1.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    contactnumberbox1.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    emailbox.setText(tableModel.getValueAt(selectedRow, 3).toString());
                }
            }
        });
    }
   
        private void addSearchFunctionality2() {
        rowSorter = new TableRowSorter<>(tableModel);
        jTable3.setRowSorter(rowSorter);

        searchbox1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchbox1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchbox1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchbox1.getText());
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
    
    private void searchbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbox1ActionPerformed

    }//GEN-LAST:event_searchbox1ActionPerformed

    private void searchbox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox1KeyReleased

    }//GEN-LAST:event_searchbox1KeyReleased

    private void clearbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn2ActionPerformed

        new UpdateController().clearCustomer();
        clearFields();
    }//GEN-LAST:event_clearbtn2ActionPerformed

    private void deletebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn2ActionPerformed

        new DeleteController().DeleteCustomer(idbox1.getText());
        new UpdateController().updateCoustomerTable(jTable3);
        clearFields();
        this.dispose();
        customers f = new customers();
        f.setVisible(true);

    }//GEN-LAST:event_deletebtn2ActionPerformed

    private void updatebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn2ActionPerformed

        new UpdateController().UpdateCustomer(idbox1.getText(), namebox1.getText(), contactnumberbox1.getText() , emailbox.getText());
        clearFields();
        this.dispose();
        customers f = new customers();
        f.setVisible(true);
    }//GEN-LAST:event_updatebtn2ActionPerformed

    private void insertbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn2ActionPerformed

        new InsertController().InsertCustomer(idbox1.getText(), namebox1.getText(), contactnumberbox1.getText(), emailbox.getText());
        new UpdateController().updateCoustomerTable(jTable3);
        clearFields();
        this.dispose();
        customers f = new customers();
        f.setVisible(true);
    }//GEN-LAST:event_insertbtn2ActionPerformed

    private void menubtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn2ActionPerformed
        menu y = new menu();
        y.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubtn2ActionPerformed

    private void emailboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailboxActionPerformed

    private void clearFields() {
        idbox1.setText("");
        namebox1.setText("");
        contactnumberbox1.setText("");
        emailbox.setText("");
        searchbox1.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn2;
    public javax.swing.JTextField contactnumberbox1;
    private javax.swing.JButton deletebtn2;
    public javax.swing.JTextField emailbox;
    public javax.swing.JTextField idbox1;
    private javax.swing.JButton insertbtn2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton menubtn2;
    public javax.swing.JTextField namebox1;
    public javax.swing.JTextField searchbox1;
    private javax.swing.JButton updatebtn2;
    // End of variables declaration//GEN-END:variables

   
}
