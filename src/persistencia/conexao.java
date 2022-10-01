/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
/**
 *
 * @author Suporte
 */
public class conexao {


    public static Connection getConexao() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro","root","Ana@26272852");
		 }         
		 catch(Exception excecao) {
			throw new RuntimeException(excecao);
		 }
     }
    
    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
