package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelResumen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton btnFin;
	public JLabel lblTitulo;
	public JTextArea txtaDatosUser, txtaDatosHotel, txtaDatosRva, txtaDatosPago;
	
	public PanelResumen() {
		setBorder(new LineBorder(SystemColor.desktop, 1, true));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));

		lblTitulo = new JLabel("DETALLES DE LA RESERVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(66, 69, 665, 51);
		add(lblTitulo);
		
		btnFin= new JButton("Imprimir");
		btnFin.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnFin.setAlignmentY(Component.TOP_ALIGNMENT);
		btnFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFin.setBounds(653, 536, 101, 23);
		add(btnFin);
		
		txtaDatosUser = new JTextArea();
		txtaDatosUser.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtaDatosUser.setToolTipText("\r\n");
		txtaDatosUser.setEditable(false);
		txtaDatosUser.setBounds(167, 173, 250, 100);
		add(txtaDatosUser);
		
		txtaDatosHotel = new JTextArea();
		txtaDatosHotel.setBorder(new TitledBorder(null, "Datos alojamiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtaDatosHotel.setToolTipText("\r\n");
		txtaDatosHotel.setEditable(false);
		txtaDatosHotel.setBounds(167, 285, 250, 100);
		add(txtaDatosHotel);
		
		txtaDatosRva = new JTextArea();
		txtaDatosRva.setBorder(new TitledBorder(null, "Datos reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtaDatosRva.setToolTipText("\r\n");
		txtaDatosRva.setEditable(false);
		txtaDatosRva.setBounds(429, 173, 180, 212);
		add(txtaDatosRva);
		
		txtaDatosPago = new JTextArea();
		txtaDatosPago.setBorder(new TitledBorder(null, "Precio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtaDatosPago.setBounds(167, 397, 442, 99);
		add(txtaDatosPago);
	}
}
