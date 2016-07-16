package testes;




import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import model.domain.Autor;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class testeAutores {
    
    
     
    public static void main (String args[]){
    
      
        ArrayList<Autor> lista = new ArrayList<Autor>();
        
        lista.add(new Autor(1,"Ribeiro P.C.C."));
        lista.add(new Autor(2,"Scavarda A.J."));
        lista.add(new Autor(3,"Ribeiro P.C.C."));
        
        //lista de arestas únicas
        TreeSet<Autor> autoresOrdenados = new TreeSet<Autor>();
      
     
      
        
        ManipuladorDeArquivos m = new ManipuladorDeArquivos();
        autoresOrdenados = m.geraTreeSetAutores(lista);

        String texto = m.listarAutoresOrdenados(autoresOrdenados);
       
        System.out.println(texto); 
    }
}
