package principal;
import dados.*;
public class principal{
    private static Pessoa pessoa1 = new Pessoa();
    private static Pessoa pessoa2 = new Pessoa();
    private static Pessoa pessoa3 = new Pessoa();
    private static Sorteador sorteador = new Sorteador();
    public static void main(String[] args) {
        pessoa1.setCpf("09066083921");
        pessoa3.setCpf("09063234426");
        pessoa2.setCpf("01266343921");
        pessoa1.setNome("Pedro");
        pessoa2.setNome("Fernando");
        pessoa3.setNome("Gustavo");
        pessoa1.setIdade(18);
        pessoa2.setIdade(18);
        pessoa3.setIdade(18);
        sorteador.setPessoa(pessoa1);
        sorteador.setPessoa(pessoa2);
        sorteador.setPessoa(pessoa3);
        System.out.println("Pessoa sorteada: " + sorteador.sortearProximo().toString());

    }
}