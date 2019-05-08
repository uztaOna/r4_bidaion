package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {
	
	private Conexion conexion;
	private Connection connection;
	
	
	public Consultas(Conexion conexion) {
		this.conexion = conexion;
		this.connection = null;
	}
	
	//Cargar ubicaciones disponibles
		public ArrayList<String> getUbicaciones() {
			ArrayList<String> ubicaciones = new ArrayList<String>();
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			String query = "select DISTINCT(Ubicacion)FROM hoteles";

			try {
				//levantar la conexion
				connection = conexion.conectar();
				
				//preparar la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				
				//execute la consulta y guardarla en un ResultSet
				result = stmt.executeQuery();
				
				//crear un objeto Hotel y añade los hoteles que limita la consulta a un ArrayList
				while (result.next()) {
					ubicaciones.add(result.getString("Ubicacion"));
				}
			} catch (SQLException e) {
					e.printStackTrace();
				} finally {
				    //cerrar la conexion
				    conexion.desconectar();
				    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
				} 
			return ubicaciones;
		}	
	
	//Cargar la lista de hoteles segun ubicacion seleccionada
	public ArrayList<Hotel> getHotelesUbicacion(String ubicacion){
		//read * hotels
		Hotel hotel = null;
		ArrayList<Hotel> listaHoteles = new ArrayList<Hotel>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM hoteles WHERE Ubicacion=?";

		
		try {
			//levantar la conexion
			connection = conexion.conectar();
			
			//preparar la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, ubicacion);
			System.out.println(ubicacion);
			
			//execute la consulta y guardarla en un ResultSet
			result = stmt.executeQuery();
			
			//crear un objeto Hotel y añade los hoteles que limita la consulta a un ArrayList
			while (result.next()) {
				hotel = new Hotel();
				hotel.setId(result.getString("Id"));
				hotel.setNombreAloj(result.getString("Nombre"));
				hotel.setUbicacion(result.getString("Ubicacion"));
				hotel.setPrecio(result.getDouble("Precio"));
				//hotel.setCategoria(result.getInt("Categoria"));
				listaHoteles.add(hotel);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    //cerrar la conexion
			    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
			} 
		//return ArrayList
		return listaHoteles;
	}
	
	//Método que recibe nombre de un hotel y saca sus datos
	public Hotel getDatosHotel(String nombreHotel){
		//read * hotels
		Hotel hotel = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM hoteles WHERE Nombre=?";

		try {
			//levantar la conexion
			connection = conexion.conectar();
			
			//preparar la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, nombreHotel);
			System.out.println(nombreHotel);
			
			//execute la consulta y guardarla en un ResultSet
			result = stmt.executeQuery();
			
			//crear un objeto Hotel sus datos propios
			while (result.next()) {
				hotel = new Hotel();
				hotel.setId(result.getString("Id"));
				hotel.setNombreAloj(result.getString("Nombre"));
				hotel.setCategoria(result.getInt("Categoria"));
				hotel.setUbicacion(result.getString("Ubicacion"));
				hotel.setPrecio(result.getDouble("Precio"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    //cerrar la conexion
			    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
			} 
		//return ArrayList
		return hotel;
	}
	public boolean comprobarDNIenBD(String dni) {		
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "select DNI from cliente where DNI = \"" + dni + "\"";
		try {
			connection = conexion.conectar();
			
			//preparar la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			//execute la consulta y guardarla en un ResultSet
			result = stmt.executeQuery();
			if (result.next()) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}