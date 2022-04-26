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

    }

    public static Contato novoContato() {
        Contato contato = new Contato();
        System.out.println("Digite o nome do contato");
        String nome = in.nextLine();
        contato.setNome(nome);

        System.out.println("Digite ");
        int telefone = Integer.parseInt(in.nextLine());
        contato.setTelefone(telefone);

        return contato;
    }

    public void adicionarContato(Contato contato) {
        listaTelefonica.adicionarContato(contato);
    }

    public void removerContato() {
        Contato contatoDesejado = new Contato();
        System.out.println("Digite a letra do contato que voce desja remover");
        String input = in.nextLine().toUpperCase();
        char letra = input.charAt(0);
        exibirContatos(letra);
        System.out.println("Digite o nome do contato que voce deseja remover");
        int id = Integer.parseInt(in.nextLine());
        contatoDesejado = listaTelefonica.buscarContatos(letra).get(id);
        listaTelefonica.removeContato(contatoDesejado);

    }

    public void exibirContatos() {
        listaTelefonica.buscarContatos().forEach((letra, contatos) -> {
            System.out.println(letra);
            for (Contato c : contatos) {
                System.out.println(c.toString());
            }
        });
    }

    public void exibirContatos(char letra) {
        List<Contato> contatos = new LinkedList<Contato>();
        contatos = listaTelefonica.buscarContatos(letra);
        for (int i = 0; i < contatos.size(); i += 1) {
            System.out.println("ID: " + i + contatos.get(i));
        }
    }

}
