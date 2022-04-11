package dados;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private boolean menorDeIdade;
    private Endereco endereco = new Endereco();

    public Pessoa() {

    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, boolean menorDeIdade, Endereco endereco) {
        this.nome = nome;
        this.menorDeIdade = menorDeIdade;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMenorDeIdade() {
        return this.menorDeIdade;
    }

    public boolean getMenorDeIdade() {
        return this.menorDeIdade;
    }

    public void setMenorDeIdade(boolean menorDeIdade) {
        this.menorDeIdade = menorDeIdade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        String pessoaString = "";
        pessoaString += "\n Nome: " + this.nome;
        if (this.menorDeIdade == true) {
            pessoaString += "\n Menor de idade: Sim";
        } else {
            pessoaString += "\n Menor de idade: Não";
        }
        if (this.endereco != null)
            pessoaString += "\n Endereço: " + this.endereco.toString();
        return pessoaString;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && menorDeIdade == pessoa.menorDeIdade
                && Objects.equals(endereco, pessoa.endereco);
    }
}
