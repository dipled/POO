package negocios;

import dados.*;
import java.util.List;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import persistencia.*;
import exceptions.*;

public class Sistema {
    private AlunoDAO alunoDAO;
    private SemestreDAO semestreDAO;
    private DisciplinaDAO disciplinaDAO;
    private AvaliacaoDAO avaliacaoDAO;
    // O idAluno = -1 indica que não há aluno logado no momento. Isso será útil para
    // definir qual menu será mostrado quando for implementada a interfae gráfica
    private int idAluno = -1;
    private int idSemestre = -1;
    private int idDisciplina = -1;
    private int idAvaliacao = -1;

    public Sistema() throws ClassNotFoundException, SQLException, SelectException {
        alunoDAO = AlunoDAO.getInstance();
        semestreDAO = SemestreDAO.getInstance();
        disciplinaDAO = DisciplinaDAO.getInstance();
        avaliacaoDAO = AvaliacaoDAO.getInstance();
    }


    public int getIdAluno() {
        return this.idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdSemestre() {
        return this.idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public int getIdDisciplina() {
        return this.idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String login(String cpfIn, String senhaIn) throws SelectException {
        Aluno aluno = new Aluno();
        aluno = alunoDAO.login(cpfIn, senhaIn);
        if (aluno != null) {
            this.idAluno = aluno.getId();
            return "Logado como " + aluno.getNome();
        } else {
            return "Erro ao fazer login";
        }
    }

    public void cadastraAluno(Aluno aluno) throws InsertException, SelectException, AlunoJaCadastradoException {
        alunoDAO.validaCpf(aluno.getCpf());
        alunoDAO.insere(aluno);

    }

    public void removeAluno() throws DeleteException, SelectException {
        Aluno aluno = new Aluno();
        aluno = alunoDAO.select(idAluno);
        alunoDAO.delete(aluno);
    }
    public void cadastraSemestre(Semestre semestre) throws InsertException, SelectException {
        semestre.setIdAluno(idAluno);
        semestreDAO.insere(semestre);
    }
    
    public void removeSemestre() throws SelectException, DeleteException {
        Semestre semestre = new Semestre();
        semestre = semestreDAO.select(idSemestre);
        semestreDAO.delete(semestre);
    }
    
    public void cadastraDisciplina(Disciplina disciplina) throws InsertException, SelectException {
        disciplina.setIdSemestre(idSemestre);
       disciplinaDAO.insere(disciplina);
    }
    
    public void removeDisciplina() throws SelectException, DeleteException {
        Disciplina disciplina = new Disciplina();
        disciplina = disciplinaDAO.select(idDisciplina);
        disciplinaDAO.delete(disciplina);
    }
    public void cadastraAvalicao(Avaliacao avaliacao) throws InsertException, SelectException {
        avaliacao.setIdDisciplina(idDisciplina);
        avaliacaoDAO.insere(avaliacao);
    }
    
    public void removeAvaliacao() throws SelectException, DeleteException {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao = avaliacaoDAO.select(idAvaliacao);
        avaliacaoDAO.delete(avaliacao);
    }
    
    public void adicionaNota(double nota) throws SelectException, UpdateException {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao = avaliacaoDAO.select(idAvaliacao);
        avaliacao.setNota(nota);
        avaliacaoDAO.update(avaliacao);
    }

    public void editaAluno(Aluno a) throws UpdateException{
        alunoDAO.update(a);
    }

    public void editaSemestre(Semestre s) throws UpdateException{
        semestreDAO.update(s);
    }
    public void editaDisciplina(Disciplina d) throws UpdateException{
        disciplinaDAO.update(d);
    }
    public void editaAvaliacao(Avaliacao a) throws UpdateException{
        avaliacaoDAO.update(a);
    }
    
    public List<Semestre> buscarSemestres() throws SelectException {
        return semestreDAO.selectAluno(idAluno);
    }
    
    public List<Disciplina> buscarDisciplinas() throws SelectException {
        return disciplinaDAO.selectSemestre(idSemestre);
    }
    
    public List<Avaliacao> buscarAvaliacoes() throws SelectException {
        return avaliacaoDAO.selectDisciplina(idDisciplina);
    }
    public double calculaMediaDaDisciplina() throws SelectException {
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = avaliacaoDAO.selectDisciplina(idDisciplina);

        double soma = 0;
        double pesoTotal = 0;
        for (int i = 0; i < avaliacoes.size(); i += 1) {
            // Verifica se a avaliação tem nota ou não e só a inclui no cálculo se tiver
            if (avaliacoes.get(i).getNota() != -1) {
                soma += (avaliacoes.get(i).getNota()) * avaliacoes.get(i).getPeso();
                pesoTotal += avaliacoes.get(i).getPeso();
            }
        }
        return soma / pesoTotal;
    }
    public double calculaMediaDaDisciplina(int idDisciplina) throws SelectException {
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = avaliacaoDAO.selectDisciplina(idDisciplina);

        double soma = 0;
        double pesoTotal = 0;
        for (int i = 0; i < avaliacoes.size(); i += 1) {
            // Verifica se a avaliação tem nota ou não e só a inclui no cálculo se tiver
            if (avaliacoes.get(i).getNota() != -1) {
                soma += (avaliacoes.get(i).getNota()) * avaliacoes.get(i).getPeso();
                pesoTotal += avaliacoes.get(i).getPeso();
            }
        }
        return soma / pesoTotal;
    }
    public double calculaMediaDoExame() throws SelectException {
        double mediaFinal = this.calculaMediaDaDisciplina(idDisciplina);
        if (mediaFinal >= 7) {
            return -1;
        }
        if (mediaFinal < 1.7) {
            return -2;
        }
        double exame = -1.5 * mediaFinal + 12.5;
        return exame;

    }
    
    public double calculaMediaDoExame(int idDisciplina) throws SelectException {
        double mediaFinal = this.calculaMediaDaDisciplina(idDisciplina);
        if (mediaFinal >= 7) {
            return -1;
        }
        if (mediaFinal < 1.7) {
            return -2;
        }
        double exame = -1.5 * mediaFinal + 12.5;
        return exame;

    }
    public String situacaoDoExame() throws SelectException {
        double exame = this.calculaMediaDoExame(idDisciplina);
        if (exame == -2) {
            return "Aluno Reprovado";
        }
        if (exame == -1) {
            return "Aluno Aprovado";
        }
        return "Exame; Média necessária: " + exame;
        
    }
    
    public String situacaoDoExame(int idDisciplina) throws SelectException {
        double exame = this.calculaMediaDoExame(idDisciplina);
        if (exame == -2) {
            return "Aluno Reprovado";
        }
        if (exame == -1) {
            return "Aluno Aprovado";
        }
        return "Exame; Média necessária: " + exame;
        
    }
    
    // O método alunoPdf() apresenta o resumo de todas as disciplinas de todos os
    // semestres cadastrados, como se fosse um relatório final do aluno.
    public void alunoPdf() throws SelectException {
        Aluno aluno = new Aluno();
        aluno = alunoDAO.select(idAluno);
        List<Semestre> semestres = new LinkedList<>();
        semestres = semestreDAO.selectAluno(idAluno);
        try {
            String dest = "Notas" + aluno.getCpf() + ".pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);
            
            doc.add(new Paragraph("Nome do Aluno: " + aluno.getNome()));
            doc.add(new Paragraph("-\tCPF: " + aluno.getCpf()));
            doc.add(new Paragraph("-\tIdade: " + aluno.getIdade()));
            doc.add(new Paragraph("-\tCurso: " + aluno.getCurso()));
            for (int i = 0; i < semestres.size(); i += 1) {
                doc.add(new Paragraph("Semestre: " + semestres.get(i).getNome()));
                List<Disciplina> disciplinas = new LinkedList<>();
                disciplinas = disciplinaDAO.selectSemestre(semestres.get(i).getId());
                for (int i2 = 0; i2 < disciplinas.size(); i2 += 1) {
                    doc.add(new Paragraph("-\tDisciplina: "
                            + disciplinas.get(i2).getNome()));
                            doc.add(new Paragraph("-\t\tMédia Final: " + this.calculaMediaDaDisciplina(disciplinas.get(i2).getId())));
                            doc.add(new Paragraph("-\t\tSituação: " + this.situacaoDoExame(disciplinas.get(i2).getId())));
                        }
            }
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
