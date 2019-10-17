 package cap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	    public Connection getConnection() {
	        try {
	        	String banco = System.getenv("tipoBanco");
	        	Connection conexao = null;
	        	if (banco == "mysql") {
	            conexao = 
	                    DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "usuario", "senha");
	        	}
	        	else if(banco == "postgres") {
	        		DriverManager.getConnection("jdbc:postegres://localhost:3306/banco", "usuario", "senha");
	        	}
	        	
	            return conexao;
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}