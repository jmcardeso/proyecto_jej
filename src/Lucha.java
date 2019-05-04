import java.util.Scanner;

class Lucha{
	public static void main(String[] args) {
		
		//Creamos objetos
		Scanner sca = new Scanner(System.in);
		Personaje prs = new Personaje();
		
		// Creamos varios contadores
		int contadorEnemigo;
		
		//Variable para elegir opcion
		int opcion;
		
		//Hacemos pruebas con varios parametros
		int saludPersonaje, saludEnemigo, numero;
		saludPersonaje = 100;
		saludEnemigo = 120;
		
		while(true) {
			
			//Generamos un número aleatorio
			numero = (int) (Math.random() * 100);
			
			if(numero <= 50) {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
			
					System.out.printf("========================Salud enemigo: %d\n", saludEnemigo);
					System.out.println();
					System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3===\n");
					System.out.printf("(4) Ultra================================\n");
					System.out.printf("(5) Poción===============================\n");
					System.out.printf("Tu salud: %d=============================\n", saludPersonaje);
				
					numero = (int) (Math.random() * 100);
				
					if(numero <= 30) {
						// Realiza el ataque 1
					}else if (numero <= 60) {
						// Realiza el ataque 2
					}else if (numero <= 100) {
						// Realiza el ataque 3
					}
				
					if(saludPersonaje == 0){
						break;
					}
				
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.println("Elige una acción a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							// Realiza la acción (1)
						}else if (opcion == 2) {
							// Realiza la acción (2)
						}else if (opcion == 3) {
							// Realiza la acción (3)
						}else if (opcion == 4) {
							// Realiza la acción (4)
						}else if (opcion == 5) {
							// Realiza la acción (5)
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo == 0){
						break;
					}
				}
				
			}else {
				System.out.println("Turno del personaje");
			}
			
			if(saludPersonaje == 0 || saludEnemigo == 0){
				break;
			}
		}
		
		System.out.println("Salimos del bucle");
	}
}