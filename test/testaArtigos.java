
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import model.domain.Artigo;
import model.domain.Autor;



/**
 *
 * @author cristiano
 */
public class testaArtigos {
    
    
    
    public static void main (String args[]){
        
    Autor autor = new Autor("Cristiano");
    //System.out.println(autor.getNome());
    
    Artigo artigo =  new Artigo();
    artigo.setId(1);
   // System.out.println(artigo.getId());
    

    artigo.inserirAutor(autor);
    
    Autor autor2 = new Autor ("teste2");
    
    artigo.inserirAutor(autor2);
    
    ArrayList<Autor> autores = artigo.getAutores();
    /*
    System.out.println("Tamanho da lista: "+autores.size());
     for (int i=0; i<autores.size(); i++){
         
         autor = autores.get(i);
         System.out.println(autor.getNome());
     }
    */
    
    }
    
    
}
