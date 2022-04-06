package dados;

public class Dono {
    private String nome, cpf;
    private Endereco endereco;
    
    public Dono(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }  
    public String getNome(){
        return this.nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }
    public String toString(){
        String donoString = "";
        donoString += "Nome: "+this.nome+"\nCpf: "+this.cpf+"\nEndereco"+this.endereco.toString();
        return donoString;
    }
}