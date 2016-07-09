
package model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author cristiano
 */
public class Artigo {
    
    private int id;
    private String titulo;
    //a lista de autores é ordenada
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    private ArrayList<String> filiacoes = new ArrayList<String>();

    
    public Artigo (){
    
    //this.autores =  new ArrayList<Autor>();
    }
    
    public Artigo(int i) {
        
        this.setId(id);
    }

    
    public void inserirFiliacao(String f){
        
        //System.out.println("Inserindo "+f);
        this.filiacoes.add(f);
        
        //System.out.println("A lista tem "+this.filiacoes.size());
        for (int i=0; i<this.filiacoes.size(); i++){
         
         
         //System.out.println(filiacoes.get(i));
     }
        
       
    }
    
    

    public void inserirAutor(Autor autor){
        
        //System.out.println("Inserindo "+autor.getNome());
        this.autores.add(autor);
        
        //System.out.println("A lista tem "+this.autores.size());
        for (int i=0; i<this.autores.size(); i++){
         
         //autor = autores.get(i);
         //System.out.println(autores.get(i).getNome());
     }
        
       
    }
    
    public ArrayList<Autor> getAutores(){
        
        return this.autores;
        
    }
    
    
    public ArrayList<String> getFiliacoes(){
        
        return this.filiacoes;
        
    }
    
    
    public Artigo(String titulo){
        
        this.setTitulo(titulo);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    @Override
    public String toString() {
        return "Artigo{" + "id=" + this.getId() + ", nome=" + this.getTitulo() + '}';
    }
    
}
