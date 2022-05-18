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
        for (int i = 0; i < quantidade; i += 1) {
            if (isAbundante(i)) {
                this.sequencia.add(i);
            }
        }
    }
}
