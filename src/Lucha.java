import java.io.IOException;
import java.util.Scanner;

class Lucha{
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Constante salud
		final int SALUD_MAX = 500;
		
		// Creamos objetos
		Scanner sca = new Scanner(System.in);
		Terminal cmd = new Terminal();
		//Texto txt = new Texto();
		
		// Creamos variable para controlar las salud actual
		int mSaludJug, mSaludEnem;
		
		// Creamos varios contadores
		int contadorEnemigo = 0, numero;
		
		// Variable para elegir opcion
		int opcion, saludPocion;
		
		// Creamos enemigos
		Personaje enm1 = new Personaje("Miguel", 500, 100, "Aburrimiento", 50, "Sin luz", 75, "PDF", 100, "PC biejo", 200);
		
		// Creamos el personaje
		System.out.println("Bienvenido, ¿como te llamas?");
		String nombre = sca.nextLine();
		Personaje jug = new Personaje(nombre, 500, 100, "Pereza", 75, "Movil", 100, "Google", 125, "stack overflow", 250);
		int danoProducido = 0, danoRecibido = 0;
	
		while(true) {
			
			//Generamos un n�mero aleatorio
			numero = (int) (Math.random() * 100);
			
			cmd.pressReturn(sca);
			
			if(numero <= 100) {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
					
					cmd.clearScreen();
			
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
				
					//Turno enemigo
					numero = (int) (Math.random() * 90);
				
					if(numero <= 30) {
						
						mSaludJug = jug.getSaludAct();
						
						jug.setSaludAct(enm1.ataqueEnemigoUno(enm1.getNombre(), enm1.getNombreAtaque1(), jug.getSaludAct(), enm1.getDanAtaq1()));
						
						//cargamos el power del jugador
						jug.setDanoRecibido(mSaludJug - jug.getSaludAct());
						jug.power();
						
					}else if (numero <= 60) {
						
						mSaludJug = jug.getSaludAct();
						
						jug.setSaludAct(enm1.ataqueEnemigoDos(enm1.getNombre(), enm1.getNombreAtaque2(), jug.getSaludAct(), enm1.getDanAtaq2()));
						
						//cargamos el power del jugador
						jug.setDanoRecibido(mSaludJug - jug.getSaludAct());
						jug.power();
						
					}else if (numero <= 90) {
						
						mSaludJug = jug.getSaludAct();
						
						jug.setSaludAct(enm1.ataqueEnemigoTres(enm1.getNombre(), enm1.getNombreAtaque3(), jug.getSaludAct(), enm1.getDanAtaq3()));
						
						//cargamos el power del jugador
						jug.setDanoRecibido(mSaludJug - jug.getSaludAct());
						jug.power();
						
					}
					
					if(jug.getSaludAct() <= 0){
						break;
					}
					
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
					
					//Turno personaje
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.printf("%s elige una accion a realizar:\n", jug.getNombre());
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la accion (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque1());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq1());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque1());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq1());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque1());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq1() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq1() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque2());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq2());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque2());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq2());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque2());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq2() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq2() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque3());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq3());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque3());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq3());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque3());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq3() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq3() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la accion (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo %s ultra\n", jug.getNombre(), jug.getNombreUltra());
								jug.ultra();
							}else {
								//Ataque critico
								
								if(jug.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", jug.getNombre());
									enm1.setSaludAct(enm1.getSaludAct() - jug.ultra());
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", jug.getNombre());
							saludPocion = jug.pocion(jug.getSaludAct());
							if(jug.getSaludAct() + saludPocion > SALUD_MAX) {
								jug.setSaludAct(SALUD_MAX);
							}else {
								jug.setSaludAct(jug.getSaludAct() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(enm1.getSaludAct() <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
				}
			}else {
				
				//Una vez elegimos quien empieza se mantendra hasta que uno de los dos muera
				while (true) {
					
					cmd.clearScreen();
			
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
					
					//Turno personaje
					//Quedar en bucle hasta elegir la opcion correcta
					while (true) {
					
						System.out.printf("%s elige una accion a realizar:\n", jug.getNombre());
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la accion (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque1());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq1());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque1());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq1());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque1());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq1() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq1() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque2());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq2());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque2());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq2());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque2());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq2() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq2() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s %s fallo %s\n", jug.getNombre(), jug.getNombreAtaque3());
							}else if (numero <= 60) {
								//Ataque normal
								enm1.setSaludAct(enm1.getSaludAct() - jug.getDanAtaq3());
								System.out.printf("%s realizo ataque %s\n", jug.getNombre(), jug.getNombreAtaque3());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq3());
								//Almacenar y aumentar el valor de power
								jug.power();
							}else {
								System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque3());
								enm1.setSaludAct(enm1.getSaludAct() - (jug.getDanAtaq3() + 25));
								//Almacenar en la variable danoProducio el dano producido en esta accion
								jug.setDanoProducido(jug.getDanAtaq3() + 25);
								//Almacenar y aumentar el valor de power
								jug.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la accion (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo %s ultra\n", jug.getNombre(), jug.getNombreUltra());
								jug.ultra();
							}else {
								//Ataque critico
								
								if(jug.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", jug.getNombre());
									enm1.setSaludAct(enm1.getSaludAct() - jug.ultra());
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", jug.getNombre());
							saludPocion = jug.pocion(jug.getSaludAct());
							if(jug.getSaludAct() + saludPocion > SALUD_MAX) {
								jug.setSaludAct(SALUD_MAX);
							}else {
								jug.setSaludAct(jug.getSaludAct() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(enm1.getSaludAct() <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
					
					//Turno enemigo
					numero = (int) (Math.random() * 90);
					
					if(numero <= 30) {
						
						// Realiza el ataque 1
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.printf("%s fallo %s\n", enm1.getNombre(), enm1.getNombreAtaque1());
						}else if (numero <= 60) {							
							//Ataque normal
							jug.setSaludAct(jug.getSaludAct() - enm1.getDanAtaq1());
							System.out.printf("%s realizo ataque %s\n", enm1.getNombre(), enm1.getNombreAtaque1());
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq1());
							jug.power();
						}else {
							System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque1());
							jug.setSaludAct(jug.getSaludAct() - (enm1.getDanAtaq1() + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq1() + 25);
							jug.power();
						}
					}else if (numero <= 60) {
						
						// Realiza el ataque 2
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.printf("%s fallo %s\n", enm1.getNombre(), enm1.getNombreAtaque1());
						}else if (numero <= 60) {
							//Ataque normal
							jug.setSaludAct(jug.getSaludAct() - enm1.getDanAtaq2());
							System.out.printf("%s realizo ataque %s\n", enm1.getNombre(), enm1.getNombreAtaque2());
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq2());
							jug.power();
						}else {
							System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque1());
							jug.setSaludAct(jug.getSaludAct() - (enm1.getDanAtaq2() +25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq2() + 25);
							jug.power();
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.printf("%s fallo %s\n", enm1.getNombre(), enm1.getNombreAtaque1());
						}else if (numero <= 60) {
							//Ataque normal
							jug.setSaludAct(jug.getSaludAct() - enm1.getDanAtaq3());
							System.out.printf("%s realizo ataque %s\n", enm1.getNombre(), enm1.getNombreAtaque3());
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq3());
							jug.power();
						}else {
							System.out.printf("%s realizo ataque %s y fue critico\n", enm1.getNombre(), enm1.getNombreAtaque1());
							jug.setSaludAct(jug.getSaludAct() - (enm1.getDanAtaq3() +25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq3() + 25);
							jug.power();
						}
					}
				
					if(jug.getSaludAct() <= 0){
						break;
					}
					
					cmd.pressReturnBlanco(sca);
					cmd.pressReturn(sca);
					cmd.clearScreen();
					
					System.out.printf("================================Enemigo: %s Salud: %d\n", enm1.getNombre(), enm1.getSaludAct());
					System.out.println();
					System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", jug.getNombreAtaque1(),
							jug.getNombreAtaque2(), jug.getNombreAtaque3(), jug.getNombreUltra());
					System.out.printf("Nombre: %s: Salud: %d Power: %d\n", jug.getNombre(), jug.getSaludAct(), jug.getPower());
				}
			}
			
			if(jug.getSaludAct() <= 0) {
				System.out.printf("%s a ganado\n", enm1.getSaludAct());
				break;
			}else {
				System.out.printf("%s a ganado\n", jug.getNombre());
				contadorEnemigo ++;
			}
			
			if(enm1.getSaludAct() <= 0) {
				break;
			}
		}
		
		System.out.println("salimos del bucle principal");
		
		if(jug.getSaludAct() <= 0) {
			System.out.println("YOU LOSE");
			System.out.printf("Puntos conseguidos: %d\n", jug.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}else {
			System.out.println("YOU WIN");
			System.out.printf("Puntos conseguidos: %d\n", jug.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}
	}
}