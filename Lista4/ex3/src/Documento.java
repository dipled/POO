package ex3;

public class Documento extends Arquivo{
    public Documento() {
        super();
    }

    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + super.getExtensao() + "\nTexto: " + this.texto;
    }
}
