package GUI;

import Code.Queue;
import javax.swing.JOptionPane;

public class ControlPanel extends javax.swing.JFrame {
    private static Queue ordersQueue = new Queue(10);
    private int orderNumber = 1;
    
    public ControlPanel() {
        initComponents();
    }
    
    private boolean isNumber(String txt){
        if(txt.isEmpty() ||
                txt.isBlank()) 
            return false;
        
        try{
            Integer.parseInt(txt);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    private boolean isSelectedAtLeastOneProduct(){
        final boolean op1 = (checkBoxSalt.isSelected() && isNumber(txtSaltQty.getText()));
        final boolean op2 = (checkBoxCheese.isSelected() && isNumber(txtCheeseQty.getText()));
        final boolean op3 = (checkBoxCaramel.isSelected() && isNumber(txtCaramelQty.getText()));
        
        return op1 || op2 || op3;
    }
    
    private String[] getOrderedProducts() {
        return new String[] { "Salted Popcorn", "Cheese Popcorn", "Caramel Popcorn" };
    }
    
    private int[] getQuantities() {
        return new int[] {
            (checkBoxSalt.isSelected() && isNumber(txtSaltQty.getText())) ? Integer.parseInt(txtSaltQty.getText()) : 0,
            (checkBoxCheese.isSelected() && isNumber(txtCheeseQty.getText())) ? Integer.parseInt(txtCheeseQty.getText()) : 0,
            (checkBoxCaramel.isSelected() && isNumber(txtCaramelQty.getText())) ? Integer.parseInt(txtCaramelQty.getText()) : 0
        };
    }
    
    private void insertOrder() {
        if(!isSelectedAtLeastOneProduct()){
            JOptionPane.showMessageDialog(rootPane, "Enter the required information first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(ordersQueue.isFull()){
            JOptionPane.showMessageDialog(rootPane, "Sorry, we are busy at the moment...\nJust give us a minute...", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ordersQueue.insert(orderNumber, getOrderedProducts(), getQuantities());
        JOptionPane.showMessageDialog(rootPane, "Order # " + orderNumber + " is placed successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
        orderNumber++;
    }
    
    private void clearForm() {
        checkBoxSalt.setSelected(false);
        txtSaltQty.setText("");
        checkBoxCheese.setSelected(false);
        txtCheeseQty.setText("");
        checkBoxCaramel.setSelected(false); 
        txtCaramelQty.setText("");
    }

    private void updateOrderObserver() {
        if(ordersQueue.isEmpty()){
            txtObserver.setText("No orders at the moment...");
            return;
        }
        
        txtObserver.setText(ordersQueue.peek().toString());
        ordersQueue.resetViewFront();
        
    }
    
    private void viewNextOrder() {
        if(ordersQueue.isEmpty()) return;
        
        if(ordersQueue.viewFront == (ordersQueue.getRear())){
            int res = JOptionPane.showConfirmDialog(rootPane, "That's all! Do you want to reset the observer?", "That's all!", JOptionPane.YES_NO_OPTION);
            if(res == 0){
                ordersQueue.resetViewFront();
                updateOrderObserver();
            }
            
            return;
        }
        
        txtObserver.setText(ordersQueue.getNext().toString());
    }
    
    private void completeOrder() {
        ordersQueue.remove();
        ordersQueue.resetViewFront();
        updateOrderObserver();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCheeseQty = new javax.swing.JTextField();
        txtSaltQty = new javax.swing.JTextField();
        txtCaramelQty = new javax.swing.JTextField();
        checkBoxSalt = new javax.swing.JCheckBox();
        checkBoxCheese = new javax.swing.JCheckBox();
        checkBoxCaramel = new javax.swing.JCheckBox();
        btnOrderNow = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObserver = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnViewNextOrder = new javax.swing.JButton();
        btnCompleteOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/pic.PNG"))); // NOI18N

        txtCheeseQty.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtCheeseQty.setForeground(new java.awt.Color(255, 0, 51));
        txtCheeseQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCheeseQty.setEnabled(false);

        txtSaltQty.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtSaltQty.setForeground(new java.awt.Color(255, 0, 51));
        txtSaltQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaltQty.setEnabled(false);

        txtCaramelQty.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtCaramelQty.setForeground(new java.awt.Color(255, 0, 51));
        txtCaramelQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaramelQty.setEnabled(false);

        checkBoxSalt.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxSalt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        checkBoxSalt.setText("Salt");
        checkBoxSalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSaltActionPerformed(evt);
            }
        });

        checkBoxCheese.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxCheese.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        checkBoxCheese.setText("Cheese");
        checkBoxCheese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCheeseActionPerformed(evt);
            }
        });

        checkBoxCaramel.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxCaramel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        checkBoxCaramel.setText("Caramel");
        checkBoxCaramel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCaramelActionPerformed(evt);
            }
        });

        btnOrderNow.setBackground(new java.awt.Color(255, 0, 0));
        btnOrderNow.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnOrderNow.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderNow.setText("Order Now");
        btnOrderNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderNowActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(255, 0, 0));
        btnClear.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkBoxCaramel)
                            .addComponent(checkBoxCheese, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxSalt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSaltQty, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtCheeseQty)
                            .addComponent(txtCaramelQty)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaltQty, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxSalt))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCheeseQty, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxCheese))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaramelQty, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxCaramel))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOrderNow, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtObserver.setColumns(20);
        txtObserver.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtObserver.setRows(5);
        jScrollPane1.setViewportView(txtObserver);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnViewNextOrder.setBackground(new java.awt.Color(255, 0, 0));
        btnViewNextOrder.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnViewNextOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnViewNextOrder.setText("View Next Order");
        btnViewNextOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewNextOrderActionPerformed(evt);
            }
        });

        btnCompleteOrder.setBackground(new java.awt.Color(255, 0, 0));
        btnCompleteOrder.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCompleteOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCompleteOrder.setText("Complete Order");
        btnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnViewNextOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCompleteOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewNextOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(btnCompleteOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Opertaor", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxSaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSaltActionPerformed
        if(checkBoxSalt.isSelected())
            txtSaltQty.setEnabled(true);
        else
            txtSaltQty.setEnabled(false);
    }//GEN-LAST:event_checkBoxSaltActionPerformed

    private void checkBoxCheeseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCheeseActionPerformed
        if(checkBoxCheese.isSelected())
            txtCheeseQty.setEnabled(true);
        else
            txtCheeseQty.setEnabled(false);
    }//GEN-LAST:event_checkBoxCheeseActionPerformed

    private void checkBoxCaramelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCaramelActionPerformed
        if(checkBoxCaramel.isSelected())
            txtCaramelQty.setEnabled(true);
        else
            txtCaramelQty.setEnabled(false);
    }//GEN-LAST:event_checkBoxCaramelActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnOrderNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderNowActionPerformed
        insertOrder();
    }//GEN-LAST:event_btnOrderNowActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if(jTabbedPane1.getSelectedIndex() == 1)
            updateOrderObserver();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnViewNextOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewNextOrderActionPerformed
        viewNextOrder();
    }//GEN-LAST:event_btnViewNextOrderActionPerformed

    private void btnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteOrderActionPerformed
        completeOrder();
    }//GEN-LAST:event_btnCompleteOrderActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControlPanel cp = new ControlPanel();
                cp.setResizable(false);
                cp.setLocationRelativeTo(null);
                cp.pack();
                cp.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCompleteOrder;
    private javax.swing.JButton btnOrderNow;
    private javax.swing.JButton btnViewNextOrder;
    private javax.swing.JCheckBox checkBoxCaramel;
    private javax.swing.JCheckBox checkBoxCheese;
    private javax.swing.JCheckBox checkBoxSalt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCaramelQty;
    private javax.swing.JTextField txtCheeseQty;
    private javax.swing.JTextArea txtObserver;
    private javax.swing.JTextField txtSaltQty;
    // End of variables declaration//GEN-END:variables
}
