package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Hotel;
import modelo.Modelo;
import modelo.Reserva;
import modelo.TipoHab;
import vista.Vista;

public class Control_pago implements ActionListener {
	
	Vista vista;
	Modelo modelo;
	Reserva reserva;
	Hotel hotel;
	/**
	 * declaracion de vista,modelo
	 * @param modelo
	 * @param vista
	 */
	public Control_pago(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	/**
	 * iniciador de los eventos del panel
	 */
	public void inicializar_eventos_pago() {
		this.vista.panelPago.btnConfirmar.addActionListener(this);
		this.vista.panelPago.btnAtras.addActionListener(this);
		this.vista.panelPago.btnCancelar.addActionListener(this);
		this.vista.panelPago.btnPagar.addActionListener(this);
	}
	
	

	TipoHab cama1=new TipoHab(40, 10,14,16);
	Date miFecha= new Date(115, 6, 2, 15, 30);


	//Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
	

	Hotel hotel1=new Hotel("H001", "Hotel Baserri", "Bilbao", 85, 4, 50);
	Cliente cliente1=new Cliente("Pit", "Anquila","64651682Q", 'M', miFecha, "QQQQ", 1234567890, 2500.50f);

	/**
	 * acciondel del panel
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelPago.btnPagar) {		
//			Control_pago.pagar(vista, modelo.metodoLogin.modelo.clienteRegistrado);
			pagar(vista);
			Control_reserva.actualizacionCamas(vista, cama1);
			Control_reserva.disponibilidadCamas(vista, cama1);			
		}
		else if(e.getSource() == vista.panelPago.btnAtras) {
			this.vista.setContentPane(vista.panelReserva);
		}
		else if(e.getSource() == vista.panelPago.btnCancelar) {
			Control_hoteles.limpiarBox(vista);
			this.vista.setContentPane(vista.panelBienvenida);
		}
		else if(e.getSource() == vista.panelPago.btnConfirmar) {
			this.vista.setContentPane(vista.panelResumen);
			this.vista.panelResumen.txtaDatosUser.setText(rellenarDatosUsuario(vista, cliente1));
			this.vista.panelResumen.txtaDatosHotel.setText(rellenarDatosHotel(vista, hotel1));
			this.vista.panelResumen.txtaDatosPago.setText(rellenarDatosPrecio(vista, hotel1));
			this.vista.panelResumen.txtaDatosRva.setText(rellenarDatosRva(vista));
//			actualizarFrame();
		}
	}
	
//	/*
//	 * Resta el precio de la reserva de la cuenta del usuario
//	 */
//	public static void pagar(Vista vis, Cliente cliente){
//		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==cliente.NCuenta) {
//
//			System.out.println("Saldo ante-pago = 	" + cliente.saldo);
//			cliente.saldo=cliente.saldo-Double.parseDouble(vis.panelPago.textAPagar.getText());
//			vis.panelPago.textAPagar.setText("0");
//			System.out.println("Saldo post-pago = 	" + cliente.saldo);
//			vis.panelPago.btnPagar.setEnabled(false);
//			vis.panelPago.btnConfirmar.setEnabled(true);
//			vis.panelPago.btnAtras.setEnabled(false);
//			vis.panelPago.btnCancelar.setEnabled(false);
//			vis.panelPago.textAPagar.setEnabled(false);
//			vis.panelPago.textCuenta.setEnabled(false);
//		}
//		else
//			JOptionPane.showMessageDialog(null,"Nº cuenta incorrecto","Error",JOptionPane.ERROR_MESSAGE);
//	}
	/**
	 * metodo para solucionar el pago
	 * @param vis
	 */
	public static void pagar(Vista vis){
			vis.panelPago.btnPagar.setEnabled(false);
			vis.panelPago.btnConfirmar.setEnabled(true);
			vis.panelPago.btnAtras.setEnabled(false);
			vis.panelPago.btnCancelar.setEnabled(false);
			vis.panelPago.textAPagar.setEnabled(false);
			vis.panelPago.textCuenta.setEnabled(false);
	}
	
	/**
	 * metodo para coger el precio de la reserva
	 * @param vis
	 * @param hotel
	 * @return
	 */
	public static double precio(Vista vis, Hotel hotel) {	
		double precio = (Double.parseDouble(vis.panelReserva.lblCantInd.getText())*hotel.getPrecio()) + 
		(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())*(hotel.getPrecio()*1.1)) + 
		(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())*(hotel.getPrecio()*1.2));
		
