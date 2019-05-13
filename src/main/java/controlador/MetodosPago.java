package controlador;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Hotel;
import vista.Ventana;

public class MetodosPago {
	
	public static void pagar(Ventana vis, Cliente cliente){
		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==cliente.NCuenta) {

			System.out.println(cliente.saldo);
			cliente.saldo=cliente.saldo-Double.parseDouble(vis.panelPago.textAPagar.getText());
			vis.panelPago.textAPagar.setText("0");
			System.out.println(cliente.saldo);
			vis.panelPago.btnPagar.setEnabled(false);
			vis.panelPago.btnConfirmar.setEnabled(true);
		}
	
		else {
			JOptionPane.showMessageDialog(null,"Nº cuenta incorrecto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static double precio(Ventana vis, Hotel hotel) {	
		double precio = (Double.parseDouble(vis.panelReserva.lblCantInd.getText())*hotel.getPrecio())+
				(Double.parseDouble(vis.panelReserva.lblCantMatri.getText())*(hotel.getPrecio()*1.1))+
				(Double.parseDouble(vis.panelReserva.lblCantDoble.getText())*(hotel.getPrecio()*1.2));
		System.out.println(vis.panelReserva.rdbtnWifi.getActionCommand());
		return Math.round(precio);
	}
}
