package dados;

import java.util.Random;

public class Sorteador {

    private int quantidadeDePessoas = 0;
    private Pessoa[] pessoas = new Pessoa[5];

    public void setQuantidadePessoas(int quantidadeDePessoas) {
        this.quantidadeDePessoas = quantidadeDePessoas;
    }

    public int getQuantidadePessoas() {
        return this.quantidadeDePessoas;
    }

    public Pessoa[] getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }

    public void setPessoa(Pessoa pessoa) {
        if (this.quantidadeDePessoas < 5) {
            this.pessoas[this.quantidadeDePessoas] = pessoa;
            this.quantidadeDePessoas += 1;
        }
    }

    public Pessoa sortearProximo() {
        Random random = new Random();
        int numeroSorteado = random.nextInt(0 + this.quantidadeDePessoas) + 0;
        Pessoa sorteada = this.pessoas[numeroSorteado];
        removePessoa(numeroSorteado);
        return sorteada;
    }

    public void removePessoa(int x) {
        Pessoa[] novo = new Pessoa[quantidadeDePessoas - 1];
        int i2 = 0;
        for (int i = 0; i < quantidadeDePessoas; i += 1) {
            if (i != x) {
                novo[i2] = this.pessoas[i];
                i2 += 1;
            }
        }
        this.setPessoas(novo);
        quantidadeDePessoas -= 1;
    }

}
