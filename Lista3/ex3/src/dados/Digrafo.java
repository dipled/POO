package dados;
import java.util.List;
import java.util.LinkedList;

public class Digrafo{
    protected List<List<Integer>> matrizAdjacendia1 = new LinkedList<>();
    


    public void adicionarVertice(){
        for(int i = 0; i < matrizAdjacendia1.size() + 1; i += 1){
            for(int i2 = matrizAdjacendia1.get(i).size(); i2 < matrizAdjacendia1.get(i).size() + 1; i2 += 1){
                matrizAdjacendia1.get(i).add(0);
            }
        }
    }
}