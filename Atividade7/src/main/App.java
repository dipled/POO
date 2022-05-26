package main;

import java.util.LinkedList;
import java.util.List;

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
        List<Double> lista = new LinkedList<>();
        abundantes.gerar(10);
        fatoriais.gerar(10);
        fibonacci.gerar(10);
        naturais.gerar(10);
        perfeitos.gerar(4);
        primo.gerar(10);
        quadrados.gerar(10);
        lista.add((double)abundantes.mediaAritimetica());
        lista.add((double)fatoriais.mediaAritimetica());
        lista.add((double)naturais.mediaAritimetica());
        lista.add((double)perfeitos.mediaAritimetica());
        lista.add((double)primo.mediaAritimetica());
        lista.add((double)quadrados.mediaAritimetica());
        System.out.println("Maior media arimitetica: "+maior(lista));
        lista.clear();
        lista.add((double)abundantes.somatorio());
        lista.add((double)fatoriais.somatorio());
        lista.add((double)naturais.somatorio());
        lista.add((double)perfeitos.somatorio());
        lista.add((double)primo.somatorio());
        lista.add((double)quadrados.somatorio());
        System.out.println("Maior somatorio: "+maior(lista));
        lista.clear();
        lista.add((double)abundantes.mediaGeometrica());
        lista.add((double)fatoriais.mediaGeometrica());
        lista.add((double)naturais.mediaGeometrica());
        lista.add((double)perfeitos.mediaGeometrica());
        lista.add((double)primo.mediaGeometrica());
        lista.add((double)quadrados.mediaGeometrica());
        System.out.println("Maior media geometrica: "+maior(lista));
        lista.clear();
        lista.add((double)abundantes.variancia());
        lista.add((double)fatoriais.variancia());
        lista.add((double)naturais.variancia());
        lista.add((double)perfeitos.variancia());
        lista.add((double)primo.variancia());
        lista.add((double)quadrados.variancia());
        System.out.println("Maior variancia: "+maior(lista));
        lista.clear();
        lista.add((double)abundantes.amplitude());
        lista.add((double)fatoriais.amplitude());
        lista.add((double)naturais.amplitude());
        lista.add((double)perfeitos.amplitude());
        lista.add((double)primo.amplitude());
        lista.add((double)quadrados.amplitude());
        System.out.println("Maior amplitude(): "+maior(lista));
        lista.clear();
        lista.add((double)abundantes.desvioPadrao());
        lista.add((double)fatoriais.desvioPadrao());
        lista.add((double)naturais.desvioPadrao());
        lista.add((double)perfeitos.desvioPadrao());
        lista.add((double)primo.desvioPadrao());
        lista.add((double)quadrados.desvioPadrao());
        System.out.println("Maior Desvio padrao: "+maior(lista));
        

    }
    public static double maior(List<Double> lista){
        double maior = Double.MIN_VALUE;
        for(int i = 0; i < lista.size(); i += 1){
            if(lista.get(i)>maior){
                maior = lista.get(i);
            }
        }
        return maior;
    }
    

}
