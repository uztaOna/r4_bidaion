package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	

	//****************************************
		
		public ArrayList<Casa> getCasasUbicacion(String ubicacion){
			//read * casas
			Casa casa = null;
			ArrayList<Casa> listaCasas = new ArrayList<Casa>();
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			String query = "SELECT * FROM casas WHERE Ubicacion=?";

			
			try {
				//levantar la conexion
				connection = conexion.conectar();
				
				//preparar la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				stmt.setString(1, ubicacion);
				System.out.println(ubicacion);
				
				//execute la consulta y guardarla en un ResultSet
				result = stmt.executeQuery();
				
				//crear un objeto Casa y añade las casas que limita la consulta a un ArrayList
				while (result.next()) {
					casa = new Casa();
					casa.setId(result.getString("Id"));
					casa.setNombreAloj(result.getString("Nombre"));
					casa.setUbicacion(result.getString("Ubicacion"));
					casa.setPrecio(result.getDouble("Precio"));
					//hotel.setCategoria(result.getInt("Categoria"));
					listaCasas.add(casa);
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
			return listaCasas;
		}
		
		//Método que recibe nombre de una casa y saca sus datos
		public Casa getDatosCasa(String nombreCasa){
			//read * hotels
			Casa casa = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			String query = "SELECT * FROM casas WHERE Nombre=?";

			try {
				//levantar la conexion
				connection = conexion.conectar();
				
				//preparar la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				stmt.setString(1, nombreCasa);
				System.out.println(nombreCasa);
				
				//execute la consulta y guardarla en un ResultSet
				result = stmt.executeQuery();
				
				//crear un objeto Hotel sus datos propios
				while (result.next()) {
					casa = new Casa();
					casa.setId(result.getString("Id"));
					casa.setNombreAloj(result.getString("Nombre"));
					casa.setNbanos(result.getInt("Nbanos"));
					casa.setUbicacion(result.getString("Ubicacion"));
					casa.setPrecio(result.getDouble("Precio"));
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
			return casa;
		}
		
	//***************************
		
		public ArrayList<Apartamento> getApartamentosUbicacion(String ubicacion){
			//read * apartamentos
			Apartamento apartamento = null;
			ArrayList<Apartamento> listaApartamento = new ArrayList<Apartamento>();
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			String query = "SELECT * FROM apartamentos WHERE Ubicacion=?";

			
			try {
				//levantar la conexion
				connection = conexion.conectar();
				
				//preparar la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				stmt.setString(1, ubicacion);
				System.out.println(ubicacion);
				
				//execute la consulta y guardarla en un ResultSet
				result = stmt.executeQuery();
				
				//crear un objeto Apartamento y añade los apartamentos que limita la consulta a un ArrayList
				while (result.next()) {
					apartamento = new Apartamento();
					apartamento.setId(result.getString("Id"));
					apartamento.setNombreAloj(result.getString("Nombre"));
					apartamento.setUbicacion(result.getString("Ubicacion"));
					apartamento.setPrecio(result.getDouble("Precio"));
					listaApartamento.add(apartamento);
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
			return listaApartamento;
		}
		
		//Método que recibe nombre de un apartamento y saca sus datos
		public Apartamento getDatosApartamento(String nombreApartamento){
			//read * hotels
			Apartamento apartamento = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			
			String query = "SELECT * FROM apartamentos WHERE Nombre=?";

			try {
				//levantar la conexion
				connection = conexion.conectar();
				
				//preparar la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				stmt.setString(1, nombreApartamento);
				System.out.println(nombreApartamento);
				
				//execute la consulta y guardarla en un ResultSet
				result = stmt.executeQuery();
				
				//crear un objeto Apartamento sus datos propios
				while (result.next()) {
					apartamento = new Apartamento();
					apartamento.setId(result.getString("Id"));
					apartamento.setNombreAloj(result.getString("Nombre"));
					apartamento.setNpiso(result.getInt("Npiso"));
					apartamento.setUbicacion(result.getString("Ubicacion"));
					apartamento.setPrecio(result.getDouble("Precio"));
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
			return apartamento;
		}
	/**
	 * Metodo que comprueba la existencia del DNI introducido en la BBDD
	 * @param dni
	 * @return
	 */
	public boolean comprobarDNIenBD(String dni) {		
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "select DNI from clientes where DNI = \"" + dni + "\"";
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
	
	/**
	 * Inserta la informacion del usuario en la base de datos
	 * 
	 * @param usuario el cliente que se registrara en la base de datos
	 * @param mod     modelo con la conexion a la base de datos
	 */
	public void insertarUsuarioEnBaseDeDatos(Cliente usuario) { 
				System.out.println(usuario.dni + usuario.nombre + usuario.apellido +  usuario.fechaNac.getTime() + usuario.sexo + usuario.getContrasenia());
				System.out.println(usuario.NCuenta + usuario.saldo);
		try {
			String query2 = "insert into cc (NumeroCC, DNI, Saldo) values(?,?,10000);";
			String query = "insert into clientes (DNI,Nombre,Apellido,Fnac,Sexo,Password) values(?,?,?,?,?,?);";
			PreparedStatement insertarUsuario = this.conexion.cnx.prepareStatement(query);
			PreparedStatement insertarCuenta = this.conexion.cnx.prepareStatement(query2);
			insertarUsuario.setString(1, usuario.dni);
			insertarUsuario.setString(2, usuario.nombre);
			insertarUsuario.setString(3, usuario.apellido);
			insertarUsuario.setDate(4, new java.sql.Date(usuario.fechaNac.getTime()));
			insertarUsuario.setString(5, String.valueOf(usuario.sexo));
			insertarUsuario.setString(6, usuario.getContrasenia());
			insertarCuenta.setInt(1, usuario.NCuenta);
			insertarCuenta.setString(2, usuario.dni);
			
			insertarUsuario.executeUpdate();
			insertarCuenta.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
	
	/*public void insertarCuentaDelUsuarioEnBBDD(Cliente usuario) {
		try {
			String query2 = "insert into cc (NumeroCC, DNI, Saldo) values(?,?,10000);";
			PreparedStatement insertarCuenta = this.conexion.cnx.prepareStatement(query2);
			insertarCuenta.setInt(1, usuario.NCuenta);
			insertarCuenta.setString(2, usuario.dni);
			
			insertarCuenta.executeUpdate();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}*/
	
	
}