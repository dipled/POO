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
        abundantes.gerar(10);
        fatoriais.gerar(10);
        fibonacci.gerar(10);
        naturais.gerar(10);
        perfeitos.gerar(10);
        primo.gerar(10);
        quadrados.gerar(10);
        


    }
    

}
