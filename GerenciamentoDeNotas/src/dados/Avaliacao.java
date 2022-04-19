package dados;


public class Avaliacao {
    private String nome;
    private float peso;
    private String data;
    private float nota = -1;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String toString() {
        String str = "";
        str += "Nome: " + this.nome + "\nPeso: " + this.peso + "\nData: " + this.data;
        if (this.nota != -1)
            str += "Nota: " + this.nota;
        return str;
    }

    public boolean equals(Avaliacao avaliacao){
        if(this.nome == avaliacao.getNome())
            return true;
        else
            return false;
    }

}