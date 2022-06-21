package ex3;

public class Musica extends Arquivo{
    public Musica() {
        super();
    }

    private int duracao;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + super.getExtensao() + "\nDuracao: " + this.duracao;
    }
}
