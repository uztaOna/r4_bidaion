package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.Vista;

public class Control_resumen implements ActionListener {

	Vista vista;
	Modelo modelo;
	
	public Control_resumen(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void inicializar_eventos_resumen() {
		this.vista.panelResumen.btnFin.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelResumen.btnFin) {			
			vista.setContentPane(vista.panelDespedida);
			resetBotonesPago(vista);
		}
	}
	
	/*
	 * Deja los botones que cambiaron de estado al estado con el que empezaron
	 */
	public void resetBotonesPago(Vista vista) {
		vista.panelPago.btnPagar.setEnabled(true);
		vista.panelPago.btnConfirmar.setEnabled(false);
		vista.panelPago.btnAtras.setEnabled(true);
		vista.panelPago.btnCancelar.setEnabled(true);
		vista.panelPago.textAPagar.setEnabled(true);
		vista.panelPago.textCuenta.setEnabled(true);		
	}
	
}
