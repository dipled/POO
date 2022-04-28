package dados;

import java.util.LinkedList;
import java.util.List;

public class Semestre {
    private String nome;
    private List<Disciplina> disciplinas = new LinkedList<Disciplina>();
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }     
    public void setDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    
}
