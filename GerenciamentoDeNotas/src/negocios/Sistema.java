package negocios;

import dados.*;
import java.util.List;
import java.util.Objects;
import java.util.LinkedList;

public class Sistema {
    private List<Aluno> alunos = new LinkedList<Aluno>();

    public Sistema() {
    }

    public Sistema(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public int login(Aluno aluno) {
        for (int i = 0; i < this.alunos.size(); i += 1) {
            if (this.alunos.get(i).login(aluno)) {
                return i;
            }
        }
        return -1;
    }

    public void cadastraAluno(Aluno aluno) {

        this.alunos.add(aluno);

    }

    public void removeAluno(int idAluno) {
        this.alunos.remove(idAluno);
    }

    public void cadastraSemestre(int idAluno, Semestre semestre) {
        this.alunos.get(idAluno).getSemestres().add(semestre);

    }

    public void removeSemestre(int idAluno, int idSemestre) {
        this.alunos.get(idAluno).getSemestres().remove(idSemestre);

    }

    public void cadastraDisciplina(int idAluno, int idSemestre, Disciplina disciplina) {
        this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().add(disciplina);
    }

    public void removeDisciplina(int idAluno, int idSemestre, int idDisciplina) {
        this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().remove(idDisciplina);
    }

    public void cadastraAvalicao(int idAluno, int idSemestre, int idDisciplina, Avaliacao avaliacao) {
        this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes().add(avaliacao);
    }

    public void removeAvaliacao(int idAluno, int idSemestre, int idDisciplina, int idAvaliacao) {
        this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes().remove(idAvaliacao);
    }

    public void adicionaNota(int idAluno, int idSemestre, int idDisciplina, int idAvaliacao, float nota) {
        this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes().get(idAvaliacao).setNota(nota);
    }

    public List<Semestre> buscarSemestres(int idAluno) {
        return this.alunos.get(idAluno).getSemestres();
    }

    public List<Disciplina> buscarDisciplinas(int idAluno, int idSemestre) {
        return this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas();
    }

    public List<Avaliacao> buscarAvaliacoes(int idAluno, int idSemestre, int idDisciplina) {
       return this.alunos.get(idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes();
    }

    public float calculaMediaDaDisciplina(int idAluno, int idSemestre, int idDisciplina) {
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = this.alunos.get(idAluno).getSemestreAt(idSemestre).getDisciplinaAt(idDisciplina).getAvaliacoes();
        float soma = 0;
        for (int i = 0; i < avaliacoes.size(); i += 1) {
            if (avaliacoes.get(i).getNota() != -1) {
                soma += (avaliacoes.get(i).getNota()) * avaliacoes.get(i).getPeso();
            }
        }
        return soma / avaliacoes.size();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sistema)) {
            return false;
        }
        Sistema sistema = (Sistema) o;
        return Objects.equals(alunos, sistema.alunos);
    }
}
