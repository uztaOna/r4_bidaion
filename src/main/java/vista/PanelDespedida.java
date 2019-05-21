package vista;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class PanelDespedida extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelDespedida() {
		setBorder(new LineBorder(SystemColor.desktop, 1, true));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		JLabel lblGraciasPorSu = new JLabel("Gracias por su compra");
		lblGraciasPorSu.setBounds(314, 206, 132, 138);
		add(lblGraciasPorSu);
		

	}
}
