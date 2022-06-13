package dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    protected float largura;
    protected float comprimento;
    protected float altura;

    public Animal() {
    }


    public Animal(String nome, String cor, String especie, int idade, float largura, float comprimento, float altura) {
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.idade = idade;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculaEspacoOcupado() {
        return this.comprimento * this.largura;
    }

    public String toString() {
        return "Nome:'" + getNome() + "'" +
                ", Cor: '" + getCor() + "'" +
                ", Especie: '" + getEspecie() + "'" +
                ", Idade: '" + getIdade() + "'" +
                ", Largura: '" + getLargura() + "'" +
                ", Comprimento: '" + getComprimento() + "'" +
                ", Altura: '" + getAltura() + "'";
    }

}
