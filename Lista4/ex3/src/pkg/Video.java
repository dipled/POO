package pkg;

public class Video extends Arquivo {
    private Qualidade qual;

    public Video(String nome) throws NomeInvalidoException {
        super(nome);
    }

    public Qualidade getQual() {
        return this.qual;
    }

    public void setQual(Qualidade qual) {
        this.qual = qual;
    }

    public String toString() {
        super.setExtensao(".mp4");
        return super.getNome() + super.getExtensao() + "\n" +
                "Qualidade: " + getQual().getResolucao();
    }

}