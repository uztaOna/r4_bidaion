package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo.*;
import vista.Vista;

public class Control_resumen implements ActionListener, MouseListener {

	Vista vista;
	Modelo modelo;
	/**
	 * declaracion de vista,controlador
	 * @param modelo
	 * @param vista
	 */
	public Control_resumen(Modelo modelo, Vista vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	/**
	 * inicializador de eventos
	 */
	public void inicializar_eventos_resumen() {
		this.vista.panelResumen.btnFin.addActionListener(this);
		this.vista.panelDespedida.label.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.panelResumen.btnFin) {			
			vista.setContentPane(vista.panelDespedida);
			resetBotonesPago(vista);
			Control_login.limpiarLogin(this.vista);
			Control_registro.limpiarRegistro(this.vista);
			Control_hoteles.limpiarBox(vista);
		}
	}
	
	/**
	 * metodo para resetear los botones del panel pago
	 * @param vista
	 */
	public void resetBotonesPago(Vista vista) {
		vista.panelPago.btnPagar.setEnabled(true);
		vista.panelPago.btnConfirmar.setEnabled(false);
		vista.panelPago.btnAtras.setEnabled(true);
		vista.panelPago.btnCancelar.setEnabled(true);
		vista.panelPago.textAPagar.setEnabled(true);
		vista.panelPago.textCuenta.setEnabled(true);		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource() == vista.panelDespedida.label) {	
				vista.setContentPane(vista.panelBienvenida);
			}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
