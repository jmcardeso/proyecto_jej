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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondoPanelPrincipal, 0, 0, getWidth(), getHeight(), this);
		setOpaque(true);
	}

	public void anadirEtiqueta(JLabel etiqueta, String s, int posicionX, int posicionY, int tamanoX, int tamanoY) {
		etiqueta = new JLabel(s);
		etiqueta.setBounds(posicionX, posicionY, tamanoX, tamanoY);
		etiqueta.setVisible(true);
		etiqueta.setOpaque(false);
		etiqueta.repaint();
		// etiqueta.setBackground(bg);
		// etiqueta.setFont(font);
		// etiqueta.font y tal

		this.add(etiqueta);
		super.repaint();
	}

	public void ocultarEtiqueta(JLabel etiqueta) {
		etiqueta.setVisible(false);
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
				// Aquí hay que ejecutar el método ATAQUE y el método para la animación. Prueba:
				System.out.println("Se ha pulsado el botón con imagen en " + rutaImagen);
			}
		});

		this.add(botoncito);
		super.repaint();

	}

	public void anadirPersonaje(String rutaImagen, String nombrePersonaje, int posicionX, int posicionY, int tamanoX,
			int tamanoY, int vidaPersonaje) {
		Image img = pantalla.getImage(rutaImagen);
		JButton botoncito = new JButton();
		botoncito.setBounds(posicionX, posicionY, tamanoX, tamanoY);
		botoncito.setIcon(new ImageIcon(img));
		botoncito.setVisible(true);
		botoncito.setOpaque(true);
		botoncito.setContentAreaFilled(false);
		botoncito.setBorder(null);

		JLabel etiqueta = new JLabel();

		anadirEtiqueta(etiqueta, nombrePersonaje, posicionX + 60, (posicionY - 40), 200, 100);

		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí hay que ejecutar el geter de la salud del personaje. El segundo
				// parámetro es un string que concatena el nombre del personaje con sus puntos
				// de vida
				// etiqueta.setVisible(false);
				anadirEtiqueta(etiqueta, new String(new char[nombrePersonaje.length() + 4]).replace("\0", " ") + ": "
						+ Integer.toString(vidaPersonaje) + "HP", posicionX + 70, (posicionY - 40), 200, 100);

			}
		});

		this.add(botoncito);
		super.repaint();

	}

}
