package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class PanelBuscador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JLabel lblUbicacion, lblEscojaElDestino;
	public JButton btnContinuar;
	public JComboBox<String> comboBox;
	
	public PanelBuscador() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		lblUbicacion = new JLabel("Ubicaci\u00F3n");
		lblUbicacion.setBounds(257, 304, 71, 23);
		add(lblUbicacion);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnContinuar.setBounds(653, 536, 101, 23);
		add(btnContinuar);
		
		comboBox = new JComboBox<String>();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bilbao", "Madrid", "Otros"}));
		comboBox.setBounds(329, 304, 229, 22);
		add(comboBox);
		
		lblEscojaElDestino = new JLabel("Escoja el destino de su reserva");
		lblEscojaElDestino.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblEscojaElDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscojaElDestino.setBounds(187, 121, 451, 126);
		add(lblEscojaElDestino);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(398, 337, 95, 20);
		add(dateChooser);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(284, 347, 80, 20);
		add(lblFechaInicio);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(430, 383, 41, 20);
		add(spinner);
		
		JLabel lblNmeroDeDas = new JLabel("N\u00FAmero de d\u00EDas");
		lblNmeroDeDas.setBounds(282, 386, 82, 14);
		add(lblNmeroDeDas);
		
		
		
		
		
	}
}
