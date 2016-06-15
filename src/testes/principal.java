package testes;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import model.domain.Artigo;
import model.domain.Autor;
import model.domain.ManipulaArquivo;


/**
 *
 * @author cristiano
 */
public class principal {
    
    
    public static void main (String args[]){
        
        
        //String nomeArquivo ="C:\\Desenvolvimento\\Python\\entrada\\AutoresComTrabalhos.csv";
        
        
        
        
        
        
        String nomeArquivo ="C:\\Desenvolvimento\\scopus.csv";
        File arquivo = new File(nomeArquivo);
        ManipulaArquivo m = new ManipulaArquivo();
        //Gerar lista de autores de cada trabalho
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        //Autor autor ; 
        artigos = m.lerAutoresPorArtigo(arquivo);
        
        //percorrendo lista de artigos
        System.out.println("Listando os autores");
        System.out.println("----------------------------------");
        for (int i=0; i<artigos.size();i++){
            
            Artigo artigo = artigos.get(i);
            System.out.println("----------------------------------");
            System.out.println("Artigo: "+artigo.getId());
            System.out.println("----------------------------------");
           
            autores = artigo.getAutores();
            
            //percorrendo lista de autores
            
            if (autores.size()>0){
            
                
                
                //System.out.println("tamanho da lista: "+autores.size());
                //String autor = autores.get(i);
                
                for (int j=0; j<autores.size(); j++){

                      Autor autor = autores.get(j);
                      System.out.println(autor.getNome());
                  }
            
                }
            
            

            
        }
        
        
        
        
        
        
        
       /* 
        String textoTeste = "Id Trabalho;IdAutor;Autor\n" +
                            "1;34; Ramanathan R.\n" +
                            "1;21;Ko L.W.L.\n" +
                            "1;10;Oliveira C.\n" +
                            "1;6;Chen H.";
        
        */
        
        
        //Criando arquivo para escrever:
       /*
       FileWriter escritor; 
       try {
            escritor = new FileWriter(nomeArquivo);
             m.escreveCsv(textoTeste, escritor);
        } catch (IOException ex) {
            
        }
        */
       /*

        //Lendo Arquivo de Entrada
        System.out.println("Arquivo de Entrada");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = m.lerCsv(arquivo);
        
        
        
        //System.out.println(texto.get(0));
        System.out.println("-------------------");
        //System.out.println("Id Trabalho - IdAutor - Autor");
        
        
        
        //Gerar arquivo de saída
        String linha = "";
        String idTrabalho = null; 
        String idAutor = null; 
        String autor = null; 
        String[] dados = null;
        
        int j = 0;
        //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            
            //System.out.println("Linha: "+i);
            linha = texto.get(i);
            dados = linha.split(", ");
            
            
            //idTrabalho = dados[0];
            //idAutor = dados[1];
            //autor = dados[2];
            
            System.out.println(linha);
            //System.out.println(dados[0]);
            
            autor = dados[0].replace("\"", "");
            //autor = dados[0];
            System.out.println(autor);
            j = 1;

            while(dados[j].contains("\"")==false){
                autor = dados[j];
                System.out.println(autor);
                j++;
            }
            //autor = dados[j].replace("\"", "");

            linha = dados[j];
            dados = linha.split(",");
            autor = dados[0].replace("\"", "");
            System.out.println(autor);
            
            
            
            
            
            
            
            
            
        }
        */
        
        
        
    }
    
}
