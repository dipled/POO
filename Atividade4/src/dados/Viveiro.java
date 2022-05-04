package dados;

import java.util.LinkedList;
import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais = new LinkedList<>();

    public Viveiro() {
    }

    public Viveiro(String nome, float comprimento, float largura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public List<Animal> getAnimais() {
        return this.animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public float calculaEspaco() {
        return this.comprimento * this.largura;
    }

    private float espacoOcupado() {
        float ocupado = 0;
        for (int i = 0; i < this.animais.size(); i += 1) {
            ocupado += this.animais.get(i).calculaEspacoOcupado();
        }
        return ocupado;
    }

    private float espacoDisponivel() {
        return this.calculaEspaco() - this.espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        float animalEspaco = animal.calculaEspacoOcupado();
        if(!(this instanceof Aquario) && (animal instanceof Peixe))
        {
            return false;
        }
        if (this.espacoDisponivel() > animalEspaco + 0.70 * animalEspaco) {
            this.animais.add(animal);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "{" +
                " Nome:'" + getNome() + "'" +
                ", Comprimento:'" + getComprimento() + "'" +
                ", Largura:'" + getLargura() + "'" +
                "}";
    }

}
