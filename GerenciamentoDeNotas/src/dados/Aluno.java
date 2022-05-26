package dados;

import java.util.LinkedList;
import java.util.List;

public class Aluno {
    private String cpf;
    private String senha;
    private String nome;
    private int idade;
    private List<Semestre> semestres = new LinkedList<Semestre>();

    public List<Semestre> getSemestres() {
        return this.semestres;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public void setCfp(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean equals(Object o) {
        if (o instanceof Aluno) {
            Aluno a = (Aluno) o;
            if (a.cpf == this.cpf && a.senha == this.senha && a.idade == this.idade && a.nome == this.nome) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //Método verifica se o aluno recebido como parâmetro possui o mesmo cpf e senha que ele(Esta é a condição para fazer login).
    public boolean login(Aluno aluno) {
        if (aluno.getCpf().equals(this.cpf) && aluno.getSenha().equals(this.senha)) {
            return true;
        } else {
            return false;
        }
    }
}
