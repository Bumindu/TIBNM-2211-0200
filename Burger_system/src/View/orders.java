
package View;

import Controller.DeleteController;
import Controller.InsertController;
import Controller.UpdateController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class orders extends javax.swing.JFrame {
    
    //Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Connection connection;
    private DefaultTableModel tableModel2;
    private TableRowSorter<DefaultTableModel> rowSorter;

 
   
    public orders() {
       initComponents();
       connectToDatabase();
       loadDataOrder();
       addSearchFunctionality();
       addTableClickListener();  
       
       new UpdateController().updateOrderTable(table4);
    }

        private void addTableClickListener() {
        table4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table4.getSelectedRow();
                if (selectedRow != -1) {
                    idbox3.setText(tableModel2.getValueAt(selectedRow, 0).toString());
                    cidbox.setText(tableModel2.getValueAt(selectedRow, 1).toString());
                    datebox.setText(tableModel2.getValueAt(selectedRow, 2).toString());
                    amountbox.setText(tableModel2.getValueAt(selectedRow, 3).toString());
                }
            }
        });
    }
    
    private void clearFields() {
        idbox3.setText("");
        cidbox.setText("");
        datebox.setText("");
        amountbox.setText("");
        searchbox3.setText("");
    }
    
     private void addSearchFunctionality() {
        rowSorter = new TableRowSorter<>(tableModel2);
        table4.setRowSorter(rowSorter);

        searchbox3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchbox3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchbox3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchbox3.getText());
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
    
    private void loadDataOrder() {
       try {
            String query = "SELECT id, customer_id, date, amount FROM orders";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Set up table model
            tableModel2 = new DefaultTableModel(new Object[]{"id", "customer_id", "date", "amount",}, 0);
            table4.setModel(tableModel2);

            // Populate table
            while (resultSet.next()) {
                int id = resultSet.getInt("id");                
                String customer_id = resultSet.getString("customer_id");
                String date = resultSet.getString("date");
                String amount = resultSet.getString("amount");
               
                tableModel2.addRow(new Object[]{id, customer_id, date, amount});
            }
            
           

        } catch (SQLException e) {
           
            JOptionPane.showMessageDialog(this, "Failed to load data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchbox3 = new javax.swing.JTextField();
        cleatbtn3 = new javax.swing.JButton();
        insertbtn3 = new javax.swing.JButton();
        Menubtn3 = new javax.swing.JButton();
        deletebtn3 = new javax.swing.JButton();
        updatebtn3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        idbox3 = new javax.swing.JTextField();
        cidbox = new javax.swing.JTextField();
        datebox = new javax.swing.JTextField();
        amountbox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table4.setModel(new javax.swing.table.DefaultTableModel(
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
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table4MouseClicked(evt);
            }
        });
        table4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table4KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table4);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 320, 250));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        searchbox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchbox3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        cleatbtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cleatbtn3.setText("Clear");
        cleatbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleatbtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(cleatbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 72, -1));

        insertbtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn3.setText("Insert");
        insertbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        Menubtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Menubtn3.setText("Menu");
        Menubtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menubtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(Menubtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 75, -1));

        deletebtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn3.setText("Delete");
        deletebtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        updatebtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn3.setText("Update");
        updatebtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, -1, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("C.ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Amount");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountbox)
                    .addComponent(datebox)
                    .addComponent(cidbox)
                    .addComponent(idbox3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 222, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idbox3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountbox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 310, 330));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHAMA COMPUTERS\\Downloads\\Brown Organic Burger Presentation\\image (1).jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 450));

        setSize(new java.awt.Dimension(681, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deletebtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn3ActionPerformed
       
        new DeleteController().DeleteOrders(idbox3.getText());
        this.dispose();
        orders f = new orders();
        f.setVisible(true);
    }//GEN-LAST:event_deletebtn3ActionPerformed

    private void table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseClicked
      
    }//GEN-LAST:event_table4MouseClicked

    private void table4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table4KeyReleased
      
    }//GEN-LAST:event_table4KeyReleased

    private void searchbox3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox3KeyReleased
     
    }//GEN-LAST:event_searchbox3KeyReleased

    private void updatebtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn3ActionPerformed
       
        new UpdateController().UpdateOrders(idbox3.getText(), cidbox.getText(), datebox.getText(), Double.parseDouble(amountbox.getText())); 
        new UpdateController().updateOrderTable(table4);
        this.dispose();
        orders f = new orders();
        f.setVisible(true);
    }//GEN-LAST:event_updatebtn3ActionPerformed

    private void insertbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn3ActionPerformed
      
        new InsertController().InsertOrders(idbox3.getText(), cidbox.getText(), datebox.getText(), Double.parseDouble(amountbox.getText()));
        new UpdateController().updateOrderTable(table4);
        this.dispose();
        orders f = new orders();
        f.setVisible(true);
    }//GEN-LAST:event_insertbtn3ActionPerformed

    private void cleatbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleatbtn3ActionPerformed
       clearFields();
    }//GEN-LAST:event_cleatbtn3ActionPerformed

    private void Menubtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menubtn3ActionPerformed
        menu c =  new menu();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Menubtn3ActionPerformed

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
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Menubtn3;
    private javax.swing.JTextField amountbox;
    private javax.swing.JTextField cidbox;
    private javax.swing.JButton cleatbtn3;
    private javax.swing.JTextField datebox;
    private javax.swing.JButton deletebtn3;
    private javax.swing.JTextField idbox3;
    private javax.swing.JButton insertbtn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchbox3;
    private javax.swing.JTable table4;
    private javax.swing.JButton updatebtn3;
    // End of variables declaration//GEN-END:variables

}
