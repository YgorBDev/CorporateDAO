package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	private static Connection bd = null;
	
	public static Connection getBd() {
		if (bd == null) {
			try {
				bd = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bd_integrador",
						"root",
						"root"
						);
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return bd;
	}
}
