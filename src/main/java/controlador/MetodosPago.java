package controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Cliente;
import vista.Ventana;

public class MetodosPago {
	
	public static void pagar(Ventana vis, Cliente cliente){
		if(Integer.parseInt(vis.panelPago.textCuenta.getText())==Integer.parseInt(cliente.NCuenta)) {
			System.out.println(cliente.dinero);
			cliente.dinero=cliente.dinero-Integer.parseInt(vis.panelPago.textAPagar.getText());
			vis.panelPago.textAPagar.setText("0");
			System.out.println(cliente.dinero);
		}
		else {
			System.out.println("N� cuenta incorrecto");
		}
	}
	
}
