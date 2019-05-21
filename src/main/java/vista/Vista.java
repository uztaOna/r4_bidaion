package vista;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class Vista extends JFrame {

	//private JPanel contentPane;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelBienvenida panelBienvenida;
	public PanelBuscador panelBuscador;
	public PanelHoteles panelHoteles;
	public PanelRegistro panelRegistro;
	public PanelLogin panelLogin;
	public PanelReserva panelReserva;
	public PanelPago panelPago;	
	public PanelResumen panelResumen;	
	public PanelDespedida panelDespedida;
	
	public Vista() {
		
		panelBienvenida=new PanelBienvenida();
		panelBuscador=new PanelBuscador();
		panelHoteles=new PanelHoteles();
		panelPago=new PanelPago();
		panelRegistro=new PanelRegistro();
		panelLogin=new PanelLogin();
		panelReserva=new PanelReserva();
		panelPago=new PanelPago();
		panelResumen=new PanelResumen();
		panelDespedida=new PanelDespedida();

		getContentPane().add(panelBienvenida);
		getContentPane().add(panelBuscador);
		getContentPane().add(panelHoteles);
		getContentPane().add(panelRegistro);
		getContentPane().add(panelLogin);
		getContentPane().add(panelReserva);
		getContentPane().add(panelPago);	
		getContentPane().add(panelResumen);
		getContentPane().add(panelDespedida);	
		
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
