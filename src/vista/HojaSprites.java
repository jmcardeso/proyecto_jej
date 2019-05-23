package vista;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// Esta clase se va a dedicar a cargar las hojas de sprites

public class HojaSprites {
	private final int alto;
	private final int ancho;
	public final int[] pixeles;

	// Colección de hojas de Sprites
	public static HojaSprites personaje = new HojaSprites("src/Images/spritePersonaje.png", 832, 1344);
	// Fin de colección de hojas de Sprites

	public HojaSprites(final String rutaImagen, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		// Así, el array tendrá el mismo tamaño que píxeles la imagen
		pixeles = new int[ancho * alto];

		// Ahora hay que poblar el array con los valores de los colores de cada pixel
		// individual
		BufferedImage imagen;
		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(rutaImagen));
			// Ahora volcamos los valores de la imagen dentro del array
			// imagen.getRGB(startX, startY, w, h, rgbArray, offset, scansize)
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public int getAncho() {
		return this.ancho;
	}

	public void setAncho(int x) {

	}
}
