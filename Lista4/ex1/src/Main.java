import java.util.Random;

public class Main {
    public static Multiplicacao mult = new Multiplicacao();
    public static Soma sum = new Soma();
    public static Mod mod = new Mod();
    public static MDC mdc = new MDC();
    public static Random rand = new Random();
    public static void main(String[] args) {
        int valor1;
        int valor2;
        valor1 = rand.nextInt(50);
        valor2 = rand.nextInt(50);
        System.out.println(valor1 + " + " + valor2 + " = " + sum.executar(valor1, valor2));
        valor1 = rand.nextInt(50);
        valor2 = rand.nextInt(50);
        System.out.println(valor1 + " * " + valor2 + " = " + mult.executar(valor1, valor2));
        valor1 = rand.nextInt(50);
        valor2 = rand.nextInt(50);
        System.out.println(valor1 + " mod " + valor2 + " = " + mod.executar(valor1, valor2));
        valor1 = rand.nextInt(50);
        valor2 = rand.nextInt(50);
        System.out.println(valor1 + " MDC " + valor2 + " = " + mdc.executar(valor1, valor2));
        
    }
}
