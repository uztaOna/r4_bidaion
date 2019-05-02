package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;

import modelo.Alojamiento;
import modelo.Cama;
import modelo.Habitacion;
import modelo.Hotel;

import modelo.Modelo;
import vista.Ventana;

public class Controlador implements ActionListener, ContainerListener {

	private Ventana vista;
	private Modelo modelo;
	
	
	public Controlador(Ventana vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.setContentPane(vista.panelBienvenida);
		inicializarEventos();
		}
	
	public void inicializarEventos() {
	
		this.vista.panelBienvenida.btnContinuar.addActionListener(this);
		this.vista.panelBuscador.btnContinuar.addActionListener(this);
		this.vista.panelHoteles.btnAtras.addActionListener(this);
		this.vista.panelHoteles.btnContinuar.addActionListener(this);
		this.vista.panelHoteles.jlistHoteles.addContainerListener(this);
		this.vista.panelHoteles.btnSeleccionar.addContainerListener(this);
		this.vista.panelHoteles.btnLogHoteles.addActionListener(this);
		this.vista.panelHoteles.btnRegisHoteles.addActionListener(this);
		this.vista.panelHoteles.btnSeleccionar.addActionListener(this);	
		this.vista.panelReserva.btnLogReserva.addActionListener(this);
		this.vista.panelReserva.btnRegisReser.addActionListener(this);
		this.vista.panelReserva.btnReservar.addActionListener(this);
		this.vista.panelLogin.btnRegistrarme.addActionListener(this);
		this.vista.panelLogin.btnCancelar.addActionListener(this);
		this.vista.panelLogin2.btnContinuar.addActionListener(this);
		this.vista.panelLogin2.btnNoAcc.addActionListener(this);
		this.vista.panelLogin2.btnCancelar.addActionListener(this);
		this.vista.panelPago.btnCancelar.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		ArrayList<Hotel> nomHoteles = controlador.Seleccion_hotel.cosas(hotel); 
		//hotel [0]=new Hotel("hotel1", "Madrid", 20);
		//hotel [1]=new Hotel("hotel2", "Madrid", 25);
		//hotel [2]=new Hotel("hotel3", "Madrid", 22);
		
		Cama cama1=new Cama("no", "si", 21, "089", "spa",6,10,5);
		
		if(e.getSource() == vista.panelBienvenida.btnContinuar) {	
			Control_buscador.addUbicacionesCombo();
			vista.setContentPane(vista.panelBuscador);
			System.out.println("dfsdfsdfsdfsfsdfsdf");
		}else if(e.getSource() == vista.panelBuscador.btnContinuar) {
			System.out.println("vaaa bennneeeee");
			Control_hoteles.addHotelesJList();	
			vista.setContentPane(vista.panelHoteles);
//		}else if(e.getSource() == vista.panelHoteles.btnSeleccionar) {			
//			controlador.Seleccion_hotel.mostrarDatos(vista, );
		}else if(e.getSource() == vista.panelHoteles.btnAtras || e.getSource() == vista.panelLogin.btnCancelar
				||e.getSource() == vista.panelLogin2.btnCancelar) {			
			vista.setContentPane(vista.panelBuscador);
		}else if(e.getSource() == vista.panelHoteles.btnRegisHoteles || e.getSource() == vista.panelReserva.btnRegisReser
				||  e.getSource() == vista.panelLogin2.btnNoAcc) {
			vista.setContentPane(vista.panelLogin);
		}else if(e.getSource() == vista.panelHoteles.btnLogHoteles || e.getSource() == vista.panelReserva.btnLogReserva) {
			vista.setContentPane(vista.panelLogin2);
		}else if(e.getSource() == vista.panelHoteles.btnContinuar) {
			vista.setContentPane(vista.panelReserva);
			//CerrarVentana.VistaPrincipal();
		}else if(e.getSource() == vista.panelReserva.btnReservar) {
			if(controlador.MetodosReserva.reserva(vista, modelo, cama1)==true) {
				vista.setContentPane(vista.panelPago);
			}
		}else if(e.getSource() == vista.panelPago.btnCancelar) {
			vista.setContentPane(vista.panelHoteles);
		}
	}

	
	@Override
	public void componentAdded(ContainerEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
	}
}
