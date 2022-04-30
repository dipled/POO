package negocios;

import dados.*;
import java.util.List;
import java.util.Comparator;
import java.util.LinkedList;

public class Sistema {
    private List<Pessoa> umAteDoze = new LinkedList<Pessoa>();
    private List<Pessoa> trezeAteDezoito = new LinkedList<Pessoa>();
    private List<Pessoa> dezenoveAteVinteECinco = new LinkedList<Pessoa>();
    private List<Pessoa> vinteESeisAteCinquentaENove = new LinkedList<Pessoa>();
    private List<Pessoa> sessentaOuMais = new LinkedList<Pessoa>();
    private List<List<Pessoa>> pessoas = new LinkedList<>();
    private Comparator<Pessoa> compareByNome = (Pessoa o1, Pessoa o2) -> o1.getNome().compareTo(o2.getNome());


    public List<List<Pessoa>> getPessoas() {
        return this.pessoas;
    }



    public Sistema() {
        this.pessoas.add(umAteDoze);
        this.pessoas.add(trezeAteDezoito);
        this.pessoas.add(dezenoveAteVinteECinco);
        this.pessoas.add(vinteESeisAteCinquentaENove);
        this.pessoas.add(sessentaOuMais);
    }

    public boolean intervalo(int a, int b, int c) {
        if (c >= a && c <= b) {
            return true;
        } else {
            return false;
        }

    }

    public void adicionaPessoa(Pessoa pessoa) {
        if (intervalo(1, 12, pessoa.getIdade())) {
            this.pessoas.get(0).add(pessoa);
            return;
        }
        if (intervalo(13, 18, pessoa.getIdade())) {
            this.pessoas.get(1).add(pessoa);
            return;
        }
        if (intervalo(19, 25, pessoa.getIdade())) {
            this.pessoas.get(2).add(pessoa);
            return;
        }
        if (intervalo(26, 59, pessoa.getIdade())) {
            this.pessoas.get(3).add(pessoa);
            return;
        }
        if (intervalo(60, 1000, pessoa.getIdade())) {
            this.pessoas.get(4).add(pessoa);
            return;
        }
    }

    public void ordenaIntervalos() {
        for (int i = 0; i < 5; i += 1) {
            this.pessoas.get(i).sort(compareByNome);
        }
    }
}
