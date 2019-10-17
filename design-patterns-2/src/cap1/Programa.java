package cap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Programa {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
	}
}
