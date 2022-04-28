package negocio;
import dados.Contato;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
public class ListaTelefonica {


    private Map<Character, List<Contato>> contatos = new HashMap<Character,List<Contato>>();

    public ListaTelefonica(){
        for(char i = 'A'; i<'Z'; i += 1){
            List <Contato> listaContatos = new LinkedList<Contato>();
            this.contatos.put(i, listaContatos);
        }
    }
    
    public void adicionarContato(Contato contato){
        String nome = contato.getNome().toUpperCase();
        this.contatos.get(nome.charAt(0)).add(contato);
    }
    public void removeContato(Contato contato){
        String nome = contato.getNome().toUpperCase();
        this.contatos.get(nome.charAt(0)).remove(contato);
    }
    public List<Contato> buscarContatos(char letra){
        return this.contatos.get(letra);
    }
    public Map<Character,List<Contato>> buscarContatos(){
        return this.contatos;
    }
}
