import java.util.Scanner;

class Lucha{
	public static void main(String[] args) {
		
		// Creamos objetos
		Scanner sca = new Scanner(System.in);
		Personaje prs = new Personaje();
		
		// Creamos varios contadores
		int contadorEnemigo = 0, numero;
		
		// Variable para elegir opcion
		int opcion;
		
		// Pruebas
		int saludEnemigo = 500;
		
		// Creamos el personaje
		System.out.println("Como te llamas:");
		prs.setNombre(sca.nextLine());
		prs.setSalud(500);
		int danoProducido = 0, danoRecibido = 0;
		prs.ataque1();
		prs.ataque2();
		prs.ataque3();
		prs.ultra(danoRecibido, danoProducido);
		prs.pocion(prs.getSalud());
		
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
					System.out.printf("Tu salud: %d=============================\n", prs.getSalud());
				
					numero = (int) (Math.random() * 90);
				
					if(numero <= 30) {
						
						// Realiza el ataque 1
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Ataque fallido");
						}else if (numero <= 60) {
							//Ataque normal
						}else {
							System.out.println("Ataque critico");
						}
					}else if (numero <= 60) {
						
						// Realiza el ataque 2
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Ataque fallido");
						}else if (numero <= 60) {
							//Ataque normal
						}else {
							System.out.println("Ataque critico");
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Ataque fallido");
						}else if (numero <= 60) {
							//Ataque normal
						}else {
							System.out.println("Ataque critico");
						}
					}
				
					if(prs.getSalud() == 0){
						break;
					}
				
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.println("Elige una acción a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la acción (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.println("Ataque fallido");
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque1();
							}else {
								System.out.println("Ataque critico");
								saludEnemigo = saludEnemigo - (prs.ataque1() + 25);
							}
						}else if (opcion == 2) {
							
							// Realiza la acción (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.println("Ataque fallido");
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque2();
							}else {
								System.out.println("Ataque critico");
								saludEnemigo = saludEnemigo - (prs.ataque2() + 25);
							}
						}else if (opcion == 3) {
							
							// Realiza la acción (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.println("Ataque fallido");
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque3();
							}else {
								System.out.println("Ataque critico");
								saludEnemigo = saludEnemigo - (prs.ataque3() + 25);
							}
						}else if (opcion == 4) {
							
							// Realiza la acción (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.println("Ataque critico fallido");
							}else {
								//Ataque critico
							}
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
			
			if(prs.getSalud() == 0){
				break;
			}
			
			contadorEnemigo ++;
		}
		
		System.out.println("Salimos del bucle");
	}
}