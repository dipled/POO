package dados;
public class Disciplina {
    private int id;
    private String nome;
    private int idSemestre;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, int idSemestre) {
        this.id = id;
        this.nome = nome;
        this.idSemestre = idSemestre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSemestre() {
        return this.idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
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
