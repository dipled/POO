package dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public Peixe(){
        
    }


    public Peixe(String nome, String cor, String especie, int idade, float largura, float comprimento, float altura) {
        super(nome, cor, especie, idade, largura, comprimento, altura);
    }


    public float getTemperaturaIdeal() {
        return this.temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
    public float calculaEspacoOcupado(){
        return super.calculaEspacoOcupado()*super.altura;
    }
    public String toString(){
        return super.toString()+ ", Temperatura Ideal: '" + getTemperaturaIdeal() + "'";
    }
    
}
