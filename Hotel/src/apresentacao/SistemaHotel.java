package apresentacao;

import dados.Cliente;
import dados.Endereco;
import dados.Pessoa;
import dados.Quarto;
import java.util.Scanner;

public class SistemaHotel {
    private static Scanner in = new Scanner(System.in);
    private static Quarto[] quartos = new Quarto[50];
    private static Cliente[] clientes = new Cliente[50];
    private static int numeroDeQuartos = 0;
    private static int numeroDeClientes = 0;

    public static void menu() {
        System.out.println("Digite 1 para adicionar um quarto");
        System.out.println("Digite 2 para consultar todos os quartos");
        System.out.println("Digite 3 para adicionar um cliente");
        System.out.println("Digite 4 para consultar todos os clientes cadastrados");
        System.out.println("Digite 0 para sair");
    }

    public static void adicionaQuarto() {
        Quarto quarto = new Quarto();
        if (numeroDeQuartos >= 50) {
            System.out.println("Número mámximo de quartos atingido");
            return;
        }
        System.out.println("Digite o número do quarto");
        int numero = Integer.parseInt(in.nextLine());
        quarto.setNumero(numero);

        System.out.println("O quarto é uma suite? (S/N)");
        String resposta = in.nextLine();
        boolean suite;
        if (resposta.equals("S")||resposta.equals("s")) {
            suite = true;
        } else {
            suite = false;
        }
        quarto.setSuite(suite);

        quartos[numeroDeQuartos] = quarto;
        numeroDeQuartos += 1;

    }

    public static Quarto buscaQuarto(int numero) {
        for (int i = 0; i < numeroDeQuartos; i += 1) {
            if (quartos[i].getNumero() == numero) {
                return quartos[i];
            }
        }
        System.out.println("Quarto não encontrado");
        return null;
    }

    public static Endereco cadastraEndereco() {
        Endereco e = new Endereco();

        System.out.println("\n\nDigite a rua");
        String rua = in.nextLine();
        e.setRua(rua);

        System.out.println("Digite o bairro");
        String bairro = in.nextLine();
        e.setBairro(bairro);

        System.out.println("Digite o numero da casa");
        String numero = (in.nextLine());
        e.setNumero(numero);

        System.out.println("Digite a cidade");
        String cidade = in.nextLine();
        e.setCidade(cidade);

        System.out.println("Digite o estado");
        String estado = in.nextLine();
        e.setEstado(estado);

        System.out.println("Digite o cep");
        String cep = in.nextLine();
        e.setCep(cep);

        return e;
    }

    public static Pessoa cadastraPessoa() {
        Pessoa pessoa = new Pessoa();

        System.out.println("Digite o nome");
        String nome = in.nextLine();
        pessoa.setNome(nome);

        System.out.println("É menor de idade?(S/N)");
        String resposta = in.nextLine();
        boolean menorDeIdade;
        if (resposta == "S") {
            menorDeIdade = true;
        } else {
            menorDeIdade = false;
        }
        pessoa.setMenorDeIdade(menorDeIdade);

        return pessoa;
    }

    public static void adicionaCliente() {
        if (numeroDeClientes >= 50) {
            System.out.println("Número máximo de clientes atingido");
            return;
        }
        Cliente cliente = new Cliente();

        Pessoa pessoaQueReservou = new Pessoa();
        pessoaQueReservou = cadastraPessoa();

        Endereco endereco = new Endereco();
        endereco = cadastraEndereco();
        pessoaQueReservou.setEndereco(endereco);

        cliente.setPessoaQueReservou(pessoaQueReservou);

        Pessoa pessoa = new Pessoa();
        System.out.println("Quantos acompanhantes essa pessoa tem? (Máximo de 10 acompanhantes)");
        int quantidadeAcompanhantes = Integer.parseInt(in.nextLine());
        if (quantidadeAcompanhantes < 10) {
            System.out.println("Digite as informações dos acompanhantes");
            for (int i = 0; i < quantidadeAcompanhantes; i += 1) {
                pessoa = cadastraPessoa();
                cliente.setAcompanhantes(pessoa);
            }

        } else {
            System.out.println("Quantidade inválida de acompanhantes");
            return;
        }
        System.out.println("Digite o quarto que este cliente gostaria de alugar");
        int numero = Integer.parseInt(in.nextLine());
        Quarto quarto = buscaQuarto(numero);
        if (quarto != null) {
            if (quarto.isOcupado() == true) {
                System.out.println("Quarto já ocupado");
                return;
            }
            quarto.setOcupado(true);
            cliente.setQuarto(quarto);
        } else {
            System.out.println("Quarto inválido");
            return;
        }
        clientes[numeroDeClientes] = cliente;
        numeroDeClientes += 1;
    }

    public static void mostraQuartos() {
        for (int i = 0; i < numeroDeQuartos; i += 1) {
            String quartoString = quartos[i].toString();
            System.out.println("\n" + quartoString);
        }
    }

    public static void mostraClientesCadastrados() {
        for (int i = 0; i < numeroDeClientes; i += 1) {
            String clienteString = clientes[i].toString();
            System.out.println("\n" + clienteString);
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            int escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 0:
                    return;
                case 1:
                    adicionaQuarto();
                    break;
                case 2:
                    mostraQuartos();
                    break;
                case 3:
                    adicionaCliente();
                    break;
                case 4:
                    mostraClientesCadastrados();
                    break;
                default:
                    break;

            }
        }

    }

}
