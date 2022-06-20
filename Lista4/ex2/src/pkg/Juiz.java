package pkg;

public class Juiz {
    private String nome;
    private Pilha<Processo> processos;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Pilha<Processo> getProcessos() {
        return this.processos;
    }

    public Juiz(int limite) {
        this.processos = new Pilha<>(limite);
    }

    public void cadastrarProcesso(Processo processo) throws PilhaCheiaException {
        try {
            this.processos.inserir(processo);
        } catch (PilhaCheiaException pc) {
            throw new PilhaCheiaException("Pilha do juiz "+this.nome+" está cheia");
            
        }
    }

}
