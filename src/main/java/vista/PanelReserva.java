package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class PanelReserva extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JLabel lblHotelSelc, lblUsuarioReser, lblInDisp, lblMatriDisp, lblDobleDisp, lblCantInd, lblCantMatri, lblCantDoble;
	public JButton btnReservar, btnLogReserva, btnRegisReser, btnIndividual, btnMatrimonio, btnDoble, btnCancelar;
	public JRadioButton rdbtnWifi, rdbtnPiscina, rdbtnSpa, rdbtnParking, rdbtnAireAcon, rdbtnRestaurante, rdbtnBar, rdbtnGYM;

	
	public PanelReserva() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		lblHotelSelc = new JLabel("El Hotel Seleccionado");
		lblHotelSelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelSelc.setBounds(37, 41, 210, 62);
		add(lblHotelSelc);
		
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
		
		btnIndividual = new JButton("INDIVIDUAL");
		btnIndividual.setBounds(306, 274, 110, 50);
		add(btnIndividual);
		
		 btnMatrimonio = new JButton("MATRIMONIO");
		btnMatrimonio.setBounds(431, 274, 119, 56);
		add(btnMatrimonio);
		
		 btnDoble = new JButton("DOBLE");
		btnDoble.setBounds(572, 274, 119, 50);
		add(btnDoble);
		
		 lblInDisp = new JLabel("(0 disponibles) ");
		lblInDisp.setBounds(306, 331, 110, 21);
		add(lblInDisp);
		
		lblMatriDisp = new JLabel("(0 disponibles) ");
		lblMatriDisp.setBounds(431, 331, 110, 21);
		add(lblMatriDisp);
		
		lblDobleDisp = new JLabel("(0 disponibles) ");
		lblDobleDisp.setBounds(572, 331, 110, 21);
		add(lblDobleDisp);
		
		rdbtnWifi = new JRadioButton("Wifi");
		rdbtnWifi.setBounds(307, 416, 109, 23);
		add(rdbtnWifi);
		
		rdbtnPiscina = new JRadioButton("Piscina");
		rdbtnPiscina.setBounds(306, 442, 109, 23);
		add(rdbtnPiscina);
		
		rdbtnSpa = new JRadioButton("Spa");
		rdbtnSpa.setBounds(306, 469, 109, 23);
		add(rdbtnSpa);
		
		rdbtnParking = new JRadioButton("Parking");
		rdbtnParking.setBounds(306, 496, 109, 23);
		add(rdbtnParking);
		
		rdbtnAireAcon = new JRadioButton("Aire Acondicionado");
		rdbtnAireAcon.setBounds(432, 418, 109, 23);
		add(rdbtnAireAcon);
		
		rdbtnRestaurante = new JRadioButton("Restaurante");
		rdbtnRestaurante.setBounds(431, 444, 109, 23);
		add(rdbtnRestaurante);
		
		rdbtnBar = new JRadioButton("Bar");
		rdbtnBar.setBounds(431, 471, 109, 23);
		add(rdbtnBar);
		
		rdbtnGYM = new JRadioButton("Gimnasio");
		rdbtnGYM.setBounds(431, 498, 109, 23);
		add(rdbtnGYM);
		
		lblCantInd = new JLabel("0");
		lblCantInd.setBounds(306, 356, 101, 23);
		add(lblCantInd);
		
		lblCantMatri = new JLabel("0");
		lblCantMatri.setBounds(431, 363, 101, 23);
		add(lblCantMatri);
		
		lblCantDoble = new JLabel("0");
		lblCantDoble.setBounds(572, 363, 101, 23);
		add(lblCantDoble);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(0.0f);
		btnCancelar.setBounds(27, 536, 101, 23);
		add(btnCancelar);

	}
}
