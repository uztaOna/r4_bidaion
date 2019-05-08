package modelo;

import java.util.Date;

public class Cliente {
	
	public String nombre;
	public String apellido;
	public String dni;
	public char sexo;
	public Date fechaNac;
	private char[] contrasenia;
	public String NCuenta;
	public int dinero;

	public Cliente (String nombre, String apellido, String dni, char sexo, Date fechaNac, char[] contrasenia, String NCuenta, int dinero) {
		this.nombre = nombre;
		this.dni = dni;	
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.contrasenia=contrasenia;
		this.NCuenta=NCuenta;
		this.dinero=dinero;
	}
	
	public Cliente () {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public char[] getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(char[] contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNCuenta() {
		return NCuenta;
	}

	public void setNCuenta(String nCuenta) {
		NCuenta = nCuenta;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
}
