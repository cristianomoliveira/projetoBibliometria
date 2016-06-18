
package model.domain;

import java.util.Objects;

/**
 *
 * @author cristiano
 */

//Implementa Comparable
public class Aresta implements Comparable<Aresta>{
    
    
    private No Origem;
    private No Destino;
    private int id;
    private String label;
    private String tipo;
    private float weight;

   

   public Aresta(){
    
   } 
    public Aresta(No origem, No destino){
        
        
        this.setOrigem(origem);
        this.setDestino(destino);
        
    }
    
    public Aresta(int id, No origem, No destino, String tipo, float weight){
        this(origem, destino);
        this.setId(id);
        this.setTipo(tipo);
        this.setWeight(weight);
    }
    
    // id+";"+idSource+";"+idTarget+";Undirected;1;"+nome1+" e "+nome2+"\n";
    
   

    @Override
    public String toString() {
        return "Aresta{" + "Origem=" + this.getOrigem().toString() 
                +", Destino=" + this.getDestino().toString() + ","
                + " id=" + this.getId() 
                + ", label=" + this.getLabel() 
                + ", tipo=" + this.getTipo() + ", "
                + "weight=" + this.getWeight() + '}';
    }

    
    public boolean equals(Aresta obj) {
       
        boolean igual = false;
        String noOrigem = "";
        String noDestino = ""; 
       
        String objNoOrigem = "";
        String objNoDestino = "";
        
        
        if (obj!=null){
            noOrigem=this.getOrigem().getLabel();
            noDestino=this.getDestino().getLabel();
            
            objNoOrigem=obj.getOrigem().getLabel();
            objNoDestino=obj.getDestino().getLabel();
        }
        
        
        
        
        if( ((noOrigem.equals(objNoOrigem))&&(noDestino.equals(objNoDestino)))
                ||
             ((noOrigem.equals(objNoDestino))&&(noDestino.equals(objNoOrigem))) )
        {

              igual = true;
              System.out.println("-- EQUALS ---Arestas iguais");

        }
        
        

        return igual;
    }
    
    public int compareTo(Aresta obj){
        int igual = -1;
        
       String noOrigem = "";
       String noDestino = ""; 
       
       String objNoOrigem = "";
       String objNoDestino = "";
       
       if (obj!=null){
            noOrigem=this.getOrigem().getLabel();
            noDestino=this.getDestino().getLabel();
            
            objNoOrigem=obj.getOrigem().getLabel();
            objNoDestino=obj.getDestino().getLabel();
        }
        
        
        if(
                
                ((noOrigem.equals(objNoOrigem))&&
                (noDestino.equals(objNoDestino)))
                ||
                ((noOrigem.equals(objNoDestino))&&
                (noDestino.equals(objNoOrigem)))
                
                
           )
        {

              igual = 0;
              System.out.println("-- compareTo ---Arestas iguais");

        }else{
            
              System.out.println("-- compareTo ---Arestas diferentes");
        }
        
        return igual;
    }
    
    
    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    public No getOrigem() {
        return Origem;
    }

    public void setOrigem(No Origem) {
        this.Origem = Origem;
    }

    public No getDestino() {
        return Destino;
    }

    public void setDestino(No Destino) {
        this.Destino = Destino;
    }
    
    
    
}
