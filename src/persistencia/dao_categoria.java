/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import entidades.categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
/**
 *
 * @author Suporte
 */
public class dao_categoria {  
    
  
     public static boolean inserir(categoria categoria){
     
        try { 
            Connection con = conexao.getConexao();
            String sql = "INSERT INTO categoria(nome, tipo) VALUES(?,?)";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
           
            comando.execute();
            comando.close();
            return true;
        }  
        catch (Exception e) { 
            return false;
        } }
      public static boolean alterar(categoria categoria){
      
      try {
          Connection con = conexao.getConexao();
          String sql = "UPDATE categoria SET"+"nome=?"+"tipo= ?"+"WHERE id = ?";
          PreparedStatement comando = con.prepareStatement(sql);
          comando.setString(1, categoria.getNome());
          comando.setString(2, String.valueOf(categoria.getTipo()));
          comando.setInt(3, categoria.getId());
          
          int nrLinhas = comando.executeUpdate();
          comando.close();
          return nrLinhas>0;
      }catch (Exception e) { 
            return false;
        } }
      
     public static boolean excluir(int id) {
            try {
          
          Connection con = conexao.getConexao();
          String sql = "DELETE FROM categoria WHERE id=?";
          PreparedStatement comando = con.prepareStatement(sql);
          comando.setInt(1,id);
 
          int nrLinhas = comando.executeUpdate();
          comando.close();
          return nrLinhas>0;
          
          
            }catch (Exception e) { 
            System.out.println(e.getMessage());
            return false;
        } }

     public static ArrayList<categoria> listar(){
         ArrayList<categoria> categorias = new ArrayList<categoria>();
     
     try { 
            Connection con = conexao.getConexao();
            String sql = "SELECT*FROM categoria";
            Statement comando = con.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()) {
                categoria c = new categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setTipo(resultado.getString("tipo").charAt(0));
                categorias.add(c);
            }
            resultado.close();
            comando.close();
             }catch (Exception e) { 
            System.out.println(e.getMessage());
     }
     return categorias;
     }
    
     public static ArrayList<categoria> listarPorTipo(char tipo){
    ArrayList<categoria> categorias = new ArrayList<categoria>();
     
     try { 
            Connection con = conexao.getConexao();
            String sql = "SELECT*FROM categoria WHERE tipo = ?";
            
             PreparedStatement comando = con.prepareStatement(sql);
             comando.setString(1,String.valueOf(tipo));
             ResultSet resultado = comando.executeQuery();
             
             while(resultado.next()) {
                categoria c = new categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setTipo(tipo);
                categorias.add(c);
            }
            resultado.close();
            comando.close();
             }catch (Exception e) { 
            System.out.println(e.getMessage());
     
    }
        return categorias;

}
}