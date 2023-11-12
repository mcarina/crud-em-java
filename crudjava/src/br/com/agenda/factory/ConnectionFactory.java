package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// nome do usuario
	private static final String USERNAME = "root";
	
	//senha
	private static final String PASSWORD = "";
	
	// caminho do banco de dados, port, nome do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

	/*
	 * conexao com o banco
	 * 
	 */
	
    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
				
	}
	
    public static void main(String[] args) throws Exception, SQLException {
        Connection con = createConnectionToMySQL();

        if (con != null) {
            System.out.println("Conexão bem-sucedida!!");
            con.close();
        }
    }

	
}
