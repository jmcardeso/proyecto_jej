package controlador;

public class UsoHilos {

	public static void main(String[] args) {
		Ventanita frame = new Ventanita();
		frame.setVisible(true);
		frame.lblPrincipal.setText("Hilo principal iniciado.");

		// Primero, construye un objeto MiHilo.
		MiHilo mh = new MiHilo("#1", frame.lblHilo1);
		MiHilo mh2 = new MiHilo("#2", frame.lblHilo2);
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
