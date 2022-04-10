package dados;

import java.util.Objects;

public class AnimalDeEstimacao {
    private String nome;
    private String especie;
    private String descricao;

    public AnimalDeEstimacao() {
    }

    public AnimalDeEstimacao(String nome, String especie, String descricao) {
        this.nome = nome;
        this.especie = especie;
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString() {
        String animalString = "";
        animalString += " Nome: " + this.nome;
        animalString += "\n Espécie: " + this.especie;
        animalString += "\n Sobre: " + this.descricao;
        return animalString;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AnimalDeEstimacao)) {
            return false;
        }
        AnimalDeEstimacao animalDeEstimacao = (AnimalDeEstimacao) o;
        return Objects.equals(nome, animalDeEstimacao.nome) && Objects.equals(especie, animalDeEstimacao.especie)
                && Objects.equals(descricao, animalDeEstimacao.descricao);
    }

}
