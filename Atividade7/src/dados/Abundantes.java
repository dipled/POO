package dados;
public class Abundantes extends Gerador {

    private boolean isAbundante(int x) {
        int somadiv = 0;
        for (int i = 1; i < x; i += 1) {
            if(x%i == 0){
                somadiv += i;
            }
        }
        if(somadiv > x){
            return true;
        }
        else{
            return false;
        }
    }

    public void gerar(int quantidade) {
        int i = 0;
        int cont = 0;
        while(true) {
            if (isAbundante(i)) {
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
