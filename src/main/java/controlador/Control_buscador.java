package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import modelo.Modelo;
import vista.Ventana;

public class Control_buscador implements ActionListener, ContainerListener {

	Modelo modelo;
	Ventana vista;
	
	public Control_buscador (Modelo modelo,Ventana vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializar_eventos_buscador()
	{
		this.vista.panelBuscador.btnContinuar.addActionListener(this);
		this.vista.panelBuscador.spinnerDias.addContainerListener(this);
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			this.vista.setContentPane(vista.panelHoteles);
		}
	}
	
	
}
