package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import modelo.*;
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
		//Panel bienvenida
		this.vista.panelBienvenida.btnContinuar.addActionListener(this);
		
		//Panel buscador de destinos
		this.vista.panelBuscador.btnContinuar.addActionListener(this);
		
		//Panel de selecci�n de hoteles
		this.vista.panelHoteles.btnAtras.addActionListener(this);
		this.vista.panelHoteles.btnContinuar.addActionListener(this);
		this.vista.panelHoteles.jlistHoteles.addContainerListener(this);
		this.vista.panelHoteles.btnSeleccionar.addActionListener(this);	
		this.vista.panelHoteles.btnLogin.addActionListener(this);
		this.vista.panelHoteles.btnRegistro.addActionListener(this);
		
		//Panel de reserva
		this.vista.panelReserva.btnLogReserva.addActionListener(this);
		this.vista.panelReserva.btnRegisReser.addActionListener(this);
		this.vista.panelReserva.btnReservar.addActionListener(this);
		this.vista.panelReserva.btnCancelar.addActionListener(this);
		this.vista.panelReserva.btnIndividual.addActionListener(this);
		this.vista.panelReserva.btnMatrimonio.addActionListener(this);
		this.vista.panelReserva.btnDoble.addActionListener(this);
		
		//Panel login de usuario
		this.vista.panelLogin.btnRegistrarme.addActionListener(this);
		this.vista.panelLogin.btnCancelar.addActionListener(this);
		
		//Panel login de usuario 2
		this.vista.panelLogin2.btnContinuar.addActionListener(this);
		this.vista.panelLogin2.btnNoAcc.addActionListener(this);
		this.vista.panelLogin2.btnCancelar.addActionListener(this);
		
		//Panel de pago
		this.vista.panelPago.btnConfirmar.addActionListener(this);
		this.vista.panelPago.btnCancelar.addActionListener(this);
		this.vista.panelPago.btnPagar.addActionListener(this);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Cama cama1=new Cama("no", "si", 21, "089", "spa",6,10,5);
		Cliente cliente1=new Cliente("Juan", "BRRRRR","GDSASS", 'M', "04/04/2000", "QQQQ", "2", 9999999);

		MetodosReserva.disponibilidadCamas(vista, cama1);
		if(e.getSource() == vista.panelBienvenida.btnContinuar) {	
			Control_buscador.addUbicacionesCombo();
			vista.setContentPane(vista.panelBuscador);
			System.out.println("dfsdfsdfsdfsfsdfsdf");
		}
		else if(e.getSource() == vista.panelBuscador.btnContinuar) {
			System.out.println("vaaa bennneeeee");
			Control_hoteles.addHotelesJList();	
			vista.setContentPane(vista.panelHoteles);
		}
		else if(e.getSource() == vista.panelHoteles.btnSeleccionar) {			
			Control_hoteles.infoHotelSelec();
		}
		else if(e.getSource() == vista.panelHoteles.btnAtras || e.getSource() == vista.panelLogin.btnCancelar
				||e.getSource() == vista.panelLogin2.btnCancelar || e.getSource() == vista.panelReserva.btnCancelar
				|| e.getSource() == vista.panelLogin2.btnCancelar) {			
			vista.setContentPane(vista.panelBuscador);
			MetodoLogin.limpiarRegistro(vista);
			MetodoLogin.limpiarLogin(vista);
			MetodosReserva.limpiarDispReser(vista);
		}else if(e.getSource() == vista.panelHoteles.btnLogHoteles || e.getSource() == vista.panelReserva.btnLogReserva) {
			if(vista.panelHoteles.btnLogHoteles.getText()=="Log out"||vista.panelReserva.btnLogReserva.getText()=="Log out") {				
				controlador.MetodoLogin.salirUsuario(vista);
			}
			else {
				vista.setContentPane(vista.panelLogin2);
			}
		}
		else if(e.getSource() == vista.panelHoteles.btnRegistro || e.getSource() == vista.panelReserva.btnRegisReser ||  e.getSource() == vista.panelLogin2.btnNoAcc) {

			vista.setContentPane(vista.panelLogin);
		}
		else if(e.getSource() == vista.panelHoteles.btnLogin || e.getSource() == vista.panelReserva.btnLogReserva) {
			vista.setContentPane(vista.panelLogin2);
		}
		else if(e.getSource() == vista.panelHoteles.btnContinuar) {
//			MetodosReserva.infoRva();
			vista.setContentPane(vista.panelReserva);
			//CerrarVentana.VistaPrincipal();
		}
		else if(e.getSource() == vista.panelReserva.btnIndividual) {			
			vista.panelReserva.lblCantInd.setText(MetodosReserva.sumaBoton(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnMatrimonio) {			
			vista.panelReserva.lblCantMatri.setText(MetodosReserva.sumaBoton2(vista));
		}
		else if(e.getSource() == vista.panelReserva.btnDoble) {			
			vista.panelReserva.lblCantDoble.setText(MetodosReserva.sumaBoton3(vista));
			}else if(e.getSource() == vista.panelLogin2.btnContinuar) {		
				controlador.MetodoLogin.nombreUsuario(vista, cliente1);
			}else if(e.getSource() == vista.panelLogin.btnRegistrarme) {		
				MetodoLogin.registro(vista, modelo);
				System.out.println("Registra bien");
			}else if(e.getSource() == vista.panelPago.btnPagar) {		
				controlador.MetodosPago.pagar(vista, cliente1);
				MetodosReserva.actualizacionCamas(vista, cama1);
			}else if(e.getSource() == vista.panelHoteles.btnContinuar) {
				vista.setContentPane(vista.panelReserva);
				//CerrarVentana.VistaPrincipal();
			}else if(e.getSource() == vista.panelReserva.btnReservar) {
				if(controlador.MetodosReserva.reserva(vista, cama1)==true) {
					vista.setContentPane(vista.panelPago);
				}
			}else if(e.getSource() == vista.panelPago.btnCancelar) {
				vista.setContentPane(vista.panelHoteles);
			}else if(e.getSource() == vista.panelReserva.btnCancelar) {
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
