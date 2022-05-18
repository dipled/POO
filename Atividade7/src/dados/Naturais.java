package dados;

public class Naturais extends Gerador{
    
    public void gerar(int quantidade){
        for(int i = 0; i < quantidade; i += 1){
            this.sequencia.add(i);
        }
    }
}
