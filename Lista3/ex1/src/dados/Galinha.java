package dados;

public class Galinha extends Animal{
    public Galinha(String nome){
        super(nome);
    }
    public String emitirSom(){
        return this.nome+": Cocoricó";
    }
}
