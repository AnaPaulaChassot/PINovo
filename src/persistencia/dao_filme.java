/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import entidades.categoria;
import entidades.filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
    
/**
 *
 * @author Suporte
 */
public class dao_filme {
    
     public static boolean inserir(filme f){
     
        try { 
            Connection con = conexao.getConexao();
            String sql = "INSERT INTO filme(titulo, descricao, preco, numDias, categoria_id, duracao, diretor) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, f.getTitulo());
             comando.setString(2, f.getDescricao());
              comando.setDouble(3, f.getPreco());
               comando.setInt(4, f.getNumDias());
               comando.setInt(5, f.getCategoria().getId());
               comando.setInt(6, f.getDuracao());
               comando.setString(7, f.getDiretor());
            int resultado = comando.executeUpdate();
            comando.close();
            return resultado>0;
        }  
        catch (Exception e) { 
            System.out.println(e);
            return false;
        } }
      public static boolean alterar(filme f){
      
      try {
          Connection con = conexao.getConexao();
          String sql = "UPDATE filme SET "+"titulo=?, descricao=?, preco=?, numDias=?, " +"categoria_id=?, duracao=?, diretor=? "+"WHERE id = ?";
          PreparedStatement comando = con.prepareStatement(sql);
           comando.setString(1, f.getTitulo());
             comando.setString(2, f.getDescricao());
              comando.setDouble(3, f.getPreco());
               comando.setInt(4, f.getNumDias());
                 comando.setInt(5, f.getCategoria().getId());
               comando.setInt(6, f.getDuracao());
               comando.setString(7, f.getDiretor());
               comando.setInt(8, f.getId());
          
         int resultado = comando.executeUpdate();
            comando.close();
            return resultado>0;
        }  
        catch (Exception e) { 
            System.out.println(e);
            return false;
        }}
      
     public static boolean excluir(int id) {
            try {
          
          Connection con = conexao.getConexao();
          String sql = "DELETE FROM filme WHERE id=?";
          PreparedStatement comando = con.prepareStatement(sql);
          comando.setInt(1,id);
 
          int resultado = comando.executeUpdate();
          comando.close();
          return resultado>0;
          
          
            }catch (Exception e) { 
            System.out.println(e);
            return false;
        } }

     public static List<filme> listar(){
         List<filme> filmes = new ArrayList<filme>();
     
     try { 
            Connection con = conexao.getConexao();
            String sql = "select filme.*, categoria.nome as categoria, categoria.tipo as tipo_categoria "
                    +"from filme "+"inner join categoria on filme.categoria_id=categoria.id";
            Statement comando = con.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()) {
                categoria c = new categoria();
                c.setId(resultado.getInt("categoria_id"));
                c.setNome(resultado.getString("categoria"));
                c.setTipo(resultado.getString("tipo_categoria").charAt(0));
                filme f = new filme(c);
                 f.setId(resultado.getInt("id"));
                  f.setDescricao(resultado.getString("descricao"));
                   f.setDuracao(resultado.getInt("duracao"));
                   f.setNumDias(resultado.getInt("NumDias"));
                   f.setPreco(resultado.getDouble("preco"));
                   f.setDiretor(resultado.getString("diretor"));
                   f.setTitulo(resultado.getString("titulo"));
                   filmes.add(f);
            }
            resultado.close();
            comando.close();
             }catch (Exception e) { 
            System.out.println(e.getMessage());
     }
     return filmes;
     }
    
}
    
   