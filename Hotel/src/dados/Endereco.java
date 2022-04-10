package dados;

import java.util.Objects;

public class Endereco {
    private String rua, numero, bairro, cidade, estado, cep;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    public String toString() {
        String enderecoString = "";
        enderecoString += " Rua " + this.rua;
        enderecoString += ", " + this.numero;
        enderecoString += ", " + this.bairro;
        enderecoString += ", " + this.cidade;
        enderecoString += ", " + this.estado;
        enderecoString += ". CEP: " + this.cep + "\n\n";
        return enderecoString;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero)
                && Objects.equals(bairro, endereco.bairro) && Objects.equals(cidade, endereco.cidade)
                && Objects.equals(estado, endereco.estado) && Objects.equals(cep, endereco.cep);
    }
}