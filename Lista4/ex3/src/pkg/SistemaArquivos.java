package pkg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    Map<String, List<Arquivo>> diretorios = new HashMap<String, List<Arquivo>>();

    SistemaArquivos() {
        diretorios.put("Documentos", new LinkedList<>());
        diretorios.put("Downloads", new LinkedList<>());
        diretorios.put("Videos", new LinkedList<>());
        diretorios.put("Musicas", new LinkedList<>());
    }

    public String toString() {
        String string = "";
        string += "Downloads:";
        string += "\n";
        for (int i = 0; i < diretorios.get("Downloads").size(); i += 1) {
            string += diretorios.get("Downloads").get(i);
            string += "\n";
        }

        string += "Documentos:";
        string += "\n";
        for (int i = 0; i < diretorios.get("Documentos").size(); i += 1) {
            string += diretorios.get("Documentos").get(i);
            string += "\n";
        }
        string += "Videos:";
        string += "\n";
        for (int i = 0; i < diretorios.get("Videos").size(); i += 1) {
            string += diretorios.get("Videos").get(i);
            string += "\n";
        }
        string += "Musicas:";
        string += "\n";
        for (int i = 0; i < diretorios.get("Musicas").size(); i += 1) {
            string += diretorios.get("Musicas").get(i);
            string += "\n";
        }
        return string;
    }

    public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException {
        try {
            Musica m = new Musica(nome);
            m.setDuracao(duracao);
            diretorios.get(diretorio).add(m);
        } catch (NomeInvalidoException e) {
            throw e;
        }
    }

    public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException {
        try {
            Video v = new Video(nome);
            v.setQual(qualidade);
            diretorios.get(diretorio).add(v);
        } catch (NomeInvalidoException e) {
            throw e;
        }
    }

    public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException {
        try {
            Documento d = new Documento(nome);
            d.setTexto(texto);
            diretorios.get(diretorio).add(d);
        } catch (NomeInvalidoException e) {
            throw e;
        }
    }
}
