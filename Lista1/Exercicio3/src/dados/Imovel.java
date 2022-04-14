package dados;

public class Imovel {
    private float comprimento = 0;
    private float largura = 0;
    private float valor = 0;

    public Imovel(float comprimento, float largura, float valor) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.valor = valor;
    }

    public Imovel() {

    }

    public Imovel(float comprimento, float largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getLargura() {
        return this.largura;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return this.valor;
    }

    public float areaTotal() {
        float area = this.comprimento * this.largura;
        return area;
    }

    public String toString() {
        String imovelString = "";
        imovelString += " Valor: \tR$" + this.valor;
        imovelString += "\n Comprimento:\t" + this.comprimento + " m";
        imovelString += "\n Largura:\t" + this.largura + " m";
        imovelString += "\n Área Total:\t" + this.areaTotal() + " m2";
        return imovelString;
    }

}
