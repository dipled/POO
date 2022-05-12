package dados;

public class Losango extends FormaGeometrica {
    public void setD(double valor) {
        this.medida1 = valor;
    }

    public void setd(double valor) {
        this.medida2 = valor;
    }

    public double calcularArea() {
        return this.medida1 * this.medida2 / 2;
    }

    public double calcularPerimetro() {
        return 4 * (Math.sqrt(Math.pow(this.medida1, 2) / 4 + Math.pow(this.medida2, 2) / 4));
    }

    public String toString() {
        String string = "";
        string += "Losango: " + "\nDiagonal maior: " + this.medida1 + "\nDiagonal menor: " + this.medida2 + "\nÁrea: "
                + this.calcularArea() + "\nPerimetro: " + this.calcularPerimetro();
        return string;
    }

}
