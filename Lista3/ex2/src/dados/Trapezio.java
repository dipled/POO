package dados;

public class Trapezio extends FormaGeometrica {
    private double altura;

    public void setBaseMenor(double valor) {
        this.medida1 = valor;
    }

    public void setBaseMaior(double valor) {
        this.medida2 = valor;
    }

    public void setAltura(double valor) {
        this.altura = valor;
    }

    public double calcularArea() {
        return (this.medida1 + this.medida2) * this.altura / 2; // Essa eh a formula correta da area do trapezio
    }

    public double calcularPerimetro() {
        return 4 * (Math.sqrt(Math.pow((this.medida1 / 2 - this.medida2 / 2), 2))); // Nem sei se isso funciona pra
                                                                                    // calcular o perimetro, pra mim a
                                                                                    // formula do slide nao fez o menor
                                                                                    // sentido
    }

    public String toString() {
        String string = "";
        string += "Trapezio: " + "\nBase maior: " + this.medida1 + "\nBase menor: " + this.medida2 + "\nAltura: "
                + this.altura + "\nÁrea: " + this.calcularArea() + "\nPerimetro: " + this.calcularPerimetro();
        return string;
    }
}
