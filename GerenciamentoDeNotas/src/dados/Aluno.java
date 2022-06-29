package dados;

public class Aluno {
    private int id;
    private String cpf;
    private String senha;
    private String nome;
    private int idade;
    private String curso;


    public Aluno() {
    }


    public Aluno(int id, String cpf, String senha, String nome, int idade, String curso) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

}
