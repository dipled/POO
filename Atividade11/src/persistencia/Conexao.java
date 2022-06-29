package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection con = null;

    private Conexao() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if (con == null) {
            String url = "jdbc:postgresql://localhost:5432/contato";
            String usuario = "postgres";
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
            try {
                con = DriverManager.getConnection(url, usuario, "calzone");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return con;
    }
}
