package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
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
	private Reserva reserva;
	private DefaultTableModel tablaBillete;
	
	public Control_pago(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_pago() {
		this.vista.panelPago.btnConfirmar.addActionListener(this);
		this.vista.panelPago.btnAtras.addActionListener(this);
		this.vista.panelPago.btnCancelar.addActionListener(this);
		this.vista.panelPago.btnPagar.addActionListener(this);
	}
	
	

	TipoHab cama1=new TipoHab(40, 10,14,16);
	Date miFecha= new Date(115, 6, 2, 15, 30);

	Cliente cliente1=new Cliente("Pit", "El Anquila","64651682Q", 'M', miFecha, "QQQQ", 2, 9999999);
	Hotel hotel1=new Hotel("ID DEMO", "HOTEL DEMO", "DEMO CITY", 10, 5, 50);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelPago.btnPagar) {		
			Control_pago.pagar(vista, cliente1);
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
//			actualizarFrame();
		}
	}
	
	/*
	 * Resta el precio de la reserva de la cuenta del usuario
	 */
	public static void pagar(Vista vis, Cliente cliente){
		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==cliente.NCuenta) {

			System.out.println("Saldo ante-pago = 	" + cliente.saldo);
			cliente.saldo=cliente.saldo-Double.parseDouble(vis.panelPago.textAPagar.getText());
			vis.panelPago.textAPagar.setText("0");
			System.out.println("Saldo post-pago = 	" + cliente.saldo);
			vis.panelPago.btnPagar.setEnabled(false);
			vis.panelPago.btnConfirmar.setEnabled(true);
			vis.panelPago.btnAtras.setEnabled(false);
			vis.panelPago.btnCancelar.setEnabled(false);
		}

		else
			JOptionPane.showMessageDialog(null,"N� cuenta incorrecto","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * Devuelve el calcula el precio del total de camas seleccionadas
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
	
	/*
	 * Devuelve el calculo del servicio seleccionado
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
	
	public void actualizarFrame() {
		DefaultTableModel tablaRva = (DefaultTableModel) vista.panelResumen.table.getModel();
		mostrarReserva(modelo.reserva, tablaRva);
		
		vista.setContentPane(vista.panelResumen);
	}
	
	/*
	 * Muestra los datos de la reserva
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
		datosRva[10] = rva.getPrecio() + "�"; //Precio final de la reserva
		
		tablaModel.addRow(datosRva);
		System.out.println(datosRva);
	}
	
	/*
	 * Inserta los datos del Usuario en el texarea del usuario
	 */
	public String rellenarDatosUsuario(Vista vista, Cliente cliente) {
		String datosUsuario;
		return datosUsuario= "Nombre: " + cliente.getNombre() + "\n" +"Apellido: " + cliente.getApellido() + 
				"\n" + "DNI: " + cliente.getDni() + "\n" + "Sexo: " + cliente.getSexo();
	}
	
	/*
	 * Inserta los datos del Hotel en el texarea del Hotel
	 */
	public String rellenarDatosHotel(Vista vista, Hotel hotel) {
		String datosHotel;
		return datosHotel= "Hotel: " + hotel.getNombreAloj()+ "\n" + "Ubicaci�n: " + hotel.getUbicacion() +"\n" +
		"Estrellas: " + hotel.getCategoria() + "\n" + "Cantidad habitaciones: " + hotel.getNumHabitaciones() ;
	}
	
	/*
	 * Inserta los datos del Precio en el texarea del Precio
	 */
	public String rellenarDatosPrecio(Vista vista, Hotel hotel) {
		String datosPrecio;
		return datosPrecio= "Hotel: " + precio(vista, hotel)+ "\n" + "Servicios Extra: " + precioRadios(vista) +
		"\n" + "D�as: " + Control_buscador.getPernoctaciones(vista) +"Total: " + "\n" +  
		((precio(vista, hotel)+precioRadios(vista))*Control_buscador.getPernoctaciones(vista));
	}
	
}
