/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.filme;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.dao_filme;
/**
 *
 * @author Suporte
 */
public class listaFilmes extends javax.swing.JFrame {
    List<filme> listaFilmes;

    /**
     * Creates new form listaCategoria
     */
    public listaFilmes() {
        initComponents();
        listarFilmes();
       
    }

   
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabFilmes = new javax.swing.JTable();
        btnNova = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabFilmes.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Categoria", "Preço", "N° Dias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabFilmes);

        btnNova.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNova.setText("Nova");
        btnNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNova)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addContainerGap(443, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNova)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaActionPerformed
        new cadastroFilmes(this).setVisible(true);
    }//GEN-LAST:event_btnNovaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tabFilmes.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um filme para alterar!");
        }else {
            
            cadastroFilmes cadFilmes = new cadastroFilmes(this); //tela categoria para alteração
            cadFilmes.setJogo(listaFilmes.get(linha));
            cadFilmes.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tabFilmes.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um filme para excluir!");
        }else {
            filme f = listaFilmes.get(linha);
            int opcao = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir o filme: "+f.getTitulo()+"?",
                    "Confirme a exclusão", JOptionPane.YES_NO_OPTION);
            
            if (opcao == JOptionPane.YES_NO_OPTION){
                if(dao_filme.excluir(f.getId())){
                    listarFilmes();
                    JOptionPane.showMessageDialog(this, "Filme excluído com sucesso!");
                    
                }else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o Filme!");
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(listaFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaFilmes().setVisible(true);
            }
        });
    }

    public void listarFilmes() {
       listaFilmes = dao_filme.listar();
       DefaultTableModel modelo = (DefaultTableModel)tabFilmes.getModel();
       modelo.setRowCount(0); //eliminar linhas tabela
       
       for(filme f: listaFilmes){
           Object[] linha = {
               f.getTitulo(),
               f.getCategoria().getNome(),
               f.getPreco(),
               f.getNumDias()
           
           };  
          
           modelo.addRow(linha);
         
       }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNova;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabFilmes;
    // End of variables declaration//GEN-END:variables
}
