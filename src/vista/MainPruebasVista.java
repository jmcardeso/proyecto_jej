package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

// Un Buffer es un espacio de memoria que guarda cosas, en este caso va a guardar las imágenes. Sin un Buffer, el programa tendría errores al pintar las imágenes. El Buffer es un paso intermedio para que las imagenes y la pantalla no se calculen a la vez que se dibujan
public abstract class MainPruebasVista extends JFrame implements Runnable {

	private static final long serialVersionUID = -6434380015889810268L;

	public static void main(String[] args) {

		PanelPrincipal tapiz = new PanelPrincipal();

		MarcoPrincipal marco = new MarcoPrincipal(tapiz);

		JLabel etiqueta = new JLabel();

		// VARIABLES DE PRUEBA
		String nombreJugador = "Elías";
		String nombreProfe = "Álex";
		int vidaJugador = 100;
		int vidaProfe = 98;

		// SALIDA DE TEXTO: Lo que pondríamos en un println() va a aparecer en
		// la pizarra usando este método con estas coordenadas:
		tapiz.anadirEtiqueta(etiqueta, "Elías usó STACK OVERFLOW", 370, 50, 250, 200);

		// AÑADIR BOTONES DE HABILIDADES. LOS PARÁMETROS TIENEN QUE MANTENERSE PARA QUE
		// LA POSICIÓN DE LOS ELEMENTOS SEA CORRECTA:
		tapiz.anadirBoton("resources/images/icons/espadas.png", "", 379, 460, 76, 76);
		tapiz.anadirBoton("resources/images/icons/magia.png", "", 460, 384, 76, 76);
		tapiz.anadirBoton("resources/images/icons/punch.png", "", 460, 460, 76, 76);
		tapiz.anadirBoton("resources/images/icons/pocion.png", "", 546, 460, 76, 76);

		// AÑADIR IMÁGENES DE PERSONAJES (SON UN BOTÓN Y CREAN UNA ETIQUETA AL PULSARSE)
		// PARÁMETROS: RUTA, NOMBRE_PERSONAJE, POSICIONX, POSICIONY, TAMAÑOX, TAMAÑOY,
		// VIDA_PERSONAJE;
		tapiz.anadirPersonaje("resources/images/PERSONAJES/jugador.png", nombreJugador, 200, 250, 160, 160,
				vidaJugador); // COORDENADAS DEL JUGADOR
		tapiz.anadirPersonaje("resources/images/PERSONAJES/alex.png", nombreProfe, 650, 250, 160, 160, vidaProfe); // COORDENADAS
																													// DEL
																													// PROFE
	}
}