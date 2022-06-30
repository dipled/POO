package negocios;
import dados.*;
import java.sql.SQLException;

import exceptions.InsertException;
import exceptions.SelectException;

public class Teste {
    private static Sistema sistema;
    public static void main(String[] args) {
        try {
            sistema = new Sistema();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Aluno aluno = new Aluno();
        aluno.setCfp("1");
        aluno.setSenha("senha");
        aluno.setNome("Pedro");
        try {
            sistema.cadastraAluno(aluno);
        } catch (InsertException | SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            sistema.login("1", "senha");
        } catch (SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Semestre semestre = new Semestre();
        semestre.setNome("2022/1");
        try {
            sistema.cadastraSemestre(semestre);
        } catch (InsertException | SelectException e) {
            e.printStackTrace();
        }
        sistema.setIdSemestre(1);
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("CDI2");
        try {
            sistema.cadastraDisciplina(disciplina);
        } catch (InsertException | SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sistema.setIdDisciplina(1);
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setPeso(1);
        avaliacao.setNome("a1");
        avaliacao.setNota(10);
        try {
            sistema.cadastraAvalicao(avaliacao);
        } catch (InsertException | SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            System.out.println(sistema.calculaMediaDaDisciplina());
            System.out.println(sistema.calculaMediaDoExame());
            System.out.println(sistema.situacaoDoExame());
            sistema.alunoPdf();
        } catch (SelectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
