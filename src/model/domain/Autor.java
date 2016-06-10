
package model.domain;

/**
 *
 * @author cristiano
 */
public class Autor {
    
    private int id;
    private String nome;

    
    public Autor(String nome){
        
        this.setNome(nome);
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
    
    
}
