/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author cristiano
 */
public class ManipuladorDeGrafos {
    
    
    
    public String gerarNos(String textoEscrita, TreeSet<Autor> nos) {
        
        String nome = "";
        //System.out.println("Inserindo Autores na lista Ordenada:");
        textoEscrita = "Id;Label;Nome"+"\n";
        Iterator<Autor> iterador = nos.iterator();
        int id = 0;
        while(iterador.hasNext()){

            id++;
            nome =iterador.next().getNome();
            //System.out.println(nome);
            textoEscrita = textoEscrita + id+";"+nome+";"+nome+"\n";

        }
        return textoEscrita;
    }
    
    public String gerarTextoNos(String textoEscrita, TreeSet<No> nos) {
        
        String nome = "";
        //System.out.println("Inserindo Autores na lista Ordenada:");
        textoEscrita = "Id;Label;Nome"+"\n";
        Iterator<No> iterador = nos.iterator();
        int id = 0;
        System.out.println("Escrevendo os nós (texto)");
        System.out.println("Qtde de Nós"+nos.size());
        while(iterador.hasNext()){

            id++;
            nome =iterador.next().getLabel();
            System.out.println(nome);
            textoEscrita = textoEscrita + id+";"+nome+";"+nome+"\n";

        }
        return textoEscrita;
    }
    
    
    public int frequeciaArestas(List<Aresta> lista, Aresta aresta){
        
        int frequencia = 0;
        
        for(int i=0; i<lista.size(); i++){
            if(aresta.equals(lista.get(i))){
                
               
                frequencia++;
                
            }
            else{
               
            }
            
        }
        
        return frequencia;
    }
    
    
    
    public int frequeciaNos(List<No> lista, No no){
        
        int frequencia = 0;
        
        for(int i=0; i<lista.size(); i++){
            if(no.equals(lista.get(i))){
                
               
                frequencia++;
                
            }
            else{
               
            }
            
        }
        
        return frequencia;
    }
    
    
    
    public String listarArestasOrdenadas(TreeSet<Aresta> arestas, List<Aresta> lista){
        
        String textoSaida = "";
        int cont =0;
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        
        textoSaida=textoSaida+"Id;Source;Target;Type;Weight;Autores"+"\n";
        
        
        for (Aresta aresta:arestas){
            
            
            cont = mg.frequeciaArestas(lista, aresta);
            textoSaida=textoSaida+aresta.getId()+";"
                    +aresta.getOrigem().getId()+";"
                    +aresta.getDestino().getId()+";"
                    +"Undirected;"
                    +cont+";"
                    +aresta.getOrigem().getLabel()+" - "+aresta.getDestino().getLabel()
                    +"\n";
                    
                    //aresta.toString()+"frequencia: "+cont+"\n";
            
        }    
        
        return textoSaida;
        
    }
    
    
    
    
    
     public String listarNosOrdenados(TreeSet<No> nos, List<No> lista){
        
        String textoSaida = null;
        int cont =0;
        ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        
        for (No no:nos){
            
            
            cont = mg.frequeciaNos(lista, no);
            textoSaida=textoSaida+no.toString()+"frequencia: "+cont;
            
        }    
        
        return textoSaida;
        
    }
    
    
    
    
    
    
    
    //recebe um List de Arestas e retirna um TreeSet de Arestas
    public TreeSet<Aresta> gerarArestasOrdenadas(List<Aresta> lista){
        
        Aresta a;
        Iterator<Aresta> iteradorAresta = lista.iterator();
        TreeSet<Aresta> arestasOrdenadas = new TreeSet<Aresta>();
        while(iteradorAresta.hasNext()){
          a=iteradorAresta.next();
          arestasOrdenadas.add(a);
          System.out.println("-------");
          System.out.println(a.toString());
          System.out.println("-------");
        }
        
        return arestasOrdenadas;

        
    }
    
    
    
    //recebe um List de Nós e retirna um TreeSet de Nós
    
