package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CerrarVentana extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void VistaPrincipal() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }
 
    public void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }

}
