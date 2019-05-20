package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	private String s = "Hola Mundo";

	private static final long serialVersionUID = 7894326737730452505L;
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	Image fondoPanelPrincipal = pantalla.getImage("src/Images/fondo.png");

	/*
	 * public void paint(Graphics g) { super.paint(g);
	 * g.drawImage(fondoPanelPrincipal, 0, 0, getWidth(), getHeight(), this);
	 * setOpaque(false); }
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoPanelPrincipal, 0, 0, getWidth(), getHeight(), this);
		// g.drawString(this.s, 100, 100);
		setOpaque(true);

	}

	public void añadirEtiqueta(String s, int posicionX, int posicionY, int tamanoX, int tamanoY) {
		JLabel etiqueta = new JLabel(s);
		etiqueta.setBounds(posicionX, posicionY, tamanoX, tamanoY);
		etiqueta.setVisible(true);
		etiqueta.setOpaque(false);
		etiqueta.repaint();
		// etiqueta.font y tal

		this.add(etiqueta);
	}

}
