package modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null,"¡Error al conectarse!","Error",0);
		}
		return cnx;
	}
	
	public void desconectar() {
		try {
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"[ERROR] No se pudo finalizar la conexión","Error",0);
		}
	}
}
