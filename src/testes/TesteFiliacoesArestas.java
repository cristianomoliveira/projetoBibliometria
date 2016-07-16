package testes;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.domain.Aresta;
import model.domain.Artigo;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;



/**
 *
 * @author cristiano
 */
public class TesteFiliacoesArestas {
    
    
    public static void main (String args[]) throws FileNotFoundException, IOException{
    
    
        //String arquivo = "C://testes//Affiliations(com28).csv";
       File arquivo = new File("C://testes//scopus(com 28).csv"); 
       
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        //ArrayList<No> nos = new ArrayList<No>();
        
        ArrayList<No> nosPaises = ma.getPaises(arquivo);
        ArrayList<No> nosUnicos = ma.getPaisesUnicos(nosPaises);
        
        
        System.out.println("----------------");
        System.out.println("Nós paises GERAL");
        System.out.println("----------------");
        for(No n:nosPaises){
            
            System.out.println(n.getLabel());
            
        }
        System.out.println("----------------");
        
        System.out.println("----------------");
        System.out.println("Nós paises ÚNICOS");
        System.out.println("----------------");
        for(No n:nosUnicos){
            
            System.out.println(n.getLabel());
            
        }
        System.out.println("----------------");
        
        
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
        ArrayList<String> filiacoes = new ArrayList<String>();
        
       
        artigos = ma.lerFiliacoesPorArtigo(arquivo);
        /*
        for (Artigo a:artigos){
            
             filiacoes = a.getFiliacoes();
             for(String f:filiacoes){
                 System.out.println(f);
                 
             }
            
        }
        */
        
       //lista de arestas únicas
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        ArrayList<Aresta> arestasUnicas = new ArrayList<Aresta>();
        
        //gerando listagem de arestas
        arestas = mg.gerarArestasDeNosPaises(nosUnicos, artigos);
        arestasUnicas = mg.gerarArestasUnicas(arestas);


        //para calcular a frequência de cada arestas
        String textoEscrita = mg.listarArestasPaises(arestas, arestasUnicas);
        System.out.println(textoEscrita);
        
      
        
        File arquivoW = new File("C://testes//arestasPaises.csv");
        
        FileWriter fw = new FileWriter( arquivoW );
        ma.escreveCsv(textoEscrita, fw);
       
       
       
                
                     
    }
    
    
    
    
    
    
}
