package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ContatoDAO {
    private static ContatoDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement selectAll;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement selectLetra;

    private ContatoDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection con = Conexao.getConnection();
        selectNewId = con.prepareStatement("select nextval ('id_contato')");
        insert = con.prepareStatement("insert into contato values (?,?,?)");
        select = con.prepareStatement("select * from contato where id = ?");
        selectAll = con.prepareStatement("select * from contato");
        delete = con.prepareStatement("delete from contato where id = ? ");
        update = con.prepareStatement("update contato set nome = ?, telefone = ? where id = ?");
        selectLetra = con.prepareStatement("select * from contato where substring(nome,1,1) = ?");
    }

    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id na tabela contato");
        }
        return 0;
    }

    public static ContatoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null) {
            instance = new ContatoDAO();

        }
        return instance;
    }

    public void insere(Contato contato) throws InsertException, SelectException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, contato.getNome());
            insert.setInt(3, contato.getTelefone());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir contato");
        }
    }

    public Contato select(int contato) throws SelectException {
        try {
            select.setInt(1, contato);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);
                return new Contato(id, nome, telefone);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar contato");
        }
        return null;
    }

    public void delete(Contato c) throws DeleteException {
        try {
            delete.setInt(1, c.getId());
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar contato");
        }
    }

    public void update(Contato c) throws UpdateException {
        try {
            update.setString(1, c.getNome());
            update.setInt(2, c.getTelefone());
            update.setInt(3, c.getId());
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar contato");
        }
    }

    public List<Contato> selectAll() throws SelectException {
        List<Contato> contatos = new LinkedList<>();
        try {
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);
                contatos.add(new Contato(id, nome, telefone));
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar contato");
        }
        return contatos;
    }

    public List<Contato> selectLetra(String letra) throws SelectException {
        List<Contato> contatos = new LinkedList<>();
        String s = letra;
        try {
            selectLetra.setString(1, s);
            ResultSet rs = selectLetra.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);
                contatos.add(new Contato(id, nome, telefone));
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar contato");
        }
        return contatos;
    }
}
