package dados;

public abstract class Animal {
    protected String nome;
    
    public Animal(){

    }

    public Animal(String nome){
        this.nome = nome;
    }
        
    public abstract String emitirSom();

}
