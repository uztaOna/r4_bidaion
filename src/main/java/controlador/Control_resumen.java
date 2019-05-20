package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
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
	}
}
