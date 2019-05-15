package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Hotel;
import modelo.Modelo;
import modelo.TipoHab;
import vista.Vista;

public class Control_pago implements ActionListener {
	
	Vista vista;
	Modelo modelo;
	Cliente cliente;
	Hotel hotel;
	
	public Control_pago(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_pago() {
		this.vista.panelPago.btnConfirmar.addActionListener(this);
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
		else if(e.getSource() == vista.panelPago.btnCancelar) {
			vista.setContentPane(vista.panelBienvenida);
		}else if(e.getSource() == vista.panelPago.btnConfirmar) {
			vista.setContentPane(vista.panelResumen);
//			Control_Resumen.mostrarReserva(); //Revisar la llamada al metodo para mostrar detalles de reserva (resumen)
		}
	}
	
	
	public static void pagar(Vista vis, Cliente cliente){
		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==cliente.NCuenta) {

			System.out.println(cliente.saldo);
			cliente.saldo=cliente.saldo-Double.parseDouble(vis.panelPago.textAPagar.getText());
			vis.panelPago.textAPagar.setText("0");
			System.out.println(cliente.saldo);
			vis.panelPago.btnPagar.setEnabled(false);
			vis.panelPago.btnConfirmar.setEnabled(true);
		}

		else
			JOptionPane.showMessageDialog(null,"Nº cuenta incorrecto","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public static double precio(Vista vis, Hotel hotel) {	
		double precio = (Double.parseDouble(vis.panelReserva.lblCantInd.getText())*hotel.getPrecio())+
				(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())*(hotel.getPrecio()*1.1))+
				(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())*(hotel.getPrecio()*1.2));
		System.out.println(vis.panelReserva.rdbtnWifi.getActionCommand());
		return Math.round(precio);
	}
	
	public static double precioRadios(Vista vis) {
		boolean radioArray[] = {vis.panelReserva.rdbtnWifi.isSelected(),
				vis.panelReserva.rdbtnPiscina.isSelected(),
				vis.panelReserva.rdbtnSpa.isSelected(), 
				vis.panelReserva.rdbtnParking.isSelected(),
				vis.panelReserva.rdbtnAireAcon.isSelected(),
				vis.panelReserva.rdbtnRestaurante.isSelected(),
				vis.panelReserva.rdbtnBar.isSelected(),
				vis.panelReserva.rdbtnGYM.isSelected()};
		double radioPrecio[] = {100,200,300,400,500,600,700,800};
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
}
