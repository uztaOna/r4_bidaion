package vista;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import modelo.Hotel;
import javax.swing.JList;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelHoteles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JList<Object> jlistHoteles;
	public DefaultListModel<Object> modeloHoteles = new DefaultListModel<Object>();
	public JButton btnAtras, btnContinuar, btnSeleccionar, btnLogHoteles, btnRegisHoteles;
	public JLabel labelNombreHotel, labelUbicacion, labelPrecio, labelCategoria, lblNombreHotel, lblUbicaci�n, lblPrecio, lblCategor�a, lblUsuarioHotel;
	
	public PanelHoteles() {
		setBackground(new Color(255, 201, 164));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnAtras.setBounds(27, 536, 89, 23);
		add(btnAtras);
				
		jlistHoteles = new JList<Object>();
		jlistHoteles.setBounds(48, 164, 194, 181);
		add(jlistHoteles);
		
		lblNombreHotel = new JLabel("Nombre hotel");
		lblNombreHotel.setBounds(436, 161, 101, 23);
		add(lblNombreHotel);
		
		lblUbicaci�n = new JLabel("Ubicacion");
		lblUbicaci�n.setBounds(436, 208, 101, 23);
		add(lblUbicaci�n);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(436, 252, 101, 23);
		add(lblPrecio);
		
		lblCategor�a = new JLabel("Categoria");
		lblCategor�a.setBounds(436, 303, 101, 23);
		add(lblCategor�a);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnContinuar.setBounds(653, 536, 101, 23);
		add(btnContinuar);
		
		labelNombreHotel = new JLabel("");
		labelNombreHotel.setBounds(574, 161, 101, 23);
		add(labelNombreHotel);
		
		labelUbicacion = new JLabel("");
		labelUbicacion.setBounds(574, 208, 101, 23);
		add(labelUbicacion);
		
		labelPrecio = new JLabel("");
		labelPrecio.setBounds(574, 252, 101, 23);
		add(labelPrecio);
		
		labelCategoria = new JLabel("");
		labelCategoria.setBounds(574, 303, 101, 23);
		add(labelCategoria);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(275, 161, 111, 23);
		add(btnSeleccionar);
		
		btnLogHoteles = new JButton("Logearme");
		btnLogHoteles.setBounds(660, 29, 94, 20);
		add(btnLogHoteles);
		
		btnRegisHoteles = new JButton("Registrarme");
		btnRegisHoteles.setBounds(660, 59, 94, 20);
		add(btnRegisHoteles);
		
		lblUsuarioHotel = new JLabel(" ");
		lblUsuarioHotel.setBounds(497, 29, 153, 50);
		add(lblUsuarioHotel);
		
		

		
		
	}
}
