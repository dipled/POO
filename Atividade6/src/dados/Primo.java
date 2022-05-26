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
        int i = 2;
        int cont = 0;
        while(true) {
            if (isPrimo(i)) {
                this.sequencia.add(i);
                cont += 1;
            }
            i += 1;
            if(cont == quantidade){
                return;
            }
        }
    }
}
