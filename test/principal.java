
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.ManipulaArquivo;


/**
 *
 * @author cristiano
 */
public class principal {
    
    
    public static void main (String args[]){
        
        
        //String nomeArquivo ="C:\\Desenvolvimento\\Python\\entrada\\AutoresComTrabalhos.csv";
        
        
        String nomeArquivo ="C:\\Desenvolvimento\\AutoresComTrabalhos.csv";
        File arquivo = new File(nomeArquivo);
        ManipulaArquivo m = new ManipulaArquivo();
        
        String textoTeste = "Id Trabalho;IdAutor;Autor\n" +
                            "1;34; Ramanathan R.\n" +
                            "1;21;Ko L.W.L.\n" +
                            "1;6;Chen H.";
        
        
        
        //Criando arquivo para escrever:
       FileWriter escritor; 
       try {
            escritor = new FileWriter(nomeArquivo);
             m.escreveCsv(textoTeste, escritor);
        } catch (IOException ex) {
            
        }
        

        //Lendo Arquivo de Entrada
        System.out.println("Arquivo de Entrada");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = m.lerCsv(arquivo);
        
        
        
        //System.out.println(texto);
        System.out.println("-------------------");
        //System.out.println("Id Trabalho - IdAutor - Autor");
        
        
        
        //Gerar arquivo de saída
        String linha = "";
        String idTrabalho = null; 
        String idAutor = null; 
        String autor = null; 
        String[] dados = null;
        //manipulando a String
        for(int i=0;i<=texto.size()-1; i++){
            
            //System.out.println("Linha: "+i);
            linha = texto.get(i);
            dados = linha.split(";");
            idTrabalho = dados[0];
            idAutor = dados[1];
            autor = dados[2];
            System.out.println(idTrabalho+" - "+idAutor+" - "+autor);
            
            
            
        }
        
        
        
        
    }
    
}
