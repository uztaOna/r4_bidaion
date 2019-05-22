package vista;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelDespedida extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JLabel label;
	
	public PanelDespedida() {
		setBorder(new LineBorder(SystemColor.desktop, 1, true));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		JLabel lblGraciasPorSu = new JLabel("Gracias por su compra");
		lblGraciasPorSu.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblGraciasPorSu.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraciasPorSu.setBounds(10, 80, 780, 138);
		add(lblGraciasPorSu);
		
		label = new JLabel("");
		label.setBounds(0, 0, 800, 600);
		add(label);
		

	}
}
