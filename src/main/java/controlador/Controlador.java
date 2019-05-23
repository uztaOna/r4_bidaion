package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener, ContainerListener {

	/**
	 * declaraciones de los controladores
	 */
	private Vista vista;
	private Modelo modelo;
	
	private Control_bienvenida control_bienvenida;
	private Control_buscador control_buscador;
	private Control_hoteles control_hoteles;
	private Control_login control_login;
	private Control_registro control_registro;
	private Control_reserva control_reserva;
	private Control_pago control_pago;
	private Control_resumen control_resumen;
	
	/**
	 * controlador del programa
	 * @param vista
	 * @param modelo
	 */
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo; 
		
		control_bienvenida = new Control_bienvenida(this.modelo, this.vista);
		control_bienvenida.inicializar_eventos_bienvenida();
		
		control_buscador = new Control_buscador(this.modelo, this.vista);
		control_buscador.inicializar_eventos_buscador();
			
		control_hoteles = new Control_hoteles(this.modelo, this.vista);
		control_hoteles.inicializar_eventos_hoteles();
		
		control_login = new Control_login(this.modelo, this.vista);
		control_login.inicializar_eventos_login();
		
		control_registro = new Control_registro(this.modelo, this.vista);
		control_registro.inicializar_eventos_registro();
		
		control_reserva = new Control_reserva(this.modelo, this.vista);
		control_reserva.inicializar_eventos_reserva();
		
		control_pago = new Control_pago(this.modelo, this.vista);
		control_pago.inicializar_eventos_pago();
		
		control_resumen = new Control_resumen(this.modelo, this.vista);
		control_resumen.inicializar_eventos_resumen();
		
		vista.setContentPane(vista.panelBienvenida);
	}

	@Override
	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void componentAdded(ContainerEvent arg0) {
		// TODO Auto-generated method stub
	}
}
