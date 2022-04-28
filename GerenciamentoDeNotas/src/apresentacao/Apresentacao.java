package apresentacao;

import dados.*;
import negocios.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private static Scanner in = new Scanner(System.in);
    private static int idAluno = -1;
    private static Sistema alunos = new Sistema();

    public static void main(String[] args) {
        int escolha;

        while (idAluno == -1) {
            login();
        }
        while (true) {
            menu();
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 1:
                    cadastraSemestre();
                    break;
                case 2:
                    removeSemestre();
                    break;
                case 3:
                    mostraSemestres();
                    break;

            }
        }

    }

    public static void menu() {
        System.out.print("Digite 1 para cadastrar um semestre\t");
        System.out.println("Digite 2 para remover um semestre");
        System.out.print("Digite 3 para mostrar os semestres\t");
        System.out.println("Digite 4 para cadastrar uma disciplina");
        System.out.print("Digite 5 para remover uma disciplina\t");
        System.out.println("Digite 6 para mostrar as disciplinas de um dado semestre");
        System.out.print("Digite 7 para cadastrar uma avaliacao\t");
        System.out.println("Digite 8 para remover uma avaliacao");
        System.out.print("Digite 9 para mostrar uma avaliacao de uma dada disciplina\t");
        System.out.println("Digite 10 para adicionar uma nota a uma avaliacao");
        System.out.print("Digite 11 para calcular a media de uma disciplina\t");
        System.out.println("Digite 12 para calcular a nota do Exame");
        System.out.print("Digite 0 para deslogar\t");
        System.out.println("Digite -1 para deletar sua conta");
    }

    public static void cadastraAluno() {
        Aluno aluno = new Aluno();

        System.out.println("Digite o seu nome");
        String nome = in.nextLine();
        aluno.setNome(nome);

        System.out.println("Digite sua idade");
        int idade = Integer.parseInt(in.nextLine());
        aluno.setIdade(idade);

        System.out.println("Digite o seu cpf");
        String cpf = in.nextLine();
        aluno.setCfp(cpf);

        System.out.println("Digite a sua senha");
        String senha = in.nextLine();
        aluno.setSenha(senha);

        alunos.cadastraAluno(aluno);
    }

    public static void removeAluno() {
        alunos.removeAluno(idAluno);
    }

    public static void cadastraSemestre() {
        if (idAluno != -1) {
            Semestre semestre = new Semestre();
            System.out.println("Digite o período do semestre(Ex: 2022/2)");
            String nome = in.nextLine();
            semestre.setNome(nome);
            alunos.cadastraSemestre(idAluno, semestre);

        }
    }

    public static void removeSemestre() {
        mostraSemestres();
        System.out.println("Digite o id do semestre desejado");
        int idSemestre = Integer.parseInt(in.nextLine());
        alunos.removeSemestre(idAluno, idSemestre);
    }

    public static void cadastraDisciplina() {
        Disciplina disciplina = new Disciplina();
        mostraSemestres();
        System.out.println("Digite o id do semestre desejado");
        int idSemestre = Integer.parseInt(in.nextLine());

        System.out.println("Digite o nome da disciplina");
        String nome = in.nextLine();
        disciplina.setNome(nome);

        alunos.cadastraDisciplina(idAluno, idSemestre, disciplina);
    }

    public static void removeDisciplina() {
        mostraSemestres();
        int idSemestre = selecionaSemestre();
        mostraDisciplinas(idSemestre);
        System.out.println("Digite o id da disciplina desejada");
        int idDisciplina = Integer.parseInt(in.nextLine());
        alunos.removeDisciplina(idAluno, idSemestre, idDisciplina);
    }

    public static int selecionaSemestre() {
        int idSemestre;
        mostraSemestres();
        System.out.println("Digite o id do semestre desejado");
        idSemestre = Integer.parseInt(in.nextLine());
        return idSemestre;
    }

    public static int selecionaDisciplina() {
        int idDisciplina;
        int idSemestre = selecionaSemestre();
        mostraDisciplinas(idSemestre);
        System.out.println("Digite o id da disciplina desejada");
        idDisciplina = Integer.parseInt(in.nextLine());
        return idDisciplina;
    }

    public static int selecionaAvaliacao() {
        int idAvaliacao;
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina();
        mostraAvaliacoes(idSemestre, idDisciplina);
        System.out.println("Digite o id da avaliacao desejada");
        idAvaliacao = Integer.parseInt(in.nextLine());
        return idAvaliacao;

    }

    public static void mostraSemestres() {
        List<Semestre> semestres = new LinkedList<Semestre>();
        semestres = alunos.buscarSemestres(idAluno);
        for (int i = 0; i < semestres.size(); i += 1) {
            System.out.println("ID " + i + " " + semestres.get(i).toString());
        }
    }

    public static void mostraDisciplinas(int idSemestre) {
        List<Disciplina> disciplinas = new LinkedList<Disciplina>();
        disciplinas = alunos.buscarDisciplinas(idAluno, idSemestre);
        for (int i = 0; i < disciplinas.size(); i += 1) {
            System.out.println("ID " + i + " " + disciplinas.get(i).toString());
        }
    }

    public static void mostraAvaliacoes(int idSemestre, int idDisciplina) {
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = alunos.buscarAvaliacoes(idAluno, idSemestre, idDisciplina);
        for (int i = 0; i < avaliacoes.size(); i += 1) {
            System.out.println("ID " + i + " " + avaliacoes.get(i).toString());
        }
    }

    public static void login() {
        int escolha;
        System.out.println("Digite 1 para loggar ou 2 para se cadastrar");
        escolha = Integer.parseInt(in.nextLine());
        if (escolha == 2) {
            cadastraAluno();
        } else {
            Aluno aluno = new Aluno();
            System.out.println("Digite o seu cpf");
            String cpf = in.nextLine();
            aluno.setCfp(cpf);

            System.out.println("Digite a sua senha");
            String senha = in.nextLine();
            aluno.setSenha(senha);
            idAluno = alunos.login(aluno);
            if (idAluno == -1)
                System.out.println("Erro ao tentar loggar");
        }
    }
}
