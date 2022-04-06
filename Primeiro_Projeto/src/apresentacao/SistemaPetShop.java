package apresentacao;

import dados.Animais;
import dados.Endereco;
import dados.Dono;
import dados.Veterinarios;
import java.util.Scanner;

public class SistemaPetShop {
    private static Veterinarios[] veterinarios = new Veterinarios[50];
    private static int numeroVeterinarios = 0;
    private static Scanner in = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n\nDigite 1 para cadastrar um veterinário");
        System.out.println("Digite 2 para exibir os veterinários");
        System.out.println("Digite 3 para cadastrar um endereço ao veterinário");
        System.out.println("Digite 4 para cadastrar um animal");
        System.out.println("Digite 5 para exibir os animais");
        System.out.println("Digite 6 para cadastrar um dono");
        System.out.println("Digite 0 para sair");
    }

    public static void cadastrarVeterinario() {
        if (numeroVeterinarios < 50) {
            Veterinarios vet = new Veterinarios();

            System.out.println("\n\nDigite o nome do veterinário");
            String nome = in.nextLine();
            vet.setNome(nome);

            System.out.println("Digite o salario do veterinário");
            double salario = Double.parseDouble(in.nextLine());
            vet.setSalario(salario);

            veterinarios[numeroVeterinarios] = vet;
            numeroVeterinarios += 1;

        }
    }

    public static Veterinarios escolheVeterinario() {
        if (numeroVeterinarios == 0)
        {
            System.out.println("Nenhum veterinário cadastrado");
            return null;
        }
            System.out.println("\n\nEscolha um veterinario");
        mostrarVeterinarios();
        int vetEscolha = Integer.parseInt(in.nextLine());
        if (vetEscolha > numeroVeterinarios) {
            System.out.println("Escolha inválida");
            return null;
        } else
            return veterinarios[vetEscolha];
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

    public static void cadastraEnderecoVeterinario() {
        Veterinarios vet = escolheVeterinario();
        if (vet != null) {
            vet.setEndereco(cadastraEndereco());
        } else {
            System.out.println("\n\nEscolha inválida");
        }
    }

    public static void mostrarVeterinarios() {
        for (int i = 0; i < numeroVeterinarios; i += 1) {
            System.out.println("\n\nID " + i + " \n" + veterinarios[i].toString());
        }
        if (numeroVeterinarios == 0) {
            System.out.println("\n\nNenhum veterinário cadastrado");
        }
    }

    public static Animais cadastrarAnimais() {
        Animais ani = new Animais();

        System.out.println("\n\nDigite o nome do animal");
        String nome = in.nextLine();
        ani.setNome(nome);

        System.out.println("Digite a espécie do animal");
        String especie = in.nextLine();
        ani.setEspecie(especie);

        System.out.println("Digite a descrição do animal");
        String descricao = in.nextLine();
        ani.setDescricao(descricao);

        return ani;
    }

    public static void cadastrarAnimalVeterinario() {
        Veterinarios vet = escolheVeterinario();
        if (vet != null)
            vet.setAnimais(cadastrarAnimais());
        else {
            System.out.println("\n\nEscolha inválida");
        }

    }

    public static Dono cadastrarDono() {
        Dono don = new Dono();

        System.out.println("\n\nDigite o nome do dono");
        String nome = in.nextLine();
        don.setNome(nome);

        System.out.println("Digite o cpf do dono");
        String cpf = in.nextLine();
        don.setCpf(cpf);

        don.setEndereco(cadastraEndereco());

        return don;
    }

    public static void mostrarAnimais() {
        Veterinarios vet = escolheVeterinario();
        if (vet != null) {
            for (int i = 0; i < vet.getQuantidadeAnimais(); i += 1) {
                System.out.println("\n\nAnimal Id " + i + " \n" + vet.getAnimais()[i].toString());
            }
            if (vet.getQuantidadeAnimais() == 0)
                System.out.println("\n\nNenhum animal cadastrado");
        }
        else{
            System.out.println("\n\nEscolha inválida");
        }
    }

    public static Animais escolheAnimais() {
        Veterinarios vet = escolheVeterinario();
        if (vet != null) {
            for (int i = 0; i < vet.getQuantidadeAnimais(); i += 1) {
                System.out.println("\n\nAnimal Id " + i + " \n" + vet.getAnimais()[i].toString());
            }
            if (vet.getQuantidadeAnimais() == 0) {
                System.out.println("\n\nNenhum animal cadastrado para esse veterinário");
                return null;
            }
            int aniEscolha = Integer.parseInt(in.nextLine());
            if (aniEscolha > vet.getQuantidadeAnimais()) {
                return null;
            } else {
                return vet.getAnimais()[aniEscolha];
            }
        }
        return null;
    }

    public static void cadastrarDonoAnimal() {
        Animais ani = escolheAnimais();
        if (ani != null)
            ani.setDono(cadastrarDono());
        else {
            System.out.println("\n\nEscolha inválida");
        }
    }

    public static void main(String[] args) {
        int escolha = -1;
        while (escolha != 0) {
            menu();
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 0:
                    break;
                case 1:
                    cadastrarVeterinario();
                    break;
                case 2:
                    mostrarVeterinarios();
                    break;
                case 3:
                    cadastraEnderecoVeterinario();
                    break;
                case 4:
                    cadastrarAnimalVeterinario();
                    break;
                case 5:
                    mostrarAnimais();
                    break;
                case 6:
                    cadastrarDonoAnimal();
                    break;
                default:
                    System.out.println("Escolha invalida");
                    break;
            }
        }
    }
}