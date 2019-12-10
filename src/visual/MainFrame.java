package visual;

import dao.DAOConnection;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.entities.*;
import model.structure.*;
import resources.WindowFrame;
import visual.reports.*;

public class MainFrame extends WindowFrame {
    
    DAOConnection connect = new DAOConnection();
    Connection database;
    
    private int access;
        
    public void setDatabase(Connection database) {
        this.database = database;
        atualizaTabelas();
        panelClients.setOpaque(false);
        panelUsers.setOpaque(false);
        panelExpenses.setOpaque(false);
        panelProducts.setOpaque(false);
        panelProducts.setBackground(Color.black);
        panelProviders.setOpaque(false);
        panelSales.setOpaque(false);
    }
    
    public MainFrame() {    
        setUndecorated(true);
        initComponents();
        setLabelBackground(labelBackground);
        setSize(1280,800);
        setBackground(new Color(0,0,0,0));
        setBackgroundMovable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listProducts = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Product>());
        listClients = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Client>());
        listSales = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Sale>());
        listProviders = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <Provider>());
        listExpenses = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <MonthlyFixedExpense>());
        listUsers = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList <User>());
        mainTabPanel = new javax.swing.JTabbedPane();
        panelProducts = new javax.swing.JPanel();
        scrollTableProducts = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        btnAddProduct = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        panelClients = new javax.swing.JPanel();
        scrollTableClients = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        btnAddClient = new javax.swing.JButton();
        btnEditClient = new javax.swing.JButton();
        btnDeleteClient = new javax.swing.JButton();
        panelSales = new javax.swing.JPanel();
        scrollTableSales = new javax.swing.JScrollPane();
        tableSales = new javax.swing.JTable();
        btnAddSale = new javax.swing.JButton();
        btnEditSale = new javax.swing.JButton();
        btnDeleteSale = new javax.swing.JButton();
        panelProviders = new javax.swing.JPanel();
        scrollTableProviders = new javax.swing.JScrollPane();
        tableProviders = new javax.swing.JTable();
        btnAddProvider = new javax.swing.JButton();
        btnEditProvider = new javax.swing.JButton();
        btnDeleteProvider = new javax.swing.JButton();
        panelExpenses = new javax.swing.JPanel();
        scrollTableExpenses = new javax.swing.JScrollPane();
        tableExpenses = new javax.swing.JTable();
        btnAddExpense = new javax.swing.JButton();
        btnEditExpense = new javax.swing.JButton();
        btnDeleteExpense = new javax.swing.JButton();
        panelUsers = new javax.swing.JPanel();
        scrollTableUsers = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnReportProductSale = new javax.swing.JButton();
        btnReportSalesPerYear = new javax.swing.JButton();
        btnReportMonthlyExpenses = new javax.swing.JButton();
        btnReportClientRegionSales = new javax.swing.JButton();
        btnReportTypePayments = new javax.swing.JButton();
        btnReportNew = new javax.swing.JButton();
        btnFechar2 = new javax.swing.JButton();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        scrollTableProducts.setPreferredSize(new java.awt.Dimension(450, 400));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProducts, tableProducts);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Nome do Produto");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${brandName}"));
        columnBinding.setColumnName("Marca");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceSale}"));
        columnBinding.setColumnName("Preço de Venda");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cost}"));
        columnBinding.setColumnName("Preço de Custo");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${companyName}"));
        columnBinding.setColumnName("Fornecedor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableProducts.setViewportView(tableProducts);

        btnAddProduct.setText("ADICIONAR PRODUTO");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnEditProduct.setText("EDITAR PRODUTO");

        btnDeleteProduct.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
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
                    .addComponent(scrollTableProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainTabPanel.addTab("PRODUTOS", panelProducts);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listClients, tableClients);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idClient}"));
        columnBinding.setColumnName("Código");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Nome do Cliente");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${city}"));
        columnBinding.setColumnName("Cidade");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fu}"));
        columnBinding.setColumnName("UF");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("E-mail");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contact}"));
        columnBinding.setColumnName("Contact");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableClients.setViewportView(tableClients);

        btnAddClient.setText("ADICIONAR PRODUTO");
        btnAddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClientActionPerformed(evt);
            }
        });

        btnEditClient.setText("EDITAR PRODUTO");

        btnDeleteClient.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelClientsLayout = new javax.swing.GroupLayout(panelClients);
        panelClients.setLayout(panelClientsLayout);
        panelClientsLayout.setHorizontalGroup(
            panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableClients, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddClient, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(btnDeleteClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelClientsLayout.setVerticalGroup(
            panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientsLayout.createSequentialGroup()
                        .addComponent(btnAddClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteClient)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollTableClients, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainTabPanel.addTab("CLIENTES", panelClients);

        panelSales.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listSales, tableSales);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idSale}"));
        columnBinding.setColumnName("Código");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Data da Venda");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clientName}"));
        columnBinding.setColumnName("Nome do Cliente");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userName}"));
        columnBinding.setColumnName("Nome do Funcionário");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableSales.setViewportView(tableSales);

        btnAddSale.setText("ADICIONAR VENDA");
        btnAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaleActionPerformed(evt);
            }
        });

        btnEditSale.setText("EDITAR PRODUTO");

        btnDeleteSale.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelSalesLayout = new javax.swing.GroupLayout(panelSales);
        panelSales.setLayout(panelSalesLayout);
        panelSalesLayout.setHorizontalGroup(
            panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableSales, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEditSale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(btnAddSale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(btnDeleteSale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSalesLayout.setVerticalGroup(
            panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSalesLayout.createSequentialGroup()
                        .addComponent(btnAddSale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditSale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSale)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollTableSales, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainTabPanel.addTab("VENDAS", panelSales);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProviders, tableProviders);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Nome da Empresa");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Nome do Responsável");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Endereço");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Cidade");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("UF");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("CNPJ");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("E-mail");
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Contato");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableProviders.setViewportView(tableProviders);

        btnAddProvider.setText("ADICIONAR PRODUTO");

        btnEditProvider.setText("EDITAR PRODUTO");

        btnDeleteProvider.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelProvidersLayout = new javax.swing.GroupLayout(panelProviders);
        panelProviders.setLayout(panelProvidersLayout);
        panelProvidersLayout.setHorizontalGroup(
            panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvidersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableProviders, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProvider, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(btnDeleteProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelProvidersLayout.setVerticalGroup(
            panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvidersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProvidersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableProviders)
                    .addGroup(panelProvidersLayout.createSequentialGroup()
                        .addComponent(btnAddProvider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditProvider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteProvider)
                        .addGap(0, 419, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainTabPanel.addTab("FORNECEDORES", panelProviders);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listExpenses, tableExpenses);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${useMaterial}"));
        columnBinding.setColumnName("Material de Uso");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${equipment}"));
        columnBinding.setColumnName("Equipamento");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monthlyTax}"));
        columnBinding.setColumnName("Juros Mensais");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rent}"));
        columnBinding.setColumnName("Aluguel");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${loan}"));
        columnBinding.setColumnName("Empréstimo");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${maintenance}"));
        columnBinding.setColumnName("Manutenção");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employee}"));
        columnBinding.setColumnName("Funcionários");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${others}"));
        columnBinding.setColumnName("Outros");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableExpenses.setViewportView(tableExpenses);

        btnAddExpense.setText("ADICIONAR PRODUTO");

        btnEditExpense.setText("EDITAR PRODUTO");

        btnDeleteExpense.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelExpensesLayout = new javax.swing.GroupLayout(panelExpenses);
        panelExpenses.setLayout(panelExpensesLayout);
        panelExpensesLayout.setHorizontalGroup(
            panelExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddExpense, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(btnEditExpense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteExpense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelExpensesLayout.setVerticalGroup(
            panelExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelExpensesLayout.createSequentialGroup()
                        .addComponent(btnAddExpense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditExpense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteExpense)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollTableExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)))
        );

        mainTabPanel.addTab("DESPESAS", panelExpenses);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listUsers, tableUsers);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Nome do Funcionário");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Username");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Cidade");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Endereço");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("UF");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("CPF");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("RG");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("E-mail");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ObjectProperty.create());
        columnBinding.setColumnName("Contact");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTableUsers.setViewportView(tableUsers);

        btnAddUser.setText("ADICIONAR PRODUTO");

        btnEditUser.setText("EDITAR PRODUTO");

        btnDeleteUser.setText("EXCLUIR PRODUTO");

        javax.swing.GroupLayout panelUsersLayout = new javax.swing.GroupLayout(panelUsers);
        panelUsers.setLayout(panelUsersLayout);
        panelUsersLayout.setHorizontalGroup(
            panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelUsersLayout.setVerticalGroup(
            panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsersLayout.createSequentialGroup()
                        .addComponent(btnAddUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollTableUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainTabPanel.addTab("FUNCIONÁRIOS", panelUsers);

        getContentPane().add(mainTabPanel);
        mainTabPanel.setBounds(10, 229, 1268, 560);

        btnReportProductSale.setText("RELATÓRIO VENDA DE PRODUTOS");
        btnReportProductSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportProductSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportProductSale);
        btnReportProductSale.setBounds(500, 60, 350, 23);

        btnReportSalesPerYear.setText("RELATÓRIO DE VENDAS");
        btnReportSalesPerYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportSalesPerYearActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportSalesPerYear);
        btnReportSalesPerYear.setBounds(870, 60, 350, 23);

        btnReportMonthlyExpenses.setText("RELATÓRIO DAS DESPESAS DO MÊS");
        btnReportMonthlyExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportMonthlyExpensesActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportMonthlyExpenses);
        btnReportMonthlyExpenses.setBounds(500, 100, 350, 23);

        btnReportClientRegionSales.setText("RELATÓRIO DE CLIENTES QUE MAIS COMPRARAM");
        btnReportClientRegionSales.setEnabled(false);
        btnReportClientRegionSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportClientRegionSalesActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportClientRegionSales);
        btnReportClientRegionSales.setBounds(500, 140, 350, 23);

        btnReportTypePayments.setText("RELATÓRIO TIPOS DE PAGAMENTO");
        btnReportTypePayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportTypePaymentsActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportTypePayments);
        btnReportTypePayments.setBounds(870, 100, 350, 23);

        btnReportNew.setText("RELATÓRIO FUNCIONÁRIOS");
        btnReportNew.setEnabled(false);
        btnReportNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportNew);
        btnReportNew.setBounds(870, 140, 350, 23);

        btnFechar2.setBackground(new java.awt.Color(255, 0, 0));
        btnFechar2.setFont(new java.awt.Font("Arial Black", 0, 8)); // NOI18N
        btnFechar2.setForeground(new java.awt.Color(255, 255, 255));
        btnFechar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfechar.png"))); // NOI18N
        btnFechar2.setContentAreaFilled(false);
        btnFechar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnFechar2.setMaximumSize(new java.awt.Dimension(30, 30));
        btnFechar2.setMinimumSize(new java.awt.Dimension(30, 30));
        btnFechar2.setPreferredSize(new java.awt.Dimension(30, 30));
        btnFechar2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfecharover.png"))); // NOI18N
        btnFechar2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/btnfechar.png"))); // NOI18N
        btnFechar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar2);
        btnFechar2.setBounds(1250, 0, 30, 30);

        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mainbackground.png"))); // NOI18N
        getContentPane().add(labelBackground);
        labelBackground.setBounds(0, 0, 1280, 800);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportProductSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportProductSaleActionPerformed
        List<Product> products = connect.getListProduct();
        
        ReportProductSales report = new ReportProductSales("RELATÓRIO", "GRÁFICO", products);
        report.pack();
    }//GEN-LAST:event_btnReportProductSaleActionPerformed

    private void btnReportMonthlyExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportMonthlyExpensesActionPerformed
        List<MonthlyFixedExpense> expenses = connect.getMonthlyFixedExpense();
        MonthlyFixedExpense expense = expenses.get(0);
        
        ReportPercentExpenses report = new ReportPercentExpenses("RELATÓRIO", "GRÁFICO" + expense.getDate(), expense);
        report.pack();
    }//GEN-LAST:event_btnReportMonthlyExpensesActionPerformed

    private void btnReportSalesPerYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSalesPerYearActionPerformed
        List<Sale> sales = connect.getSales();
        
        ReportSalesPerYear report = new ReportSalesPerYear("RELATÓRIO", "GRÁFICO", sales);
        report.pack();
    }//GEN-LAST:event_btnReportSalesPerYearActionPerformed

    private void btnReportClientRegionSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportClientRegionSalesActionPerformed
        List<Sale> sales = connect.getSales();
        
        ReportClientRegionSales report = new ReportClientRegionSales("RELATÓRIO", "GRÁFICO", sales);
    }//GEN-LAST:event_btnReportClientRegionSalesActionPerformed

    private void btnReportTypePaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportTypePaymentsActionPerformed
        List<Sale> sales = connect.getSales();
        
        ReportTypePayments report = new ReportTypePayments("RELATÓRIO", "GRÁFICO", sales);
        report.pack();
    }//GEN-LAST:event_btnReportTypePaymentsActionPerformed

    private void btnReportNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportNewActionPerformed

    private void btnAddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddClientActionPerformed

    private void btnFechar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnFechar2ActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        AddProducts addProducts = new AddProducts();
        addProducts.setDatabase(database);
        addProducts.setVisible(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaleActionPerformed
        NewSale newSale = new NewSale();
        newSale.setDatabase(database);
        newSale.setVisible(true);
    }//GEN-LAST:event_btnAddSaleActionPerformed

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
    private javax.swing.JButton btnAddClient;
    private javax.swing.JButton btnAddExpense;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnAddProvider;
    private javax.swing.JButton btnAddSale;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnDeleteExpense;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteProvider;
    private javax.swing.JButton btnDeleteSale;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditClient;
    private javax.swing.JButton btnEditExpense;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnEditProvider;
    private javax.swing.JButton btnEditSale;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnFechar2;
    private javax.swing.JButton btnReportClientRegionSales;
    private javax.swing.JButton btnReportMonthlyExpenses;
    private javax.swing.JButton btnReportNew;
    private javax.swing.JButton btnReportProductSale;
    private javax.swing.JButton btnReportSalesPerYear;
    private javax.swing.JButton btnReportTypePayments;
    private javax.swing.JLabel labelBackground;
    private java.util.List<Client> listClients;
    private java.util.List<MonthlyFixedExpense> listExpenses;
    private java.util.List<Product> listProducts;
    private java.util.List<Provider> listProviders;
    private java.util.List<Sale> listSales;
    private java.util.List<User> listUsers;
    private javax.swing.JTabbedPane mainTabPanel;
    private javax.swing.JPanel panelClients;
    private javax.swing.JPanel panelExpenses;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JPanel panelProviders;
    private javax.swing.JPanel panelSales;
    private javax.swing.JPanel panelUsers;
    private javax.swing.JScrollPane scrollTableClients;
    private javax.swing.JScrollPane scrollTableExpenses;
    private javax.swing.JScrollPane scrollTableProducts;
    private javax.swing.JScrollPane scrollTableProviders;
    private javax.swing.JScrollPane scrollTableSales;
    private javax.swing.JScrollPane scrollTableUsers;
    private javax.swing.JTable tableClients;
    private javax.swing.JTable tableExpenses;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableProviders;
    private javax.swing.JTable tableSales;
    private javax.swing.JTable tableUsers;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void atualizaTabelas(){
        
        listProducts.clear();
        listProducts.addAll(connect.getProductsDisplay());
        int linha = listProducts.size()-1;
        if(linha>=0){
            tableProducts.setRowSelectionInterval(linha, linha);
            tableProducts.scrollRectToVisible
            (tableProducts.getCellRect(linha, linha, true));
        }
        
        listExpenses.clear();
        listExpenses.addAll(connect.getMonthlyFixedExpense());
        linha = listExpenses.size()-1;
        if(linha>=0){
            tableExpenses.setRowSelectionInterval(linha, linha);
            tableExpenses.scrollRectToVisible
            (tableExpenses.getCellRect(linha, linha, true));
        }
        
        listSales.clear();
        listSales.addAll(connect.getSalesDisplay());
        linha = listSales.size()-1;
        if(linha>=0){
            tableSales.setRowSelectionInterval(linha, linha);
            tableSales.scrollRectToVisible
            (tableSales.getCellRect(linha, linha, true));
        }
//        setCalendarValuesInTable();

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
    
    public void setCalendarValuesInTable(){
        for(int i = 0; i < tableExpenses.getRowCount(); i++) {
            tableExpenses.setValueAt("teste", i, 0);
        }
    }
    
    public void setAccessLevel(){
        switch (access){
            case 1:
                System.out.println("Caso1");
                break;
            case 2:
                System.out.println("Caso2");
                btnAddUser.setEnabled(false);
                btnEditUser.setEnabled(false);
                btnDeleteUser.setEnabled(false);
                btnReportClientRegionSales.setEnabled(false);
                btnReportMonthlyExpenses.setEnabled(false);
                btnReportNew.setEnabled(false);
                btnReportProductSale.setEnabled(false);
                btnReportSalesPerYear.setEnabled(false);
                btnReportTypePayments.setEnabled(false);
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
    
    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
