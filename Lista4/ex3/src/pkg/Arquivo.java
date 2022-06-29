package pkg;

public class Arquivo {
    private String extensao;
    private String nome;

    public String getExtensao() {
        return this.extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arquivo(String nome) throws NomeInvalidoException {
        if (nome.length() <= 256 && nome.length() >= 10 && !nome.contains("\n") && !nome.contains("(")
                && !nome.contains(")")
                && !nome.contains("'") && !nome.contains("{") && !nome.contains("}") && !nome.contains("\34"))
            this.nome = nome;
        else {
            throw new NomeInvalidoException("Nome inválido");
        }
    }

}
