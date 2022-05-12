package dados;

public class Avaliacao {
    private String nome;
    private double peso;
    private String data;
    private double nota = -1;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String toString() {
        String str = "";
        str += "Nome: " + this.nome + "\nPeso: " + this.peso + "\nData: " + this.data;
        if (this.nota != -1)
            str += "\nNota: " + this.nota;
        return str;
    }

    public boolean equals(Object o) {
        if (o instanceof Avaliacao) {
            Avaliacao a = (Avaliacao) o;
            if (a.nome == this.nome && a.data == this.data && a.nota == this.nota && a.peso == this.peso) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
