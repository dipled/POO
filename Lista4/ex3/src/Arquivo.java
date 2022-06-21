package ex3;

public class Arquivo {
    private String nome;
    private String extensao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Arquivo(String nome) throws NomeInvalidoException {
        if ( nome.length() > 256 || nome.length() < 10) {
            NomeInvalidoException error = new NomeInvalidoException("Numero de caracteres invalidos");
            throw error;
        }
        for(int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == '\n' || nome.charAt(i) == '[' || nome.charAt(i) == ']' || nome.charAt(i) == '(' || nome.charAt(i) == ')'
                    || nome.charAt(i) == '\'' || nome.charAt(i) == '"'){
                NomeInvalidoException error = new NomeInvalidoException("Caracteres invalidos");
                throw error;
            }
        }
        this.nome = nome;
    }
}
