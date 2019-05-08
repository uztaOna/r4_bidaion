package controlador;

import javax.swing.JOptionPane;

import modelo.Cliente;
import vista.Ventana;

public class MetodosPago {
	
	public static void pagar(Ventana vis, Cliente cliente){
		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==cliente.NCuenta) {
			System.out.println(cliente.saldo);
			cliente.saldo=cliente.saldo-Integer.parseInt(vis.panelPago.textAPagar.getText());
			vis.panelPago.textAPagar.setText("0");
			System.out.println(cliente.saldo);
		}
	
		else {
			JOptionPane.showMessageDialog(null,"Nº cuenta incorrecto","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
