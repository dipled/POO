package dados;

import java.util.Objects;

public class Pessoa {
    private String nome, cpf, cidade;
    private int idade;


    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String cidade, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa nome(String nome) {
        setNome(nome);
        return this;
    }

    public Pessoa cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Pessoa cidade(String cidade) {
        setCidade(cidade);
        return this;
    }

    public Pessoa idade(int idade) {
        setIdade(idade);
        return this;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(cidade, pessoa.cidade) && idade == pessoa.idade;
    }

    public String toString() {
        return this.nome + ", " + this.idade + ", " + this.cpf + ", " + this.cidade;
    }
}
