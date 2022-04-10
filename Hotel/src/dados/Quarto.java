package dados;

import java.util.Objects;

public class Quarto {
    private boolean ocupado;
    private int numero;
    private boolean suite;

    public Quarto(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Quarto(boolean ocupado, int numero, boolean suite) {
        this.ocupado = ocupado;
        this.numero = numero;
        this.suite = suite;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public boolean getOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isSuite() {
        return this.suite;
    }

    public boolean getSuite() {
        return this.suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public String toString() {
        String quartoString = "";
        quartoString += " Número do quarto: " + this.numero;
        if (this.suite == true) {
            quartoString += "\n Suite: Sim";
        } else {
            quartoString += "\n Suite: Não";
        }
        if (this.ocupado == true) {
            quartoString += "\n Ocupado: Sim";
        } else {
            quartoString += "\n Ocupado: Não";
        }
        return quartoString;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Quarto)) {
            return false;
        }
        Quarto quarto = (Quarto) o;
        return ocupado == quarto.ocupado && numero == quarto.numero && suite == quarto.suite;
    }

}
