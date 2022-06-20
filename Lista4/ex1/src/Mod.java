public class Mod implements IOperacaoInteira{
    public int executar(int valor1, int valor2){
        int anterior = 0;
        int original = valor2;
        Soma sum = new Soma();
        Multiplicacao mult = new Multiplicacao();
        for(int i = 1; i < valor1; i = sum.executar(i, 1)){
            if(valor1 - valor2 == 0)
                return valor1 - valor2;
            if(valor1 - valor2 < 0)
                return valor1 - anterior;
            anterior = valor2;
            valor2 = mult.executar(original, i);
        }
        return valor1 - anterior;
    }
}
