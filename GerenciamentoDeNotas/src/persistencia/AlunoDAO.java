package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Aluno;
import exceptions.AlunoJaCadastradoException;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class AlunoDAO {
    private static AlunoDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement login;
    private PreparedStatement validaCpf;

    private AlunoDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection con = Conexao.getConnection();
        selectNewId = con.prepareStatement("select nextval ('id_aluno')");
        insert = con.prepareStatement("insert into aluno values (?,?,?,?,?,?)");
        select = con.prepareStatement("select * from aluno where id = ?");
        delete = con.prepareStatement("delete from aluno where id = ? ");
        update = con
                .prepareStatement("update aluno set cpf = ?, senha = ?, nome = ?, idade = ?, curso = ? where id = ?");
        login = con.prepareStatement("select * from aluno where cpf = ? and senha = ?");
        validaCpf = con.prepareStatement("select * from aluno where cpf = ?");
    }
    private int selectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id na tabela aluno");
        }
        return 0;
    }
    
    public static AlunoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null) {
            instance = new AlunoDAO();
            
        }
        return instance;
    }

    public Aluno login(String cpfIn, String senhaIn) throws SelectException {
        try {
            login.setString(1, cpfIn);
            login.setString(2, senhaIn);
            ResultSet rs = login.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String cpf = rs.getString(2);
                String senha = rs.getString(3);
                String nome = rs.getString(4);
                int idade = rs.getInt(5);
                String curso = rs.getString(6);

                return new Aluno(id, cpf, senha, nome, idade, curso);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar aluno");
        }
        return null;
    }
    
    public void insere(Aluno aluno) throws InsertException, SelectException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, aluno.getCpf());
            insert.setString(3, aluno.getSenha());
            insert.setString(4, aluno.getNome());
            insert.setInt(5, aluno.getIdade());
            insert.setString(6, aluno.getCurso());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir aluno");
        }
    }
    
    public Aluno select(int aluno) throws SelectException {
        try {
            select.setInt(1, aluno);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String cpf = rs.getString(2);
                String senha = rs.getString(3);
                String nome = rs.getString(4);
                int idade = rs.getInt(5);
                String curso = rs.getString(6);

                return new Aluno(id, cpf, senha, nome, idade, curso);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao selecionar aluno");
        }
        return null;
    }
    public void validaCpf(String cpf) throws AlunoJaCadastradoException{
        try{
            validaCpf.setString(1, cpf);
            ResultSet rs = validaCpf.executeQuery();
            if(rs.next()){
                throw new AlunoJaCadastradoException("CPF já cadastrado");
            }
            
        }catch(SQLException e){}
    }

    public void delete(Aluno a) throws DeleteException {
        try {
            delete.setInt(1, a.getId());
            delete.executeUpdate();

        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar aluno");
        }
    }

    public void update(Aluno a) throws UpdateException {
        try {
            update.setString(1, a.getCpf());
            update.setString(2, a.getSenha());
            update.setString(3, a.getNome());
            update.setInt(4, a.getIdade());
            update.setString(5, a.getCurso());
            update.setInt(6, a.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar aluno");
        }
    }

}
