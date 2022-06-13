package apresentacao;

import dados.*;
import negocio.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static ListaTelefonica listaTelefonica = new ListaTelefonica();

    public static void main(String[] args) {
        int escolha;
        while (true) {
            menu();
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 4:
                    System.out.println("Digite a letra do contato desejado");
                    String input = in.nextLine();
                    exibirContatos(input.charAt(0));
                    break;
                case 0:
                    return;
            }
        }

    }
    public static void menu() {
        System.out.println("Digite 1 para adicionar um novo contato");
        System.out.println("Digite 2 para remover um contato");
        System.out.println("Digite 3 para exibir os contatos");
        System.out.println("Digite 4 para exibir os contatos de uma determindada letra");
        System.out.println("Digite 0 para sair do programa");
    }

    public static Contato novoContato() {
        Contato contato = new Contato();
        System.out.println("Digite o nome do contato");
        String nome = in.nextLine();
        contato.setNome(nome);

        System.out.println("Digite o telefone do contato");
        int telefone = Integer.parseInt(in.nextLine());
        contato.setTelefone(telefone);

        return contato;
    }

    public static void adicionarContato() {
        Contato contato = new Contato();
        contato = novoContato();
        listaTelefonica.adicionarContato(contato);
    }

    public static void removerContato() {
        Contato contatoDesejado = new Contato();
        System.out.println("Digite a letra do contato que voce desja remover");
        String input = in.nextLine().toUpperCase();
        char letra = input.charAt(0);
        exibirContatos(letra);
        System.out.println("Digite o id do contato que voce deseja remover");
        int id = Integer.parseInt(in.nextLine());
        contatoDesejado = listaTelefonica.buscarContatos(letra).get(id);
        listaTelefonica.removeContato(contatoDesejado);
    }

    public static void exibirContatos() {
        for (char i = 'A'; i < 'Z'; i += 1) {
            System.out.println(i);
            List<Contato> contatos = new LinkedList<Contato>();
            contatos = listaTelefonica.buscarContatos(i);
            if (contatos == null)
                break;
            for (int i2 = 0; i2 < contatos.size(); i2 += 1) {
                System.out.println(contatos.get(i2).toString());
            }
            System.out.println();
        }
    }

    public static void exibirContatos(char letra) {
        letra = Character.toUpperCase(letra);
        List<Contato> contatos = new LinkedList<Contato>();
        contatos = listaTelefonica.buscarContatos(letra);
        for (int i = 0; i < contatos.size(); i += 1) {
            System.out.println("ID: " + i + " " + contatos.get(i));
        }
    }

}
