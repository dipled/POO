package Ex3;

public class Video extends Arquivo{
    public Video(){
        super();
    }

    public Qualidade getQualidade() {
        return qualidade;
    }

    public void setQualidade(Qualidade qualidade) {
        this.qualidade = qualidade;
    }

    private Qualidade qualidade;

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + super.getExtensao() + "\nQualidade: " + this.qualidade;
    }
}
