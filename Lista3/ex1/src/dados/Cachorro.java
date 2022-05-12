package dados;

public class Cachorro extends Animal {
    public Cachorro(String nome){
        super(nome);
    }
    public String emitirSom(){
        return this.nome+": Au au";
    }    
}
