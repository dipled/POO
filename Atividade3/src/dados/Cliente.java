package dados;

public class Cliente {
    private String cpf, telefone;
    private String nome, endereco;
    private int quantidadeDeReserva = 0;
    private Reserva[] reservas = new Reserva[50];

    public int getQuantidadeDeReserva() {
        return this.quantidadeDeReserva;
    }

    public void setQuantidadeDeReserva(int quantidadeDeReserva) {
        this.quantidadeDeReserva = quantidadeDeReserva;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Reserva[] getReservas() {
        return this.reservas;

    }

    public void reservarIda(Reserva reserva) {
        int id = this.quantidadeDeReserva;
        if (id < 50) {
            this.reservas[id] = new Reserva();
            this.reservas[id] = reserva;
            this.quantidadeDeReserva += 1;

        }
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        int id = this.quantidadeDeReserva;
        if (id < 50) {
            this.reservas[id] = volta;
            this.quantidadeDeReserva += 1;
            ida.setVolta(volta);

        }
    }

    public String toString() {
        String retorno = "";
        retorno += " CPF: '" + this.cpf + "'" +
                ", Telefone: '" + this.telefone + "'" +
                ", Nome: '" + this.nome + "'" +
                ", Endereco: '" + this.endereco + "'";
        if (this.quantidadeDeReserva > 0)
            retorno += ", Reservas: '" + this.reservas.toString() + "'";
        return retorno;
    }

}
