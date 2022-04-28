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

    public void cadastraAluno(Aluno aluno) {
        if (aluno != null) {
            this.alunos.add(aluno);
        }
    }

    public void cadastraSemestre(int idAluno, Semestre semestre) {
        this.alunos.get(idAluno).cadastraSemestre(semestre);

    }
    public void removeSemestre(int idAluno, int idSemestre){
        this.alunos.get(idAluno).removeSemestre(idSemestre);
    }

    public int login(Aluno aluno) {
        for (int i = 0; i < this.alunos.size(); i += 1) {
            if (this.alunos.get(i).login(aluno)) {
                return i;
            }
        }
        return -1;
    }

    public List<Semestre> buscaSemestres(int idAluno) {
        return this.alunos.get(idAluno).getSemestres();
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
