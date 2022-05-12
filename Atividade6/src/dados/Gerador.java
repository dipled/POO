package dados;

import java.util.LinkedList;
import java.util.List;

public abstract class Gerador {
    protected List<Integer> sequencia = new LinkedList<>();

    public List<Integer> getSequencia() {
        return this.sequencia;
    }
    public abstract void gerar(int quantidade);
}
