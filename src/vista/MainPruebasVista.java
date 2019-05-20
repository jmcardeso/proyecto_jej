package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// Un Buffer es un espacio de memoria que guarda cosas, en este caso va a guardar las imágenes. Sin un Buffer, el programa tendría errores al pintar las imágenes. El Buffer es un paso intermedio para que las imagenes y la pantalla no se calculen a la vez que se dibujan
public class MainPruebasVista {
	public static void main(String[] args) {

		PanelPrincipal tapiz = new PanelPrincipal();

		MarcoPrincipal marco = new MarcoPrincipal(tapiz);

		tapiz.añadirEtiqueta("Esto es un texto de prueba", 400, 500, 400, 50);
		// tapiz.añadirEtiqueta("Etiueta 2", 100, 100, 200, 200);
		JButton botoncito = new JButton("Boton prueba");
		botoncito.setBounds(400, 300, 100, 100);
		tapiz.add(botoncito);

		botoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tapiz.añadirEtiqueta("Hola", 300, 200, 100, 100);
				// marco.getContentPane().add(tapiz);

			}
		});

	}
}