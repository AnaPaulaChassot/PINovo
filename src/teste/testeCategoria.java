/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidades.categoria;
import persistencia.dao_categoria;
/**
 *
 * @author Suporte
 */
public class testeCategoria {
    public static void main(String[] args) {
        categoria cat = new categoria();
        cat.setNome("Senac");
        cat.setTipo('F');
        
        cat.setId(1);
        System.out.println(dao_categoria.excluir(1));
    }
}
