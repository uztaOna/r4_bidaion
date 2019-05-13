package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ficheros {

	public Ficheros() {
		
	}
	
public String imprimirBillete(Hotel billeteIda, String path) {
		
		FileWriter fichero = null;	
		PrintWriter writer = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		try {
			
			fichero = new FileWriter(path);
			writer = new PrintWriter(fichero);
			
			writer.println("=== DATOS DE LA RESERVA ===");
			writer.println();
//			writer.println("Destino: " + Ubicacion.getUbicacion);
			writer.println();
//			writer.println("Hotel: " + Hotel.getNombre());
//			writer.println("Categoria: " + Hotel.getCategoria());
			writer.println();
//			writer.println("Precio: " + Hotel.getPrecio());
			writer.println();
			writer.println();
			writer.println("Fecha de compra: " + dateFormat.format(date));
			writer.println();
			
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
				if (writer != null) {
					writer.close();
				}
				} catch (Exception e) {
					e.getStackTrace();
			}
		}
		return path;
		
	}
}
