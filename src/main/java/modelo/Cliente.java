package modelo;

import java.util.Date;

public class Cliente {
	
	public String nombre;
	public String apellido;
	public String dni;
	public char sexo;
	public Date fechaNac;
	private String contrasenia;
	public int NCuenta;
	public double saldo;

	public Cliente () {
		
	}
	
	public Cliente (String dni, String nombre, String apellido, Date fechaNac, char sexo, String contrasenia) {
		this.nombre = nombre;
		this.dni = dni;	
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.contrasenia=contrasenia;
	}
	
	public Cliente (String nombre, String apellido, String dni, char sexo, Date fechaNac, String contrasenia, int NCuenta, double saldo) {
		this.nombre = nombre;
		this.dni = dni;	
		this.apellido = apellido;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.contrasenia=contrasenia;
		this.NCuenta=NCuenta;
		this.saldo=saldo;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getNCuenta() {
		return NCuenta;
	}

	public void setNCuenta(int nCuenta) {
		NCuenta = nCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
}
