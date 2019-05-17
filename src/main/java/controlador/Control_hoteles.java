package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Cliente;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Hotel;
import modelo.Modelo;
import modelo.TipoHab;
import vista.Vista;

public class Control_hoteles implements ListSelectionListener, ActionListener {

	Vista vista;
	Modelo modelo;
	Hotel ubicacion;
	Hotel hotel;
	Cliente cliente;
	
	//Constructor
	public Control_hoteles(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	//Añadir listeners a los botones del panel 'hoteles'
	public void inicializar_eventos_hoteles() {
		this.vista.panelHoteles.JListHoteles.addListSelectionListener(this);
		this.vista.panelHoteles.btnContinuar.addActionListener(this);
		this.vista.panelHoteles.btnSeleccionar.addActionListener(this);
		this.vista.panelHoteles.btnAtras.addActionListener(this);
		this.vista.panelHoteles.btnCancelar.addActionListener(this);
		//Eventos de control de usuarios
		this.vista.panelHoteles.btnLogin.addActionListener(this);
		this.vista.panelHoteles.btnRegistro.addActionListener(this);
	}
	
	TipoHab cama1=new TipoHab(40, 10,14,16);
	Date miFecha= new Date(115, 6, 2, 15, 30);

	Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
	Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelHoteles.btnSeleccionar) {
			this.vista.panelHoteles.btnContinuar.setEnabled(true);
			infoHotelSelec(modelo, vista);
			this.vista.panelReserva.lblHotelSelc.setText(hotel1.getNombreAloj());
			this.vista.panelHoteles.btnContinuar.setEnabled(true);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnAtras) {			
			this.vista.setContentPane(this.vista.panelBuscador);
			limpiarBox(this.vista);
			Control_login.limpiarRegistro(this.vista);
			Control_login.limpiarLogin(this.vista);
			Control_reserva.limpiarDispReser(this.vista);
			Control_buscador.limpiarinfoHotelSelec(this.vista);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
			Control_buscador.limpiarinfoHotelSelec(this.vista);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnLogin) {
			if(this.vista.panelReserva.btnLogin.getText() == "Log out") {		
				Control_login.salirUsuario(this.vista);
//				Control_login.vista = vista.panelHoteles;
			}
			else {
				this.vista.setContentPane(this.vista.panelLogin);
			}
		}
		else if(e.getSource() == this.vista.panelHoteles.btnRegistro) {
			this.vista.setContentPane(this.vista.panelRegistro);
		}
		else if(e.getSource() == this.vista.panelHoteles.btnContinuar) {
//			MetodosReserva.infoRva();
			this.vista.setContentPane(this.vista.panelReserva);
			Control_reserva.disponibilidadCamas(vista, cama1);
			//CerrarVentana.VistaPrincipal();
		}
		if(e.getSource() == vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			vista.setContentPane(vista.panelHoteles);
		}
		else if(e.getSource() == vista.panelHoteles.btnSeleccionar) {			
			Control_hoteles.infoHotelSelec(modelo, vista);
			vista.panelReserva.lblHotelSelc.setText(hotel1.getNombreAloj());
		}
		if(e.getSource() == vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			vista.setContentPane(vista.panelHoteles);
		}
		else if(e.getSource() == vista.panelHoteles.btnSeleccionar) {			
			Control_hoteles.infoHotelSelec(modelo, vista);
			vista.panelReserva.lblHotelSelc.setText(hotel1.getNombreAloj());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}

	//Añadir listado de hoteles a JList según ubicación
	public static void addHotelesJList(Modelo modelo, Vista vista) {
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
	
	public static void addCasaJList(Modelo modelo, Vista vista) {
		//Panel esta creado en el constructor de vista.
		//Guardar ubicacion seleccionada
		String ubicacion = vista.panelBuscador.comboBox.getSelectedItem().toString();

		//Lamar a la funcion que lee los hoteles de la BBDD en el modelo
		ArrayList <Casa> casasList =	modelo.consulta.getCasasUbicacion(ubicacion);
		Control_hoteles.listadoCasas(casasList); 
		
		//Limpiar el JList de hoteles
		vista.panelHoteles.modeloHoteles.clear();
			
		//Mostrar hoteles en JList
		for(int i=0; i<casasList.size(); i++) {
			vista.panelHoteles.modeloHoteles.addElement(casasList.get(i).getNombreAloj());
		}
		vista.panelHoteles.JListHoteles.setModel(vista.panelHoteles.modeloHoteles);
	}
	
	public static void addApartamentoJList(Modelo modelo, Vista vista) {
		//Panel esta creado en el constructor de vista.
		//Guardar ubicacion seleccionada
		String ubicacion = vista.panelBuscador.comboBox.getSelectedItem().toString();

		//Lamar a la funcion que lee los hoteles de la BBDD en el modelo
		ArrayList <Apartamento> apartamentoList =	modelo.consulta.getApartamentosUbicacion(ubicacion);
		Control_hoteles.listadoApartamento(apartamentoList); 
		
		//Limpiar el JList de hoteles
		vista.panelHoteles.modeloHoteles.clear();
			
		//Mostrar hoteles en JList
		for(int i=0; i<apartamentoList.size(); i++) {
			vista.panelHoteles.modeloHoteles.addElement(apartamentoList.get(i).getNombreAloj());
		}
		vista.panelHoteles.JListHoteles.setModel(vista.panelHoteles.modeloHoteles);
	}
	
	//Muestra info del hotel pulsando el botón "Seleccionar"
	public static void infoHotelSelec(Modelo modelo, Vista vista) {
		// 1 Leer JList seleccionado
		String nombreHotel = (String)vista.panelHoteles.JListHoteles.getSelectedValue();
		
		// 2 Ir a BBDD y sacar datos de hotel pasandole NOMBRE
		Hotel hotel = modelo.consulta.getDatosHotel(nombreHotel);
		
		// Limpiar elementos anteriores
//		vista.panelHoteles.ubicacion.removeAll();
//		vista.panelHoteles.categoria.removeAll();
//		vista.panelHoteles.precio.removeAll();

		// 3 Cambiar labels de pan hoteles con datos de bbdd
		vista.panelHoteles.ubicacion.setText(hotel.getUbicacion());
		vista.panelHoteles.categoria.setText(Integer.toString(hotel.getCategoria()) + " estrellas");
		vista.panelHoteles.precio.setText(Double.toString(hotel.getPrecio()) + " €");
	}
	
	
	public static void tres(Vista vis) {
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
	
	public static void limpiarBox(Vista vis) {		
		vis.panelHoteles.JListHoteles.removeAll();
	}
	
	public static void cargaNombreHotel(Vista vis, String nombre) {		
		vis.panelHoteles.lblNomHotel.setText(nombre);
	}
	
	
	public static ArrayList<Hotel> listadoHoteles (ArrayList<Hotel> listHoteles) {	
		for (int i = 0; i <listHoteles.size(); i++) {
			listHoteles.get(i);
		}
		return listHoteles;
	}
	
	
	public static ArrayList<Casa> listadoCasas (ArrayList<Casa> listCasas) {	
		for (int i = 0; i <listCasas.size(); i++) {
			listCasas.get(i);
		}
		return listCasas;
	}
	
	public static ArrayList<Apartamento> listadoApartamento (ArrayList<Apartamento> listApartamento) {	
		for (int i = 0; i <listApartamento.size(); i++) {
			listApartamento.get(i);
		}
		return listApartamento;
	}
}
