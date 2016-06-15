
package model.domain;

/**
 *
 * @author cristiano
 */
public class No {
    
    private int id;
    private String label;
    
    
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
    
    
    
}
