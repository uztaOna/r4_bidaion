package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class PanelPago extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JButton btnConfirmar, btnCancelar, btnPagar;
	public JLabel label_2, lblNCuenta, lblPrecioTotal;
	public JTextField textAPagar, textCuenta;
	@SuppressWarnings("rawtypes")
	public DefaultListModel modeloCambio;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelPago() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnConfirmar.setAlignmentY(Component.TOP_ALIGNMENT);
		//btnConfirmar.setBackground(new Color(192, 192, 192));
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(653, 536, 101, 23);
		add(btnConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(Component.TOP_ALIGNMENT);
		//btnCancelar.setBackground(new Color(192, 192, 192));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(56, 536, 101, 23);
		add(btnCancelar);
		
		label_2 = new JLabel("\u20AC");
		label_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		label_2.setBounds(445, 66, 29, 35);
		add(label_2);
		
		textAPagar = new JTextField();
		textAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		textAPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAPagar.setBounds(331, 60, 104, 42);
		add(textAPagar);
		textAPagar.setColumns(10);
		
		modeloCambio= new DefaultListModel<String>();
		textAPagar.setText("0.00");
		btnConfirmar.setEnabled(false);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(277, 345, 247, 83);
		add(btnPagar);
		
		textCuenta = new JTextField();
		textCuenta.setText("000000");
		textCuenta.setBounds(277, 252, 247, 25);
		add(textCuenta);
		textCuenta.setColumns(10);
		
		lblNCuenta = new JLabel("N\u00BA Cuenta");
		lblNCuenta.setBounds(277, 166, 130, 25);
		add(lblNCuenta);
		
		lblPrecioTotal = new JLabel("El precio total de su reserva ser\u00E1 de:");
		lblPrecioTotal.setBounds(56, 66, 254, 35);
		add(lblPrecioTotal);
	}
	
	/*
	public void ActDesBotones(boolean estado) {
		for (int i = 0; i < arrayBtn.length; i++) {
			arrayBtn[i].setEnabled(estado);
		}
	}
	*/

}
