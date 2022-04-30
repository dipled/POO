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
    
}
