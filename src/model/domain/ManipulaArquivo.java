
package model.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author cristiano
 */
public class ManipulaArquivo {
    
    
    
    
    public ArrayList<String> lerAutoresScopus(File csv){
        
        ArrayList<String> linhas = new ArrayList<String>();
        ArrayList<String> autores = new ArrayList<String>();
        ArrayList<String> linhasAutores = new ArrayList<String>();
        String texto = null;
        String[] dados = null;
        linhas = this.lerCsv(csv);
        
        for(int i=1; i<linhas.size();i++) {
            texto = linhas.get(i);    
            dados = texto.split(";");
            linhasAutores.add(i, dados[1]);
            
               
                //System.out.println("Linha: "+i);   
        }
        
        for(int i=1; i<linhasAutores.size();i++) {
                
            texto = linhasAutores.get(i);    
            dados = texto.split(",");
            
            for(int j=0; i<dados.length;j++) {
                autores.add(dados[j]);
            }
               
                //System.out.println("Linha: "+i);   
        }
        
        
        return linhas;
        
        
    }
    
    
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
            System.out.println(ex);
            
        }
        
        
        return linhas;
        
    }
    
    public ArrayList<String> lerAutores(File arquivo){
        
        ArrayList<String> autores = new ArrayList<String>();
        ManipulaArquivo m = new ManipulaArquivo();
        
        //Lendo Arquivo de Entrada
        System.out.println("Lendo os autores");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = m.lerCsv(arquivo);
        
        //Gerar arquivo de saída
        String linha = "";
        String autor = null; 
        String[] dados = null;
        int j = 0;
        
               //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            linha = texto.get(i);
            dados = linha.split(", ");
            System.out.println(linha);
            autor = dados[0].replace("\"", "");
            //System.out.println(autor);
            autores.add(autor);
            j = 1;
            while(dados[j].contains("\"")==false){
                autor = dados[j];
                autores.add(autor);
                //System.out.println(autor);
                j++;
            }
            linha = dados[j];
            dados = linha.split(",");
            autor = dados[0].replace("\"", "");
            autores.add(autor);
            //System.out.println(autor); 
            
        }
        
        return autores;
    }
    public TreeSet<String> geraTreeSet(ArrayList<String> texto){
        
        System.out.println("Gerando os nós");
        System.out.println("-----------------------");
        TreeSet<String> nos = new TreeSet<String>();
        
        //Iterator<String> iterador = texto.iterator();
        //iterador.next();
        for(int i =0; i<texto.size(); i++){
            
            nos.add(texto.get(i));
            System.out.println(texto.get(i));
            
        }
        
        return nos;
        
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

    public String gerarNos(String textoEscrita, TreeSet<String> nos) {
        
        String nome = "";
        //System.out.println("Inserindo Autores na lista Ordenada:");
        textoEscrita = "ID;LABEL \n";
        Iterator<String> iterador = nos.iterator();
        int id = 0;
        while(iterador.hasNext()){

            id++;
            nome =iterador.next();
            //System.out.println(nome);
            textoEscrita = textoEscrita + id+";"+nome+"\n";

        }
        return textoEscrita;
    }

    public ArrayList<Artigo> lerAutoresPorArtigo(File arquivo) {
        
        
        
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
        ManipulaArquivo m = new ManipulaArquivo();
        
        //Lendo Arquivo de Entrada
        //System.out.println("Lendo os autores por Artigo");
        //System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = m.lerCsv(arquivo);
        
        //Gerar arquivo de saída
        String linha = "";
        //String autor = null; 
        String[] dados = null;
        int j = 0;
        
         //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            linha = texto.get(i);
            dados = linha.split(", ");
            //System.out.println(i+"-"+linha);
            Artigo artigo = new Artigo();
            artigo.setId(i);
            Autor autor = new Autor (dados[0].replace("\"", ""));
            artigo.inserirAutor(autor);
            //System.out.println("inserido primeiro"+autor.getNome());
            
            j = 1;
            while(dados[j].contains("\"")==false){
                
                Autor autormeio = new Autor(dados[j]);
                //autor.setNome(dados[j]);
                artigo.inserirAutor(autormeio);
                //System.out.println("inserido meio "+autormeio.getNome());
                //System.out.println(autor.getNome());
                //autoresPorArtigo.add(autor);
                //System.out.println(autor);
                j++;
            }
            linha = dados[j];
            dados = linha.split(",");
            Autor autorFim = new Autor(dados[0].replace("\"", ""));
            //autor.setNome(dados[0].replace("\"", ""));
            artigo.inserirAutor(autorFim);
            artigos.add(artigo);
            //System.out.println(autor.getNome());
            //System.out.println(autor); 
            
        }
        
        return artigos;
        
    }
    
    
    
    public String gerarArestas(String texto ,TreeSet<String> nos, 
            ArrayList<Artigo> artigos){
        
    
    ManipulaArquivo m = new ManipulaArquivo();
    int idSource = 0;
    int idTarget = 0;
    int id = 0;    
    //listando autores por trabalho
    texto = "ID;SOURCE;TARGET \n";
    System.out.println("Artigos");
    System.out.println("--------------------");
    for(int i=0;i<=artigos.size()-1; i++){

        System.out.println("-----------------");
        System.out.println("Artigo: "+artigos.get(i).getId());
        
        System.out.println("Autores: ");
        System.out.println("-----------------");

        //percorrendo os autores de cada artigo

        int numAutores = artigos.get(i).getAutores().size();
        System.out.println("número de autores "+numAutores);
        for(int j=0;j<numAutores; j++){
            String nome1 = artigos.get(i).getAutores().get(j).getNome();

            int k = j+1;
            while(k<numAutores){
                id++;
                idSource = m.getIdNo(nome1, nos);
                String nome2 = artigos.get(i).getAutores().get(k).getNome();
                idTarget = m.getIdNo(nome2, nos);
                System.out.println(nome1+";"+nome2);
                System.out.println(idSource+";"+idTarget);
                texto = texto + id+";"+idSource+";"+idTarget+"\n";
                k++;
            }


        }



    }
        
        
        
    return texto;
        
    }

    private int getIdNo(String nome, TreeSet<String> nos) {
        
        int i =0;
        Iterator<String> iterador = nos.iterator();
        while(iterador.hasNext()){
        i++;
        //System.out.println("-------");
        //System.out.println("Nome: "+nome);
        //System.out.println("Nó: "+iterador.next());
        //System.out.println("-------");
        if(nome.equals(iterador.next()) ){
                
               // System.out.println("Nome: "+nome);
                return i;
            }
        }
        
        return i;
        
    }
    
    
}
