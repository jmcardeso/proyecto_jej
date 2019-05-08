import java.io.IOException;
import java.util.Scanner;

class Terminal {
	
	public void clearScreen() throws IOException, InterruptedException {
		
		// Borrar la pantalla en todos los S.O.
        
		final String os = System.getProperty("os.name");
        
        if (os.contains("Windows")) {
        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }else {
            System.out.println("\033[H\033[2J");
            System.out.flush();
        }
	}

    public void pressReturn(Scanner scan) {
        
    	System.out.print("\n\nPulse RETURN para continuar.\n");
        scan.nextLine();
    }
    
    public void pressReturnBlanco(Scanner scan) {
        
    	System.out.print("\n\n \n");
        scan.nextLine();
    }
}