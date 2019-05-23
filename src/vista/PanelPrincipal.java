package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	private static final long serialVersionUID = 7894326737730452505L;
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	Image fondoPanelPrincipal = pantalla.getImage("resources/images/fondo.png");

	/*
	 * public void paint(Graphics g) { super.paint(g);
	 * g.drawImage(fondoPanelPrincipal, 0, 0, getWidth(), getHeight(), this);
	 * setOpaque(false); }
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoPanelPrincipal, 0, 0, getWidth(), getHeight(), this);
		setOpaque(true);
	}

	public void anadirEtiqueta(String s, int posicionX, int posicionY, int tamanoX, int tamanoY) {
		JLabel etiqueta = new JLabel(s);
		etiqueta.setBounds(posicionX, posicionY, tamanoX, tamanoY);
		etiqueta.setVisible(true);
		etiqueta.setOpaque(false);
		etiqueta.repaint();
		// etiqueta.font y tal

		this.add(etiqueta);
		super.repaint();
	}

	public void anadirBoton(String rutaImagen, String texto, int posicionX, int posicionY, int tamanoX, int tamanoY) {
		Image img = pantalla.getImage(rutaImagen);
		JButton botoncito = new JButton(texto);
		botoncito.setBounds(posicionX, posicionY, tamanoX, tamanoY);
		botoncito.setIcon(new ImageIcon(img));
		botoncito.setVisible(true);
		botoncito.setOpaque(true);
		botoncito.setContentAreaFilled(false);
		botoncito.setBorder(null);

		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí va el código que se ejecuta al pulsar el botón. Prueba:
				System.out.println("Se ha pulsado el botón con imagen en " + rutaImagen);
			}
		});

		this.add(botoncito);
		super.repaint();

	}

}
