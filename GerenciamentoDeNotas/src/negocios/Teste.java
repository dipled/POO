package negocios;

import dados.Aluno;
import dados.Avaliacao;
import dados.Disciplina;
import dados.Semestre;

public class Teste {
    private static Sistema sistema = new Sistema();
    // A variável idAluno funciona como um identificador de qual usuário está logado
    // no momento (-1 representa que ninguem esta logado)
    private static int idAluno = -1;

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
        idAluno = sistema.login(temp);
        if (idAluno == -1)
            System.out.println("Usuario inválido");
        else
            System.out.println("Logado como " + aluno.getNome());

        // Cadastrando um semestre
        Semestre semestre = new Semestre();
        semestre.setNome("2022/1");
        sistema.cadastraSemestre(idAluno, semestre);

        // Cadastrando uma disciplina no semestre:
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Cálculo de sequentes para lógicas não-clássicas");
        disciplina.setProfessor("Ariel");
        sistema.cadastraDisciplina(idAluno, 0, disciplina);

        // Cadastrando algumas avaliacoes
        Avaliacao avaliacao1 = new Avaliacao();
        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao1.setNome("A1");
        avaliacao1.setData("22/02/22");
        avaliacao1.setPeso(2);
        avaliacao2.setNome("A2");
        avaliacao2.setData("29/05/22");
        avaliacao2.setPeso(3);
        sistema.cadastraAvalicao(idAluno, 0, 0, avaliacao1);
        sistema.cadastraAvalicao(idAluno, 0, 0, avaliacao2);

        // Atribuindo notas às avaliações
        sistema.adicionaNota(idAluno, 0, 0, 0, 9.5);
        sistema.adicionaNota(idAluno, 0, 0, 1, 6);

        // Calculando a média do aluno e concluindo se ele precisa ou nao de exame
        System.out.println("Média: " + sistema.calculaMediaDaDisciplina(idAluno, 0, 0));
        double mediaExame = sistema.calculaMediaDoExame(idAluno, 0, 0);
        if (mediaExame == -1)
            System.out.println("Aluno aprovado");
        else
            System.out.println("Aluno em situação de exame, média necessária: " + mediaExame);

    }

}
