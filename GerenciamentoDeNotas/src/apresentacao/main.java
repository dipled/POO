package apresentacao;
import dados.*;
import negocios.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class main {
    private static Scanner in = new Scanner(System.in);
    private static int idAluno;
    private static Sistema alunos = new Sistema();
    public static void main(String[] args) {
        
    }

    public static void cadastraAluno(){
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
    public static void cadastraSemestre(){
        if(idAluno != -1){
            Semestre semestre = new Semestre();
            System.out.println("Digite o período do semestre(Ex: 2022/2)");
            String nome = in.nextLine();
            semestre.setNome(nome);
            alunos.cadastraSemestre(idAluno, semestre);

        }
    }
    public static void removeSemestre(){
        mostraSemestres();
        System.out.println("Digite o id do semestre que voce deseja remover");
        int idSemestre = Integer.parseInt(in.nextLine());
        alunos.removeSemestre(idAluno, idSemestre);
    }

    public static void mostraSemestres(){
        List<Semestre> semestres = new LinkedList<Semestre>();
        semestres = alunos.buscaSemestres(idAluno);
        for(int i = 0; i < semestres.size(); i += 1){
            System.out.println("ID " + i + " " + semestres.get(i));
        }
    }
    public static boolean login(){
        Aluno aluno = new Aluno();
        System.out.println("Digite o seu cpf");
        String cpf = in.nextLine();
        aluno.setCfp(cpf);

        System.out.println("Digite a sua senha");
        String senha = in.nextLine();
        aluno.setSenha(senha);
        idAluno = alunos.login(aluno);
        if(idAluno != -1){
            return true;
        }
        else{
            return false;
        }
    }
}
