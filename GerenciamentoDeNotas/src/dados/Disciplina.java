package dados;

public class Disciplina {
    private String nome;
    private int quantidadeDeAvaliacoes = 0;
    private float media;
    private Avaliacao[] avaliacoes = new Avaliacao[10];

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeAvaliacoes() {
        return this.quantidadeDeAvaliacoes;
    }

    public void setQuantidadeDeAvaliacoes(int quantidadeDeAvaliacoes) {
        this.quantidadeDeAvaliacoes = quantidadeDeAvaliacoes;
    }

    public float getMedia() {
        return this.media;
    }

    public void setMedia(float media) {
        this.media = media;
    }


    public Avaliacao[] getAvaliacoes() {
        return this.avaliacoes;
    }

    public void cadastraAvalicao(Avaliacao avaliacao){
        if(this.quantidadeDeAvaliacoes < 10 && avaliacao != null){
            this.avaliacoes[this.quantidadeDeAvaliacoes] = new Avaliacao();
            this.avaliacoes[this.quantidadeDeAvaliacoes] = avaliacao;
            this.quantidadeDeAvaliacoes += 1;
        }
    }

    public void removeAvaliacao(Avaliacao avaliacao){
        Avaliacao[] novoAvaliacoes = new Avaliacao[10];
        int perm = 0;
        for(int i = 0; i < this.quantidadeDeAvaliacoes; i += 1){
            int i2 = 0;
            if(this.avaliacoes[i].equals(avaliacao) == false){
                novoAvaliacoes[i2] = new Avaliacao();
                novoAvaliacoes[i2] = this.avaliacoes[i];
                i2 += 1;
            }
            else{
                perm = 1;
            }
                
        }
        if(perm == 1)
            this.quantidadeDeAvaliacoes -= 1;
    }
    
    public void adicionaNota(int idAvaliacao, float nota){
        avaliacoes[idAvaliacao].setNota(nota);
    }
    
}
