package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;

public class PanelResumen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton btnFin;
	public JLabel lblTitulo;
	public JTextArea txtaDatosUser, txtaDatosHotel, txtaDatosRva, txtaDatosPago;
	public JTable table;

	
	public PanelResumen() {
		setBorder(new LineBorder(SystemColor.desktop, 1, true));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(255, 201, 164));

		lblTitulo = new JLabel("DETALLES DE LA RESERVA");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(66, 69, 665, 51);
		add(lblTitulo);
		
		btnFin= new JButton("Imprimir");
		btnFin.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		btnFin.setAlignmentY(Component.TOP_ALIGNMENT);
		btnFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFin.setBounds(653, 536, 101, 23);
		add(btnFin);
		
		txtaDatosUser = new JTextArea();
		txtaDatosUser.setToolTipText("\r\n");
		txtaDatosUser.setEditable(false);
		txtaDatosUser.setBounds(106, 179, 180, 200);
		add(txtaDatosUser);
		
		txtaDatosHotel = new JTextArea();
		txtaDatosHotel.setToolTipText("\r\n");
		txtaDatosHotel.setEditable(false);
		txtaDatosHotel.setBounds(298, 179, 180, 200);
		add(txtaDatosHotel);
		
		txtaDatosRva = new JTextArea();
		txtaDatosRva.setToolTipText("\r\n");
		txtaDatosRva.setEditable(false);
		txtaDatosRva.setBounds(490, 179, 180, 200);
		add(txtaDatosRva);
		
		txtaDatosPago = new JTextArea();
		txtaDatosPago.setBounds(106, 421, 372, 99);
		add(txtaDatosPago);
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario:");
		lblDatosUsuario.setBounds(104, 142, 84, 26);
		add(lblDatosUsuario);
		
		JLabel lblDatosHotel = new JLabel("Datos Hotel:");
		lblDatosHotel.setBounds(298, 142, 77, 32);
		add(lblDatosHotel);
		
		JLabel lblDatosReserva = new JLabel("Datos Reserva:");
		lblDatosReserva.setBounds(490, 148, 84, 23);
		add(lblDatosReserva);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(106, 390, 84, 32);
		add(lblPrecio);
		
		// JTable = Tabla con el resumen de la reserva
		table = new JTable();
		Object[][] datosIda = {};
		String[] columnNames = {"Nº Reserva", "Destino", "Alojamiento", "Fecha llegada",  "Fecha salida", 
				"Dni", "Nombre", "Apellido", "Descripción", "Extras", "Precio"};
		
		table.setModel(new DefaultTableModel(datosIda,columnNames) {
			private static final long serialVersionUID = 1L;
			
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				int.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, double.class
			};
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		
//		//Parametros del Jtable
//		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
//		cellRenderer.setHorizontalAlignment( JLabel.CENTER );
//		
//		table.setDefaultRenderer(String.class, cellRenderer);
//		table.setDefaultRenderer(int.class, cellRenderer);
//		table.setDefaultRenderer(float.class, cellRenderer);
//		table.setFillsViewportHeight(true);
//		
//		table.setBounds(66, 198, 665, 266);
//		table.setBackground(SystemColor.controlShadow);
//		table.setFocusable(false);
//		table.setRowHeight(50);
//		table.setRowSelectionAllowed(false);
//		
//		table.getColumnModel().getColumn(0).setPreferredWidth(120);
//		table.getColumnModel().getColumn(1).setPreferredWidth(120);
//		table.getColumnModel().getColumn(2).setPreferredWidth(120);
//		table.getColumnModel().getColumn(3).setPreferredWidth(120);
//		table.getColumnModel().getColumn(4).setPreferredWidth(120);
//		table.getColumnModel().getColumn(5).setPreferredWidth(120);
//		table.getColumnModel().getColumn(6).setPreferredWidth(120);
//		table.getColumnModel().getColumn(7).setPreferredWidth(120);
//		table.getColumnModel().getColumn(8).setPreferredWidth(120);
//		table.getColumnModel().getColumn(9).setPreferredWidth(120);
//		table.getColumnModel().getColumn(10).setPreferredWidth(120);
//		add(table);
	}
}
