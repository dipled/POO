package dados;

import java.util.LinkedList;
import java.util.List;

public class Equipe<T> {
    private String nome;
    private List<T> lista = new LinkedList<>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<T> getLista() {
        return this.lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public String toString(){
        String string = "";
        for(int i = 0; i < this.lista.size(); i += 1){
            string += "|"+this.lista.get(i).toString();
        }
        return string;
    }

}
