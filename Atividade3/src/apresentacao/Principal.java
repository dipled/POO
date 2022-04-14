package apresentacao;

import negocio.*;

import java.util.Scanner;

import dados.*;

public class Principal {
    private static Scanner in = new Scanner(System.in);
    private static ReservaPassagem reservaPassagem = new ReservaPassagem();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Digite 1 para cadastrar uma cidade");
            System.out.println("Digite 2 para cadastrar um cliente");
            System.out.println("Digite 3 para fazer uma reserva");
            System.out.println("Digite 4 para mostrar todas as reservas de um cliente");
            System.out.println("Digite 0 para sair do programa");
            int escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    mostrarReservas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Escolha invalida");
                    break;

            }
        }

    }

    public static void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Digite o nome do cliente");
        String nome = in.nextLine();
        cliente.setNome(nome);

        System.out.println("Digite o CPF");
        String cpf = in.nextLine();
        cliente.setCpf(cpf);

        System.out.println("Digite o telefone");
        String telefone = in.nextLine();
        cliente.setTelefone(telefone);

        System.out.println("Digite o endereco");
        String endereco = in.nextLine();
        cliente.setEndereco(endereco);

        reservaPassagem.cadastrarCliente(cliente);
    }

    public static void cadastrarCidade() {
        Cidade cidade = new Cidade();

        System.out.println("Digite o nome da cidade");
        String nome = in.nextLine();
        cidade.setNome(nome);

        System.out.println("Digite o estado da cidade");
        String estado = in.nextLine();
        cidade.setEstado(estado);

        reservaPassagem.cadastrarCidade(cidade);
    }

    public static void fazerReserva() {
        if((reservaPassagem.getQuantidadeDeClientes() == 0) || (reservaPassagem.getQuantidadeDeCidades() == 0)){
            System.out.println("Algo deu errado");
            return;
        }

        Cliente[] clientes = reservaPassagem.mostrarClientes();
        System.out.println("CLIENTES:\n");
        for (int i = 0; i < reservaPassagem.getQuantidadeDeClientes(); i += 1) {
            System.out.println("ID " + i + clientes[i].toString());
        }
        System.out.println("Digite o ID do cliente para qual será feita a reserva");
        int clienteID = Integer.parseInt(in.nextLine());

        Reserva reserva = new Reserva();
        Cidade[] cidades = reservaPassagem.mostrarCidades();
        System.out.println("CIDADES:\n");
        for (int i = 0; i < reservaPassagem.getQuantidadeDeCidades(); i += 1) {
            System.out.println("ID " + i + cidades[i].toString());
        }
        System.out.println("Digite o ID da cidade de origem");
        int origemID = Integer.parseInt(in.nextLine());
        System.out.println("Digite o ID da cidade de destino");
        int destinoID = Integer.parseInt(in.nextLine());
        reserva = cadastraReserva();
        reserva.setOrigem(cidades[origemID]);
        reserva.setDestino(cidades[destinoID]);

        Reserva volta = new Reserva();
        System.out.println("Digite 1 para reservar uma volta para este cliente");
        int escolha = Integer.parseInt(in.nextLine()); 
        if (escolha == 1) {
            volta = cadastraReserva();
            volta.setOrigem(cidades[destinoID]);
            volta.setDestino(cidades[origemID]);
            reserva.setVolta(volta);
        }

        clientes[clienteID].reservarIda(reserva);
        if (reserva.isIdaEVolta() == true)
            clientes[clienteID].reservarVolta(reserva, volta);
        reservaPassagem.setCliente(clienteID, clientes[clienteID]);

    }

    public static Reserva cadastraReserva() {
        Reserva reserva = new Reserva();

        System.out.println("Digite o numero da reserva");
        int numReserva = Integer.parseInt(in.nextLine());
        reserva.setNumReserva(numReserva);

        System.out.println("Digite a data do voo");
        String dataVoo = in.nextLine();
        reserva.setDataVoo(dataVoo);

        System.out.println("Digite a hora do voo");
        String horaVoo = in.nextLine();
        reserva.setHoraVoo(horaVoo);

        System.out.println("Digite o preco da reserva");
        float preco = Float.parseFloat(in.nextLine());
        reserva.setPreco(preco);

        System.out.println("Digite a classe do voo");
        String classeVoo = in.nextLine();
        reserva.setClasseVoo(classeVoo);

        System.out.println("Digite o numero da poltrona");
        int poltrona = Integer.parseInt(in.nextLine());
        reserva.setPoltrona(poltrona);

        return reserva;
    }

    public static void mostrarReservas() {
        if (reservaPassagem.getQuantidadeDeClientes() == 0) {
            System.out.println("Algo deu errado");
            return;
        }
        System.out.println("Digite o cpf do cliente para o qual deseja mostrar as reservas");
        String cpfCliente = (in.nextLine());
        Reserva[] reservas = reservaPassagem.mostrarReservas(cpfCliente);
        if (reservas == null) {
            System.out.println("Algo deu errado");
            return;
        }
        for (int i = 0; i < reservas.length; i += 1) {
            if (reservas[i] == null)
                break;
            System.out.println(reservas[i].toString());

        }
    }

}
