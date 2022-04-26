package dados;

public class Semestre {
    private String nome;
    private Disciplina[] disciplinas = new Disciplina[10];
    private int quantidadeDeDisciplinas = 0;
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public Disciplina[] getDisciplinas(){
        return this.disciplinas;
    }     
    public void setDisciplina(Disciplina disciplina){
        if(quantidadeDeDisciplinas < 10){
            this.disciplinas[this.quantidadeDeDisciplinas] = disciplina;

            //EU SOU FODA HAHAHAAHAAHAHAHAHAHAHAHAHHAHAHAHH
        }
    }
    public int getQuantidadeDeDisciplinas(){
        return this.quantidadeDeDisciplinas;
    }

    public void setQuantidadeDeDisciplinas(int quantidadeDeDisciplinas){
        this.quantidadeDeDisciplinas = quantidadeDeDisciplinas;
    }
}
