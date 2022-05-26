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
        System.out.println("Abundantes:");
        mostraLista(abundantes);
        System.out.println("\nFatoriais:");
        mostraLista(fatoriais);
        System.out.println("\nSequencia de Fibonacci");
        mostraLista(fibonacci);
        System.out.println("\nNúmeros naturais:");
        mostraLista(naturais);
        System.out.println("\nPerfeitos:");
        mostraLista(perfeitos);
        System.out.println("\nPrimos:");
        mostraLista(primo);
        System.out.println("\nQuadrados:");
        mostraLista(quadrados);

    }
    public static void mostraLista(Gerador gerador){
        for(int i = 0; i < gerador.getSequencia().size(); i += 1){
            System.out.println(gerador.getSequencia().get(i));
        }
    }
}
