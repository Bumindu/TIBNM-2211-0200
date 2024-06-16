
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

public class orderdetails extends javax.swing.JFrame {
    
    //Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Connection connection;
    private DefaultTableModel tableModel3;
    private TableRowSorter<DefaultTableModel> rowSorter;

   
    public orderdetails() {
       initComponents();
       connectToDatabase();
       loadDataOrderDetails();
       addSearchFunctionality();
       addTableClickListener();
       
    }
    
       private void addTableClickListener() {
        table5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table5.getSelectedRow();
                if (selectedRow != -1) {
                    odidbox.setText(tableModel3.getValueAt(selectedRow, 0).toString());
                    oidbox1.setText(tableModel3.getValueAt(selectedRow, 1).toString());
                    pidbox.setText(tableModel3.getValueAt(selectedRow, 2).toString());
                    quantitybox1.setText(tableModel3.getValueAt(selectedRow, 3).toString());
                    pricebox1.setText(tableModel3.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
    
    private void clearFields() {
        odidbox.setText("");
        oidbox1.setText("");
        pidbox.setText("");
        quantitybox1.setText("");
        pricebox1.setText("");
    }
    
     private void addSearchFunctionality() {
        rowSorter = new TableRowSorter<>(tableModel3);
        table5.setRowSorter(rowSorter);

        searchbox4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchbox4.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchbox4.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchbox4.getText());
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
    
    private void loadDataOrderDetails() {
       try {
            String query = "SELECT order_detail_id, order_id, product_id, quantity, price FROM order_details";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Set up table model
            tableModel3 = new DefaultTableModel(new Object[]{"order_detail_id", "order_id", "product_id", "quantity", "price",}, 0);
            table5.setModel(tableModel3);

            // Populate table
            while (resultSet.next()) {
                int order_detail_id = resultSet.getInt("order_detail_id");
                int order_id = resultSet.getInt("order_id");                
                int product_id = resultSet.getInt("product_id");
                String quantity = resultSet.getString("quantity");
                String price = resultSet.getString("price");
               
                tableModel3.addRow(new Object[]{order_detail_id, order_id, product_id, quantity, price});
            }
            
           

        } catch (SQLException e) {
           
            JOptionPane.showMessageDialog(this, "Failed to load data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
       


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        clearbtn4 = new javax.swing.JButton();
        insertbtn4 = new javax.swing.JButton();
        updatebtn4 = new javax.swing.JButton();
        deletebtn4 = new javax.swing.JButton();
        menubtn4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        searchbox4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        odidbox = new javax.swing.JTextField();
        oidbox1 = new javax.swing.JTextField();
        pidbox = new javax.swing.JTextField();
        quantitybox1 = new javax.swing.JTextField();
        pricebox1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table5.setModel(new javax.swing.table.DefaultTableModel(
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
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        table5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table5KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table5);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 320, 240));

        clearbtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn4.setText("Clear");
        clearbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(clearbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 65, -1));

        insertbtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn4.setText("Insert");
        insertbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        updatebtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn4.setText("Update");
        updatebtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        deletebtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn4.setText("Delete");
        deletebtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, -1, -1));

        menubtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menubtn4.setText("Menu");
        menubtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(menubtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        searchbox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox4, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("O.Details ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Order ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Product ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Price");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(pricebox1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(quantitybox1)
                    .addComponent(pidbox)
                    .addComponent(oidbox1)
                    .addComponent(jLabel1)
                    .addComponent(odidbox))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(odidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oidbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantitybox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pricebox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 310, 330));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHAMA COMPUTERS\\Downloads\\Brown Organic Burger Presentation\\image (1).jpg")); // NOI18N
        jLabel6.setText("jLabel5");
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        setSize(new java.awt.Dimension(681, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
  
    }//GEN-LAST:event_table5MouseClicked

    private void table5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table5KeyReleased
  
    }//GEN-LAST:event_table5KeyReleased

    private void clearbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn4ActionPerformed
        clearFields();
    }//GEN-LAST:event_clearbtn4ActionPerformed

    private void insertbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn4ActionPerformed
         
        new InsertController().InsertOrderDetails(odidbox.getText(),oidbox1.getText(),pidbox.getText(),Integer.parseInt(quantitybox1.getText()),Double.parseDouble(pricebox1.getText()) );
        this.dispose();
        orderdetails f = new orderdetails();
        f.setVisible(true);
       
    }//GEN-LAST:event_insertbtn4ActionPerformed

    private void deletebtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn4ActionPerformed
        
       new DeleteController().DeleteOrderDetails(odidbox.getText());
       this.dispose();
        orderdetails f = new orderdetails();
        f.setVisible(true);                            
    }//GEN-LAST:event_deletebtn4ActionPerformed

    private void menubtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn4ActionPerformed
        
        menu c =  new menu();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubtn4ActionPerformed

    private void searchbox4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox4KeyReleased

    }//GEN-LAST:event_searchbox4KeyReleased

    private void updatebtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn4ActionPerformed

        new UpdateController().UpdateOrderDetails(odidbox.getText(),oidbox1.getText(),pidbox.getText(),Integer.parseInt(quantitybox1.getText()),Double.parseDouble(pricebox1.getText()) );
        this.dispose();
        orderdetails f = new orderdetails();
        f.setVisible(true);
        
    }//GEN-LAST:event_updatebtn4ActionPerformed

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
            java.util.logging.Logger.getLogger(orderdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn4;
    private javax.swing.JButton deletebtn4;
    private javax.swing.JButton insertbtn4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menubtn4;
    private javax.swing.JTextField odidbox;
    private javax.swing.JTextField oidbox1;
    private javax.swing.JTextField pidbox;
    private javax.swing.JTextField pricebox1;
    private javax.swing.JTextField quantitybox1;
    private javax.swing.JTextField searchbox4;
    private javax.swing.JTable table5;
    private javax.swing.JButton updatebtn4;
    // End of variables declaration//GEN-END:variables

} 
