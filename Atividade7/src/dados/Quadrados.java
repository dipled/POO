package dados;

public class Quadrados extends Gerador{

    public void gerar(int quantidade){
        for(int i = 1; i < quantidade; i += 1){
            this.sequencia.add(i*i);
        }
    }
    
}
