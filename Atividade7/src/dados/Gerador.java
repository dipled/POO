package dados;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Gerador implements ISequencia {
    Random rand = new Random();
    protected List<Integer> sequencia = new LinkedList<>();

    public List<Integer> getSequencia() {
        return this.sequencia;
    }

    public abstract void gerar(int quantidade);

    public int sortear() {
        int i = rand.nextInt(this.sequencia.size());
        return this.sequencia.get(i);
    }

    public long somatorio() {
        long soma = 0;
        for (int i = 0; i < this.sequencia.size(); i += 1) {
            soma += this.sequencia.get(i);
        }
        return soma;
    }

    public double mediaAritimetica() {
        double soma = 0;
        for (int i = 0; i < this.sequencia.size(); i += 1) {
            soma += this.sequencia.get(i);
        }
        return soma / this.sequencia.size();
    }

    public double mediaGeometrica() {
        double produto = 1;
        for (int i = 0; i < this.sequencia.size(); i += 1) {
            produto = produto * this.sequencia.get(i);
        }
        return Math.pow(produto, (1.0 / this.sequencia.size()));
    }

    public double variancia(){
        double media = this.mediaAritimetica();
        double soma = 0;
        for(int i = 0; i < this.sequencia.size(); i += 1){
            soma += Math.pow((this.sequencia.get(i) - media),2);
        }
        return soma/(this.sequencia.size()-1);
    }

    public double desvioPadrao(){
        return Math.pow(this.variancia(),0.5);
    }
    public long amplitude(){
        long menor = Long.MAX_VALUE;
        long maior = Long.MIN_VALUE;
        long num;
        for(int i = 0; i < this.sequencia.size(); i += 1){
            num = this.sequencia.get(i);
            if(num < menor)
                menor = num;
            if(num > maior)
                maior = num;
        }
        return maior - menor;

    }

}   
