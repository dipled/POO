package negocios;

import dados.Aluno;
import dados.Avaliacao;
import dados.Disciplina;
import dados.Semestre;

public class Teste {

    private static Sistema sistema = new Sistema();

    public static void main(String[] args) {
        // Cadastro de um novo usuario:
        Aluno aluno = new Aluno();
        aluno.setNome("Josias Dutra");
        aluno.setCfp("908.075.789-67");
        aluno.setIdade(20);
        aluno.setSenha("senha");
        sistema.cadastraAluno(aluno);

        // Realizando o login
        Aluno temp = new Aluno();
        temp.setCfp("908.075.789-67");
        temp.setSenha("senha");
        System.out.println(sistema.login(temp));

        // Cadastrando um semestre
        Semestre semestre = new Semestre();
        semestre.setNome("2022/1");
        sistema.cadastraSemestre(semestre);

        // Cadastrando uma disciplina no semestre:
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Cálculo de sequentes para lógicas não-clássicas");
        disciplina.setProfessor("Ariel");
        sistema.cadastraDisciplina(0, disciplina);

        // Cadastrando algumas avaliacoes
        Avaliacao avaliacao1 = new Avaliacao();
        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao1.setNome("A1");
        avaliacao1.setData("22/02/22");
        avaliacao1.setPeso(2);
        avaliacao2.setNome("A2");
        avaliacao2.setData("29/05/22");
        avaliacao2.setPeso(3);
        sistema.cadastraAvalicao(0, 0, avaliacao1);
        sistema.cadastraAvalicao(0, 0, avaliacao2);

        // Atribuindo notas às avaliações
        sistema.adicionaNota(0, 0, 0, 9.5);
        sistema.adicionaNota(0, 0, 1, 6);

        // Calculando a média do aluno e concluindo se ele precisa ou nao de exame
        System.out.println("Média na disciplina " + sistema.buscarDisciplinas(0).get(0) + ": "
                + sistema.calculaMediaDaDisciplina(0, 0));
        System.out.println(sistema.situacaoDoExame(0, 0));
        sistema.alunoPdf();
        // Deslogando
        sistema.deslogar();

        System.out.println();
        System.out.println();
        // Cadastrando um novo aluno
        Aluno aluno2 = new Aluno();
        aluno2.setNome("Alfredo Douglas");
        aluno2.setCfp("040.755.482-62");
        aluno2.setIdade(19);
        aluno2.setSenha("batata");
        sistema.cadastraAluno(aluno2);

        // Realizando um login inválido
        temp.setCfp("080.330.728-10");
        temp.setSenha("senha");
        System.out.println(sistema.login(temp));
        System.out.println();
        System.out.println();
        // Realizando login de outro aluno
        Aluno temp2 = new Aluno();
        temp2.setCfp("040.755.482-62");
        temp2.setSenha("batata");
        System.out.println(sistema.login(temp2));

        // Cadastrando um semestre pro aluno agora logado
        Semestre semestre2 = new Semestre();
        semestre2.setNome("2022/1");
        sistema.cadastraSemestre(semestre2);

        // Cadastrando disciplina
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("Metodologia de pesquisa");
        disciplina2.setProfessor("Carla");
        sistema.cadastraDisciplina(0, disciplina2);

        // Cadastrando avaliacoes
        avaliacao1.setNome("A1");
        avaliacao1.setData("22/02/22");
        avaliacao1.setPeso(2);
        avaliacao2.setNome("A2");
        avaliacao2.setData("29/05/22");
        avaliacao2.setPeso(3);
        sistema.cadastraAvalicao(0, 0, avaliacao1);
        sistema.cadastraAvalicao(0, 0, avaliacao2);

        // Atribuindo notas às avaliações
        sistema.adicionaNota(0, 0, 0, 0.5);
        sistema.adicionaNota(0, 0, 1, 3);
        // Calculando a media e decidindo se o aluno está ou não de exame
        System.out.println("Média na disciplina " + sistema.buscarDisciplinas(0).get(0) + ": "
                + sistema.calculaMediaDaDisciplina(0, 0));

        System.out.println(sistema.situacaoDoExame(0, 0));

        sistema.alunoPdf();

    }

}
