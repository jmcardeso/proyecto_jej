import java.io.IOException;
import java.util.Scanner;

class Lucha{
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Constante salud
		final int SALUD_MAX = 500;
		
		// Creamos objetos
		Scanner sca = new Scanner(System.in);
		Terminal cmd = new Terminal();
		Texto txt = new Texto();
		
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
			
			//Generamos un número aleatorio
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
						
						// Realiza el ataque 1
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.printf("%s fallo %s", enm1.getNombre(), enm1.getNombreAtaque1());
						}else if (numero <= 60) {							
							//Ataque normal
							jug.setSaludAct(jug.getSaludAct() - enm1.getDanAtaq1());
							System.out.printf("%s realizo ataque %s", enm1.getNombre(), enm1.getNombreAtaque1());
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							jug.setDanoRecibido(enm1.getDanAtaq1());
							jug.power();
						}else {
							System.out.printf("%s realizo ataque %s y fue critico", enm1.getNombre(), enm1.getNombreAtaque1());
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
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
							//Asignar el daï¿½o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo +25));
							//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
							//Asignar el daï¿½o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
							//Asignar el daï¿½o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
							//Asignar el daï¿½o recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}
					
					
				
					if(prs.getSalud() <= 0){
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
					
						System.out.println("Elige una accion a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la acciï¿½n (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque1();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
								prs.setDanoProducido(prs.ataque1());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque1() + 25);
								//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
								prs.setDanoProducido(prs.ataque1() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque2();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque2() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque3();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
								prs.setDanoProducido(prs.ataque3());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque3() + 25);
								//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
								prs.setDanoProducido(prs.ataque3() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la accion (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
								prs.ultra();
							}else {
								//Ataque critico
								
								if(prs.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", prs.getNombre());
									saludEnemigo = saludEnemigo - prs.ultra();
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", prs.getNombre());
							saludPocion = prs.pocion(prs.getSalud());
							if(prs.getSalud() + saludPocion > SALUD_MAX) {
								prs.setSalud(SALUD_MAX);
							}else {
								prs.setSalud(prs.getSalud() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo <= 0){
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
					
						System.out.println("Elige una accion a realizar:");
						opcion = sca.nextInt();
				
						if(opcion == 1) {
							
							// Realiza la accion (1)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque1();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque1());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque1() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque1() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 2) {
							
							// Realiza la accion (2)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque2();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque2() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque2() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 3) {
							
							// Realiza la accion (3)
							numero = (int) (Math.random() * 90);
							
							if(numero <= 30) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
							}else if (numero <= 60) {
								//Ataque normal
								saludEnemigo = saludEnemigo - prs.ataque3();
								System.out.printf("%s uso ataque normal\n", prs.getNombre());
								//Almacenar en la variable danoProducio el daï¿½o producido en esta acciï¿½n
								prs.setDanoProducido(prs.ataque3());
								//Almacenar y aumentar el valor de power
								prs.power();
							}else {
								System.out.printf("%s hizo un ataque critico\n", prs.getNombre());
								saludEnemigo = saludEnemigo - (prs.ataque3() + 25);
								//Almacenar en la variable danoProducio el dano producido en esta accion
								prs.setDanoProducido(prs.ataque3() + 25);
								//Almacenar y aumentar el valor de power
								prs.power();
							}
						}else if (opcion == 4) {
							
							// Realiza la acciï¿½n (4)
							numero = (int) (Math.random() * 100);
							if(numero <= 20) {
								System.out.printf("%s fallo su ataque\n", prs.getNombre());
								prs.ultra();
							}else {
								//Ataque critico
								
								if(prs.getPower() >= 200) {
									System.out.printf("%s hizo un ataque ultra\n", prs.getNombre());
									saludEnemigo = saludEnemigo - prs.ultra();
								}else {
									System.out.println("El ultra solo puede ser usado "
											+ "al alcanzar 200 puntos de power");
									System.out.println("Perdida de turno por no saber esperar");
								}
							}
						}else if (opcion == 5) {
							// Realiza la accion (5)
							System.out.printf("%s uso pocion\n", prs.getNombre());
							saludPocion = prs.pocion(prs.getSalud());
							if(prs.getSalud() + saludPocion > SALUD_MAX) {
								prs.setSalud(SALUD_MAX);
							}else {
								prs.setSalud(prs.getSalud() + saludPocion);
							}
						}else {
							System.out.println("Elige entre las opciones indicadas");
						}
					
						if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
							break;
						}
					}
				
					if(saludEnemigo <= 0){
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
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 60) {
						
						// Realiza el ataque 2
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}else if (numero <= 90) {
						
						// Realiza el ataque 3
						numero = (int) (Math.random() * 90);
						
						if(numero <= 30) {
							System.out.println("Enemigo fallo su ataque");
						}else if (numero <= 60) {
							//Ataque normal
							prs.setSalud(prs.getSalud() - ataqueEnemigo);
							System.out.println("Enemigo hizo un ataque normal");
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dano recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo);
							prs.power();
						}else {
							System.out.println("Enemigo hizo un ataque critico");
							prs.setSalud(prs.getSalud() - (ataqueEnemigo + 25));
							//Almacenar en la variable danoProducio el dano producido en esta accion
							//Asignar el dan recibido a una variable
							prs.setDanoRecibido(ataqueEnemigo + 25);
							prs.power();
						}
					}
				
					if(prs.getSalud() <= 0){
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
			
			if(prs.getSalud() <= 0) {
				txt.victoriaMiguel();
				break;
			}else {
				txt.derrotaMiguel();
				contadorEnemigo ++;
			}
			
			if(saludEnemigo <= 0) {
				break;
			}
		}
		
		System.out.println("salimos del bucle principal");
		
		if(prs.getSalud() <= 0) {
			System.out.println("YOU LOSE");
			System.out.printf("Puntos conseguidos: %d\n", prs.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}else {
			System.out.println("YOU WIN");
			System.out.printf("Puntos conseguidos: %d\n", prs.puntos(contadorEnemigo));
			System.out.printf("Enemigos matados: %d\n", contadorEnemigo);
		}
	}
}