


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
public class testaArestas {
    
    
    
    public static void main (String args[]){
    
      
        
        
        File arquivo = new File("C://Desenvolvimento//scopus.csv");
        
        
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();

        
        
        //ArrayList<No> nos = new ArrayList<No>();
        ArrayList<Autor> autores = new ArrayList<Autor>();
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
            
        
        autores = ma.lerAutores(arquivo);
        artigos = ma.lerAutoresPorArtigo(arquivo);
       
        System.out.println("-----------------");
        System.out.println("IMPRIMINDO AUTORES -----------------");
        System.out.println("-----------------");
        int i = 0;
        for(Autor a : autores){
            i++;
            System.out.println(i+" :"+a);
        }
        
        
        System.out.println("IMPRIMINDO ARTIGOS");
        for(Artigo a : artigos){
            System.out.println(a);
        }
        
        
        //nos = ma.lerArrayListNos(arquivo);
        
       
        //System.out.println(mg.gerarTextoNosArrayList("", nos)); 
         
      
        //lista de arestas únicas
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        ArrayList<Aresta> arestasUnicas = new ArrayList<Aresta>();
      
     
      
        
        arestas = mg.gerarArestasArrayList(autores, artigos);
        System.out.println("IMPRIMINDO ARESTAS(TOTAIS)");
        i = 0;
        for(Aresta a : arestas){
            i++;
            System.out.println(i+": "+a);
        }
        
        
        
        arestasUnicas = mg.gerarArestasUnicas(arestas);
        i = 0;
        System.out.println("IMPRIMINDO ARESTAS(ÚNICAS)");
        for(Aresta a : arestasUnicas){
            i++;
            System.out.println(i+": "+a);
        }

        //para calcular a frequência de cada arestas
        String texto = mg.listarArestas(arestas, arestasUnicas);
       
        System.out.println(texto); 
       
        
            
              
            //System.out.println(aresta.toString()+": "+Collections.frequency(lista, aresta));
        
        
    /*        
    Autor autor = new Autor("Cristiano");
    System.out.println(autor.getNome());
    
    Artigo artigo =  new Artigo();
    artigo.setId(1);
    System.out.println(artigo.getId());
    

    artigo.inserirAutor(autor);
    
    Autor autor2 = new Autor ("teste2");
    
    artigo.inserirAutor(autor2);
    
    List<Autor> autores = artigo.getAutores();
    
    System.out.println("Tamanho da lista: "+autores.size());
     for (int i=0; i<autores.size(); i++){
         
         autor = autores.get(i);
         System.out.println(autor.getNome());
     }
    
    */
    }
    
    
}
