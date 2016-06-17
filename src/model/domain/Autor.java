
package model.domain;

/**
 *
 * @author cristiano
 */
public class Autor implements Comparable<Autor>{
    
    private int id;
    private String nome;

    
    public Autor(){
        
        
    }
    
    public Autor(String nome){
        
        this.setNome(nome);
    }
    
    
    public Autor(int id,String nome){
        
        this(nome);
        this.setId(id);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public boolean equals(Autor obj) {
       
        boolean igual = false;
        
        if (obj==null){
            igual=false;
        }else if(this.getNome() == obj.getNome()){

            igual = true;

        }
        return igual;
    }
    
    
    
    
    public int compareTo(Autor obj) {
       
        int igual = 1;
        
        String nome1 ="";
        String nome2 ="";
        
        if (obj!=null){
            nome1 = this.getNome();
            nome2 = obj.getNome();
        }
        
        if (obj==null){
            igual=1;
        }
        else if( nome1.equals(nome2)){

            igual = 0;

        }
        return igual;
    }
    
    @Override
    public String toString() {
        return "Autor{" + "id=" + this.getId() + ", nome=" + this.getNome() + '}';
    }

    
    
}
