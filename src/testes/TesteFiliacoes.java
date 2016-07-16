package testes;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.domain.ManipuladorDeArquivos;
import model.domain.ManipuladorDeGrafos;
import model.domain.No;

/**
 *
 * @author cristiano
 */
public class TesteFiliacoes {
    
    public static void main (String args[]) throws FileNotFoundException, IOException{
    
        //pegar o nome do arquivo
        //String arquivo = "C://testes//Affiliations(com28).csv";
       File arquivo = new File("C://testes//scopus(com 28).csv"); 
        
        ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
           
         //nesse ArrayList existem nós repetidos
         ArrayList<No> nosPaises = ma.getPaises(arquivo);
         ArrayList<No> nosUnicos = ma.getPaisesUnicos(nosPaises);
         
        String texto = "Id;Latitude;Longitude;Label"+"\n";
        for (No no : nosUnicos){
            
            
            System.out.println("País: "+ no.getId()+no.getLabel());
            texto = texto +no.getId()+";;;"+no.getLabel()+"\n";
            
        }
        
        System.out.println(texto);
        
        
        //pegar o nome do arquivo para salvar
        File arquivoW = new File("C://testes//paises.csv");
        
        FileWriter fw = new FileWriter( arquivoW );
        ma.escreveCsv(texto, fw);
              
    }
        
}
        
    
    
    
    
      
