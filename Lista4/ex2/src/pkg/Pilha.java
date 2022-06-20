package pkg;

import java.util.LinkedList;
import java.util.List;

public class Pilha<T> {
    private int limite;
    private List<T> elementos = new LinkedList<>();
    
    public Pilha(int limite) {
        this.limite = limite;
    }

    public void inserir(T objeto) throws PilhaCheiaException {
        if (this.elementos.size() == this.limite) {
            throw new PilhaCheiaException();
        } else {
            this.elementos.add(objeto);
        }
    }

    public T remover() throws PilhaVaziaException {
        if (this.elementos.isEmpty()) {
            throw new PilhaVaziaException("Pilha vazia");
        } else {
            T retorno = this.elementos.get(this.elementos.size() - 1);
            this.elementos.remove(this.elementos.size() - 1);
            return retorno;
        }
    }
    public int getSize(){
        return this.elementos.size();
    }
    public int getLimite(){
        return this.limite;
    }
}
