package persistencia;

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class EditorTexto {
    public void gravaTexto(String caminho, List<String> dados) {
        FileWriter arquivo;

        try {
            arquivo = new FileWriter(caminho);
            for (int i = 0; i < dados.size(); i += 1) {
                arquivo.write(dados.get(i) + "\n");

            }
            arquivo.close();
        } catch (Exception e) {
            System.err.println("Erro ao manipular o arquivo");
            System.exit(0);
        }
    }

    public void gravaTexto(String caminho, String linha) {

        FileWriter arquivo;
        try {
            arquivo = new FileWriter(caminho, true);
            arquivo.write(linha+"\n");
            arquivo.close();
        } catch (Exception e) {
            System.err.println("Erro ao manipular arquivo");
            System.exit(0);
        }

    }

    public List<String> leTexto(String caminho) {
        List<String> dados = new LinkedList<>();
        FileReader arquivo;
        BufferedReader lerArq;

        try {
            arquivo = new FileReader(caminho);
            lerArq = new BufferedReader(arquivo);
            String s = lerArq.readLine();
            while (s != null) {
                dados.add(s);
                s = lerArq.readLine();
            }
            arquivo.close();
        } catch (Exception e) {
            System.err.println("Erro ao manipular arquivo");
            System.exit(0);
        }
        return dados;
    }

}