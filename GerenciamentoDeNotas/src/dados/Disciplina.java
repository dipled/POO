package dados;

import java.util.LinkedList;
import java.util.List;

public class Disciplina {
    private String nome;
    private float media;
    private List<Avaliacao> avaliacoes = new LinkedList<Avaliacao>();

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMedia() {
        return this.media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void cadastraAvalicao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public void removeAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.remove(avaliacao);
    }

    public void adicionaNota(int idAvaliacao, float nota) {
        this.avaliacoes.get(idAvaliacao).setNota(nota);
    }

}
