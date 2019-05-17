package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javafx.scene.control.Spinner;
import modelo.Hotel;
import modelo.Modelo;
import vista.Vista;

public class Control_buscador implements ActionListener, ContainerListener {

	Modelo modelo;
	Vista vista;
	
	public Control_buscador (Modelo modelo,Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializar_eventos_buscador()
	{
		this.vista.panelBuscador.btnContinuar.addActionListener(this);
		this.vista.panelBuscador.btnCancelar.addActionListener(this);
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
		int pernoctaciones = (Integer)vista.panelBuscador.spinnerDias.getValue();
		Date fechaInicio = vista.panelBuscador.dateInicio.getDate();
		
		if(e.getSource() == this.vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			this.vista.setContentPane(vista.panelHoteles);
			sumarDiasAFecha(fechaInicio, pernoctaciones);
			System.out.println("LLEGADA: " + fechaInicio + "         DIAS:" + pernoctaciones);
		}
		else if(e.getSource() == this.vista.panelBuscador.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
			limpiarinfoHotelSelec(vista);
		}
//		else if(e.getSource() == this.vista.panelBuscador.dateInicio) {
//			Date fechaInicio = vista.panelBuscador.dateInicio.getDate();
//		}
		else if (e.getSource() == this.vista.panelBuscador.spinnerDias) {
			sumarDiasAFecha(fechaInicio, pernoctaciones);
			System.out.println("LLEGADA: " + fechaInicio + "         DIAS:" + pernoctaciones);
		}
	}
	
	public static Date sumarDiasAFecha(Date fechaInicio, int pernoctaciones){
		int dias = pernoctaciones;
		if (dias==0) {
			  return fechaInicio;
		}
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(fechaInicio); 
		calendar.add(Calendar.DAY_OF_MONTH, dias);  
		return calendar.getTime();   
	}
//	Date fechaFinal = variarFecha(fechaInicio, Calendar.HOUR, 1000);
	
	//Acciones de los eventos de PropertyChangeListener (date)
	public void propertyChange(PropertyChangeEvent e) {
		
	}
	
	public static void limpiarinfoHotelSelec(Vista vista) {
		vista.panelHoteles.ubicacion.setText("");
		vista.panelHoteles.categoria.setText("");
		vista.panelHoteles.precio.setText("");
		vista.panelHoteles.btnContinuar.setEnabled(false);
	}
	
}
