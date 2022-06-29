package negocios;

import java.sql.SQLException;

import dados.Aluno;
import exceptions.InsertException;
import exceptions.SelectException;

public class Teste {
    private static Sistema sistema;

    public static void main(String[] args) {
        try {
            sistema = new Sistema();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            System.err.println(e);
        }
        
    }
}
