package vista;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MarcoPrincipal extends JFrame {

	private static final long serialVersionUID = 1998857156786763224L;

	public MarcoPrincipal(PanelPrincipal p) { // Para el Marco principal, pido que se le pase por parámetro un Jpanel
												// para usar como panel principal
		Toolkit pantalla = Toolkit.getDefaultToolkit(); // En esta variable se almacena cuál es nuestro sistema nativo
														// // de ventanas
		Dimension tamanoPantalla = pantalla.getScreenSize(); // De aquí se sacan el ancho y el alto, que son dos
		// propiedades de la clase Dimension

		int anchoVentana = 1024;
		int altoVentana = 576;

		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		this.getContentPane().add(p);
		this.setSize(anchoVentana, altoVentana);
		this.setLocation(((anchoPantalla / 2) - (anchoVentana / 2)), (altoPantalla / 2) - (altoVentana / 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Síndrome de DAW - by JEJ");
		this.setVisible(true);
		this.setResizable(false);

		// Para poner un icono nuevo a la ventana:

		Image miIcono = pantalla.getImage("resources/images/icons/espadas.png"); // Icon made by [smalllikeart] from
																					// www.flaticon.com
		this.setIconImage(miIcono);
	}
}