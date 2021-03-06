package visual;

import dao.DAOConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entities.Client;
import model.entities.Product;
import resources.WindowFrame;

public class NewSale extends WindowFrame {
    
    
    DAOConnection connect = new DAOConnection();
    Connection database;
    float subtotal;
    float total;

    List<Client> clients;
    ArrayList<Product> products = new ArrayList<>();

    public NewSale() {
        setUndecorated(true);
        initComponents();
        tableProductsToSell.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        setLabelBackground(labelBackground);
        setSize(840,530);
        setBackground(new Color(0,0,0,0));
        setBackgroundMovable();
        updateFields();
    }

    public void setDatabase(Connection database) {
        this.database = database;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTaxDiscount = new javax.swing.ButtonGroup();
        listClients = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Client>());
        labelUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboClients = new javax.swing.JComboBox();
        btnNewClient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductsToSell = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPercentTaxDiscount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboSaleType = new javax.swing.JComboBox();
        btnNewClient1 = new javax.swing.JButton();
        btnNewClient2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPeriod = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        labelParcel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(null);

        labelUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelUser.setText("MARCELO LEITE JUNIOR");
        getContentPane().add(labelUser);
        labelUser.setBounds(180, 130, 180, 14);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cliente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 170, 80, 17);

        comboClients.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClients.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboClientsFocusGained(evt);
            }
        });
        getContentPane().add(comboClients);
        comboClients.setBounds(120, 170, 220, 20);

        btnNewClient.setBackground(new java.awt.Color(0, 157, 229));
        btnNewClient.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewClient.setForeground(new java.awt.Color(255, 255, 255));
        btnNewClient.setText("Cancelar Venda");
        btnNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClientActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewClient);
        btnNewClient.setBounds(400, 470, 180, 40);

        tableProductsToSell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProductsToSell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Produto", "Preço de Venda", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProductsToSell);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 250, 580, 200);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL À PAGAR:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(650, 390, 113, 17);

        labelTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelTotal.setText("R$x.xxx.xxx,xx");
        getContentPane().add(labelTotal);
        labelTotal.setBounds(630, 410, 140, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("SUBTOTAL À PAGAR");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(640, 120, 138, 17);

        labelSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSubTotal.setText("R$x.xxx.xxx,xx");
        getContentPane().add(labelSubTotal);
        labelSubTotal.setBounds(630, 150, 160, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Parcelas");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(680, 320, 70, 17);

        txtPercentTaxDiscount.setText("0");
        txtPercentTaxDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercentTaxDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(txtPercentTaxDiscount);
        txtPercentTaxDiscount.setBounds(700, 270, 40, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("%");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(680, 280, 12, 17);

        jButton1.setBackground(new java.awt.Color(0, 157, 229));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Adicionar Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(25, 208, 190, 40);

        jButton2.setBackground(new java.awt.Color(0, 157, 229));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remover Produto");
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 208, 180, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Venda:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(660, 180, 120, 17);

        comboSaleType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "À PRAZO", "A VISTA", "CRÉDITO", "DÉBITO" }));
        comboSaleType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSaleTypeActionPerformed(evt);
            }
        });
        getContentPane().add(comboSaleType);
        comboSaleType.setBounds(650, 210, 120, 20);

        btnNewClient1.setBackground(new java.awt.Color(0, 157, 229));
        btnNewClient1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewClient1.setForeground(new java.awt.Color(255, 255, 255));
        btnNewClient1.setText("NOVO CLIENTE");
        getContentPane().add(btnNewClient1);
        btnNewClient1.setBounds(370, 170, 170, 25);

        btnNewClient2.setBackground(new java.awt.Color(0, 157, 229));
        btnNewClient2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNewClient2.setForeground(new java.awt.Color(255, 255, 255));
        btnNewClient2.setText("Concluir Venda");
        btnNewClient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClient2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewClient2);
        btnNewClient2.setBounds(210, 470, 180, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Vendedor:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 130, 90, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("TAXA");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(690, 240, 90, 17);

        txtPeriod.setText("1");
        txtPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodActionPerformed(evt);
            }
        });
        getContentPane().add(txtPeriod);
        txtPeriod.setBounds(690, 350, 40, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("VALOR DA PARCELA:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(650, 440, 150, 17);

        labelParcel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelParcel.setText("R$x.xxx.xxx,xx");
        getContentPane().add(labelParcel);
        labelParcel.setBounds(630, 470, 160, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 157, 229));
        jLabel2.setText("NOVA VENDA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 40, 330, 30);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/backgroundnewsales.png"))); // NOI18N
        labelBackground.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelBackgroundFocusGained(evt);
            }
        });
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 840, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClientActionPerformed
        dispose();
    }//GEN-LAST:event_btnNewClientActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExistentProduct existentProduct = new ExistentProduct();
        existentProduct.setDatabase(database);
        existentProduct.setOndeAdicionar(2);
        existentProduct.setProducts(products);
        existentProduct.setJanelaAnterior(this);
        existentProduct.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        System.out.println("BOX UPDATE");
        updateFields();
    }//GEN-LAST:event_formFocusGained

    private void labelBackgroundFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelBackgroundFocusGained
        updateFields();
    }//GEN-LAST:event_labelBackgroundFocusGained

    private void comboClientsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboClientsFocusGained
        updateFields();
    }//GEN-LAST:event_comboClientsFocusGained

    private void comboSaleTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSaleTypeActionPerformed
        atualizaTotal();
    }//GEN-LAST:event_comboSaleTypeActionPerformed

    private void txtPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodActionPerformed
        atualizaTotal();
    }//GEN-LAST:event_txtPeriodActionPerformed

    private void txtPercentTaxDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercentTaxDiscountActionPerformed
        atualizaTotal();
    }//GEN-LAST:event_txtPercentTaxDiscountActionPerformed

    private void btnNewClient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClient2ActionPerformed
        JOptionPane.showMessageDialog(null, "VENDA CADASTRADA COM SUCESSO!");
        dispose();
    }//GEN-LAST:event_btnNewClient2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSale().setVisible(true);
            }
        });
    }
    
    public void updateFields(){
        listClients.clear();
        listClients.addAll(connect.getClientNames());
        comboClients.removeAllItems();
        for (Client c : listClients) {
            comboClients.addItem(c.getName());
        }
        
        DefaultTableModel model = (DefaultTableModel) tableProductsToSell.getModel();
        
        model.setRowCount(0);
        for (Product p : products) {
            Object[] o = new Object[4];
            o[0] = p.getId();
            o[1] = p.getName();
            o[2] = p.getPriceSale();
            o[3] = p.getQuantity();
            model.addRow(o);
          }
        
        atualizaSubtotal();
        atualizaTotal();
    }
    
    public void atualizaSubtotal() {
        subtotal = 0;
        
        for (Product p : products) {
           subtotal += p.getPriceSale() * p.getQuantity();
          }
        
        labelSubTotal.setText("R$" + String.format("%.2f", subtotal));
    }
    
    public void atualizaTotal() {
        total = 0;
        double calculatedTotal = subtotal;
        double parcel;
        
        float tax = Float.parseFloat(txtPercentTaxDiscount.getText())/100;
        int period = Integer.parseInt(txtPeriod.getText());
        
        
        switch(comboSaleType.getSelectedIndex()) {
            case 0: //prazo
                calculatedTotal = (subtotal * Math.pow((1+tax),period));
                labelTotal.setText("R$" + String.format("%.2f", calculatedTotal));
                break;
            case 1: //vista
                calculatedTotal = (subtotal - (subtotal * tax * period));
                labelTotal.setText("R$" + String.format("%.2f", calculatedTotal));
                break;
            case 2: //credito
                calculatedTotal = (subtotal * Math.pow((1+tax),period));
                labelTotal.setText("R$" + String.format("%.2f", calculatedTotal));
                break;
            case 3: //debito
                calculatedTotal = (subtotal - (subtotal * tax * period));
                labelTotal.setText("R$" + String.format("%.2f", calculatedTotal));
                break;
            default:
                break;
        }
        
        parcel = calculatedTotal / period;
        labelParcel.setText("R$" + String.format("%.2f", parcel));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewClient;
    private javax.swing.JButton btnNewClient1;
    private javax.swing.JButton btnNewClient2;
    private javax.swing.ButtonGroup btnTaxDiscount;
    private javax.swing.JComboBox comboClients;
    private javax.swing.JComboBox comboSaleType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelParcel;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelUser;
    private java.util.List<Client> listClients;
    private javax.swing.JTable tableProductsToSell;
    private javax.swing.JTextField txtPercentTaxDiscount;
    private javax.swing.JTextField txtPeriod;
    // End of variables declaration//GEN-END:variables
}
