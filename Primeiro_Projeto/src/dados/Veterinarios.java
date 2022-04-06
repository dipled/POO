package dados;

public class Veterinarios {
    private String nome;
    private double salario;
    private Endereco endereco;
    private int quantidadeAnimais = 0;
    private Animais[] animais = new Animais[50];

    public Veterinarios(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }  
    public String getNome(){
        return this.nome;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }  
    public double getSalario(){
        return this.salario;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }
    public void setQuantidadeAnimais(int quantidadeAnimais){
        this.quantidadeAnimais = quantidadeAnimais;
    }
    public int getQuantidadeAnimais(){
        return this.quantidadeAnimais;
    }
    public void setAnimais(Animais animais){
        if(this.quantidadeAnimais < 30)
        {
            this.animais[quantidadeAnimais] = animais;
            quantidadeAnimais += 1;
        }
        
    }
    public Animais[] getAnimais(){
        return this.animais;
    }
    public String toString(){
        String veterinarioString = "";
        veterinarioString += "Nome: "+this.nome+"\nSalário: "+this.salario;
        if(this.endereco != null)
            veterinarioString += "\nEndereço: "+this.endereco.toString();
        return veterinarioString;
    }
}