package dados;

import java.util.LinkedList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String professor;
    private List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;

    }

    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public String toString() {
        return this.nome;
    }

}
