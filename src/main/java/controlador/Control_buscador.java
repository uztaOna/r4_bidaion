package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import modelo.Modelo;
import vista.Vista;

public class Control_buscador implements ActionListener, ContainerListener, PropertyChangeListener {

	Modelo modelo;
	Vista vista;
	
	public Control_buscador (Modelo modelo,Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	//Inicializacion de eventos Listeners del panel
	public void inicializar_eventos_buscador()
	{
		this.vista.panelBuscador.btnContinuar.addActionListener(this);
		this.vista.panelBuscador.btnCancelar.addActionListener(this);
		this.vista.panelBuscador.spinnerDias.addContainerListener(this);
		this.vista.panelBuscador.dateInicio.addPropertyChangeListener(this);
	}

	//Acciones de los eventos de ActionListeners
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			this.vista.setContentPane(vista.panelHoteles);
		}
		else if(e.getSource() == this.vista.panelBuscador.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
			limpiarinfoHotelSelec(vista);
		}
		else if (e.getSource() == this.vista.panelBuscador.dateInicio) {
			
		}
		else if (e.getSource() == this.vista.panelBuscador.spinnerDias) {
			
		}
	}
	
	//Acciones de los eventos de PropertyChangeListener (date)
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
	}
	
	public static void limpiarinfoHotelSelec(Vista vista) {
		vista.panelHoteles.ubicacion.setText("");
		vista.panelHoteles.categoria.setText("");
		vista.panelHoteles.precio.setText("");
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		// TODO Auto-generated method stub
	}
}
