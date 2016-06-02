
package model.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristiano
 */
public class ManipulaArquivo {
    
    
    public ArrayList<String> lerCsv(File csv){
        
        ArrayList<String> linhas = new ArrayList<String>();
        
        try {
            
            
            
            Scanner leitor = new Scanner(csv);
            int i = 0;
            while (leitor.hasNext()){
                
                linhas.add(i, leitor.nextLine());
                i++;
                //System.out.println("Linha: "+i);
                
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            
        }
        
        
        return linhas;
        
    }
    
    
    public void escreveCsv(String texto, FileWriter csv){
        
        String[] linhas = texto.split("\n");
        try {
            //escrevendo cabeçalho
            //csv.append("IdTrabalho;IdAutor;Autor \n");
            
            for(int i=0; i<linhas.length;i++){
                System.out.println(linhas[i]);
                csv.append(linhas[i]+" \n");
                
            }
            
            
            
            
            csv.flush();
            csv.close();
           
        } catch (IOException ex) {
            
        }
     
        
        
        
    }
    
    
}
