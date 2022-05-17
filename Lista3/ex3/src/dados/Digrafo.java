package dados;
import java.util.List;


import java.util.LinkedList;

public class Digrafo{
    protected List<List<Integer>> matrizAdjacencia1 = new LinkedList<>();
    
    public List<List<Integer>> getMatrizAdjacencia1(){
        return matrizAdjacencia1;
    }
    public void adicionarVertice(){

        List<Integer> novaLinha  = new LinkedList<>();
        for(int i = 0; i < matrizAdjacencia1.size(); i += 1){
            novaLinha.add(0);
        }
        this.matrizAdjacencia1.add(novaLinha);
        for(int i = 0; i < matrizAdjacencia1.size(); i += 1){
            matrizAdjacencia1.get(i).add(0);
        }
        
    }
    public void adicionarAresta(int origem, int destino){
        matrizAdjacencia1.get(origem).set(destino, 1);
    }
    public String toString(){
        String retorno = "   ";
        for(int i = 0; i < matrizAdjacencia1.size(); i += 1){
            retorno += i+"  ";
        }
        retorno += "\n";
        for(int i = 0; i < matrizAdjacencia1.size(); i += 1){
            retorno += i+ " ";
            retorno += matrizAdjacencia1.get(i) + "\n";
        }
        return retorno;
    }
}

