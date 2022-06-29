package dados;

public class Semestre {
    private int id;
    private String nome;
    private int idAluno;

    public Semestre() {
    }

    public Semestre(int id, String nome, int idAluno) {
        this.id = id;
        this.nome = nome;
        this.idAluno = idAluno;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return this.idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }
}