    public TreeSet<No> gerarNosOrdenados(List<No> lista){
        
        No no = new No();
        Iterator<No> iteradorNo = lista.iterator();
        TreeSet<No> nosOrdenados = new TreeSet<No>();
        while(iteradorNo.hasNext()){
          no=iteradorNo.next();
          nosOrdenados.add(no);
          System.out.println("-- Inserindo --");
          System.out.println(no.toString());
          System.out.println("A lista tem: "+nosOrdenados.size());
        }
        
        return nosOrdenados;

        
    }
    
    
    public List<Aresta> gerarArestasAutores(String texto ,TreeSet<Autor> nos, 
            ArrayList<Artigo> artigos){
        
    
        List<Aresta> lista = new ArrayList<Aresta>();
        ManipuladorDeArquivos m = new ManipuladorDeArquivos();
        //ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
        int idSource = 0;
        int idTarget = 0;
        int id = 0;    
        //listando autores por trabalho
        texto = "Id;Source;Target;Type;Weight;Autores\n";
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
                //Autor origem
                String nome1 = artigos.get(i).getAutores().get(j).getNome();

                int k = j+1;
                while(k<numAutores){
                    id++;
                    //id do autor de origem
                    idSource = this.getIdNo(nome1, nos);

                    //Autor de destino
                    String nome2 = artigos.get(i).getAutores().get(k).getNome();
                    //id do autor de destino
                    idTarget = this.getIdNo(nome2, nos);
                    System.out.println(nome1+";"+nome2);
                    System.out.println(idSource+";"+idTarget);
                    texto = texto + id+";"+idSource+";"+idTarget+";Undirected;1;"+nome1+" e "+nome2+"\n";
                    k++;
                }


            }



        }
        return lista;
    }
    
    
    
    public String gerarTextoArestas(String texto ,TreeSet<Autor> nos, 
            ArrayList<Artigo> artigos){
        
    
            ManipuladorDeArquivos m = new ManipuladorDeArquivos();
            ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
            int idSource = 0;
            int idTarget = 0;
            int id = 0;    
            //listando autores por trabalho
            texto = "Id;Source;Target;Type;Weight;Autores\n";
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
                    //Autor origem
                    String nome1 = artigos.get(i).getAutores().get(j).getNome();

                    int k = j+1;
                    while(k<numAutores){
                        id++;
                        //id do autor de origem
                        idSource = this.getIdNo(nome1, nos);

                        //Autor de destino
                        String nome2 = artigos.get(i).getAutores().get(k).getNome();
                        //id do autor de destino
                        idTarget = this.getIdNo(nome2, nos);
                        System.out.println(nome1+";"+nome2);
                        System.out.println(idSource+";"+idTarget);
                        texto = texto + id+";"+idSource+";"+idTarget+";Undirected;1;"+nome1+" e "+nome2+"\n";
                        k++;
                    }


                }



               }
        
        
        
        return texto;
        
    }
    
    
    
    
    
     public List<Aresta> gerarArestas(TreeSet<Autor> nos,
             ArrayList<Artigo> artigos){
        
            List<Aresta> lista = new ArrayList<Aresta>();
            ManipuladorDeArquivos m = new ManipuladorDeArquivos();
            ManipuladorDeGrafos mg = new ManipuladorDeGrafos();
            int idSource = 0;
            int idTarget = 0;
            int id = 0;    
            //listando autores por trabalho
            
            
            for(int i=0;i<=artigos.size()-1; i++){

                
                //percorrendo os autores de cada artigo

                int numAutores = artigos.get(i).getAutores().size();
               
                for(int j=0;j<numAutores; j++){
                    //Autor origem
                    String nome1 = artigos.get(i).getAutores().get(j).getNome();

                    int k = j+1;
                    while(k<numAutores){
                        id++;
                        //id do autor de origem
                        idSource = this.getIdNo(nome1, nos);

                        //Autor de destino
                        String nome2 = artigos.get(i).getAutores().get(k).getNome();
                        //id do autor de destino
                        idTarget = this.getIdNo(nome2, nos);
                        //System.out.println(nome1+";"+nome2);
                        //System.out.println(idSource+";"+idTarget);
                        
                        lista.add(new Aresta(id,
                                new No(idSource,nome1),
                                new No(idTarget,nome2),
                                "Undirected",
                                1
                        ));

                            
                        //texto = texto + id+";"+idSource+";"+idTarget+";Undirected;1;"+nome1+" e "+nome2+"\n";
                                
                        //Aresta(int id, No origem, No destino, String tipo, float weight)        
                                
                                
                        k++;
                    }


                }



               }
        
        
        
        return lista;
        
    }
    
    
    

    private int getIdNo(String nome, TreeSet<Autor> nos) {
        
        int i =0;
        Iterator<Autor> iterador = nos.iterator();
        while(iterador.hasNext()){
            i++;
            //System.out.println("-------");
            //System.out.println("Nome: "+nome);
            //System.out.println("Nó: "+iterador.next());
            //System.out.println("-------");
            if(nome.equals(iterador.next().getNome()) ){

                   // System.out.println("Nome: "+nome);
                    return i;
              }
        }
        
        return i;
        
    }

    public TreeSet<No> gerarNosOrdenados(ArrayList<Autor> autores) {
        
        System.out.println("Inserindo nos na lista ordenada");
        Iterator<Autor> iterador = autores.iterator();
        TreeSet<No> nosOrdenados = new TreeSet<No>();
        while(iterador.hasNext()){
          //No no = new No(iterador.next().getNome());
          //no.setLabel(iterador.next().getNome());
          nosOrdenados.add(new No(iterador.next().getNome()));
          //System.out.println("--Inserindo--");
          //System.out.println(no.toString());
          //System.out.println("Lista tem: "+nosOrdenados.size());
        }
        
        return nosOrdenados;
       
    }

    public boolean existeNo(No no, ArrayList<No> nos){
        
        boolean existe = false;
        for(No obj : nos){
            
            if(no.equals(obj)){
                existe = true;
                break;
                
            }
            
        }
        
        
        return existe;
        
    }
    
    
    public String gerarTextoNosArrayList(String textoEscrita, ArrayList<No> nos) {
        
        String nome = "";
        //System.out.println("Inserindo Autores na lista Ordenada:");
        textoEscrita = "Id;Label;Nome"+"\n";
        Iterator<No> iterador = nos.iterator();
        int id = 0;
        System.out.println("Escrevendo os nós (texto)");
        System.out.println("Qtde de Nós"+nos.size());
        while(iterador.hasNext()){

            id++;
            nome =iterador.next().getLabel();
            System.out.println(nome);
            textoEscrita = textoEscrita + id+";"+nome+";"+nome+"\n";

        }
        return textoEscrita;
    }
    
    
}
