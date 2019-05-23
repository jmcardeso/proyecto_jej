package controlador;

public class UsoHilos {

	public static void main(String[] args) {
		Ventanita frame = new Ventanita();
		frame.setVisible(true);
		frame.lblPrincipal.setText("Hilo principal iniciado.");

		// Primero, construye un objeto MiHilo.
		HiloPelota mh = new HiloPelota("#1", frame.lblHilo1);
		HiloPelota mh2 = new HiloPelota("#2", frame.lblHilo2);
		// Luego, construye un hilo de ese objeto.
		Thread nuevoh = new Thread(mh);
		Thread nuevoh2 = new Thread(mh2);
		// Finalmente, comienza la ejecución del hilo.
		nuevoh.start();
		nuevoh2.start();
		try {
			Thread.sleep(2800);
		} catch (InterruptedException exc) {
			frame.lblPrincipal.setText("Hilo principal interrumpido.");
		}
		frame.lblPrincipal.setText("Hilo principal finalizado.");
	}
}
