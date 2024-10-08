package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	private static Connection bd = null;
	
	public static Connection getBd() {
		// na primeira vez que este método é chamado, a conexão ainda não vai
		// ter sido criada, então temos que criá-la; a partir das próximas chamadas,
		// basta retornar a variável de classe "bd"
		if (bd == null) {
			try {
				bd = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cadastro_pessoas",
						"root",
						"root"
						);
			} catch (SQLException e) {
				// erro ao conectar ao bd, vamos imprimir o stack trace e encerrar
				e.printStackTrace();
				System.exit(1);
			}
		}
		return bd;
	}
}
