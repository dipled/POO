package ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    private List<Arquivo> arquivos = new ArrayList<>();
    private Map<String, List<Arquivo>> diretorios = new HashMap<>();

    public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException {
        if (diretorios.containsKey(diretorio)) {
            Documento doc = new Documento();
            doc.setNome(nome);
            doc.setTexto(texto);
            diretorios.get(diretorio).add(doc);
        } else {
            List<Arquivo> arq = new ArrayList<>();
            Documento doc = new Documento();
            doc.setNome(nome);
            doc.setTexto(texto);
            arq.add(doc);
            diretorios.put(diretorio, arq);
        }
    }

    public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException {
        if (diretorios.containsKey(diretorio)) {
            Musica mus = new Musica();
            mus.setNome(nome);
            mus.setDuracao(duracao);
            diretorios.get(diretorio).add(mus);
        } else {
            List<Arquivo> arq = new ArrayList<>();
            Musica mus = new Musica();
            mus.setNome(nome);
            mus.setDuracao(duracao);
            arq.add(mus);
            diretorios.put(diretorio, arq);
        }
    }

    public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException {
        if (diretorios.containsKey(diretorio)) {
            Video vid = new Video();
            vid.setNome(nome);
            vid.setQualidade(qualidade);
            diretorios.get(diretorio).add(vid);
        } else {
            List<Arquivo> arq = new ArrayList<>();
            Video vid = new Video();
            vid.setNome(nome);
            vid.setQualidade(qualidade);
            arq.add(vid);
            diretorios.put(diretorio, arq);
        }
    }
}
