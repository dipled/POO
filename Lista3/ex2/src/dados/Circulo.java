package dados;

public class Circulo extends FormaGeometrica {

    public void setRaio(double valor) {
        this.medida1 = valor;
    }

    public double calcularArea() {
        return Math.PI * (Math.pow(this.medida1, 2));
    }

    public double calcularPerimetro() {
        return Math.PI * this.medida1 * 2;
    }

    public String toString() {
        String string = "";
        string += "Circulo: " + "\nRaio: " + this.medida1 + "\nÁrea: " + this.calcularArea() + "\nPerimetro: "
                + this.calcularPerimetro();
        return string;
    }

}
