package dados;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import java.util.LinkedList;

public class Digrafo{
    protected List<List<Integer>> matrizAdjacendia1 = new LinkedList<>();
    

    public void adicionarVertice(){

        List<Integer> novaLinha  = new LinkedList<>();
        for(int i = 0; i < matrizAdjacendia1.size()+1; i += 1){
            novaLinha.add(0);
        }
        this.matrizAdjacendia1.add(novaLinha);
        for(int i = 0; i < matrizAdjacendia1.size()+1; i += 1){
            matrizAdjacendia1.get(i).add(0);
        }
        
    }
    public void adicionarAresta(int origem, int destino){
        matrizAdjacendia1.get(origem).set(destino, 1);
    }
    public String toString(){
        
        }
    }
}
