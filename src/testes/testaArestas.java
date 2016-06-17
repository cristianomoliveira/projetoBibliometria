package testes;


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
    
      
        
        
        
        List<Aresta> lista = new ArrayList<Aresta>();
        
        lista.add(new Aresta(1,new No("Ribeiro P.C.C."),
                new No("Scavarda A.J."),"Undirected",1));
        lista.add(new Aresta(2,new No("Scavarda A.J."),
                new No("Ribeiro P.C.C."),"Undirected",1));
        lista.add(new Aresta(3,new No("Ribeiro P.C.C."),
                new No("Scavarda A.J."),"Undirected",1));
        lista.add(new Aresta(3,new No("Ribeiro P.C.C."),
                new No("Oliveira C."),"Undirected",1));
        
         
      
        //lista de arestas únicas
        TreeSet<Aresta> arestasOrdenadas = new TreeSet<Aresta>();
      
     
      
        
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        arestasOrdenadas = mg.gerarArestasOrdenadas(lista);

        String texto = mg.listarArestasOrdenadas(arestasOrdenadas, lista);
       
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
