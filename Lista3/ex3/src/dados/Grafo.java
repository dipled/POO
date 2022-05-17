package dados;

public class Grafo extends Digrafo {

    public void adicionarAresta(int origem, int destino){
        super.adicionarAresta(origem, destino);
        super.adicionarAresta(destino, origem);
    }
    
}
