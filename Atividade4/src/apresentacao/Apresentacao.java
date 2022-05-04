package apresentacao;

import dados.*;
import negocio.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private static Zoologico zoologico = new Zoologico();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        while (true) {
            menu();
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 1:
                    cadastrarAnimal();
                    break;
                case 2:
                    cadastrarViveiro();
                    break;
                case 3:
                    botarAnimalViveiro();
                    break;
                case 4:
                    mostrarAnimaisNumViveiro();
                    break;
                case 5:
                    mostraViveiros();;
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void menu() {
        System.out.println("Digite 1 para cadastrar um animal");
        System.out.println("Digite 2 para cadastrar um viveiro");
        System.out.println("Digite 3 para botar um animal num viveiro");
        System.out.println("Digite 4 mostra animais num determinado viveiro");
        System.out.println("Digite 5 para mostrar os viveiros cadastrados");
        System.out.println("Digite 0 para sair do programa");
    }

    public static void cadastrarAnimal() {
        System.out.println("Digite o nome do animal");
        String nome = in.nextLine();
        System.out.println("Digite a cor do animal");
        String cor = in.nextLine();
        System.out.println("Digite a idade do animal");
        int idade = Integer.parseInt(in.nextLine());
        System.out.println("Digite a largura do animal");
        float largura = Float.parseFloat(in.nextLine());
        System.out.println("Digite o comprimento do animal");
        float comprimento = Float.parseFloat(in.nextLine());
        System.out.println("Digite a altura do animal");
        float altura  = Float.parseFloat(in.nextLine());
        System.out.println("Digite a especie do animal");
        String especie = in.nextLine();
        System.out.println("Digite 1 se o animal for um peixe ou 0 se não for");
        int escolha = Integer.parseInt(in.nextLine());
        if (escolha == 1) {
            Peixe animal = new Peixe(nome, cor, especie, idade, largura, comprimento, altura);
            System.out.println("Digite a temperatura ideal");
            animal.setTemperaturaIdeal(Float.parseFloat(in.nextLine()));
            zoologico.cadastrarAnimal(animal);
        } else {
            Animal animal = new Animal(nome, cor, especie, idade, largura, comprimento, altura);
            zoologico.cadastrarAnimal(animal);
        }
    }

    public static void cadastrarViveiro() {
        System.out.println("Digite o nome do viveiro");
        String nome = in.nextLine();
        System.out.println("Digite o comprimento do viveiro");
        Float comprimento = Float.parseFloat(in.nextLine());
        System.out.println("Digite a largura do viveiro");
        Float largura = Float.parseFloat(in.nextLine());
        System.out.println("Digite 1 se o viveiro for um aquário ou 0 se nao for");
        int escolha = Integer.parseInt(in.nextLine());
        if (escolha == 1) {
            Aquario aquario = new Aquario(nome, comprimento, largura);
            System.out.println("Digite a altura do viveiro");
            aquario.setAltura(Float.parseFloat(in.nextLine()));
            System.out.println("Digite a temperatura do viveiro");
            aquario.setTemperatura(Float.parseFloat(in.nextLine()));
            zoologico.cadastrarViveiro(aquario);
        } else {
            Viveiro viveiro = new Viveiro(nome, comprimento, largura);
            zoologico.cadastrarViveiro(viveiro);
        }
    }

    public static void botarAnimalViveiro() {
        if(zoologico.getAnimais().size() == 0){
            System.out.println("Nenhum animal cadastrado");
            return;
        }
        if(zoologico.getViveiros().size() == 0){
            System.out.println("Nenhum viveiro cadastrado");
            return;
        }
        mostraAnimais();
        System.out.println("Digite o ID do animal");
        int idAnimal = Integer.parseInt(in.nextLine());

        mostraViveiros();
        System.out.println("Digite o ID do viveiro");
        int idViveiro = Integer.parseInt(in.nextLine());

        if (zoologico.alocarAnimal(zoologico.getAnimais().get(idAnimal), zoologico.getViveiros().get(idViveiro))) {
            System.out.println("SUCESSO");
        } else {
            System.out.println("Algo deu errado");
        }

    }

    public static void mostraViveiros() {
        List<Viveiro> viveiros = new LinkedList<>();
        viveiros = zoologico.getViveiros();
        if(viveiros.size() == 0){
            System.out.println("Nenhum viveiro cadastrado");
            return;
        }
        for (int i = 0; i < viveiros.size(); i += 1) {
            System.out.println("ID " + i + " " + viveiros.get(i).toString());
        }
    }

    public static void mostraAnimais() {
        List<Animal> animais = new LinkedList<>();
        animais = zoologico.getAnimais();
        for (int i = 0; i < animais.size(); i += 1) {
            System.out.println("ID " + i + " " + animais.get(i).toString());
        }
    }

    public static void mostrarAnimaisNumViveiro() {
        if(zoologico.getViveiros().size() == 0){
            System.out.println("Nenhum viveiro cadastrado");
            return;
        }
        mostraViveiros();
        System.out.println("Digite o ID do viveiro");
        int idViveiro = Integer.parseInt(in.nextLine());
        Viveiro viveiro = new Viveiro();
        if(zoologico.getViveiros().size() <= idViveiro){
            System.out.println("Viveiro nao encontrado");
        }
        viveiro = zoologico.getViveiros().get(idViveiro);
        List<Animal> animais = new LinkedList<>();
        animais = viveiro.getAnimais();
        if (animais.size() == 0)
            System.out.println("Nenhum animal cadastrado");
        for (int i = 0; i < animais.size(); i += 1) {
            System.out.println("ID " + i + " " + animais.get(i).toString());
        }
    }
}
