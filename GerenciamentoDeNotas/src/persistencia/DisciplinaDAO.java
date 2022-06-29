package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Disciplina;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class DisciplinaDAO {
    private static DisciplinaDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement selectSemestre;

    private DisciplinaDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection con = Conexao.getConnection();
        selectNewId = con.prepareStatement("select nextval ('id_disciplina')");
        insert = con.prepareStatement("insert into disciplina values (?,?,?)");
        select = con.prepareStatement("select * from disciplina where id = ?");
        delete = con.prepareStatement("delete from disciplina where id = ?");
        update = con.prepareStatement("update disciplina set nome = ?, id_semestre = ?, where id = ?");
        selectSemestre = con.prepareStatement("select * from disciplina where id_semestre = ?");
    }

    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id na tabela disciplina");
        }
        return 0;
    }

    public static DisciplinaDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null) {
            instance = new DisciplinaDAO();

        }
        return instance;
    }

    public void insere(Disciplina disciplina) throws InsertException, SelectException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, disciplina.getNome());
            insert.setInt(3,disciplina.getIdSemestre());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir disciplina");
        }
    }

    public Disciplina select(int disciplina) throws SelectException {
        try {
            select.setInt(1, disciplina);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int idSemestre = rs.getInt(3);
                return new Disciplina(id, nome, idSemestre);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar disciplina");
        }
        return null;
    }

    public void delete(Disciplina d) throws DeleteException {
        try {
            delete.setInt(1, d.getId());
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar disciplina");
        }
    }

    public void update(Disciplina d) throws UpdateException {
        try {
            update.setString(1, d.getNome());
            update.setInt(2,d.getIdSemestre());
            update.setInt(3, d.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar disciplina");
        }
    }


    public List<Disciplina> selectSemestre(int disciplina) throws SelectException {
        List<Disciplina> disciplinas = new LinkedList<>();
        try {
            selectSemestre.setInt(1, disciplina);
            ResultSet rs = selectSemestre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int idSemestre = rs.getInt(3);
                disciplinas.add(new Disciplina(id, nome, idSemestre));
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar disciplina");
        }
        return disciplinas;
    }
}
