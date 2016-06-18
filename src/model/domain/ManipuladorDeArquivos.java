
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
public class ManipuladorDeArquivos {
    
    
    
    
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
    
    public ArrayList<Autor> lerAutores(File arquivo){
        
        ArrayList<Autor> lista = new ArrayList<Autor>();
        
        /*
        lista.add(new Autor(1,"Ribeiro P.C.C."));
        lista.add(new Autor(2,"Scavarda A.J."));
        lista.add(new Autor(3,"Ribeiro P.C.C."));
        lista.add(new Autor(4,"Scavarda A.J."));
        
        */
        
        //Lendo Arquivo de Entrada
        System.out.println("Lendo os autores");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = this.lerCsv(arquivo);
        
        //Gerar arquivo de saída
        String linha = "";
        String[] dados = null;
        int j = 0;
        
               //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            linha = texto.get(i);
            dados = linha.split(", ");
            System.out.println(linha);
            //Autor autor1 = new Autor();
            //autor1.setNome(dados[0].replace("\"", ""));
            //System.out.println("Autor início: "+autor1);
            //lista.add(autor1);
            lista.add(new Autor(dados[0].replace("\"", "")));
            j = 1;
            while(dados[j].contains("\"")==false){
                //Autor autor2 = new Autor();
                //autor2.setNome( dados[j]);
                //lista.add(autor2);
                //System.out.println("Autor meio: "+autor2);
                //lista.add(new Autor("Ribeiro P.C.C."));
                lista.add(new Autor(dados[j]));
                j++;
            }
            linha = dados[j];
            dados = linha.split(",");
            //Autor autor3 = new Autor();
            //autor3.setNome(dados[0].replace("\"", ""));
            //lista.add(autor3);
            //System.out.println("Autor fim: "+autor3);
            //lista.add(new Autor("Ribeiro P.C.C."));
            lista.add(new Autor(dados[0].replace("\"", "")));
            
        }
        
        return lista;
    
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
    
