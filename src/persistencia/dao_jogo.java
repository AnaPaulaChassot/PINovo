/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import entidades.categoria;
import entidades.jogo;
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
public class dao_jogo {
    
     public static boolean inserir(jogo j){
     
        try { 
            Connection con = conexao.getConexao();
            String sql = "INSERT INTO jogo(titulo, descricao, preco, numDias, " +"categoria_id, memoria, tipo) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, j.getTitulo());
             comando.setString(2, j.getDescricao());
              comando.setDouble(3, j.getPreco());
               comando.setInt(4, j.getNumDias());
               comando.setInt(5, j.getCategoria().getId());
               comando.setInt(6, j.getMemoria());
               comando.setString(7, String.valueOf(j.getTipo()));
            int resultado = comando.executeUpdate();
            comando.close();
            return resultado>0;
        }  
        catch (Exception e) { 
            System.out.println(e);
            return false;
        } }
      public static boolean alterar(jogo j){
      
      try {
          Connection con = conexao.getConexao();
          String sql = "UPDATE jogo SET"+"titulo=?, descricao=?, preco=?, numDias=?, " +"categoria_id=?, memoria=?, tipo=?"+"WHERE id = ?";
          PreparedStatement comando = con.prepareStatement(sql);
           comando.setString(1, j.getTitulo());
             comando.setString(2, j.getDescricao());
              comando.setDouble(3, j.getPreco());
               comando.setInt(4, j.getNumDias());
                 comando.setInt(5, j.getCategoria().getId());
               comando.setInt(6, j.getMemoria());
               comando.setString(7, String.valueOf(j.getTipo()));
               comando.setInt(8, j.getId());
          
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
          String sql = "DELETE FROM categoria WHERE = id?";
          PreparedStatement comando = con.prepareStatement(sql);
          comando.setInt(1,id);
 
          int resultado = comando.executeUpdate();
          comando.close();
          return resultado>0;
          
          
            }catch (Exception e) { 
            System.out.println(e);
            return false;
        } }

     public static List<jogo> listar(){
         List<jogo> jogos = new ArrayList<jogo>();
     
     try { 
            Connection con = conexao.getConexao();
            String sql = "select jogo.*, categoria.nome as categoria, categoria.tipo as tipo_categoria"
                    +"from jogo"+"inner join categoria on jogo.categoria_id=categoria.id";
            Statement comando = con.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()) {
                categoria c = new categoria();
                c.setId(resultado.getInt("categoria_id"));
                c.setNome(resultado.getString("categoria"));
                c.setTipo(resultado.getString("tipo_categoria").charAt(0));
                jogo j = new jogo(c);
                 j.setId(resultado.getInt("id"));
                  j.setDescricao(resultado.getString("descricao"));
                   j.setMemoria(resultado.getInt("memoria"));
                   j.setNumDias(resultado.getInt("NumDias"));
                   j.setPreco(resultado.getDouble("preco"));
                   j.setTipo(resultado.getString("tipo"));
                   j.setTitulo(resultado.getString("titulo"));
                   jogos.add(j);
            }
            resultado.close();
            comando.close();
             }catch (Exception e) { 
            System.out.println(e.getMessage());
     }
     return jogos;
     }
    
}
    
   