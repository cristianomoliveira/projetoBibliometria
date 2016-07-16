package testes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import model.domain.ManipuladorDeArquivos;
import model.domain.No;



/**
 *
 * @author cristiano
 */
public class TesteExpressaoRegular {
    
    public static void main (String[] args) throws FileNotFoundException{
    
    
    ArrayList<String[]> texto = new ArrayList<String[]>();
    File arquivo = new File("C://testes//scopus(com 4).csv"); 
    ManipuladorDeArquivos ma = new ManipuladorDeArquivos();
    texto = ma.getLinhasScopus(arquivo);
    
    for(int i=0;i<texto.size();i++){
        
        System.out.println(texto.get(i)[13]);
    }
    
    
	
    }
    
}
