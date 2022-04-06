package dados;

public class Animais {
    private String nome, especie, descricao;
    private Dono dono;
    public Animais(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public String getEspecie(){
        return this.especie;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDono(Dono dono)
    {
        this.dono = dono;
    }
    public Dono getDono(){
        return this.dono;
    }
    public String toString(){
        String animalString = "";
        animalString += "Nome: "+this.nome+"\nEspécie: "+this.especie+"\nDescrição: "+this.descricao;
        if(this.dono != null)
            animalString += "Dono: "+this.dono.toString();
        return animalString;

    }
}