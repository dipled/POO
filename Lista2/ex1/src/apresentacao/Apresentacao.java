package apresentacao;
import java.util.Scanner;

import dados.*;
import negocios.*;

public class Apresentacao {
    private static Sistema sistema = new Sistema();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha = 0;
        while(true){
            System.out.println("Digite -1 para parar ou 1 para continuar");
            escolha = Integer.parseInt(in.nextLine());
            if(escolha == -1)   
                return;
            adicionaPessoa();
            mostra();
        }
    }

    public static void adicionaPessoa(){
        Pessoa pessoa = new Pessoa();
        
        System.out.println("Digite o nome da pessoa");
        pessoa.setNome(in.nextLine());

        System.out.println("Digite o cpf da pessoa");
        pessoa.setCpf(in.nextLine());

        System.out.println("Digite a cidade da pessoa");
        pessoa.setCidade(in.nextLine());

        System.out.println("Digite a idade da pessoa");
        pessoa.setIdade(Integer.parseInt(in.nextLine()));
        sistema.adicionaPessoa(pessoa);

        sistema.ordenaIntervalos();
    }

    public static void mostra(){
        for(int i = 0; i < 5; i += 1){
            intervalo(i);
            for(int i2 = 0; i2 < sistema.getPessoas().get(i).size(); i2 += 1){
                System.out.println(sistema.getPessoas().get(i).get(i2).toString());
            }
        }
    }
    public static void intervalo(int id){
        switch(id){
            case 0:
                System.out.println("1 até 12: ");
                break;
            case 1:
                System.out.println();
                System.out.println("13 até 18: ");
                break;
            case 2:
                System.out.println();
                System.out.println("19 até 25: ");
                break;
            case 3:
                System.out.println();
                System.out.println("26 até 59: ");
                break;
            case 4:
                System.out.println();
                System.out.println("60 ou mais: ");
                break;
        }
    }
}
