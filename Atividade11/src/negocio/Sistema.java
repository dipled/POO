package negocio;
import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import persistencia.ContatoDAO;

import java.sql.SQLException;
import java.util.List;
public class Sistema {


   private ContatoDAO contatoDAO;

    public Sistema()throws ClassNotFoundException, SQLException, SelectException{
        contatoDAO = ContatoDAO.getInstance();
    }
    
    public void adicionarContato(Contato contato)throws SelectException, InsertException{
        this.contatoDAO.insere(contato);
    }
    public void removeContato(Contato contato)throws DeleteException{
        this.contatoDAO.delete(contato);
    }
    public List<Contato> buscarContatos(String letra)throws SelectException{
        
        return this.contatoDAO.selectLetra(letra);
    }
    public List<Contato> listarContatos()throws SelectException{
        return this.contatoDAO.selectAll();
    }
}
