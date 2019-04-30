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
	
	
	public JLabel lblBienvenido;
	public JButton btnContinuar;
	
	public PanelBienvenida() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		btnContinuar = new JButton("Reservar");
		btnContinuar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnContinuar.setBounds(193, 496, 395, 23);
		add(btnContinuar);
		
		lblBienvenido = new JLabel("Bienvenida a BiDaiOn");
		lblBienvenido.setFont(new Font("Yu Gothic UI", Font.PLAIN, 34));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(182, 59, 411, 103);
		add(lblBienvenido);

	}
}
