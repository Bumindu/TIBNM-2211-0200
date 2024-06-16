
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


public class products extends javax.swing.JFrame {
    //Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Connection connection;
    private DefaultTableModel tableModel1;
    private TableRowSorter<DefaultTableModel> rowSorter;

   
    public products() {
       initComponents();
       connectToDatabase();
       loadDataProduct();
       addSearchFunctionality();
       addTableClickListener();
    }
    
    private void addTableClickListener() {
        table3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table3.getSelectedRow();
                if (selectedRow != -1) {
                    idbox2.setText(tableModel1.getValueAt(selectedRow, 0).toString());
                    namebox2.setText(tableModel1.getValueAt(selectedRow, 1).toString());
                    categorybox.setSelectedItem(tableModel1.getValueAt(selectedRow, 2).toString());
                    pricebox.setText(tableModel1.getValueAt(selectedRow, 3).toString());
                    quantitybox.setText(tableModel1.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }
    
    private void clearFields() {
        idbox2.setText("");
        namebox2.setText("");
        categorybox.setSelectedIndex(0);
        pricebox.setText("");
        quantitybox.setText("");
        searchbox2.setText("");
    }
    
     private void addSearchFunctionality() {
        rowSorter = new TableRowSorter<>(tableModel1);
        table3.setRowSorter(rowSorter);

        searchbox2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchbox2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchbox2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchbox2.getText());
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
    
    private void loadDataProduct() {
       try {
            String query = "SELECT id, name, category, price, quantity FROM products";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Set up table model
            tableModel1 = new DefaultTableModel(new Object[]{"ID", "Name", "Category", "Price", "Quantity"}, 0);
            table3.setModel(tableModel1);

            // Populate table
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");                
                String category = resultSet.getString("category");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
               
                tableModel1.addRow(new Object[]{id, name, category, price, quantity});
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
        table3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchbox2 = new javax.swing.JTextField();
        insertbtn2 = new javax.swing.JButton();
        menubtn2 = new javax.swing.JButton();
        clearbtn2 = new javax.swing.JButton();
        updatebtn2 = new javax.swing.JButton();
        deletebtn2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        idbox2 = new javax.swing.JTextField();
        namebox2 = new javax.swing.JTextField();
        pricebox = new javax.swing.JTextField();
        quantitybox = new javax.swing.JTextField();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        Label5 = new javax.swing.JLabel();
        categorybox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table3.setModel(new javax.swing.table.DefaultTableModel(
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
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        table3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table3KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 320, 280));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        searchbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbox2ActionPerformed(evt);
            }
        });
        searchbox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(searchbox2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(searchbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 63));

        insertbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn2.setText("Insert");
        insertbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(insertbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));

        menubtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menubtn2.setText("Menu");
        menubtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(menubtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 76, -1));

        clearbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn2.setText("Clear");
        clearbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(clearbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 72, -1));

        updatebtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn2.setText("Update");
        updatebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(updatebtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        deletebtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn2.setText("Delete");
        deletebtn2.setAutoscrolls(true);
        deletebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        Label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label1.setText("ID");

        pricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceboxActionPerformed(evt);
            }
        });

        Label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label2.setText("Name");

        Label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label3.setText("Category");

        Label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label4.setText("Price");

        Label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Label5.setText("s.quantity");

        categorybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "Chees Burger", "Chicken Burger", "Veg Burger", "Big Boss Burger", "My Burger Special ", "chees chicken Burger", "sea food Burger" }));
        categorybox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryboxItemStateChanged(evt);
            }
        });
        categorybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(Label3)
                                .addGap(255, 255, 255))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(categorybox, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Label4)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Label5)
                                            .addComponent(quantitybox, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                            .addComponent(pricebox)
                                            .addComponent(namebox2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(Label2)))
                                .addGap(34, 34, 34))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Label1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(idbox2)
                        .addGap(34, 34, 34))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namebox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(Label3)
                .addGap(12, 12, 12)
                .addComponent(categorybox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pricebox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantitybox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 310, 360));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\CHAMA COMPUTERS\\Downloads\\Brown Organic Burger Presentation\\image (1).jpg")); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        setSize(new java.awt.Dimension(679, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryboxActionPerformed

    private void menubtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubtn2ActionPerformed
        menu m = new menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubtn2ActionPerformed

    private void clearbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn2ActionPerformed
        clearFields();
    }//GEN-LAST:event_clearbtn2ActionPerformed

    private void deletebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn2ActionPerformed

        new DeleteController().DeleteProducts(idbox2.getText());
        this.dispose();
        products f = new products();
        f.setVisible(true);
    }//GEN-LAST:event_deletebtn2ActionPerformed

    private void updatebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn2ActionPerformed

        new UpdateController().UpdatProducts(idbox2.getText(), namebox2.getText(), categorybox.getSelectedItem().toString(), Double.parseDouble(pricebox.getText()), Integer.parseInt(quantitybox.getText()));
        this.dispose();
        products f = new products();
        f.setVisible(true);
    }//GEN-LAST:event_updatebtn2ActionPerformed

    private void insertbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtn2ActionPerformed

        new InsertController().InsertProducts(idbox2.getText(), namebox2.getText(), categorybox.getSelectedItem().toString(), Double.parseDouble(pricebox.getText()), Integer.parseInt(quantitybox.getText()));
        this.dispose();
        products f = new products();
        f.setVisible(true);
    }//GEN-LAST:event_insertbtn2ActionPerformed

    private void priceboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceboxActionPerformed

    private void searchbox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox2KeyReleased

    }//GEN-LAST:event_searchbox2KeyReleased

    private void searchbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbox2ActionPerformed

    }//GEN-LAST:event_searchbox2ActionPerformed

    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased

    }//GEN-LAST:event_table3KeyReleased

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked

    }//GEN-LAST:event_table3MouseClicked

    private void categoryboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryboxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryboxItemStateChanged

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
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label5;
    private javax.swing.JComboBox<String> categorybox;
    private javax.swing.JButton clearbtn2;
    private javax.swing.JButton deletebtn2;
    private javax.swing.JTextField idbox2;
    private javax.swing.JButton insertbtn2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menubtn2;
    private javax.swing.JTextField namebox2;
    private javax.swing.JTextField pricebox;
    private javax.swing.JTextField quantitybox;
    private javax.swing.JTextField searchbox2;
    private javax.swing.JTable table3;
    private javax.swing.JButton updatebtn2;
    // End of variables declaration//GEN-END:variables
}
