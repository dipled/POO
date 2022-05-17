import dados.Digrafo;
import dados.Grafo;

public class Teste {
    
    public static void main(String[] args) throws Exception {
        Digrafo digrafo = new Digrafo();
        Grafo grafo = new Grafo();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(2,1);
        digrafo.adicionarAresta(0, 0);
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarAresta(2, 1);
        grafo.adicionarAresta(3, 1);
        
        System.out.println("Dígrafo: ");
        System.out.println(digrafo.toString());
        System.out.println("Grafo: ");
        System.out.println(grafo.toString());
    }
}
