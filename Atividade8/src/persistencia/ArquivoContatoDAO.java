package persistencia;
import java.util.List;
import java.util.LinkedList;
import dados.Contato;
public class ArquivoContatoDAO{
    private final  String caminho = "src/files/contatos.csv";
    private static EditorTexto arquivo = new EditorTexto();
    
    private String toCSV(Contato c){
        String s = "";

        s+= c.getNome() + ",";
        s+= c.getTelefone();
        return s;
    }
    private Contato fromCSV(String s){
        String[] atributos = s.split(",");

        Contato contato = new Contato();
        contato.setNome(atributos[0]);
        contato.setTelefone(Integer.parseInt(atributos[1]));
        return contato;
    }
    private List<String> listaContatoToString(List<Contato> contatos){
        List<String> lista = new LinkedList<>();
        for(int i = 0; i < contatos.size(); i += 1){
            lista.add(toCSV(contatos.get(i)));
        }
        return lista;
    }
    private List<Contato>stringToListaContato(List<String> dados){
        List<Contato> contatos = new LinkedList<>();
        for(int i = 0; i < dados.size(); i += 1){
            contatos.add(fromCSV(dados.get(i)));
        }
        return contatos;
    }
    public List<Contato> leContatosArquivo(){
        return stringToListaContato(arquivo.leTexto(caminho));
    }
    public void salvaContatosArquivo(List<Contato> contatos){
        arquivo.gravaTexto(caminho, listaContatoToString(contatos));
    }
    public void salvaContatoArquivo(Contato contato){
        arquivo.gravaTexto(caminho, toCSV(contato));
    }
}