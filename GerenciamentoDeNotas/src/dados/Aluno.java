package dados;

public class Aluno {
    private String cpf;
    private String senha;
    private String nome;
    private int idade;
    private Semestre[] semestres = new Semestre[20];
    private int quantidadeDeSemestres = 0;
    
    
    public Semestre[] getSemestres(){
        return this.semestres;
    }

    public void setSemestres(Semestre semestre){
        if(quantidadeDeSemestres < 20){
            this.semestres[this.quantidadeDeSemestres] = semestre;
            this.quantidadeDeSemestres += 1;
        }
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

    public void setIdade(int idade){
        this.idade = idade;
    }

}
