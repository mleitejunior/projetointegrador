package visual;

import dao.DAOConnection;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import model.entities.Product;
import resources.WindowFrame;

public class ExistentProduct extends WindowFrame {
    
    private int ondeAdicionar; //1 = produtos, 2 = vendas
    DAOConnection connect = new DAOConnection();
    Connection database;
    List<Product> products;
    NewSale janelaAnterior;

    public void setJanelaAnterior(NewSale janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public ExistentProduct() {
        setUndecorated(true);
        initComponents();
        setLabelBackground(labelBackground);
        setSize(440,180);
        setBackground(new Color(0,0,0,0));
        setBackgroundMovable();
        updateComboBoxes();
    }

    public void setDatabase(Connection database) {
        this.database = database;
    }

    public void setOndeAdicionar(int ondeAdicionar) {
        this.ondeAdicionar = ondeAdicionar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listProducts = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Product>());
        comboProducts = new javax.swing.JComboBox();
        txtQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        comboProducts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboProducts);
        comboProducts.setBounds(20, 70, 240, 30);

        txtQuantity.setText("1");
        getContentPane().add(txtQuantity);
        txtQuantity.setBounds(270, 70, 60, 30);

        jLabel1.setText("Quantidade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 80, 90, 14);

        btnConfirm.setText("Incluir Produto");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirm);
        btnConfirm.setBounds(20, 120, 140, 30);

        btnCancel.setText("Cancelar Inclusão");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(230, 120, 140, 30);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backgroundexistentproduct.png"))); // NOI18N
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 440, 180);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        Product p = listProducts.get(comboProducts.getSelectedIndex());
        p.setQuantity(Integer.parseInt(txtQuantity.getText()));
        products.add(p);
        janelaAnterior.updateFields();
        dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(ExistentProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExistentProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExistentProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExistentProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExistentProduct().setVisible(true);
            }
        });
    }
    
    public void updateComboBoxes(){
        listProducts.clear();
        listProducts.addAll(connect.getProductForSale());
        comboProducts.removeAllItems();
        for (Product c : listProducts) {
            comboProducts.addItem(c.getName());
        }
    }

    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox comboProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelBackground;
    private java.util.List<Product> listProducts;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
