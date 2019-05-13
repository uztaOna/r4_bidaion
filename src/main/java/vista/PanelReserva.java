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

public class PanelReserva extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JLabel lblHotelSelc, lblUsuarioReser, lblInDisp, lblMatriDisp, lblDobleDisp, lblCantInd, lblCantMatri, lblCantDoble,
				  lblCamasDiponibles, lblCantSeleccionada, lblServicios, lblCamasInd, lblCamasMatri, lblCamasDoble;
	public JButton btnReservar, btnLogReserva, btnRegisReser, btnIndividual, btnMatrimonio, btnDoble, btnCancelar, btnAtras,
				   btnMasInd,btnMenosInd, btnMasMatri, btnMenosMatri, btnMasDoble, btnMenosDoble;
	public JRadioButton rdbtnWifi, rdbtnPiscina, rdbtnSpa, rdbtnParking, rdbtnAireAcon, rdbtnRestaurante, rdbtnBar, rdbtnGYM;


	
	public PanelReserva() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));
		
		lblHotelSelc = new JLabel("El Hotel Seleccionado");
		lblHotelSelc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelSelc.setBounds(37, 40, 210, 62);
		add(lblHotelSelc);
		
		btnReservar= new JButton("Reservar");
		btnReservar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnReservar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnReservar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservar.setBounds(653, 536, 101, 23);
		add(btnReservar);
		
		btnLogReserva = new JButton("Loguearme");
		btnLogReserva.setBounds(671, 31, 94, 20);
		add(btnLogReserva);
		
		lblUsuarioReser = new JLabel(" ");
		lblUsuarioReser.setBounds(508, 31, 153, 50);
		add(lblUsuarioReser);
		
		btnRegisReser = new JButton("Registrarme");
		btnRegisReser.setBounds(671, 61, 94, 20);
		add(btnRegisReser);	
		
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
		rdbtnWifi.setBounds(186, 469, 109, 23);
		add(rdbtnWifi);
		
		rdbtnPiscina = new JRadioButton("Piscina");
		rdbtnPiscina.setBounds(186, 496, 109, 23);
		add(rdbtnPiscina);
		
		rdbtnSpa = new JRadioButton("Spa");
		rdbtnSpa.setBounds(306, 469, 109, 23);
		add(rdbtnSpa);
		
		rdbtnParking = new JRadioButton("Parking");
		rdbtnParking.setBounds(306, 496, 109, 23);
		add(rdbtnParking);
		
		rdbtnAireAcon = new JRadioButton("Aire Acondicionado");
		rdbtnAireAcon.setBounds(432, 469, 117, 23);
		add(rdbtnAireAcon);
		
		rdbtnRestaurante = new JRadioButton("Restaurante");
		rdbtnRestaurante.setBounds(432, 496, 117, 23);
		add(rdbtnRestaurante);
		
		rdbtnBar = new JRadioButton("Bar");
		rdbtnBar.setBounds(567, 469, 109, 23);
		add(rdbtnBar);
		
		rdbtnGYM = new JRadioButton("Gimnasio");
		rdbtnGYM.setBounds(567, 496, 109, 23);
		add(rdbtnGYM);
		
		lblCantInd = new JLabel("0");
		lblCantInd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantInd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantInd.setBounds(126, 390, 165, 23);
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
		btnCancelar.setBounds(27, 536, 101, 23);
		add(btnCancelar);
		
		
		lblCamasDiponibles = new JLabel("Disponibles");
		lblCamasDiponibles.setBounds(10, 344, 110, 21);
		add(lblCamasDiponibles);
		
		lblCantSeleccionada = new JLabel("Cant. seleccionada:");
		lblCantSeleccionada.setBounds(10, 391, 118, 21);
		add(lblCantSeleccionada);
		
		lblServicios = new JLabel("Servicios Adicionales:");
		lblServicios.setBounds(10, 469, 110, 21);
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
		btnAtras.setBounds(146, 536, 101, 23);
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

	}
}
