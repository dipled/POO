package dados;

public class Contato {
    private int id;
    private String nome;
    private int telefone;

    public Contato(){
        
    }
    public Contato(int id, String nome, int telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "Nome: " + this.nome + "\nTelefone: " + this.telefone;
    }

    public boolean equals(Object o) {

        if (o instanceof Contato) {
            Contato c = (Contato) o;
            if (c.telefone == this.telefone && c.nome == this.nome) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}