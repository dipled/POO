package dados;

public class Gato extends Animal {

    public Gato(String nome){
        super(nome);
    }
    public String emitirSom(){
        return this.nome+": Miau miau";
    }
    
}