    public TreeSet<Autor> geraTreeSetAutores(ArrayList<Autor> autores){
        
        System.out.println("Gerando os nós");
        System.out.println("-----------------------");
        TreeSet<Autor> nos = new TreeSet<Autor>();
        
        //Iterator<String> iterador = texto.iterator();
        //iterador.next();
        for(int i =0; i<autores.size(); i++){
            
            nos.add(autores.get(i));
            System.out.println(autores.get(i).getNome());
            
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



    public ArrayList<Artigo> lerAutoresPorArtigo(File arquivo) {
        
        
        
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
        ManipuladorDeArquivos m = new ManipuladorDeArquivos();
        
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
            System.out.println(i+"-"+linha);
            Artigo artigo = new Artigo();
            artigo.setId(i);
            Autor autor = new Autor (dados[0].replace("\"", ""));
            artigo.inserirAutor(autor);
            System.out.println("inserido primeiro"+autor.getNome());
            
            j = 1;
            while(dados[j].contains("\"")==false){
                
                Autor autormeio = new Autor(dados[j]);
                //autor.setNome(dados[j]);
                artigo.inserirAutor(autormeio);
                System.out.println("inserido meio "+autormeio.getNome());
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
            artigo.setTitulo(dados[1]);
            artigos.add(artigo);
            System.out.println("inserido meio "+autorFim.getNome());
            //System.out.println(autor.getNome());
            //System.out.println(autor); 
            
        }
        
        return artigos;
        
    }
    
    
    
    
    
    public String listarAutoresOrdenados(TreeSet<Autor> autores){
        
        String textoSaida = null;
        int cont =0;
        
        
        for (Autor autor:autores){
            
            
            cont = this.frequeciaAutores(autores, autor);
            textoSaida=textoSaida+autor.toString()+"frequencia: "+cont+"\n";
            
        }    
        
        return textoSaida;
        
        
    }

    private int frequeciaAutores(TreeSet<Autor> autores, Autor autor) {
        
        
        int frequencia = 0;
        
        for(Autor a:autores){
            
            if(a.equals(autor)){
            
                frequencia++;
            }
            
            
        }
        
        return frequencia;
    }

    public TreeSet<No> lerNos(File arquivo) {
        
        
        TreeSet<No> lista = new TreeSet<No>();
        TreeSet<String> lista2 = new TreeSet<String>();
        ArrayList<String> nos = new ArrayList<String>();
        
       /*
        lista.add(new No(1,"Ribeiro P.C.C."));
        lista.add(new No(2,"Scavarda A.J."));
        lista.add(new No(3,"Ribeiro P.C.C."));
        lista.add(new No(4,"Scavarda A.J."));
        
       //exibindo a lista
       System.out.println("LISTA: ");
        for(No no : lista){
            
            
            System.out.println(no);
            
        }
        System.out.println("-------------");
       
       */
        
        //Lendo Arquivo de Entrada
        System.out.println("Lendo os autores");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = this.lerCsv(arquivo);
        
        //Gerar arquivo de saída
        String linha = "";
        String[] dados = null;
        int j = 0;
        
        //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            linha = texto.get(i);
            dados = linha.split(", ");
            System.out.println(linha);
            
            //nos.add(dados[0].replace("\"", ""));
            nos.add("a");
            j = 1;
            while(dados[j].contains("\"")==false){
                
                //nos.add(dados[j]);
                nos.add("a");
                j++;
            }
            linha = dados[j];
            dados = linha.split(",");
            
            //nos.add(dados[0].replace("\"", ""));
            nos.add("a");
        }
        
        //preenchendo a lista
        
        for(String no : nos){
        
            
           lista.add(new No(no));
           System.out.println("Nó inserido: "+ no);
            
        }
        
        for(int i=0; i<=3; i++){
            
           // lista.add(new No(no));
            lista.add(new No("a"));
           // System.out.println("Nó inserido: "+ no);
            
        }

        
        System.out.println("LISTANDO: ");
        for(No no : lista){
            
            
            System.out.println(no);
            
        }
        System.out.println("----------------");
        
        
        
        return lista;
    
        
        
    }
    
  
    public ArrayList<No> lerArrayListNos(File arquivo) {
        
        
        
        ArrayList<String> nos = new ArrayList<String>();
        ArrayList<No> lista = new ArrayList<No>();
        ManipuladorDeGrafos m = new ManipuladorDeGrafos();
       
        
        //Lendo Arquivo de Entrada
        System.out.println("Lendo os autores");
        System.out.println("-------------------");
        
        ArrayList<String> texto = new ArrayList<String>();
        texto = this.lerCsv(arquivo);
        
        //Gerar arquivo de saída
        String linha = "";
        String[] dados = null;
        int j = 0;
        
        //manipulando a String
        for(int i=1;i<=texto.size()-1; i++){
            linha = texto.get(i);
            dados = linha.split(", ");
            System.out.println(linha);
            
            nos.add(dados[0].replace("\"", ""));
            
            j = 1;
            while(dados[j].contains("\"")==false){
                
                nos.add(dados[j]);
                
                j++;
            }
            linha = dados[j];
            dados = linha.split(",");
            
            nos.add(dados[0].replace("\"", ""));
            
        }
        /*
        System.out.println("IMPRIMINDO AUTORES");
         for(String nome : nos){
            
           System.out.println("Nó inserido: "+ nome);
            
           
            
        }
        */
        
        
        //preenchendo a lista
        
        for(String nome : nos){
            
           No n = new No(nome);
           //System.out.println("Nó para inserir");
           //System.out.println(n);
           if (!m.existeNo(n, lista)){
               lista.add(n);
               //System.out.println("Nó inserido: "+ n);
           } else{
               
               //System.out.println("Já existe");
           }
           
            
        }
        
       
        /*
        
        System.out.println("LISTANDO: ");
        for(No no : lista){
            
            
            System.out.println(no);
            
        }
        System.out.println("----------------");
        
        */
        
        return lista;
    
        
        
    }
    
    
    
}
