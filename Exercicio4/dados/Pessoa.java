package dados;
public class Pessoa{
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(){

    }

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", idade='" + getIdade() + "'" +
            ", cpf='" + getCpf() + "'" +
            "}";
    }

}