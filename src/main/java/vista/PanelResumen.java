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

public class PanelResumen extends JPanel {
	public JButton btnFinReser;

	
	public PanelResumen() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		btnFinReser= new JButton("Finalizar Reserva");
		btnFinReser.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnFinReser.setAlignmentY(Component.TOP_ALIGNMENT);
		btnFinReser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinReser.setBounds(653, 536, 101, 23);
		add(btnFinReser);

	}
}
