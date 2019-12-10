package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.entities.*;
import model.structure.MonthlyFixedExpense;

public class DAOConnection {
    private static final String sqlAdress ="jdbc:mysql://localhost:3306/sevensales";
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user ="root";
    private static final String password ="";
    private static int access;

    public static int getAccess() {
        return access;
    }
    private static Connection con = null;
    
    public DAOConnection (){}
    
    public static Connection getConexao(){
        if(con==null){
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(sqlAdress, user, password);
            }catch(ClassNotFoundException ex){
                System.out.println("Não encontrou o driver " + ex.getMessage());
            }catch(SQLException ex){
                System.out.println("Erro na Conexão:"+ex.getMessage());
            }
        }
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql){
        if(con==null){
            con = getConexao();
        }
        try{
            return con.prepareStatement(sql);
        }catch(SQLException ex){
            System.out.println("Erro de SQL: "+ex.getMessage());
        }
        return null;
    }
    
    public static boolean login(String name, String password) {
        try {
            String query = "SELECT * FROM user where username = '" + name + "' and password = '" + password + "'";
 
            PreparedStatement preparedStatement = getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
  
            if (resultSet.next()) {
                access = resultSet.getInt("idAccess");
                preparedStatement.close();
                resultSet.close();
                return true;
            } else {
                preparedStatement.close();
                resultSet.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("ERRADO");
            return false;
        }
    }
    
    public List<Product> getListProduct() {
        String sql = "select * from product";
        List<Product> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Product obj = new Product();
                obj.setId(rs.getInt("idProduct"));
                obj.setName(rs.getString("name"));
                obj.setCost(rs.getDouble("cost"));
                obj.setPercentProfit(rs.getDouble("percentProfit"));
                obj.setPriceSale(rs.getDouble("priceSale"));
                obj.setQuantity(rs.getInt("quantity"));
                obj.setIdProvider(rs.getInt("provider_idProvider"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOProduct"+e.getMessage());
        }
        return lista;
    }
    
    public List<Product> getProductsDisplay(){
        String sql = "SELECT p.idProduct, p.name, b.name AS brandName, p.priceSale, p.quantity, p.cost, pv.companyName\n" +
                     "FROM product AS p, provider AS pv, brand AS b\n" +
                     "WHERE b.idBrand = p.brand_idbrand AND pv.idProvider = p.provider_idprovider;";
        List<Product> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Product obj = new Product();
                obj.setId(rs.getInt("idProduct"));
                obj.setName(rs.getString("name"));
                obj.setBrandName(rs.getString("brandName"));
                obj.setPriceSale(rs.getDouble("priceSale"));
                obj.setQuantity(rs.getInt("quantity"));
                obj.setCost(rs.getDouble("cost"));
                obj.setCompanyName(rs.getString("companyName"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOProduct"+e.getMessage());
        }
        return lista;
    }
    
    public List<Client> getClientsDisplay(){
        String sql = "SELECT c.idClient, c.name, c.city, c.fu, c.email, c.contact \n" +
                     "FROM client AS c;";
        List<Client> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Client obj = new Client();
                obj.setId(rs.getInt("idClient"));
                obj.setName(rs.getString("name"));
                obj.setAdress(rs.getString("city"));
                obj.setCity(rs.getString("city"));
                obj.setFu(rs.getString("fu"));
                obj.setEmail(rs.getString("email"));
                obj.setContact(rs.getString("contact"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOProduct"+e.getMessage());
        }
        return lista;
    }
    
    public List<Client> getClientNames() {
        
        
        String sql = "SELECT c.name FROM client AS c;";
        List<Client> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Client obj = new Client();
                obj.setName(rs.getString("name"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOGetSalesDisplay"+e.getMessage());
        }
        return lista;
    }
    
    public List<Product> getProductForSale() {
        String sql = "SELECT p.name, p.idProduct, p.priceSale, p.quantity FROM product AS p;";
        List<Product> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Product obj = new Product();
                obj.setName(rs.getString("name"));
                obj.setId(rs.getInt("idProduct"));
                obj.setPriceSale(rs.getDouble("priceSale"));
                obj.setQuantity(rs.getInt("quantity"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOGetSalesDisplay"+e.getMessage());
        }
        return lista;
    }
    
    public List<Sale> getSalesDisplay(){
        String sql = "SELECT s.idSale, s.date, c.name AS clientName, u.name AS userName\n" +
                     "FROM user AS u, client AS c, sale AS s \n" +
                     "WHERE s.User_idUser = u.idUser AND s.Client_idClient = c.idClient;";
        List<Sale> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Sale obj = new Sale();
                obj.setIdSale(rs.getInt("idSale"));
                //CONVERTENDO DATE EM CALENDAR:
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.sql.Date dt = rs.getDate("date");
                obj.setDate(dt);
                obj.setUserName(rs.getString("userName"));
                obj.setClientName(rs.getString("clientName"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOGetSalesDisplay"+e.getMessage());
        }
        return lista;
    }
    
    public List<Provider> getProvidersDisplay() {
        String sql = "SELECT p.companyName, p.ownerName, p.adress, p.city, p.fu, p.cnpj, p.email, p.contact FROM provider AS p;";
        List<Provider> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Provider obj = new Provider();
                obj.setCompanyName(rs.getString("companyName"));
                obj.setOwnerName(rs.getString("ownerName"));
                obj.setAdress(rs.getString("adress"));
                obj.setCity(rs.getString("city"));
                obj.setFu(rs.getString("fu"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setContact(rs.getString("contact"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOGetSalesDisplay"+e.getMessage());
        }
        return lista;
    }
    
    public List<User> getUsersDisplay() {
        String sql = "SELECT u.name, u.username, u.city, u.adress, u.fu, u.cpf, u.rg, u.email, u.contact FROM user AS u;";
        List<User> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                User obj = new User();
                obj.setName(rs.getString("name"));
                obj.setUsername(rs.getString("username"));
                obj.setCity(rs.getString("city"));
                obj.setAdress(rs.getString("adress"));
                obj.setFu(rs.getString("fu"));
                obj.setCpf(rs.getString("cpf"));
                obj.setRg(rs.getString("rg"));
                obj.setEmail(rs.getString("email"));
                obj.setContact(rs.getString("contact"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOGetSalesDisplay"+e.getMessage());
        }
        return lista;
    }
    
    public List<MonthlyFixedExpense> getMonthlyFixedExpense() {
        String sql = "select * from monthlyfixedexpense";
        List<MonthlyFixedExpense> lista = new ArrayList<>();
        try{
            PreparedStatement pst = getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                MonthlyFixedExpense obj = new MonthlyFixedExpense();
                //CONVERTENDO DATE EM CALENDAR:
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");;
                java.sql.Date dt = rs.getDate("dateFixedExpense");
//                System.out.println(dt);
//                Calendar c = Calendar.getInstance();
//                System.out.println(c);
//                c.setTime(dt);
//                System.out.println(c);
                obj.setDate(dt);
                obj.setEmployees(rs.getDouble("employee"));
                obj.setEquipment(rs.getDouble("equipment"));
                obj.setLoan(rs.getDouble("loan"));
                obj.setMaintenance(rs.getDouble("maintenance"));
                obj.setMonthlyTax(rs.getDouble("monthlyTax"));
                obj.setOthers(rs.getDouble("others"));
                obj.setRent(rs.getDouble("rent"));
                obj.setUseMaterial(rs.getDouble("useMaterial"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOgetMonthlyFixedExpense"+e.getMessage());
        }
        return lista;
    }
    
    public List<Sale> getSales() {
        return null;
    }

//    // CLIENTE
//    public List<Cliente> getListaCliente(){
//        String sql = "select * from cliente";
//        List<Cliente> lista = new ArrayList<>();
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                Cliente obj = new Cliente();
//                obj.setCodigo(rs.getInt("idcliente"));
//                obj.setNome(rs.getString("nome"));
//                obj.setEndereco(rs.getString("endereco"));
//                obj.setEmail(rs.getString("email"));
//                obj.setTelefone(rs.getString("telefone"));
//                lista.add(obj);
//            }
//    }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOCliente"+e.getMessage());
//    }
//        return lista;
//    }
//    
//    
//    public boolean salvar(Cliente obj) {
//       if(obj.getCodigo()==null)
//       return incluir(obj);
//        else{
//            return alterar(obj);
//        }
//    }
//    public boolean incluir (Cliente obj){
//        String sql = "insert into cliente(nome,endereco,email,telefone) values(?,?,?,?)";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setString(1,obj.getNome());
//            pst.setString(2, obj.getEndereco());
//            pst.setString(3, obj.getEmail());
//            pst.setString(4, obj.getTelefone());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.incluir(Cliente) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean alterar (Cliente obj){
//        String sql = "update cliente set nome=?, endereco=?, email=?, telefone=? where idcliente=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setString(1,obj.getNome());
//            pst.setString(2, obj.getEndereco());
//            pst.setString(3, obj.getEmail());
//            pst.setString(4, obj.getTelefone());
//            pst.setInt(5, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Cliente não alterado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.alterar(Cliente) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean remover (Cliente obj){
//        String sql = "delete from cliente where idcliente=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            
//            pst.setInt(1, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Cliente não excluido");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.remover(Cliente) = "+e.getMessage());
//        }
//        return false;
//    }//FIM CLIENTE
//    
//    //PRODUTO
//    public List<Produto> getListaProduto(){
//        String sql = "select * from produto";
//        List<Produto> lista = new ArrayList<>();
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                Produto obj = new Produto();
//                obj.setCodigo(rs.getInt("idproduto"));
//                obj.setNome(rs.getString("nome"));
//                obj.setPrecocusto(rs.getDouble("precocusto"));
//                obj.setMargemlucro(rs.getDouble("margemlucro"));
//                obj.setPrecovenda(rs.getDouble("precovenda"));
//                obj.setQtdestoque(rs.getInt("qtdestoque"));
//                lista.add(obj);
//            }
//    }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de SQL no Conexao.getListaProduto = "+e.getMessage());
//    }
//        return lista;
//    }
//    
//    
//    public boolean salvar(Produto obj) {
//        if(obj.getCodigo()==null)
//            return incluir(obj);
//        else{
//            return alterar(obj);
//        }
//    }
//    public boolean incluir (Produto obj){
//        String sql = "insert into produto(nome,precocusto,precovenda,qtdestoque) values(?,?,?,?)";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setString(1,obj.getNome());
//            pst.setDouble(2, obj.getPrecocusto());
//            pst.setDouble(3, obj.getPrecovenda());
//            pst.setInt(4, obj.getQtdestoque());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Produto não cadastrado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.incluir(Produto) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean alterar (Produto obj){
//        String sql = "update produto set nome=?, precocusto=?, precovenda=?, qtdestoque=? where idproduto=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setString(1,obj.getNome());
//            pst.setDouble(2, obj.getPrecocusto());
//            pst.setDouble(3, obj.getPrecovenda());
//            pst.setInt(4, obj.getQtdestoque());
//            pst.setInt(5, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Produto não alterado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.alterar(Produto) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean remover (Produto obj){
//        String sql = "delete from produto where idproduto=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            
//            pst.setInt(1, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Produto não excluido");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.remover(Produto) = "+e.getMessage());
//        }
//        return false;
//    }// FIM PRODUTO
//    
//    // VENDA
//    public List<Venda> getListaVenda(){
//        String sql = "select * from venda";
//        List<Venda> lista = new ArrayList<>();
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                Venda obj = new Venda();
//                obj.setCodigo(rs.getInt("idvenda"));
//                java.sql.Date dt = rs.getDate("datahora");
//                Calendar c = Calendar.getInstance();
//                obj.setClienteidcliente(rs.getInt("cliente_idcliente"));
//                lista.add(obj);
//            }
//    }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de SQL no Conexao.getListaVenda = "+e.getMessage());
//    }
//        return lista;
//    }
//    
//    
//    public boolean salvar(Venda obj) {
//       if(obj.getCodigo()==null)
//       return incluir(obj);
//        else{
//            return alterar(obj);
//        }
//    }
//    
//    public Integer getUltimaVenda(){
//        String sql = "SELECT LAST_INSERT_ID() AS id;";
//         try{
//            Integer lastId;
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);      
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                lastId = rs.getInt("id");
//                return lastId;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.incluir(Venda) = "+e.getMessage());
//            return null;
//        }
//        return null;
//    }
//    
//    public boolean incluir (Venda obj){
//        String sql = "insert into venda(cliente_idcliente) values(?)";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);            
//            pst.setInt(1, obj.getClienteidcliente());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Venda não cadastrado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.incluir(Venda) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean alterar (Venda obj){
//        String sql = "update venda set cliente_idcliente=? where idvenda=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setInt(1,obj.getClienteidcliente());
//            pst.setInt(2, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Venda alterada com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Venda não alterada");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.alterar(Venda) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean remover (Venda obj){
//        String sql = "delete from venda where idvenda=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            
//            pst.setInt(1, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Venda excluida com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Venda não excluida");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.remover(Venda) = "+e.getMessage());
//        }
//        return false;
//    }// FIM VENDA
//   
//    // ITEM VENDA
//     public List<ItemVenda> getListaItemVenda(Integer idvenda){
//        String sql = "select * from itemvenda where itemvenda.venda_idvenda ="+idvenda+";";
//        List<ItemVenda> lista = new ArrayList<>();
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                ItemVenda obj = new ItemVenda();
//                obj.setCodigo(rs.getInt("iditemvenda"));
//                obj.setQuantidade(rs.getInt("quantidade"));
//                obj.setIdvenda(rs.getInt("venda_idvenda"));
//                obj.setIdproduto(rs.getInt("produto_idproduto"));
//                lista.add(obj);
//            }
//    }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de SQL no Conexao.getListItemVenda = "+e.getMessage());
//    }
//        return lista;
//    }
//    
//    public boolean incluir (ItemVenda obj){
//        String sql = "insert into itemvenda(quantidade,venda_idvenda,produto_idproduto) values(?,?,?);";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);            
//            pst.setInt(1, obj.getQuantidade());     
//            pst.setInt(2, obj.getIdvenda());          
//            pst.setInt(3, obj.getIdproduto());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Item de venda cadastrado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Item de venda não cadastrado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.incluir(ItemVenda) = "+e.getMessage());
//        }
//        return false;
//    }
//    
//    public boolean alterar (ItemVenda obj){
//        String sql = "update itemvenda set quantidade=?, venda_idvenda=?, produto_idproduto=? where idvenda=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            pst.setInt(1,obj.getQuantidade());
//            pst.setInt(2,obj.getIdvenda());
//            pst.setInt(3,obj.getIdproduto());
//            pst.setInt(4,obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Item de venda alterado com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Item de venda não alterado");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro no sql no Conexao.alterar (ItemVenda) = "+e.getMessage());
//        }
//        return false;
//    }
//    public boolean remover (ItemVenda obj){
//        String sql = "delete from itemvenda where iditemvenda=?";
//        try{
//            PreparedStatement pst = Conexao.getPreparedStatement(sql);
//            
//            pst.setInt(1, obj.getCodigo());
//            if(pst.executeUpdate()>0){
//                JOptionPane.showMessageDialog(null, "Item de venda excluido com sucesso");
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "Item de venda não excluido");
//                return false;
//            }
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Erro de sql no Conexao.remover(ItemVenda) = "+e.getMessage());
//        }
//        return false;
//    }// FIM ITEM VENDA;
}
