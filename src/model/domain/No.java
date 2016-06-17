
package model.domain;


public class No implements Comparable<No>{
    
    private int id;
    private String label;
    
    
    public No(){
        
        
    }
    
    public No(String label){
        
        this.setLabel(label);
        
    }
    
    public No(int id, String label){
        
        this.setLabel(label);
        this.setId(id);
        
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

    @Override
    public String toString() {
        return "No{" + "id=" + this.getId() + ", label=" + this.getLabel() + '}';
    }
    
    
   
    
    public boolean equals(No no) {
        
        boolean igual = false;
        
        if (this.getLabel().equals(no.getLabel())){
            
            igual = true;
            
        }
        
        
        return igual;
    }

    @Override
    public int compareTo(No o) {
        
        int compara = 0;
        
        if (this.getLabel().equals(o.getLabel())){
            
            System.out.println("IGUAL");
            
        }else{
            compara = 1;
            System.out.println("DIFERENTE");    
        }    
        
        return compara;
        
    }
    
    
}
