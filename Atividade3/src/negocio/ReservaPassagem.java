package negocio;

import dados.Reserva;
import dados.Cidade;
import dados.Cliente;

public class ReservaPassagem {
    private Cidade[] listaDeCidades = new Cidade[50];
    private Cliente[] listaDeClientes = new Cliente[50];
    private int quantidadeDeCidades = 0, quantidadeDeClientes = 0;

    public int getQuantidadeDeCidades() {
        return this.quantidadeDeCidades;
    }

    public void setQuantidadeDeCidades(int quantidadeDeCidades) {
        this.quantidadeDeCidades = quantidadeDeCidades;
    }

    public int getQuantidadeDeClientes() {
        return this.quantidadeDeClientes;
    }

    public void setQuantidadeDeClientes(int quantidadeDeClientes) {
        this.quantidadeDeClientes = quantidadeDeClientes;
    }

    public void cadastrarCidade(Cidade cidade) {
        if (this.quantidadeDeCidades < 50 && cidade != null) {
            this.listaDeCidades[this.quantidadeDeCidades] = cidade;
            this.quantidadeDeCidades += 1;
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        if (this.quantidadeDeClientes < 50 && cliente != null) {
            this.listaDeClientes[this.quantidadeDeClientes] = cliente;
            this.quantidadeDeClientes += 1;
        }
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);

    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public Reserva[] mostrarReservas(String cpfCliente) {
        for (int i = 0; i < this.quantidadeDeClientes; i += 1) {
            if (this.listaDeClientes[i].getCpf().equals(cpfCliente)) {
                return this.listaDeClientes[i].getReservas();
            }
        }
        return null;
    }

    public Cidade[] mostrarCidades() {
        return this.listaDeCidades;
    }

    public Cliente[] mostrarClientes() {
        return this.listaDeClientes;
    }

    public void setCliente(int clienteID, Cliente cliente){
        this.listaDeClientes[clienteID] = cliente;
    }

}