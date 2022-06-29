package pkg;

public class Documento extends Arquivo {
    String texto;

    public Documento(String nome) throws NomeInvalidoException {
        super(nome);
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        super.setExtensao(".txt");
        return super.getNome() + super.getExtensao();
    }

}
