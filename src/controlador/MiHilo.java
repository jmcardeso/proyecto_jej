package controlador;

import javax.swing.JLabel;

public class MiHilo implements Runnable {
	// Crea un hilo implementando Runnable.
	// Los objetos de MiHilo se pueden ejecutar en sus propios hilos
	// porque MiHilo implementa Runnable.
	String nombreHilo;
	JLabel label;

	MiHilo(String nombre, JLabel label) {
		nombreHilo = nombre;
		this.label = label;
	}

	// Punto de entrada del hilo
	// Los hilos comienzan a ejecutarse aquí
	public void run() {
		label.setText("Comenzando " + nombreHilo);
		try {
			for (int contar = 0; contar < 10; contar++) {
				Thread.sleep(400);
				label.setText("En " + nombreHilo + ", el recuento " + contar);
			}
		} catch (InterruptedException exc) {
			label.setText(nombreHilo + "Interrumpido.");
		}
		label.setText("Terminando " + nombreHilo);
	}
}
