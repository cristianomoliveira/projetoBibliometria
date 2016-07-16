package testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.domain.Aresta;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class testaNos {
    
    
    public static void main (String args[]){
    
      
        File arquivo = new File("C://testes//scopus(com 28).csv");
        
        
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
        

        
        
        ArrayList<No> nos = new ArrayList<No>();
       
     
      
        
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        
        //nos = ma.lerArrayListNos(arquivo);
        
        nos.add(new No("Brazil"));
        No no = new No("Brazil");
        
        if(!mg.existeNo(no, nos)){
            
            nos.add(no);
        }else{
            System.out.println("existe");
        }
        System.out.println(mg.gerarTextoNosArrayList("", nos)); 
       
        
            
              
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
