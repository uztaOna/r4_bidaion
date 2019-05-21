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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelReserva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	
	public JLabel nomHotel, lblUsuarioReser, lblInDisp, lblMatriDisp, lblDobleDisp, lblCantInd, lblCantMatri, lblCantDoble,
				  lblCamasDiponibles, lblCantSeleccionada, lblServicios, lblCamasInd, lblCamasMatri, lblCamasDoble,
				  lblFllegada, lblFSalida, fLLegada, fSalida, destino;
	public JButton btnReservar, btnLogin, btnRegistro, btnIndividual, btnMatrimonio, btnDoble, btnCancelar, btnAtras,
				   btnMasInd,btnMenosInd, btnMasMatri, btnMenosMatri, btnMasDoble, btnMenosDoble;
	public JRadioButton rdbtnWifi, rdbtnPiscina, rdbtnSpa, rdbtnParking, rdbtnAireAcon, rdbtnRestaurante, rdbtnBar, rdbtnGYM;

	public PanelReserva() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		nomHotel = new JLabel("Hotel Seleccionado");
		nomHotel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		nomHotel.setHorizontalAlignment(SwingConstants.LEFT);
		nomHotel.setBounds(37, 67, 210, 36);
		add(nomHotel);
		
		btnReservar= new JButton("Reservar");
		btnReservar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnReservar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnReservar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservar.setBounds(664, 535, 101, 23);
		add(btnReservar);
		
		btnLogin = new JButton("Iniciar Sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(653, 31, 112, 20);
		add(btnLogin);
		
		lblUsuarioReser = new JLabel(" ");
		lblUsuarioReser.setBounds(508, 31, 135, 50);
		add(lblUsuarioReser);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(653, 61, 112, 20);
		add(btnRegistro);	
		
		btnIndividual = new JButton("INDIVIDUAL");
		btnIndividual.setIcon(new ImageIcon(PanelReserva.class.getResource("/imagenes/camaIndividual.jpg")));
		btnIndividual.setBounds(126, 145, 165, 140);
		add(btnIndividual);
		
		 btnMatrimonio = new JButton("MATRIMONIO");
		 btnMatrimonio.setIcon(new ImageIcon(PanelReserva.class.getResource("/imagenes/camaMatrimonio.jpg")));
		btnMatrimonio.setBounds(351, 145, 165, 140);
		add(btnMatrimonio);
		
		 btnDoble = new JButton("DOBLE");
		 btnDoble.setIcon(new ImageIcon(PanelReserva.class.getResource("/imagenes/camaDoble.jpg")));
		btnDoble.setBounds(574, 145, 165, 140);
		add(btnDoble);
		
		 lblInDisp = new JLabel("(0 disponibles) ");
		 lblInDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInDisp.setBounds(126, 344, 165, 21);
		add(lblInDisp);
		
		lblMatriDisp = new JLabel("(0 disponibles) ");
		lblMatriDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriDisp.setBounds(351, 344, 165, 21);
		add(lblMatriDisp);
		
		lblDobleDisp = new JLabel("(0 disponibles) ");
		lblDobleDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobleDisp.setBounds(574, 344, 165, 21);
		add(lblDobleDisp);
		
		rdbtnWifi = new JRadioButton("Wifi");
		rdbtnWifi.setBackground(new Color(255, 201, 164));
		rdbtnWifi.setActionCommand("100");
		rdbtnWifi.setBounds(186, 469, 109, 23);
		add(rdbtnWifi);
		
		rdbtnPiscina = new JRadioButton("Piscina");
		rdbtnPiscina.setBounds(186, 496, 109, 23);
		rdbtnPiscina.setBackground(new Color(255, 201, 164));
		add(rdbtnPiscina);
		
		rdbtnSpa = new JRadioButton("Spa");
		rdbtnSpa.setBounds(306, 469, 109, 23);
		rdbtnSpa.setBackground(new Color(255, 201, 164));
		add(rdbtnSpa);
		
		rdbtnParking = new JRadioButton("Parking");
		rdbtnParking.setBounds(306, 496, 109, 23);
		rdbtnParking.setBackground(new Color(255, 201, 164));
		add(rdbtnParking);
		
		rdbtnAireAcon = new JRadioButton("Aire Acondicionado");
		rdbtnAireAcon.setBounds(432, 469, 140, 23);
		rdbtnAireAcon.setBackground(new Color(255, 201, 164));
		add(rdbtnAireAcon);
		
		rdbtnRestaurante = new JRadioButton("Restaurante");
		rdbtnRestaurante.setBounds(432, 496, 117, 23);
		rdbtnRestaurante.setBackground(new Color(255, 201, 164));
		add(rdbtnRestaurante);
		
		rdbtnBar = new JRadioButton("Bar");
		rdbtnBar.setBounds(574, 469, 109, 23);
		rdbtnBar.setBackground(new Color(255, 201, 164));
		add(rdbtnBar);
		
		rdbtnGYM = new JRadioButton("Gimnasio");
		rdbtnGYM.setBounds(574, 496, 109, 23);
		rdbtnGYM.setBackground(new Color(255, 201, 164));
		add(rdbtnGYM);
		
		lblCantInd = new JLabel("0");
		lblCantInd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantInd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantInd.setBounds(126, 390, 165, 23);
		lblCantInd.setBackground(new Color(153, 255, 153));
		add(lblCantInd);
		
		lblCantMatri = new JLabel("0");
		lblCantMatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantMatri.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantMatri.setBounds(351, 390, 165, 23);
		add(lblCantMatri);
		
		lblCantDoble = new JLabel("0");
		lblCantDoble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantDoble.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantDoble.setBounds(574, 390, 165, 23);
		add(lblCantDoble);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnCancelar.setAlignmentY(0.0f);
		btnCancelar.setBounds(27, 535, 101, 23);
		add(btnCancelar);
		
		
		lblCamasDiponibles = new JLabel("Disponibles:");
		lblCamasDiponibles.setBounds(37, 344, 118, 21);
		add(lblCamasDiponibles);
		
		lblCantSeleccionada = new JLabel("Seleccionadas:");
		lblCantSeleccionada.setBounds(37, 391, 118, 21);
		add(lblCantSeleccionada);
		
		lblServicios = new JLabel("Servicios Extra:");
		lblServicios.setBounds(27, 470, 110, 21);
		add(lblServicios);
		
		lblCamasInd = new JLabel("Habitaci\u00F3n Individual");
		lblCamasInd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamasInd.setBounds(126, 114, 165, 21);
		add(lblCamasInd);
	
		lblCamasMatri = new JLabel("Habitaci\u00F3n Matrimonio");
		lblCamasMatri.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamasMatri.setBounds(351, 114, 165, 21);
		add(lblCamasMatri);
		
		lblCamasDoble = new JLabel("Habitaci\u00F3n Doble");
		lblCamasDoble.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamasDoble.setBounds(574, 113, 165, 21);
		add(lblCamasDoble);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnAtras.setAlignmentY(0.0f);
		btnAtras.setBounds(27, 502, 101, 23);
		add(btnAtras);
		
		btnMasInd = new JButton("+");
		btnMasInd.setBounds(136, 296, 64, 23);
		add(btnMasInd);
		
		btnMenosInd = new JButton("-");
		btnMenosInd.setBounds(215, 296, 64, 23);
		add(btnMenosInd);
		
		btnMasMatri = new JButton("+");
		btnMasMatri.setBounds(361, 296, 64, 23);
		add(btnMasMatri);
		
		btnMenosMatri = new JButton("-");
		btnMenosMatri.setBounds(440, 296, 64, 23);
		add(btnMenosMatri);
		
		btnMasDoble = new JButton("+");
		btnMasDoble.setBounds(584, 296, 64, 23);
		add(btnMasDoble);
		
		btnMenosDoble = new JButton("-");
		btnMenosDoble.setBounds(663, 296, 64, 23);
		add(btnMenosDoble);
		
		lblFllegada = new JLabel("Fecha de llegada");
		lblFllegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFllegada.setBounds(257, 28, 112, 23);
		add(lblFllegada);
		
		lblFSalida = new JLabel("Fecha de salida");
		lblFSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFSalida.setBounds(405, 28, 111, 23);
		add(lblFSalida);
		
		fLLegada = new JLabel("");
		fLLegada.setVerticalAlignment(SwingConstants.TOP);
		fLLegada.setHorizontalAlignment(SwingConstants.CENTER);
		fLLegada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fLLegada.setBounds(257, 46, 112, 35);
		add(fLLegada);
		
		fSalida = new JLabel("");
		fSalida.setVerticalAlignment(SwingConstants.TOP);
		fSalida.setHorizontalAlignment(SwingConstants.CENTER);
		fSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fSalida.setBounds(405, 46, 112, 35);
		add(fSalida);
		
		destino = new JLabel("");
		destino.setHorizontalAlignment(SwingConstants.LEFT);
		destino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		destino.setBounds(37, 31, 194, 36);
		add(destino);

	}
}
