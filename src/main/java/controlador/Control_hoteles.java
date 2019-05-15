package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Hotel;
import modelo.Modelo;
import vista.Ventana;

public class Control_hoteles implements ListSelectionListener, ActionListener {

	Ventana vista;
	Modelo modelo;
	Hotel ubicacion;
	Hotel hotel;
	
	//Constructor
	public Control_hoteles(Modelo modelo, Ventana vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	//Añadir listeners a los botones del panel 'hoteles'
	public void inicializar_eventos_hoteles() {
		this.vista.panelHoteles.JListHoteles.addListSelectionListener(this);
		this.vista.panelHoteles.btnContinuar.addActionListener(this);
		this.vista.panelHoteles.btnSeleccionar.addActionListener(this);
		this.vista.panelHoteles.btnAtras.addActionListener(this);
		
		this.vista.panelHoteles.btnLogin.addActionListener(this);
		this.vista.panelHoteles.btnRegistro.addActionListener(this);
	}
	
	Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelHoteles.btnSeleccionar) {			
			Control_hoteles.infoHotelSelec(modelo, vista);
			this.vista.panelReserva.lblHotelSelc.setText(hotel1.getNombreAloj());
		}
		if(e.getSource() == this.vista.panelHoteles.btnAtras || e.getSource() == this.vista.panelRegistro.btnCancelar
				||e.getSource() == this.vista.panelLogin.btnCancelar || e.getSource() == this.vista.panelReserva.btnCancelar
				|| e.getSource() == this.vista.panelLogin.btnCancelar) {			
			this.vista.setContentPane(this.vista.panelBuscador);
			Control_hoteles.limpiarBox(this.vista);
			Control_login.limpiarRegistro(this.vista);
			Control_login.limpiarLogin(this.vista);
			MetodosReserva.limpiarDispReser(this.vista);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnLogHoteles || e.getSource() == this.vista.panelReserva.btnLogReserva) {
			if(this.vista.panelHoteles.btnLogHoteles.getText() == "Desconexión" || this.vista.panelReserva.btnLogReserva.getText() == "Desconexión") {				
				Control_login.salirUsuario(this.vista);
			}
			else {
				this.vista.setContentPane(this.vista.panelLogin);
			}
		}
		else if(e.getSource() == this.vista.panelHoteles.btnRegistro || e.getSource() == this.vista.panelReserva.btnRegisReser ||  
				e.getSource() == this.vista.panelLogin.btnNoAcc) {
			System.out.println("No tengo cuenta");
			this.vista.setContentPane(this.vista.panelRegistro);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnLogin || e.getSource() == this.vista.panelReserva.btnLogReserva) {
			this.vista.setContentPane(this.vista.panelLogin);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnContinuar) {
//			MetodosReserva.infoRva();
			this.vista.setContentPane(this.vista.panelReserva);
			//CerrarVentana.VistaPrincipal();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}

	//Añadir listado de hoteles a JList según ubicación
	public static void addHotelesJList(Modelo modelo, Ventana vista) {
		//Panel esta creado en el constructor de vista.
		//Guardar ubicacion seleccionada
		String ubicacion = vista.panelBuscador.comboBox.getSelectedItem().toString();

		//Lamar a la funcion que lee los hoteles de la BBDD en el modelo
		ArrayList <Hotel> hotelesList =	modelo.consulta.getHotelesUbicacion(ubicacion);
		Control_hoteles.listadoHoteles(hotelesList); 
		
		//Limpiar el JList de hoteles
		vista.panelHoteles.modeloHoteles.clear();
			
		//Mostrar hoteles en JList
		for(int i=0; i<hotelesList.size(); i++) {
			vista.panelHoteles.modeloHoteles.addElement(hotelesList.get(i).getNombreAloj());
		}
		vista.panelHoteles.JListHoteles.setModel(vista.panelHoteles.modeloHoteles);
	}
	
	
	//Muestra info del hotel pulsando el botón "Seleccionar"
	public static void infoHotelSelec(Modelo modelo, Ventana vista) {
		// 1 Leer JList seleccionado
		String nombreHotel = (String)vista.panelHoteles.JListHoteles.getSelectedValue();
		
		// 2 Ir a BBDD y sacar datos de hotel pasandole NOMBRE
		Hotel hotel = modelo.consulta.getDatosHotel(nombreHotel);
		
		// 3 Cambiar labels de pan hoteles con datos de bbdd
		vista.panelHoteles.ubicacion.setText(hotel.getUbicacion());
		vista.panelHoteles.categoria.setText(Integer.toString(hotel.getCategoria()) + " estrellas");
		vista.panelHoteles.precio.setText(Double.toString(hotel.getPrecio()) + " €");
	}
	
	
	public static void tres(Ventana vis) {
		String nombre = "";
		if(nombre == vis.panelHoteles.lblNomHotel.getText()) {
			if(JOptionPane.showConfirmDialog(null,"Se cerró con éxito")==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else {
				JOptionPane.showConfirmDialog(null,"No se pudo cerrar");
			}
		} 
	}
	
	public static void limpiarBox(Ventana vis) {		
		vis.panelHoteles.JListHoteles.removeAll();
	}
	
	public static void cargaNombreHotel(Ventana vis, String nombre) {		
		vis.panelHoteles.lblNomHotel.setText(nombre);
	}
	
	
	public static ArrayList<Hotel> listadoHoteles (ArrayList<Hotel> listHoteles) {	
		for (int i = 0; i <listHoteles.size(); i++) {
			listHoteles.get(i);
		}
		return listHoteles;
	}
	
}
