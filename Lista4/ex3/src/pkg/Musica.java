package pkg;

public class Musica extends Arquivo {
    public Musica(String nome) throws NomeInvalidoException {
        super(nome);
    }

    private int duracao;
    
    public int getDuracao() {
        return this.duracao;
    }
    
    
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public String toString() {
        super.setExtensao(".mp3");
        return super.getNome() + super.getExtensao() +
                "\nDuração: " + getDuracao() + " Segundos";
    }
}