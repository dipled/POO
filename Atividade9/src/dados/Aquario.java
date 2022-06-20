package dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public Aquario() {
    }

    public Aquario(String nome, float comprimento, float largura) {
        super(nome, comprimento, largura);
    }

    public float calculaEspaco() {
        return super.calculaEspaco() * this.altura;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void adicionarAnimal(Animal animal) {
        super.adicionarAnimal(animal);
    }

    @Override
    public String toString() {
        return super.toString() + ", Altura:'" + getAltura() + "'" + ", Temperatura:'" + getTemperatura();
    }

}
