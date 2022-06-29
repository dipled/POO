package pkg;

public class Main {

    public static void main(String[] args) {

        SistemaArquivos sistema = new SistemaArquivos();
        try {
            Video video = new Video("(Mitadas Henry Bugalho)");
            video.setQual(Qualidade.Q720P);
            sistema.diretorios.get("Videos").add(video);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }//Esse bloco apresenta um nome inválido

        try {
            Video video1 = new Video("Sorrizo Ronaldo");
            video1.setQual(Qualidade.Q720P);
            sistema.diretorios.get("Videos").add(video1);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }

        try {
            Musica musica1 = new Musica("Lady Gaga - Bad Romance");
            musica1.setDuracao(294);
            sistema.diretorios.get("Downloads").add(musica1);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }

        try {

            Musica musica2 = new Musica("Yung Lixo - Tua mãe me ligou");
            musica2.setDuracao(177);
            sistema.diretorios.get("Musicas").add(musica2);

        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }

        try {
            Musica musica3 = new Musica("Joji - Slow Dancing in The Dark");
            musica3.setDuracao(300);
            sistema.diretorios.get("Downloads").add(musica3);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }

        try {
            Documento documento1 = new Documento("Tarefas para amanhã");
            documento1.setTexto("Arrumar a mesa");
            sistema.diretorios.get("Documentos").add(documento1);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }
        try {
            Documento documento2 = new Documento("Telefone da Tua mãe");
            documento2.setTexto("66 6666-66666");
            sistema.diretorios.get("Documentos").add(documento2);
        } catch (NomeInvalidoException e) {
            System.err.println(e.getMessage());
        }
        System.out.print(sistema.toString());
    }
}
