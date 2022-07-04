package negocios;
import dados.*;
import java.sql.SQLException;

import exceptions.AlunoJaCadastradoException;
import exceptions.InsertException;
import exceptions.SelectException;

public class Teste {
    private static Sistema sistema;
    public static void main(String[] args) {
        try {
            sistema = new Sistema();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            e.printStackTrace();
        }
        Aluno aluno = new Aluno();
        aluno.setCfp("1");
        aluno.setSenha("senha");
        aluno.setNome("Pedro");
        aluno.setIdade(19);
        aluno.setCurso("BCC");
        Aluno aluno2 = new Aluno();
        aluno2.setCfp("2");
        aluno2.setSenha("senha");
        aluno2.setNome("Karla");
        aluno2.setIdade(60);
        aluno2.setCurso("TADS");
        try {
            sistema.cadastraAluno(aluno);
            sistema.cadastraAluno(aluno2);
        } catch (InsertException | SelectException | AlunoJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            sistema.login("1", "senha");
        } catch (SelectException e) {
            e.printStackTrace();
        }
        Semestre semestre = new Semestre();
        semestre.setNome("2022/1");
        Semestre semestre2 = new Semestre();
        semestre2.setNome("2022/2");
        Semestre semestre3 = new Semestre();
        semestre3.setNome("2023/1");
        try {
            sistema.cadastraSemestre(semestre);
        } catch (InsertException | SelectException e) {
            e.printStackTrace();
        }
        try {
            sistema.setIdSemestre(sistema.buscarSemestres().get(0).getId());
        } catch (SelectException e1) {
            e1.printStackTrace();
        }
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("CDI2");
        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNome("ALI");
        Disciplina disciplina3 = new Disciplina();
        disciplina3.setNome("EDA");
        try {
            sistema.cadastraDisciplina(disciplina);
        } catch (InsertException | SelectException e) {
            e.printStackTrace();
        }
        try {
            sistema.setIdDisciplina(sistema.buscarDisciplinas().get(0).getId());
        } catch (SelectException e1) {
            e1.printStackTrace();
        }
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setPeso(1);
        avaliacao.setNome("a1");
        avaliacao.setNota(10);
        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao2.setNome("a2");
        avaliacao2.setPeso(2);
        avaliacao2.setNota(6);
        try {
            sistema.cadastraAvalicao(avaliacao);
            sistema.cadastraAvalicao(avaliacao2);
        } catch (InsertException | SelectException e) {
            e.printStackTrace();
        }
        try {
            sistema.alunoPdf();
        } catch (SelectException e) {
            e.printStackTrace();
        }
        //Deslogar
        sistema.setIdAluno(-1);
        try{
            sistema.login("2", "senha");
            sistema.cadastraSemestre(semestre2);
            sistema.cadastraSemestre(semestre3);
            sistema.setIdSemestre(sistema.buscarSemestres().get(0).getId());
            sistema.cadastraDisciplina(disciplina2);
            sistema.cadastraDisciplina(disciplina3);
            sistema.setIdDisciplina(sistema.buscarDisciplinas().get(0).getId());
            Avaliacao avaliacao3 = new Avaliacao();
            avaliacao3.setNome("a1E");
            avaliacao3.setPeso(1);
            avaliacao3.setNota(5);
            sistema.cadastraAvalicao(avaliacao3);
            sistema.setIdDisciplina(sistema.buscarDisciplinas().get(1).getId());
            Avaliacao avaliacao4 = new Avaliacao();
            avaliacao4.setNome("a1C");
            avaliacao4.setPeso(1);
            avaliacao4.setNota(4);
            sistema.cadastraAvalicao(avaliacao4);
            sistema.setIdSemestre(sistema.buscarSemestres().get(1).getId());
            Disciplina disciplina4 = new Disciplina();
            disciplina4.setNome("Compiladores");
            sistema.cadastraDisciplina(disciplina4);
            sistema.setIdDisciplina(sistema.buscarDisciplinas().get(0).getId());
            Avaliacao avaliacao5 = new Avaliacao();
            avaliacao5.setNome("a1 Compiladores");
            avaliacao5.setPeso(2);
            avaliacao5.setNota(8);
            Avaliacao avaliacao6 = new Avaliacao();
            avaliacao6.setNome("a2 Compilaodres");
            avaliacao6.setPeso(3);
            avaliacao6.setNota(5);
            sistema.cadastraAvalicao(avaliacao5);
            sistema.cadastraAvalicao(avaliacao6);
            sistema.alunoPdf();

        }catch(InsertException | SelectException | ClassCastException e){
            e.printStackTrace();
        }
        Aluno teste = new Aluno();
        teste.setCfp("1");
        try {
            sistema.cadastraAluno(teste);
        } catch (InsertException | SelectException | AlunoJaCadastradoException e) {
            System.err.println(e.getMessage());
        }
    }
}
