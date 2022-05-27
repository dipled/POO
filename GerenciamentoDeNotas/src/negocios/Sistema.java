package negocios;

import dados.*;
import java.util.List;
import java.util.Objects;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Sistema {
    private List<Aluno> alunos = new LinkedList<Aluno>();
    // O idAluno = -1 indica que não há aluno logado no momento. Isso será útil para
    // definir qual menu será mostrado quando for implementada a interfae gráfica
    private int idAluno = -1;

    public Sistema() {
    }

    public Sistema(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public int getIdAluno() {
        return this.idAluno;
    }

    public void deslogar() {
        this.idAluno = -1;
    }

    public String login(Aluno aluno) {
        for (int i = 0; i < this.alunos.size(); i += 1) {
            if (this.alunos.get(i).login(aluno) == true) {
                this.idAluno = i;
                return "Logado como: " + this.alunos.get(this.idAluno).getNome();
            }
        }
        return "Usuário Inválido";
    }

    // Os métodos que recebem ids como parâmetro não verificam a validade do id.
    // Isso não será um problema, considerando que no programa final, não haverá
    // input do usuário através do teclado, ele apenas irá interagir com a interface
    // gŕafica, por isso não conseguirá "Quebrar" o programa escolhendo, por
    // exemplo, um id de semestre inválido.
    public void cadastraAluno(Aluno aluno) {

        this.alunos.add(aluno);

    }

    public void removeAluno() {
        this.alunos.remove(this.idAluno);
    }

    public void cadastraSemestre(Semestre semestre) {
        this.alunos.get(this.idAluno).getSemestres().add(semestre);

    }

    public void removeSemestre(int idSemestre) {
        this.alunos.get(this.idAluno).getSemestres().remove(idSemestre);

    }

    public void cadastraDisciplina(int idSemestre, Disciplina disciplina) {
        this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().add(disciplina);
    }

    public void removeDisciplina(int idSemestre, int idDisciplina) {
        this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().remove(idDisciplina);
    }

    public void cadastraAvalicao(int idSemestre, int idDisciplina, Avaliacao avaliacao) {
        this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes()
                .add(avaliacao);
    }

    public void removeAvaliacao(int idSemestre, int idDisciplina, int idAvaliacao) {
        this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes()
                .remove(idAvaliacao);
    }

    public void adicionaNota(int idSemestre, int idDisciplina, int idAvaliacao, double nota) {
        this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina).getAvaliacoes()
                .get(idAvaliacao).setNota(nota);
    }

    public List<Semestre> buscarSemestres() {
        return this.alunos.get(this.idAluno).getSemestres();
    }

    public List<Disciplina> buscarDisciplinas(int idSemestre) {
        return this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas();
    }

    public List<Avaliacao> buscarAvaliacoes(int idSemestre, int idDisciplina) {
        return this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina)
                .getAvaliacoes();
    }

    public double calculaMediaDaDisciplina(int idSemestre, int idDisciplina) {
        List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();
        avaliacoes = this.alunos.get(this.idAluno).getSemestres().get(idSemestre).getDisciplinas().get(idDisciplina)
                .getAvaliacoes();

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

    public double calculaMediaDoExame(int idSemestre, int idDisciplina) {
        double mediaFinal = this.calculaMediaDaDisciplina(idSemestre, idDisciplina);
        if (mediaFinal >= 7) {
            return -1;
        }
        if (mediaFinal < 1.7) {
            return -2;
        }
        double exame = -1.5 * mediaFinal + 12.5;
        return exame;

    }

    public String situacaoDoExame(int idSemestre, int idDisciplina) {
        double exame = this.calculaMediaDoExame(idSemestre, idDisciplina);
        if (exame == -2) {
            return "Aluno Reprovado";
        }
        if (exame == -1) {
            return "Aluno Aprovado";
        }
        return "Exame; Média necessária: " + exame;

    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sistema)) {
            return false;
        }
        Sistema sistema = (Sistema) o;
        return Objects.equals(alunos, sistema.alunos);
    }

    // O método alunoPdf() apresenta o resumo de todas as disciplinas de todos os
    // semestres cadastrados, como se fosse um relatório final do aluno.
    public void alunoPdf() {
        Aluno aluno = new Aluno();
        aluno = alunos.get(this.idAluno);
        List<Semestre> semestres = new LinkedList<>();
        semestres = aluno.getSemestres();
        try {
            String dest = "Notas" + aluno.getCpf() + ".pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);

            doc.add(new Paragraph("Nome do Aluno: " + aluno.getNome()));
            doc.add(new Paragraph("-\tCPF: " + aluno.getCpf()));
            doc.add(new Paragraph("-\tIdade: " + aluno.getIdade()));
            for (int i = 0; i < semestres.size(); i += 1) {
                doc.add(new Paragraph("Semestre: " + semestres.get(i).getNome()));
                for (int i2 = 0; i2 < semestres.get(i).getDisciplinas().size(); i2 += 1) {
                    doc.add(new Paragraph("-\tDisciplina: "
                            + semestres.get(i).getDisciplinas().get(i2).getNome()));
                    doc.add(new Paragraph("-\t\tMédia Final: " + this.calculaMediaDaDisciplina(i, i2)));
                    doc.add(new Paragraph("-\t\tSituação: " + this.situacaoDoExame(i, i2)));
                }

            }
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
