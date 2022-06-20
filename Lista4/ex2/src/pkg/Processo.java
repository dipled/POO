package pkg;

public class Processo {
    private int id;
    private String nome;
    public Processo(){

    }
    public Processo(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
