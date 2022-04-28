package dados;

import java.util.LinkedList;
import java.util.List;

public class Semestre {
    private String nome;
    private List<Disciplina> disciplinas = new LinkedList<Disciplina>();
    
    public Disciplina getDisciplinaAt(int idDisciplina){
        return this.disciplinas.get(idDisciplina);
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }     
    /*public void cadastraDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    public void removeDisciplina(int idDisciplina){
        this.disciplinas.remove(idDisciplina);
    }
    public void cadastraAvalicao(int idDisciplina, Avaliacao avaliacao) {
        this.disciplinas.get(idDisciplina).cadastraAvalicao(avaliacao);
    }
    public void removeAvaliacao(int idDisciplina, Avaliacao avaliacao){
        this.disciplinas.get(idDisciplina).removeAvaliacao(avaliacao);
    }
    public void adicionaNota(int idDisciplina, int idAvaliacao, float nota){
        this.disciplinas.get(idDisciplina).adicionaNota(idAvaliacao, nota);
    }*/
    
}
