package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private boolean idaEVolta = false;
    private int poltrona;
    private Reserva volta;
    private Cidade origem;
    private Cidade destino;

    public Cidade getOrigem() {
        return this.origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return this.destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public void setVolta(Reserva volta) {
        this.volta = volta;
        this.idaEVolta = true;
    }

    public Reserva getVolta() {
        return this.volta;
    }

    public int getNumReserva() {
        return this.numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public String getDataVoo() {
        return this.dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getHoraVoo() {
        return this.horaVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getClasseVoo() {
        return this.classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public boolean isIdaEVolta() {
        return this.idaEVolta;
    }

    public boolean getIdaEVolta() {
        return this.idaEVolta;
    }

    public void setIdaEVolta(boolean idaEVolta) {
        this.idaEVolta = idaEVolta;
    }

    public int getPoltrona() {
        return this.poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public String toString() {
        String retorno = "";
        retorno += " Numero da reserva: '" + this.numReserva + "'" +
                ", Data do voo: '" + this.dataVoo + "'" +
                ", Hora do voo: '" + this.horaVoo + "'" +
                ", Preco: '" + this.preco + "'" +
                ", Classe: '" + this.classeVoo + "'" +
                ", Poltrona: '" + this.poltrona + "'" +
                ", Origem: '" + this.origem.toString() + "'" +
                ", Destino: '" + this.destino.toString() + "'";
        return retorno;
    }

}
