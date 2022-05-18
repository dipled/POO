package dados;

public class Primo extends Gerador {
    private boolean isPrimo(int x){
        for(int i = 2; i < x; i += 1){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    public void gerar(int quantidade){
        for(int i = 0; i < quantidade; i += 1){
            if(isPrimo(i)){
                this.sequencia.add(i);
            }
        }
    }
}
