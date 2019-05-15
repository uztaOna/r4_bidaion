package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PanelBuscador extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public JLabel lblDestino, lblTitulo, lblFechaInicio, numDias;
	public JButton btnContinuar, btnCancelar;
	public JComboBox<String> comboBox;
	public JDateChooser dateInicio;
	public JSpinner spinnerDias;
	
	public PanelBuscador() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setBounds(257, 304, 71, 23);
		add(lblDestino);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnContinuar.setBounds(653, 536, 101, 23);
		add(btnContinuar);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(362, 304, 196, 22);
		add(comboBox);
		
		lblTitulo = new JLabel("Escoja su destino");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(187, 121, 451, 126);
		add(lblTitulo);
		
		lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(257, 347, 107, 20);
		add(lblFechaInicio);
		
		dateInicio = new JDateChooser();
		dateInicio.setBounds(403, 347, 155, 20);
		add(dateInicio);
		
		numDias = new JLabel("N\u00FAmero de d\u00EDas");
		numDias.setBounds(257, 386, 107, 14);
		add(numDias);
		
		spinnerDias = new JSpinner();
		spinnerDias.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerDias.setBounds(501, 383, 57, 20);
		add(spinnerDias);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setBounds(22, 536, 107, 23);
		add(btnCancelar);
		
	}
}
