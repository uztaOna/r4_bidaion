package vista;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.Font;

public class PanelBienvenida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JLabel lblTitulo;
	public JButton btnInicio;
	
	public PanelBienvenida() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		btnInicio = new JButton("Reservar");
		btnInicio.setBounds(174, 319, 411, 55);
		add(btnInicio);
		
		lblTitulo = new JLabel("Bienvenida a BiDaiOn");
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 34));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(174, 128, 411, 124);
		add(lblTitulo);

	}
}
