import dados.Imobiliaria;
import dados.Imovel;

public class App {
    private static Imovel imovel1 = new Imovel(10, 10, 300000);
    private static Imovel imovel2 = new Imovel(20, 20, 900000);
    private static Imovel imovel3 = new Imovel(2, 5, 100);
    private static Imobiliaria imobiliaria = new Imobiliaria();

    public static void main(String[] args) {
        imobiliaria.setImoveis(imovel1);
        imobiliaria.setImoveis(imovel2);
        imobiliaria.setImoveis(imovel3);
        imobiliaria.setNome("Nome");
        
        System.out.println(imobiliaria.toString());
        System.out.println(imobiliaria.filtroToString(100));
    }
}
