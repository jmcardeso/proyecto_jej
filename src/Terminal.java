import java.io.IOException;
import java.util.Scanner;

public class Terminal {
	
	private static void clearScreen() throws IOException, InterruptedException {
		// Borrar la pantalla en todos los S.O.
        final String os = System.getProperty("os.name");
        if (os.contains("Windows"))
        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    private static void pressReturn(Scanner scan) {
        System.out.print("\n\nPulse RETURN para continuar.");
        scan.nextLine();
    }
}