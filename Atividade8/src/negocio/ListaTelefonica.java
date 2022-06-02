package negocio;
import dados.Contato;
import persistencia.ContatoDAO;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
public class ListaTelefonica {


   private ContatoDAO contatoDAO = new ContatoDAO();

    public ListaTelefonica(){
    
    }
    
    public void adicionarContato(Contato contato){
        this.contatoDAO.insert(contato);
    }
    public void removeContato(Contato contato){
        this.contatoDAO.delete(contato);
    }
    public List<Contato> buscarContatos(char letra){
        Map <Character,List<Contato>> lista = new HashMap<>();
        lista = this.contatoDAO.getAll();
        List<Contato> contatos = new LinkedList<>();
        for(int i = 0; i < lista.get(letra).size(); i += 1){
            contatos.add(lista.get(letra).get(i));
        }
        return contatos;
    }
    public Map<Character,List<Contato>> listarContatos(){
        return this.contatoDAO.getAll();
    }
}
