
package model.domain;

import java.util.Objects;

/**
 *
 * @author cristiano
 */
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
        if(
                
                ((this.getOrigem().getLabel() == obj.getOrigem().getLabel())&&
                (this.getDestino().getLabel() == obj.getDestino().getLabel()))
                ||
                ((this.getOrigem().getLabel() == obj.getDestino().getLabel())&&
                (this.getDestino().getLabel() == obj.getOrigem().getLabel()))
                
                
           )
        {

              igual = true;

        }
        return igual;
    }
    
    public int compareTo(Aresta obj){
        int igual = 1;
        
        
        if(
                
                ((this.getOrigem().getLabel() == obj.getOrigem().getLabel())&&
                (this.getDestino().getLabel() == obj.getDestino().getLabel()))
                ||
                ((this.getOrigem().getLabel() == obj.getDestino().getLabel())&&
                (this.getDestino().getLabel() == obj.getOrigem().getLabel()))
                
                
           )
        {

              igual = 0;

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
