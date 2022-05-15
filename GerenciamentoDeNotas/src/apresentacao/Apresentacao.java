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
        String escolha;

        while (idAluno == -1) {
            if (login() == -1)
                return;
        }
        System.out.println(
                "\t\t\t--------------Logado como: " + alunos.getAlunos().get(idAluno).getNome() + "--------------");
        System.out.println();
        System.out.println();
        while (true) {
            System.out.println("Digite 1 para continuar ou 0 para sair do programa");
            escolha = (in.nextLine());
            if (escolha.equals("0"))
                return;
            menu();
            escolha = in.nextLine();
            switch (escolha) {
                case "1":
                    cadastraSemestre();
                    break;
                case "2":
                    removeSemestre();
                    break;
                case "3":
                    mostraSemestres();
                    break;
                case "4":
                    cadastraDisciplina();
                    break;
                case "5":
                    removeDisciplina();
                    break;
                case "6":
                    int idSemestreCase6 = selecionaSemestre();
                    mostraDisciplinas(idSemestreCase6);
                    break;
                case "7":
                    cadastraAvaliacao();
                    break;
                case "8":
                    removeAvaliacao();
                    break;
                case "9":
                    int idSemestreCase9 = selecionaSemestre();
                    int idDisciplinaCase9 = selecionaDisciplina(idSemestreCase9);
                    mostraAvaliacoes(idSemestreCase9, idDisciplinaCase9);
                    break;
                case "10":
                    adicionaNota();
                    ;
                    break;
                case "11":
                    calculaMediaDaDisciplina();
                    break;
                case "12":
                    calculaMediaDoExame();
                    break;
                case "-1":
                    deletaConta();
                    // Removi o break aqui para executar o case 0 sempre apos o case -1
                case "0":
                    idAluno = -1;
                    while (idAluno == -1)
                        if (login() == -1)
                            return;
                    break;

            }
        }
    }

    public static void limpaConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        limpaConsole();
        System.out.print("Digite 1 para cadastrar um semestre\t\t\t");
        System.out.println("Digite 7 para cadastrar uma avaliacao");
        System.out.print("Digite 2 para remover um semestre\t\t\t");
        System.out.println("Digite 8 para remover uma avaliacao");
        System.out.print("Digite 3 para mostrar os semestres\t\t\t");
        System.out.println("Digite 9 para mostrar as avaliacoes de uma disciplina");
        System.out.print("Digite 4 para cadastrar uma disciplina\t\t\t");
        System.out.println("Digite 10 para adicionar uma nota a uma avaliacao");
        System.out.print("Digite 5 para remover uma disciplina\t\t\t");
        System.out.println("Digite 11 para calcular a media de uma disciplina");
        System.out.print("Digite 6 para mostrar as disciplinas de um semestre\t");
        System.out.println("Digite 12 para calcular a nota do Exame");
        System.out.print("Digite 0 para deslogar\t\t\t\t\t");
        System.out.println("Digite -1 para deletar sua conta");
    }

    public static void cadastraAluno() {
        limpaConsole();
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
        limpaConsole();
        alunos.removeAluno(idAluno);
    }

    public static void cadastraSemestre() {
        limpaConsole();
        if (idAluno != -1) {
            Semestre semestre = new Semestre();
            System.out.println("Digite o período do semestre(Ex: 2022/2)");
            String nome = in.nextLine();
            semestre.setNome(nome);
            alunos.cadastraSemestre(idAluno, semestre);

        }
    }

    public static void removeSemestre() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        alunos.removeSemestre(idAluno, idSemestre);
    }

    public static void cadastraDisciplina() {
        limpaConsole();
        Disciplina disciplina = new Disciplina();
        int idSemestre = selecionaSemestre();

        System.out.println("Digite o nome da disciplina");
        String nome = in.nextLine();
        disciplina.setNome(nome);

        alunos.cadastraDisciplina(idAluno, idSemestre, disciplina);
    }

    public static void removeDisciplina() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        alunos.removeDisciplina(idAluno, idSemestre, idDisciplina);
    }

    public static void cadastraAvaliacao() {
        limpaConsole();
        Avaliacao avaliacao = new Avaliacao();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        System.out.println("Digite o nome da avaliação");
        avaliacao.setNome(in.nextLine());
        System.out.println("Digite o peso da avaliação");
        avaliacao.setPeso(Double.parseDouble(in.nextLine()));
        System.out.println("Digite a data da avaliação");
        avaliacao.setData(in.nextLine());
        alunos.cadastraAvalicao(idAluno, idSemestre, idDisciplina, avaliacao);
    }

    public static void removeAvaliacao() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        int idAvaliacao = selecionaAvaliacao(idSemestre, idDisciplina);
        alunos.removeAvaliacao(idAluno, idSemestre, idDisciplina, idAvaliacao);
    }

    public static int selecionaSemestre() {
        limpaConsole();
        int idSemestre;
        mostraSemestres();
        System.out.println("Digite o id do semestre desejado");
        idSemestre = Integer.parseInt(in.nextLine());
        return idSemestre;
    }

    public static int selecionaDisciplina(int idSemestre) {
        limpaConsole();
        int idDisciplina;
        mostraDisciplinas(idSemestre);
        System.out.println("Digite o id da disciplina desejada");
        idDisciplina = Integer.parseInt(in.nextLine());
        return idDisciplina;
    }

    public static int selecionaAvaliacao(int idSemestre, int idDisciplina) {
        limpaConsole();
        int idAvaliacao;
        mostraAvaliacoes(idSemestre, idDisciplina);
        System.out.println("Digite o id da avaliacao desejada");
        idAvaliacao = Integer.parseInt(in.nextLine());
        return idAvaliacao;

    }

    public static void mostraSemestres() {
        limpaConsole();
        List<Semestre> semestres = new LinkedList<Semestre>();
        semestres = alunos.buscarSemestres(idAluno);
        for (int i = 0; i < semestres.size(); i += 1) {
            System.out.println("ID " + i + " " + semestres.get(i).toString());
        }
    }

    public static void mostraDisciplinas(int idSemestre) {
        limpaConsole();
        List<Disciplina> disciplinas = new LinkedList<Disciplina>();
        disciplinas = alunos.buscarDisciplinas(idAluno, idSemestre);
        for (int i = 0; i < disciplinas.size(); i += 1) {
            System.out.println("ID " + i + " " + disciplinas.get(i).toString());
        }
    }

    public static void mostraAvaliacoes(int idSemestre, int idDisciplina) {
        limpaConsole();
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = alunos.buscarAvaliacoes(idAluno, idSemestre, idDisciplina);
        for (int i = 0; i < avaliacoes.size(); i += 1) {
            System.out.println("ID " + i + " " + avaliacoes.get(i).toString());
        }
    }

    public static void adicionaNota() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        int idAvaliacao = selecionaAvaliacao(idSemestre, idDisciplina);
        System.out.println("Digite a nota da avaliação");
        alunos.adicionaNota(idAluno, idSemestre, idDisciplina, idAvaliacao, Double.parseDouble(in.nextLine()));

    }

    public static void calculaMediaDaDisciplina() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        double nota = alunos.calculaMediaDaDisciplina(idAluno, idSemestre, idDisciplina);
        System.out.println("Nota da disciplina: " + nota);
    }

    public static void calculaMediaDoExame() {
        limpaConsole();
        int idSemestre = selecionaSemestre();
        int idDisciplina = selecionaDisciplina(idSemestre);
        double nota = alunos.calculaMediaDoExame(idAluno, idSemestre, idDisciplina);
        if (nota == -1) {
            System.out.println("Exame não é necessário");
        } else if (nota == -2) {
            System.out.println("Aluno já rodou");
        } else {
            System.out.println(nota);
        }
    }

    public static void deletaConta() {
        limpaConsole();
        alunos.removeAluno(idAluno);
    }

    public static int login() {
        limpaConsole();
        int escolha;
        System.out.println("Digite:\n 1 para loggar\n 2 para se cadastrar\n 0 para sair do programa");
        escolha = Integer.parseInt(in.nextLine());
        switch (escolha) {
            case 1:
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
                return 0;
            case 2:
                cadastraAluno();
                return 0;
            case 0:
                return -1;
            default:
                System.out.println("Escolha invalida");
                return 0;
        }
    }
}
