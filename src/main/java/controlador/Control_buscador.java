package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.beans.PropertyChangeEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		Date fechaInicio = vista.panelBuscador.dateInicio.getDate();
		
		if(e.getSource() == this.vista.panelBuscador.dateInicio) {
			this.vista.panelBuscador.btnContinuar.setEnabled(true);
		}
		else if(e.getSource() == this.vista.panelBuscador.btnContinuar) {
			Control_hoteles.addHotelesJList(modelo, vista);	
			this.vista.setContentPane(vista.panelHoteles);
			sumarDiasAFecha(fechaInicio, getPernoctaciones(vista));
			Control_hoteles.showDestinoBuscador(vista);
			Control_hoteles.showFechaBuscador(vista);
			System.out.println("LLEGADA: " + fechaInicio + "         DIAS:" + getPernoctaciones(vista));
		}
		else if(e.getSource() == this.vista.panelBuscador.btnCancelar) {
			this.vista.setContentPane(vista.panelBienvenida);
			limpiarinfoHotelSelec(vista);
		}
		else if (e.getSource() == this.vista.panelBuscador.spinnerDias) {
			sumarDiasAFecha(fechaInicio, getPernoctaciones(vista));
			System.out.println("LLEGADA: " + fechaInicio + "         DIAS:" + getPernoctaciones(vista));
		}
	}
	
	/*
	 * Devuelve la fecha en String al pasarle un parametro Date
	 */
	public static String fechaToString(Date fechaInicio){
		String patron = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(patron);
		Date fInicio = fechaInicio;
		String fInicioString = df.format(fInicio);
		
		return fInicioString;
	}
	
	/*
	 * Devuelve en valor int el valor seleccionado del Spinner
	 */
	public static int getPernoctaciones(Vista vista) {
		int pernoctaciones = (Integer)vista.panelBuscador.spinnerDias.getValue();
		return pernoctaciones;
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
	
	//Determinar si la fecha seleccionada esta dentro de temporada alta o temporada baja
//	public static boolean evaluarLimite(Date date1, Date date2) {
//	    boolean correcto = false;
//	    long diferencia = (Math.abs(date1.getTime() - date2.getTime())) / 1000;
//	    long limit = (60 * 1000) / 1000L;//limite de tiempo
//
//	    if (diferencia <= limit) {
//	        correcto= true;
//	    }
//	    return correcto;
//	}
	
	//Acciones de los eventos de PropertyChangeListener (date)
	public void propertyChange(PropertyChangeEvent e) {
	}
	
	/*
	 * Limpia los valores insertados en el panelHoteles
	 */
	public static void limpiarinfoHotelSelec(Vista vista) {
		vista.panelHoteles.categoria.setText("");
		vista.panelHoteles.precio.setText("");
		vista.panelHoteles.destino.setText("");
		vista.panelHoteles.fLLegada.setText("");
		vista.panelHoteles.fSalida.setText("");
		vista.panelHoteles.btnContinuar.setEnabled(false);
	}
	
}
