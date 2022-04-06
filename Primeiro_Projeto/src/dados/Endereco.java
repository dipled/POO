package dados;

public class Endereco {
    private String rua, numero, bairro, cidade, estado, cep;

    public Endereco() {

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
    public String toString(){
        String enderecoString = "";
        enderecoString += "Rua "+this.rua;
        enderecoString += ", "+this.numero;
        enderecoString += ", " + this.bairro;
        enderecoString += ", "+this.cidade;
        enderecoString += ", "+this.estado;
        enderecoString += ". CEP: "+this.cep+"\n\n";
        return enderecoString;
    }
}