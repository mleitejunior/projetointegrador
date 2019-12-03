package visual;

import dao.Connect;
import java.sql.Connection;
import java.util.ArrayList;
import model.Product;

public class MainFrame extends javax.swing.JFrame {
    
    Connect connect = new Connect();
    Connection database;
    
    public void setDatabase(Connection database) {
        this.database = database;
        atualizaTabelas();
    }
    
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listProducts = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Product>());
        labelLogo = new javax.swing.JLabel();
        mainTabPanel = new javax.swing.JTabbedPane();
        panelProducts = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        btnAddProduct = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        panelClients = new javax.swing.JPanel();
        panelSales = new javax.swing.JPanel();
        panelEmployees = new javax.swing.JPanel();
        panelProviders = new javax.swing.JPanel();
        panelReports = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelLogo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelLogo.setText("Logo");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProducts, tableProducts);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cost}"));
        columnBinding.setColumnName("Preço");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${percentProfit}"));
        columnBinding.setColumnName("% de lucro");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productExpense}"));
        columnBinding.setColumnName("Custo Adicional");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${salePrice}"));
        columnBinding.setColumnName("Preço de Venda");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProvider}"));
        columnBinding.setColumnName("IDFornecedor");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setMaxWidth(50);
            tableProducts.getColumnModel().getColumn(1).setMinWidth(150);
            tableProducts.getColumnModel().getColumn(2).setMaxWidth(100);
            tableProducts.getColumnModel().getColumn(3).setMaxWidth(70);
            tableProducts.getColumnModel().getColumn(4).setMinWidth(100);
            tableProducts.getColumnModel().getColumn(5).setMinWidth(100);
            tableProducts.getColumnModel().getColumn(6).setMaxWidth(70);
            tableProducts.getColumnModel().getColumn(7).setMaxWidth(70);
        }

        btnAddProduct.setText("ADICIONAR PRODUTO");

        btnEditProduct.setText("EDITAR PRODUTO");

        btnDeleteProduct.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btnEditProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductsLayout.createSequentialGroup()
                        .addComponent(btnAddProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteProduct)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainTabPanel.addTab("PRODUTOS", panelProducts);

        javax.swing.GroupLayout panelClientsLayout = new javax.swing.GroupLayout(panelClients);
        panelClients.setLayout(panelClientsLayout);
        panelClientsLayout.setHorizontalGroup(
            panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        panelClientsLayout.setVerticalGroup(
            panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        mainTabPanel.addTab("CLIENTES", panelClients);

        javax.swing.GroupLayout panelSalesLayout = new javax.swing.GroupLayout(panelSales);
        panelSales.setLayout(panelSalesLayout);
        panelSalesLayout.setHorizontalGroup(
            panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        panelSalesLayout.setVerticalGroup(
            panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        mainTabPanel.addTab("VENDAS", panelSales);

        javax.swing.GroupLayout panelEmployeesLayout = new javax.swing.GroupLayout(panelEmployees);
        panelEmployees.setLayout(panelEmployeesLayout);
        panelEmployeesLayout.setHorizontalGroup(
            panelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        panelEmployeesLayout.setVerticalGroup(
            panelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        mainTabPanel.addTab("FUNCIONÁRIOS", panelEmployees);

        javax.swing.GroupLayout panelProvidersLayout = new javax.swing.GroupLayout(panelProviders);
        panelProviders.setLayout(panelProvidersLayout);
        panelProvidersLayout.setHorizontalGroup(
            panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        panelProvidersLayout.setVerticalGroup(
            panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        mainTabPanel.addTab("FORNECEDORES", panelProviders);

        javax.swing.GroupLayout panelReportsLayout = new javax.swing.GroupLayout(panelReports);
        panelReports.setLayout(panelReportsLayout);
        panelReportsLayout.setHorizontalGroup(
            panelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        panelReportsLayout.setVerticalGroup(
            panelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        mainTabPanel.addTab("RELATÓRIOS", panelReports);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainTabPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainTabPanel)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private java.util.List<Product> listProducts;
    private javax.swing.JTabbedPane mainTabPanel;
    private javax.swing.JPanel panelClients;
    private javax.swing.JPanel panelEmployees;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JPanel panelProviders;
    private javax.swing.JPanel panelReports;
    private javax.swing.JPanel panelSales;
    private javax.swing.JTable tableProducts;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void atualizaTabelas(){
        
        listProducts.clear();
        listProducts.addAll(connect.getListProduct());
        System.out.println(connect.getListProduct());
        int linha = listProducts.size()-1;
        if(linha>=0){
            tableProducts.setRowSelectionInterval(linha, linha);
            tableProducts.scrollRectToVisible
            (tableProducts.getCellRect(linha, linha, true));
        }

//        listVenda.clear();
//        listVenda.addAll(conexao.getListaVenda());
//        linha = listVenda.size()-1;
//        if(linha>=0){
//            tblVenda.setRowSelectionInterval(linha, linha);
//            tblVenda.scrollRectToVisible
//            (tblVenda.getCellRect(linha, linha, true));
//        }
//
//        listItemVenda.clear();
//        listItemVenda.addAll(conexao.getListaItemVenda(0));
//        linha = listVenda.size()-1;
//        if(linha>=0){
//            tblVenda.setRowSelectionInterval(linha, linha);
//            tblVenda.scrollRectToVisible
//            (tblVenda.getCellRect(linha, linha, true));
//        };
    }
}
