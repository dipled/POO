package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Avaliacao;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class AvaliacaoDAO {
    private static AvaliacaoDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement selectDisciplina;

    private AvaliacaoDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection con = Conexao.getConnection();
        selectNewId = con.prepareStatement("select nextval ('id_avaliacao')");
        insert = con.prepareStatement("insert into avaliacao values (?,?,?,?,?,?)");
        select = con.prepareStatement("select * from avaliacao where id = ?");
        delete = con.prepareStatement("delete from avaliacao where id = ? ");
        update = con.prepareStatement("update avaliacao set nome = ?, peso = ?, data = ?, nota = ?, id_disciplina = ? where id = ?");
        selectDisciplina = con.prepareStatement("select * from avaliacao where id_disciplina = ?");
    }

    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id na tabela avaliacao");
        }
        return 0;
    }

    public static AvaliacaoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null) {
            instance = new AvaliacaoDAO();

        }
        return instance;
    }

    public void insere(Avaliacao avaliacao) throws InsertException, SelectException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, avaliacao.getNome());
            insert.setDouble(3, avaliacao.getPeso());
            insert.setString(4, avaliacao.getData());
            insert.setDouble(5,avaliacao.getNota());
            insert.setInt(6, avaliacao.getIdDisciplina());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir avaliacao");
        }
    }

    public Avaliacao select(int avaliacao) throws SelectException {
        try {
            select.setInt(1, avaliacao);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                Double peso = rs.getDouble(3);
                String data = rs.getString(4);
                Double nota = rs.getDouble(5);
                int idDisciplina = rs.getInt(6);
                return new Avaliacao(id, nome, peso,data,nota,idDisciplina);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar avaliacao");
        }
        return null;
    }

    public void delete(Avaliacao a) throws DeleteException {
        try {
            delete.setInt(1, a.getId());
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar avaliacao");
        }
    }

    public void update(Avaliacao a) throws UpdateException {
        try {
            update.setString(1, a.getNome());
            update.setDouble(2, a.getPeso());
            update.setString(3, a.getData());
            update.setDouble(4,a.getNota());
            update.setInt(5, a.getIdDisciplina());
            update.setInt(6, a.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar avaliacao");
        }
    }


    public List<Avaliacao> selectDisciplina(int disciplina) throws SelectException {
        List<Avaliacao> avaliacoes = new LinkedList<>();
        try {
            selectDisciplina.setInt(1, disciplina);
            ResultSet rs = selectDisciplina.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                Double peso = rs.getDouble(3);
                String data = rs.getString(4);
                Double nota = rs.getDouble(5);
                int idDisciplina = rs.getInt(6);
                avaliacoes.add(new Avaliacao(id, nome, peso,data,nota, idDisciplina));
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar avaliacao");
        }
        return avaliacoes;
    }
}
