public class MDC implements IOperacaoInteira {
    private Soma sum = new Soma();
    private Mod mod = new Mod();

    public int executar(int valor1, int valor2) {
        int maxdiv = 1;
        for (int i = 1; i <= valor1 && i <= valor2; i = sum.executar(i, 1)) {
            if (mod.executar(valor1, i) == 0 && mod.executar(valor2, i) == 0) {
                maxdiv = i;
            }
        }
        return maxdiv;
    }
}
