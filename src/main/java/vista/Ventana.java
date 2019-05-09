package vista;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	//private JPanel contentPane;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelBienvenida panelBienvenida;
	public PanelBuscador panelBuscador;
	public PanelHoteles panelHoteles;
	public PanelLogin panelLogin;
	public PanelRegistro panelRegistro;
	public PanelReserva panelReserva;
	public PanelPago panelPago;	
	public PanelResumen panelResumen;	
	
	public Ventana() {
		
		panelBienvenida=new PanelBienvenida();
		panelBuscador=new PanelBuscador();
		panelHoteles=new PanelHoteles();
		panelPago=new PanelPago();
		panelLogin=new PanelLogin();
		panelRegistro=new PanelRegistro();
		panelReserva=new PanelReserva();
		panelPago=new PanelPago();
		panelResumen=new PanelResumen();

		getContentPane().add(panelBienvenida);
		getContentPane().add(panelBuscador);
		getContentPane().add(panelHoteles);
		getContentPane().add(panelLogin);
		getContentPane().add(panelRegistro);
		getContentPane().add(panelReserva);
		getContentPane().add(panelPago);	
		getContentPane().add(panelResumen);	
		
		//Inicializacion de variables
		
		setResizable(false);
		setBounds(0, 0, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		setTitle("BiDaiOn"); 
		setLocationRelativeTo(null);
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
	}
	
	  

}
