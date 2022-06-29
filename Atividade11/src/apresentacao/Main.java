package apresentacao;

import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import negocio.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Sistema listaTelefonica;

    public static void main(String[] args) {
        try {
            listaTelefonica = new Sistema();
        } catch (SelectException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (SQLException e) {
            System.err.println(e);
        }
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
                    exibirContatos(input);
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
        try {
            listaTelefonica.adicionarContato(contato);
        } catch (SelectException | InsertException e) {
            System.err.println(e);
        }
    }

    public static void removerContato() {
        Contato contatoDesejado = new Contato();
        System.out.println("Digite a letra do contato que voce desja remover");
        String letra = in.nextLine();
        exibirContatos(letra);
        System.out.println("Digite o id do contato que voce deseja remover");
        int id = Integer.parseInt(in.nextLine());
        try {
            contatoDesejado = listaTelefonica.buscarContatos(letra).get(id);
            listaTelefonica.removeContato(contatoDesejado);
        } catch (SelectException | DeleteException e) {
            System.err.println(e);
        }
    }

    public static void exibirContatos() {
        try {
            for (char i = 'A'; i < 'Z'; i += 1) {
                String in = new String();
                in += i;
                System.out.println(i);
                List<Contato> contatos = new LinkedList<Contato>();
                contatos = listaTelefonica.buscarContatos(in);
                if (contatos == null)
                    break;
                for (int i2 = 0; i2 < contatos.size(); i2 += 1) {
                    System.out.println(contatos.get(i2).toString());
                }
                System.out.println();
            }
        } catch (SelectException e) {
            System.err.println(e);
        }
    }

    public static void exibirContatos(String letra) {
        List<Contato> contatos = new LinkedList<Contato>();
        try {
            contatos = listaTelefonica.buscarContatos(letra);
            for (int i = 0; i < contatos.size(); i += 1) {
                System.out.println("ID: " + i + " " + contatos.get(i));
            }
        } catch (SelectException e) {
            System.err.println(e);
        }
    }

}
