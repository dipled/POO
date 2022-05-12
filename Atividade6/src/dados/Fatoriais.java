package dados;

public class Fatoriais extends Gerador {

    private int fatorial(int x) {
        int resultado = 1;
        for (int i = 1; i <= x; i += 1) {
            resultado *= i;
        }
        return resultado;
    }
    public void gerar(int quantidade){
        for(int i = 0 ; i < quantidade; i += 1){
            this.sequencia.add(fatorial(i));
        }
    }

}
