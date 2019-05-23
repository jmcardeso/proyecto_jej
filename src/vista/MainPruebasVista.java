package vista;

// Un Buffer es un espacio de memoria que guarda cosas, en este caso va a guardar las imágenes. Sin un Buffer, el programa tendría errores al pintar las imágenes. El Buffer es un paso intermedio para que las imagenes y la pantalla no se calculen a la vez que se dibujan
public class MainPruebasVista {
	public static void main(String[] args) {

		PanelPrincipal tapiz = new PanelPrincipal();

		MarcoPrincipal marco = new MarcoPrincipal(tapiz);

		tapiz.anadirEtiqueta("Esto es un texto de prueba", 400, 500, 400, 50);

		tapiz.anadirBoton("resources/images/icons/espadas.png", "", 5, 420, 76, 76); // Icon made by
																						// [smalllikeart] from
																						// www.flaticon.com
		tapiz.anadirBoton("resources/images/icons/pocion.png", "", 81, 471, 76, 76); // Icon made by [Game
																						// Elements]
																						// from www.flaticon.com

	}
}