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
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarAresta(2, 1);
        
        System.out.println("Dígrafo: ");
        for(int i = 0; i < digrafo.getMatrizAdjacencia1().size(); i += 1){
            System.out.println(digrafo.getMatrizAdjacencia1().get(i));
        }
        System.out.println("Grafo: ");
        for(int i = 0; i < grafo.getMatrizAdjacencia1().size(); i += 1){
            System.out.println(grafo.getMatrizAdjacencia1().get(i));
        }
    }
}
