package vista;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelHoteles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JList<String> JListHoteles;
	public DefaultListModel<String> modeloHoteles = new DefaultListModel<String>();
	public JButton btnAtras, btnContinuar, btnSeleccionar, btnLogin, btnRegistro, btnCancelar;
	public JLabel lblNomHotel, precio, categoria, lblNombreHotel, lblPrecio, 
	lblCategoría, lblUser, lblUsuarioHotel, lblDestino, destino, lblFLlegada, lblFechaSalida, fLLegada,fSalida;
	private JLabel lblHabitaciones;
	private JLabel qHabs;
	
	public PanelHoteles() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnContinuar.setBounds(653, 536, 101, 23);
		btnContinuar.setEnabled(false);
		add(btnContinuar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnAtras.setBounds(27, 502, 89, 23);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setBounds(27, 536, 89, 23);
		add(btnCancelar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(252, 300, 111, 26);
		add(btnSeleccionar);
		
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.setBounds(643, 29, 111, 20);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(643, 59, 111, 20);
		add(btnRegistro); 
				
		JListHoteles = new JList<String>();
		JListHoteles.setBounds(48, 164, 194, 260);
		add(JListHoteles);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecio.setBounds(426, 368, 101, 23);
		add(lblPrecio);
		
		lblCategoría = new JLabel("Categoría");
		lblCategoría.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoría.setBounds(426, 300, 101, 23);
		add(lblCategoría);
		
		precio = new JLabel("");
		precio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		precio.setBounds(574, 368, 101, 23);
		add(precio);
		
		categoria = new JLabel("");
		categoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoria.setBounds(574, 300, 101, 23);
		add(categoria);
		
		lblUser = new JLabel("");
		lblUser.setBounds(497, 29, 135, 50);
		add(lblUser);
		
		lblUsuarioHotel = new JLabel(" ");
		lblUsuarioHotel.setBounds(497, 29, 153, 50);
		add(lblUsuarioHotel);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setBounds(48, 28, 89, 23);
		add(lblDestino);
		
		destino = new JLabel("");
		destino.setFont(new Font("Tahoma", Font.PLAIN, 32));
		destino.setBounds(48, 59, 194, 50);
		add(destino);
		
		lblFLlegada = new JLabel("Fecha de llegada");
		lblFLlegada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFLlegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFLlegada.setBounds(426, 164, 112, 23);
		add(lblFLlegada);
		
		lblFechaSalida = new JLabel("Fecha de salida");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSalida.setBounds(574, 164, 111, 23);
		add(lblFechaSalida);
		
		fLLegada = new JLabel("");
		fLLegada.setHorizontalAlignment(SwingConstants.CENTER);
		fLLegada.setVerticalAlignment(SwingConstants.TOP);
		fLLegada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fLLegada.setBounds(426, 200, 112, 35);
		add(fLLegada);
		
		fSalida = new JLabel("");
		fSalida.setHorizontalAlignment(SwingConstants.CENTER);
		fSalida.setVerticalAlignment(SwingConstants.TOP);
		fSalida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fSalida.setBounds(574, 200, 112, 35);
		add(fSalida);
		
		lblHabitaciones = new JLabel("Habitaciones");
		lblHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHabitaciones.setBounds(426, 269, 101, 23);
		add(lblHabitaciones);
		
		qHabs = new JLabel("");
		qHabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		qHabs.setBounds(574, 269, 101, 23);
		add(qHabs);
	}
}