		System.out.println("Hab individual: " + vis.panelReserva.lblCantInd.getText() + "		Precio: " + 
				(Double.parseDouble(vis.panelReserva.lblCantInd.getText())*hotel.getPrecio()));
		System.out.println("Hab Matrimonio: " + vis.panelReserva.lblCantMatri.getText() + "		Precio: " +
				(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())*(hotel.getPrecio()*1.1)));
		System.out.println("Hab Doble: 	" + vis.panelReserva.lblCantDoble.getText() + "		Precio: " +
				(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())*(hotel.getPrecio()*1.2)));
		System.out.println("PRECIO TOTAL == " + precio + "\n");
		System.out.println("Wifi = " + vis.panelReserva.rdbtnWifi.getActionCommand());
		System.out.println("Total dias = " + vis.panelBuscador.spinnerDias.getValue());
		return Math.round(precio);
	}
	
	/**
	 * metodo para fijar los precios de los complemento de la habitacion
	 * @param vis
	 * @return
	 */
	public static double precioRadios(Vista vis) {
		boolean radioArray[] = {vis.panelReserva.rdbtnWifi.isSelected(),
				vis.panelReserva.rdbtnPiscina.isSelected(),
				vis.panelReserva.rdbtnSpa.isSelected(), 
				vis.panelReserva.rdbtnParking.isSelected(),
				vis.panelReserva.rdbtnAireAcon.isSelected(),
				vis.panelReserva.rdbtnRestaurante.isSelected(),
				vis.panelReserva.rdbtnBar.isSelected(),
				vis.panelReserva.rdbtnGYM.isSelected()};
		double radioPrecio[] = {5,8,15,10,3,25,12,6};
		double cadena=0;
		for (int i = 0; i < 8; i++) {
			if(radioArray[i]==true) {
				cadena=cadena + radioPrecio[i];
			}
			else {
				cadena = cadena;
			}
		}
		return cadena;
	}
	
	public boolean validarDatos() {
		
		return false;
	}
	
//	public void actualizarFrame() {
//		DefaultTableModel tablaRva = (DefaultTableModel) vista.panelResumen.table.getModel();
//		mostrarReserva(modelo.reserva, tablaRva);
//		
//		vista.setContentPane(vista.panelResumen);
//	}
	
	/**
	 * metodo para reservar
	 * @param rva
	 * @param tablaModel
	 */
	public void mostrarReserva(Reserva rva, DefaultTableModel tablaModel) {
		
		Object[] datosRva = new Object[11];
		tablaModel.setRowCount(0);
		
		datosRva[0] = rva.getCodigoReserva(); //Codigo Reserva
		datosRva[1] = rva.getDestino(); //Destino
		datosRva[2] = rva.getHotel(); //Nombre de alojamiento
		datosRva[3] = rva.getFechaIni(); //Fecha de llegada
		datosRva[4] = rva.getFechaFin(); //fecha de salida
		datosRva[5] = rva.getDni(); //Dni de cliente
		datosRva[6] = rva.getNomUsuario(); //Nombre de cliente
		datosRva[7] = rva.getApeUsuario(); //Apellido de cliente
		datosRva[8] = rva.getTipoHab(); //Descripcion de las habitaciones reservadas (tipoHab + cantidad)
		datosRva[9] = rva.getExtras(); //Servicios extras contratados (si los hubiese)
		datosRva[10] = rva.getPrecio() + "€"; //Precio final de la reserva
		
		tablaModel.addRow(datosRva);
		System.out.println(datosRva);
	}
	
	/**
	 * metodo para rellenar los datos del usuario 
	 * @param vista
	 * @param cliente
	 * @return
	 */
	public String rellenarDatosUsuario(Vista vista, Cliente cliente) {
		return "Nombre: " + cliente.getNombre() + "\n" + 
				"Apellido: " + cliente.getApellido() + "\n" + 
				"DNI: " + cliente.getDni() + "\n" + 
				"Sexo: " + cliente.getSexo() + "\n" + 
				"Fecha nacimiento: " + "01/01/1990";
	}
	
	/**
	 * metodo para rellenar los datos del hotel
	 * @param vista
	 * @param hotel
	 * @return
	 */
	public String rellenarDatosHotel(Vista vista, Hotel hotel) {
		return hotel.getNombreAloj()+ "\n" + 
				"Ciudad: " + hotel.getUbicacion() +"\n" +
				"Categoría: " + hotel.getCategoria() + "*" + "\n" + 
				"Cantidad habitaciones: " + hotel.getNumHabitaciones() ;
	}
	
	/**
	 * metodo para rellenar los datos de la reserva
	 * @param vista
	 * @return
	 */
	public String rellenarDatosRva(Vista vista) {
		int codRva = 001;
		Date fiDate = vista.panelBuscador.dateInicio.getDate();
		String fInicio = Control_buscador.fechaToString(fiDate);
		String fFin = Control_buscador.fechaToString(Control_buscador.sumarDiasAFecha(fiDate, Control_buscador.getPernoctaciones(vista)));
		
		return "Nº Reserva: " + codRva + "\n" +
				"\n" +
				"Destino: " +  vista.panelBuscador.comboUbicaciones.getSelectedItem().toString() + "\n" +
				"\n" +
				"Llegada: 	" + fInicio.toString() + "\n" + 
				"Salida:	 " + fFin.toString() + "\n" +
				"Total días: " + Control_buscador.getPernoctaciones(vista) + "\n" +
				"\n" +
				"Habitación individual: " + 2 + "\n" +
				"Habitación matrimonio: " + 0 + "\n" +
				"Habitación doble: 		" + 0;
	}
	
	/**
	 * metodo para rellenar mostrar los datos de la reserva (archivo)
	 * @param vista
	 * @param hotel
	 * @return
	 */
	public String rellenarDatosPrecio(Vista vista, Hotel hotel) {
		return "Hotel: " + (precio(vista, hotel) * Control_buscador.getPernoctaciones(vista)) + " €" + "\n" + 
				"Servicios Extra: " + precioRadios(vista) + " €" + "\n" +
				"\n" +
				"TOTAL: " + ((precio(vista, hotel) + precioRadios(vista)) 
						* Control_buscador.getPernoctaciones(vista)) + " €";
	}
	
}
