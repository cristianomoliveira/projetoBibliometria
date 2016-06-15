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
import model.domain.ManipulaArquivo;
import model.domain.No;



/**
 *
 * @author cristiano
 */
public class testaArtigos {
    
    
    
    public static void main (String args[]){
    
      
        
        
        
        List<Aresta> lista = new ArrayList<Aresta>();
        lista.add(new Aresta(1,new No("Ribeiro P.C.C."),
                new No("Scavarda A.J."),"Undirected",1));
        lista.add(new Aresta(2,new No("Scavarda A.J."),
                new No("Ribeiro P.C.C."),"Undirected",1));
        lista.add(new Aresta(3,new No("Ribeiro P.C.C."),
                new No("Scavarda A.J."),"Undirected",1));
        
         /*
        List<String> listaNomes = new ArrayList<String>();
        
        
       
        
        Iterator<Aresta> iterador = lista.iterator();
        while(iterador.hasNext()){
            Aresta aresta = iterador.next();
            //System.out.println("-------");
            //System.out.println("Nome Origem: "+aresta.getOrigem().getLabel());
            //System.out.println("Nome Destino: "+aresta.getDestino().getLabel());
            //System.out.println("-------");
            listaNomes.add(aresta.getOrigem().getLabel());
            listaNomes.add(aresta.getDestino().getLabel());
        
        }
        
        Aresta a1 = lista.get(0);
        
        System.out.println(a1.toString());
        Aresta a2 = lista.get(1);
        System.out.println(a2.toString());
        if (a1.equals(a2)){
            System.out.println("Arestas iguais");
            
        }else{
            System.out.println("Arestas diferentes");
        }
        
     
        listaNomes.add("aaaa");
        listaNomes.add("bbbb");
        listaNomes.add("aaaa");
       */
      
      //lista sem repetidos
      Aresta a = new Aresta();
      Iterator<Aresta> iteradorAresta = lista.iterator();
      TreeSet<Aresta> arestasOrdenadas = new TreeSet<Aresta>();
      while(iteradorAresta.hasNext()){
        a=iteradorAresta.next();
        arestasOrdenadas.add(a);
        System.out.println("-------");
        System.out.println(a.toString());
        //System.out.println("Nó: "+iterador.next());
        System.out.println("-------");

        }
      
      
      
      ManipulaArquivo m = new ManipulaArquivo();
     // List<Aresta> arestas = lista;
        int cont = 0;
        //for (Aresta aresta:arestas){
       
        
        for (Aresta aresta:arestasOrdenadas){
            
            
            cont = m.frequeciaArestas(lista, aresta);
            System.out.println(aresta.toString()+"frequencia: "+
                    cont);
            
        }        
              
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
