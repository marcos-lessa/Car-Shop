
package Entidades;

/**
 *
 * @author gu_sc
 */
public class Estoque {
    
    protected int capacidade;
    
    public Estoque(int capacidade){
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }   
}

