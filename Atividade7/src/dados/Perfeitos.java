package dados;

public class Perfeitos extends Gerador {

    private boolean isPerfeito(int x){
        int soma = 0;
        for(int i = 1; i < x; i += 1){
            if(x%i == 0){
                soma += i;
            }
        }
        if(x == soma){
            return true;
        }
        else{
            return false;
        }
    }
    public void gerar(int quantidade){
        for(int i = 1; i < quantidade; i += 1){
            if(isPerfeito(i)){
                this.sequencia.add(i);
            }
        }
    }
    
}
