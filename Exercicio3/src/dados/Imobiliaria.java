package dados;

public class Imobiliaria {

    private String nome;
    private Imovel[] imoveis = new Imovel[50];
    private int quantidadeDeImoveis = 0;

    public Imobiliaria() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setQuantidadeDeImoveis(int quantidadeDeImoveis) {
        this.quantidadeDeImoveis = quantidadeDeImoveis;
    }

    public int getQuantidadeDeImoveis() {
        return this.quantidadeDeImoveis;
    }
    public void setImoveis(Imovel imovel) {
        if (this.quantidadeDeImoveis < 50) {
            this.imoveis[this.quantidadeDeImoveis] = imovel;
            this.quantidadeDeImoveis += 1;
        }
    }

    public Imovel[] getImoveis() {
        return this.imoveis;
    }

    public Imovel[] filtrarPorArea(float x) {
        Imovel[] imoveisOrdenados = new Imovel[this.quantidadeDeImoveis];
        Imovel aux = new Imovel();
        for (int i = 0; i < this.quantidadeDeImoveis; i += 1) {
            for (int i2 = i; i2 < this.quantidadeDeImoveis; i2 += 1) {
                if (this.imoveis[i2].areaTotal() >= x && !this.imoveis[i2].equals(aux)) {
                    imoveisOrdenados[i] = this.imoveis[i2];
                    aux = this.imoveis[i2];
                    break;
                }
            }
        }
        for (int i = 0; i < imoveisOrdenados.length; i += 1) {
            for (int i2 = i; i2 < imoveisOrdenados.length; i2 += 1) {
                if ((imoveisOrdenados[i2]!=null) && (imoveisOrdenados[i2].getValor() > imoveisOrdenados[i].getValor())) {
                    aux = imoveisOrdenados[i];
                    imoveisOrdenados[i] = imoveisOrdenados[i2];
                    imoveisOrdenados[i2] = aux;
                }
            }
        }
        return imoveisOrdenados;
    }

    public String filtroToString(float x){
        Imovel[] imoveisOrdenados = new Imovel[50];
        imoveisOrdenados = filtrarPorArea(x);
        String imoveisOrdenadosString = "\n\nImoveis com mais de "+x+" metros quadrados:\n";
        for(int i = 0; i < imoveisOrdenados.length; i += 1){
            if(imoveisOrdenados[i]!=null)
                imoveisOrdenadosString += "ID-"+i+"\n"+imoveisOrdenados[i].toString()+"\n";
        }
        return imoveisOrdenadosString;

    }

    public String toString() {
        String imoveisString = "Imoveis: ";
        for (int i = 0; i < this.quantidadeDeImoveis; i += 1) {
            imoveisString += "\n\nID-" + i + "\n";
            imoveisString += this.imoveis[i].toString();
        }
        return imoveisString;
    }
}
