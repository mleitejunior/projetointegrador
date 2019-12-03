package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Product;

public class Connect {
    private static final String sqlAdress ="jdbc:mysql://localhost:3306/sevensales";
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user ="root";
    private static final String password ="";
    private static Connection con = null;
    
    public Connect (){}
    
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
        System.out.println("Encontrou o driver");
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
                   int id;
    String name;
    float cost;
    float percentProfit;
    float productExpenses;
    float priceSale;
    int quantity;
    int idProvider;
                obj.setId(rs.getInt("idProduct"));
                obj.setName(rs.getString("name"));
                obj.setCost(rs.getFloat("cost"));
                obj.setPercentProfit(rs.getFloat("percentProfit"));
                obj.setProductExpense(rs.getFloat("productExpense"));
                obj.setPriceSale(rs.getFloat("priceSale"));
                obj.setQuantity(rs.getInt("quantity"));
                obj.setIdProvider(rs.getInt("provider_idProvider"));
                lista.add(obj);
            }
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro de SQL no getLista de DAOProduct"+e.getMessage());
        }
        return lista;
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
