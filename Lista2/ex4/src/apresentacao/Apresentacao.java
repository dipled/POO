package apresentacao;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dados.*;

public class Apresentacao {
    private static Turma turma = new Turma();
    private static List<Equipe<Aluno>> equipes = new LinkedList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "Digite -1 para sair do programa, 1 para cadastrar um aluno, 2 para dividir em equipes ou 3 para mostrar os alunos cadastrados");
            int escolha = Integer.parseInt(in.nextLine());
            if (escolha == -1)
                return;
            if (escolha == 1)
                adicionarAluno();
            if (escolha == 2) {
                equipes = turma.separarEmEquipes();
                if (equipes == null) {
                    System.out.println("Nenhuma equipe");
                } else {
                    for (int i = 0; i < equipes.size(); i += 1)
                        System.out.println("Equipe " + i + ": " + equipes.get(i).toString());

                }
            }
            if (escolha == 3) {
                mostraAlunos();
            }

        }
    }

    public static void mostraAlunos() {
        if(turma.getAlunos().size() == 0)
            System.out.println("Nenhum aluno cadastrado");
        for (int i = 0; i < turma.getAlunos().size(); i += 1) {
            System.out.println("ID " + i + " " + turma.getAlunos().get(i));
        }
    }

    public static void adicionarAluno() {
        Aluno aluno = new Aluno();
        System.out.println("Digite o nome do aluno");
        aluno.setNome(in.nextLine());
        System.out.println("Digite a idade do aluno");
        aluno.setIdade(Integer.parseInt(in.nextLine()));
        System.out.println("Digite as notas do aluno");
        aluno.setNota(Float.parseFloat(in.nextLine()));
        aluno.setNota(Float.parseFloat(in.nextLine()));
        aluno.setNota(Float.parseFloat(in.nextLine()));
        aluno.setNota(Float.parseFloat(in.nextLine()));
        aluno.setNota(Float.parseFloat(in.nextLine()));
        turma.adicionarAluno(aluno);
    }

}
