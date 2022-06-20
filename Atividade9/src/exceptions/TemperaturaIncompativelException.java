package exceptions;

public class TemperaturaIncompativelException extends Exception {
    public TemperaturaIncompativelException(){

    }
    public TemperaturaIncompativelException(String mensagem){
        super(mensagem);
    }
    
}
