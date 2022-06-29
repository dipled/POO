package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Semestre;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class SemestreDAO {
    private static SemestreDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement selectAluno;

    private SemestreDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection con = Conexao.getConnection();
        selectNewId = con.prepareStatement("select nextval ('id_semestre')");
        insert = con.prepareStatement("insert into semestre values (?,?,?)");
        select = con.prepareStatement("select * from semestre where id = ?");
        delete = con.prepareStatement("delete from semestre where id = ?");
        update = con.prepareStatement("update semestre set nome = ?, id_aluno = ?, where id = ?");
        selectAluno = con.prepareStatement("select * from semestre where id_aluno = ?");
    }

    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id na tabela semestre");
        }
        return 0;
    }

    public static SemestreDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null) {
            instance = new SemestreDAO();

        }
        return instance;
    }

    public void insere(Semestre semestre) throws InsertException, SelectException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, semestre.getNome());
            insert.setInt(3,semestre.getIdAluno());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir semestre");
        }
    }

    public Semestre select(int semestre) throws SelectException {
        try {
            select.setInt(1, semestre);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int idAluno = rs.getInt(3);
                return new Semestre(id, nome, idAluno);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar semestre");
        }
        return null;
    }

    public void delete(Semestre s) throws DeleteException {
        try {
            delete.setInt(1, s.getId());
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar semestre");
        }
    }

    public void update(Semestre s) throws UpdateException {
        try {
            update.setString(1, s.getNome());
            update.setInt(2,s.getIdAluno());
            update.setInt(3, s.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar semestre");
        }
    }


    public List<Semestre> selectAluno(int semestre) throws SelectException {
        List<Semestre> semestres = new LinkedList<>();
        try {
            selectAluno.setInt(1, semestre);
            ResultSet rs = selectAluno.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int idAluno = rs.getInt(3);
                semestres.add(new Semestre(id, nome, idAluno));
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar semestre");
        }
        return semestres;
    }
}
