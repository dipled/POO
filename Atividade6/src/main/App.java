package main;
import dados.*;
public class App {
    private static Abundantes abundantes = new Abundantes();
    private static Fatoriais fatoriais = new Fatoriais();
    private static Fibonacci fibonacci = new Fibonacci();
    private static Naturais naturais = new Naturais();
    private static Perfeitos perfeitos = new Perfeitos();
    private static Primo primo = new Primo();
    private static Quadrados quadrados = new Quadrados();
    
    public static void main(String[] args) {
        abundantes.gerar(40);
        fatoriais.gerar(10);
        fibonacci.gerar(7);
        naturais.gerar(20);
        perfeitos.gerar(4);
        primo.gerar(18);
        quadrados.gerar(20);
        mostraLista(abundantes);
        mostraLista(fatoriais);
        mostraLista(fibonacci);
        mostraLista(naturais);
        mostraLista(perfeitos);
        mostraLista(primo);
        mostraLista(quadrados);

    }
    public static void mostraLista(Gerador gerador){
        for(int i = 0; i < gerador.getSequencia().size(); i += 1){
            System.out.println(gerador.getSequencia().get(i));
        }
    }
}
