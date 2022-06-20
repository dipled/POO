package exceptions;
public class AnimalIncorretoException extends Exception{
    public AnimalIncorretoException(){

    }
    public AnimalIncorretoException(String mensagem){
        super(mensagem);
    }
}