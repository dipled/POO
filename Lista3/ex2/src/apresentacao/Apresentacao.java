package apresentacao;
import dados.*;
public class Apresentacao {
    private static Circulo circulo1 = new Circulo();
    private static Circulo circulo2 = new Circulo();
    private static Losango losango1 = new Losango();
    private static Losango losango2 = new Losango();
    private static Trapezio trapezio1 = new Trapezio();
    private static Trapezio trapezio2 = new Trapezio();

    public static void main(String[] args) {
        circulo1.setRaio(3);
        circulo2.setRaio(2);
        losango1.setD(3);
        losango1.setd(2);
        losango2.setD(5);
        losango2.setd(30);
        trapezio1.setAltura(10);
        trapezio1.setBaseMaior(30);
        trapezio1.setBaseMenor(20);
        System.out.println(circulo1.toString());
        System.out.println(circulo2.toString());
        System.out.println(losango1.toString());
        System.out.println(losango2.toString());
        System.out.println(trapezio1.toString());
    }
}
