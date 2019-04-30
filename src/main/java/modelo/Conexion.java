package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Clase que permite conectar con la base de datos
 */

public class Conexion {
	Connection cnx = null;
	
	String bd="bidaion_g5";
	String url="jdbc:mysql://localhost:3306/" + bd+"?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user="root";
	String pssw="";
	
	public Connection conectar() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx=(Connection) DriverManager.getConnection(url, user, pssw);
			System.out.println("Conexión establecida...");
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.err.println("¡Error al conectarse!");
		}
		return cnx;
	}
	
	public void desconectar() {
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("[ERROR] No se pudo finalizar la conexión");
		}
	}
}
