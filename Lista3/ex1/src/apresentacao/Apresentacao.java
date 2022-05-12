package apresentacao;
import dados.*;
public class Apresentacao {
    private static Cachorro rex = new Cachorro("Rex");
    private static Cachorro bidu = new Cachorro("Bidu");
    private static Galinha carla = new Galinha("Carla");
    private static Galinha shelley = new Galinha("Shelley");
    private static Gato mimica = new Gato("Mimica");
    private static Gato bella = new Gato("Bella");

    public static void main(String[] args) {
        System.out.println(rex.emitirSom());
        System.out.println(bidu.emitirSom());
        System.out.println(carla.emitirSom());
        System.out.println(shelley.emitirSom());
        System.out.println(mimica.emitirSom());
        System.out.println(bella.emitirSom());
    }
}
