package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.Scrollbar;
import javax.swing.JButton;

public class PanelReserva extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JLabel lblHotelSelc, lblIndividual, lblMatrimonio, lbldoble, lblUsuarioReser;
	public JSpinner indspinn, matrispinn,doblespinn;
	public JButton btnReservar, btnLogReserva, btnRegisReser;
	
	
	public PanelReserva() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		lblHotelSelc = new JLabel("El Hotel Seleccionado");
		lblHotelSelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelSelc.setBounds(37, 41, 210, 62);
		add(lblHotelSelc);
		
		lblIndividual = new JLabel("Individual");
		lblIndividual.setBounds(51, 231, 62, 27);
		add(lblIndividual);
		
		lblMatrimonio = new JLabel("Matrimonio");
		lblMatrimonio.setBounds(51, 325, 62, 27);
		add(lblMatrimonio);
		
		lbldoble = new JLabel("Doble");
		lbldoble.setBounds(51, 418, 62, 27);
		add(lbldoble);
		
		indspinn = new JSpinner();
		indspinn.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		indspinn.setBounds(139, 229, 70, 30);
		add(indspinn);
		
		matrispinn = new JSpinner();
		matrispinn.setBounds(139, 323, 70, 30);
		add(matrispinn);
		
		doblespinn = new JSpinner();
		doblespinn.setBounds(139, 416, 70, 30);
		add(doblespinn);
		
		btnReservar= new JButton("Reservar");
		btnReservar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnReservar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnReservar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservar.setBounds(653, 536, 101, 23);
		add(btnReservar);
		
		btnLogReserva = new JButton("Logearme");
		btnLogReserva.setBounds(671, 31, 94, 20);
		add(btnLogReserva);
		
		lblUsuarioReser = new JLabel(" ");
		lblUsuarioReser.setBounds(508, 31, 153, 50);
		add(lblUsuarioReser);
		
		btnRegisReser = new JButton("Registrarme");
		btnRegisReser.setBounds(671, 61, 94, 20);
		add(btnRegisReser);	

	}
}
