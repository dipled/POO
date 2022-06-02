package persistencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dados.Contato;

public class ContatoDAO {
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();

    public void insert(Contato contato) {
        arquivoContatoDAO.salvaContatoArquivo(contato);
    }

    public void delete(Contato contato) {
        List<Contato> contatos = arquivoContatoDAO.leContatosArquivo();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatosArquivo(contatos);
    }

    public Map<Character, List<Contato>> getAll() {
        List<Contato> contatos = arquivoContatoDAO.leContatosArquivo();
        Map<Character, List<Contato>> lista = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i += 1) {
            List<Contato> aux = new LinkedList<>();
            lista.put(i, aux);
        }
        for (int i = 0; i < contatos.size(); i += 1) {
            lista.get((contatos.get(i).getNome().toUpperCase().charAt(0))).add(contatos.get(i));
        }
        return lista;
    }
}
