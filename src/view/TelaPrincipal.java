/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.domain.Artigo;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraDeMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuGrafos = new javax.swing.JMenu();
        menuCoautoria = new javax.swing.JMenu();
        menuGerarNosCoautoria = new javax.swing.JMenuItem();
        menuGerarArestasCoautoria = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuRedeGeografica = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuCitracoes = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuArquivo.setText("Arquivo");
        barraDeMenu.add(menuArquivo);

        menuGrafos.setText("Grafos");

        menuCoautoria.setText("Rede de Coautotia");

        menuGerarNosCoautoria.setText("Gerar Nós");
        menuGerarNosCoautoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGerarNosCoautoriaActionPerformed(evt);
            }
        });
        menuCoautoria.add(menuGerarNosCoautoria);

        menuGerarArestasCoautoria.setText("Gerar Arestas");
        menuCoautoria.add(menuGerarArestasCoautoria);

        menuGrafos.add(menuCoautoria);
        menuGrafos.add(jSeparator1);

        menuRedeGeografica.setText("Rede Geográfica");
        menuGrafos.add(menuRedeGeografica);
        menuGrafos.add(jSeparator2);

        menuCitracoes.setText("Rede Citações");
        menuGrafos.add(menuCitracoes);

        barraDeMenu.add(menuGrafos);

        menuAjuda.setText("Ajuda");
        barraDeMenu.add(menuAjuda);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGerarNosCoautoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGerarNosCoautoriaActionPerformed
        
        
         //código para gerar nós

        //tipos de arquivos a serem escolhidos:
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("CSV", "csv");

        //Usando o JfileChooser
        JFileChooser fc = new JFileChooser();

        //adicionando tipos de arquivos que podem ser escolhidos
        fc.setFileFilter(filtro);

        //título da tela
        fc.setDialogTitle("Escolha o arquivo ...");

        //escolhendo somente arquivos
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        //resposta da janela
        int resposta = fc.showOpenDialog(this);

        //verificando a resposta:
        //Se o usuário clicar em OK
        if(resposta == JFileChooser.APPROVE_OPTION){

            File arquivo = fc.getSelectedFile();

            ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
            ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
            ArrayList <Artigo> artigos = new ArrayList<Artigo>();
            ArrayList <Autor> autores = new ArrayList<Autor>();
            ArrayList <Autor> autoresTotais = new ArrayList<Autor>();
            //ArrayList<Autor> lista = new ArrayList<Autor>();
            ArrayList<No> nos = new ArrayList<No>();
            System.out.println("Gerando nós");
            //nos = ma.lerArrayListNos(arquivo);
            
            artigos = ma.getArtigosScopus(arquivo);
            
            
            
            
            
            for(Artigo a:artigos){
               // System.out.println(a.getTitulo());
                autores = a.getAutores();
                for(Autor autor:autores){
                   // System.out.println("--"+autor.getNome());
                    autoresTotais.add(autor);
                }
            }
            
           
            
            
            nos = ma.autoresEmNos(autoresTotais);
            
            
            
            
            
            String textoEscrita = mg.gerarTextoNosArrayList("", nos);
            
            

            //Com os nós gerados agora serão salvos no arquivo
            //.csv escolhido pelo usuário
            //salvando o arquivo
            fc.setDialogTitle("Salvando o arquivo");
            //resposta da janela
            int resposta2 = fc.showOpenDialog(this);

            //verificando a resposta:
            //Se o usuário clicar em OK
            if(resposta2 == JFileChooser.APPROVE_OPTION){

                //Falta salvar o arquivo

                File arqSalvo = fc.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter( arqSalvo );
                    ma.escreveCsv(textoEscrita, fw);
                    JOptionPane.showMessageDialog(this, "Arquivo salvo");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro"+ex);
                }

            }
            
        }

        
        
        
        
        
    }//GEN-LAST:event_menuGerarNosCoautoriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuCitracoes;
    private javax.swing.JMenu menuCoautoria;
    private javax.swing.JMenuItem menuGerarArestasCoautoria;
    private javax.swing.JMenuItem menuGerarNosCoautoria;
    private javax.swing.JMenu menuGrafos;
    private javax.swing.JMenu menuRedeGeografica;
    // End of variables declaration//GEN-END:variables
}
