package dados.apresentacao;

import dados.Imobiliaria;
import dados.Imovel;

public class Apresentacao {
    private static Imovel imovel1 = new Imovel();
    private static Imovel imovel2 = new Imovel();
    private static Imobiliaria imobiliaria = new Imobiliaria();
    public static void main(String[] args) {
        imovel1.setComprimento(7);
        imovel1.setLargura(14);
        imovel1.setValor(120000);
        imovel2.setComprimento(3);
        imovel2.setLargura(30);
        imovel2.setValor(40);
        imobiliaria.setImoveis(imovel1);
        imobiliaria.setImoveis(imovel2);
        Imovel[] imoveisFiltrados = new Imovel[4];
        imoveisFiltrados = imobiliaria.filtrarPorArea(98);
        for(int i = 0; i < imoveisFiltrados.length; i+=1){
            if(imoveisFiltrados[i]!=null)
                System.out.println(imoveisFiltrados[i].toString());
        }
    }
}
