package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Personaje;
import vista.MarcoPrincipal;
import vista.PanelPrincipal;

public class SanClementeBattleImpl {
	final static int SUMA_CRITICO = 50;
	final static int RESULTADO_ATAQUE_FALLO = -1;
	final static int RESULTADO_ATAQUE_NORMAL = 0;
	final static int RESULTADO_ATAQUE_CRITICO = 1;
	final static int RESULTADO_ATAQUE_OBJETIVOMUERE = -10;
	final static int PUNTOS_NECESARIOS_ULTI = 200;
	final static int JUGADOR_MUERE = -100;
	final static int ENEMIGO_MUERE = -3;
	final static int FIN_DEL_JUEGO = -20;
	final static int TODO_OK = 100;
	static int situacionDelJuego = TODO_OK;
	static int numProfesor = 0;
	static boolean botonActivo = true;

	public static void main(String[] args) {
		
		PanelPrincipal tapiz = new PanelPrincipal();
		tapiz.setLayout(null); // Para que no se descoloquen los componentes (AbsoluteLayout)

		MarcoPrincipal marco = new MarcoPrincipal(tapiz);

		JLabel lblPizarra, lblPizarra2, lblNombreProfesor, lblNombreJugador;

		JButton btnJugador, btnEnemigo, btnAtaque1, btnAtaque2, btnAtaque3, btnPocion;

		Personaje[] profesor = new Personaje[6];

		String[] imgProfesor = { "miguel", "meritxell", "isaac", "enrique", "alex", "fran" };

		
		

		// CREACION DE PERSONAJES
		Personaje jugador = new Personaje("JEJ", 200, 100, "PREGUNTA ABSURDA", 50, "PORTÁTIL ENCENDIDO", 75,
				"VAGANCIA MÁXIMA", 100, "EXAMEN COPIADO", 150);
		profesor[0] = new Personaje("MIGUEL", 100, 50, "GOLPE DE PDF", 25, "PRÁCTICA DE TALLER", 40, "SUBIR 15 TAREAS AL MESTRE", 60, "ULT0", 100);
		profesor[1] = new Personaje("MERITXELL", 120, 60, "LA BUROCRASIA", 30, "UNA HISTORIA SOBRE RRHH", 50, "NÓMINA", 70, "ULT0", 100);
		profesor[2] = new Personaje("ISAAC", 140, 70, "UVEDOBLE TRES ESCULS", 35, "CURIOSIDADES DE INTERNET", 60, "BORDER-RADIUS", 80, "ULT0", 100);
		profesor[3] = new Personaje("ENRIQUE", 160, 80, "ATAQUE JIT", 40, "PULL REQUEST", 45, "PASAR LISTA", 90, "ULT0", 100);
		profesor[4] = new Personaje("ALEX", 180, 90, "PUÑETAZO TEÓRICO", 45, "RISA MALVADA", 50, "LEFT OUTER JOIN", 100, "ULT0", 100);
		profesor[5] = new Personaje("FRAN", 220, 100, "TEORÍA", 55, "CHISTACO", 65, "HOSTIA TUPLA", 130, "ULT0", 100);

		// SALIDA DE TEXTO: Lo que pondríamos en un println() va a aparecer en
		// la pizarra usando este método con estas coordenadas:
		lblPizarra = tapiz.anadirEtiqueta(new JLabel(), "SAN CLEMENTE BATTLE", 300, 50, 380, 200);
		lblPizarra2 = tapiz.anadirEtiqueta(new JLabel(), " ", 300, 80, 380, 200);

		// AÑADIR BOTONES DE HABILIDADES. LOS PARÁMETROS TIENEN QUE MANTENERSE PARA QUE
		// LA POSICIÓN DE LOS ELEMENTOS SEA CORRECTA:
		btnAtaque1 = tapiz.anadirBoton("resources/images/icons/espadas.png", "", 379, 460, 76, 76);
		btnAtaque2 = tapiz.anadirBoton("resources/images/icons/magia.png", "", 460, 384, 76, 76);
		btnAtaque3 = tapiz.anadirBoton("resources/images/icons/punch.png", "", 460, 460, 76, 76);
		btnPocion = tapiz.anadirBoton("resources/images/icons/pocion.png", "", 546, 460, 76, 76);

		btnAtaque1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (botonActivo) {
					botonActivo = false;
				lblPizarra.setText(jugador.getNombre() + ", ATACA CON " + jugador.getNombreAtaque1());

				switch (jugador.ataque1(profesor[numProfesor])) {
				case RESULTADO_ATAQUE_FALLO:
					lblPizarra2.setText("EL ATAQUE HA FALLADO");
					situacionDelJuego = TODO_OK;
					break;
				case RESULTADO_ATAQUE_NORMAL:
					lblPizarra2.setText(jugador.getNombre() + " LE HA CAUSADO " + jugador.getDanAtaq1()	+ " PUNTOS DE DAÑO A " + profesor[numProfesor].getNombre());
					situacionDelJuego = TODO_OK;
					
					break;
				case RESULTADO_ATAQUE_OBJETIVOMUERE:
					lblPizarra2.setText("HAS DERROTADO A TU ADVERSARIO");
					situacionDelJuego = ENEMIGO_MUERE;
				}
				tapiz.repinta();
				}
			}
		});

		btnAtaque2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (botonActivo) {
					botonActivo = false;

				lblPizarra.setText(jugador.getNombre() + ", ATACA CON " + jugador.getNombreAtaque2());

				switch (jugador.ataque2(profesor[numProfesor])) {
				case RESULTADO_ATAQUE_FALLO:
					lblPizarra2.setText("EL ATAQUE HA FALLADO");
					situacionDelJuego = TODO_OK;
					break;
				case RESULTADO_ATAQUE_NORMAL:
					lblPizarra2.setText(jugador.getNombre() + " LE HA CAUSADO " + jugador.getDanAtaq1() + " PUNTOS DE DAÑO A " + profesor[numProfesor].getNombre());
					situacionDelJuego = TODO_OK;
					break;
				case RESULTADO_ATAQUE_OBJETIVOMUERE:
					lblPizarra2.setText("HAS DERROTADO A TU ADVERSARIO");
					situacionDelJuego = ENEMIGO_MUERE;
				}
				tapiz.repinta();
				}
			}
		});

		btnAtaque3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (botonActivo) {
					botonActivo = false;

				lblPizarra.setText(jugador.getNombre() + ", ATACA CON " + jugador.getNombreAtaque3());

				switch (jugador.ataque3(profesor[numProfesor])) {
				case RESULTADO_ATAQUE_FALLO:
					lblPizarra2.setText("EL ATAQUE HA FALLADO");
					situacionDelJuego = TODO_OK;
					break;
				case RESULTADO_ATAQUE_NORMAL:
					lblPizarra2.setText(jugador.getNombre() + " LE HA CAUSADO " + jugador.getDanAtaq1() + " PUNTOS DE DAÑO A " + profesor[numProfesor].getNombre());
					situacionDelJuego = TODO_OK;
					break;
				case RESULTADO_ATAQUE_OBJETIVOMUERE:
					lblPizarra2.setText("HAS DERROTADO A TU ADVERSARIO");
					situacionDelJuego = ENEMIGO_MUERE;
				}
				tapiz.repinta();
			}
			}
		});

		btnPocion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (botonActivo) {
					botonActivo = false;
				// Aquí hay que ejecutar el método ATAQUE y el método para la animación. Prueba:
				jugador.setSaludAct(jugador.getSaludAct() + jugador.pocion(jugador.getSaludAct()));
				lblPizarra.setText("TE TOMAS UNA POCIÓN");
				lblPizarra2.setText("TU SALUD ES: " + jugador.getSaludAct());
				tapiz.repinta();
			}
			}
		});

		// CREAMOS UN NUEVO HILO PARA LA MÚSICA DEL JUEGO
		HiloSonido hs = new HiloSonido("musica.wav");
		Thread musica = new Thread(hs);
		musica.start();

		// AÑADIR IMÁGENES DE PERSONAJES (SON UN BOTÓN Y CREAN UNA ETIQUETA AL PULSARSE)
		// PARÁMETROS: RUTA, NOMBRE_PERSONAJE, POSICIONX, POSICIONY, TAMAÑOX, TAMAÑOY,
		// VIDA_PERSONAJE;
		btnJugador = tapiz.anadirPersonaje("resources/images/PERSONAJES/jugador.png", jugador.getNombre(), 200, 250, 160, 160, jugador.getSaludAct()); // COORDENADAS DEL JUGADOR
		lblNombreJugador = tapiz.anadirEtiqueta(new JLabel(), jugador.getNombre(), 260, 210, 200, 100);
		flashPersonaje(btnJugador);

		lblPizarra.setText("BIENVENIDO A LA VERSIÓN (MUY) BETA DEL JUEGO");
		wait(2000);
		lblPizarra.setText("¡LUCHA CON VALOR, ESTUDIANTE!");
		wait(2000);
		lblPizarra.setText("");
		
		lblNombreProfesor = tapiz.anadirEtiqueta(new JLabel(), profesor[numProfesor].getNombre(), 710, 210, 200, 100);
		btnEnemigo = tapiz.anadirPersonaje("resources/images/PERSONAJES/" + imgProfesor[numProfesor] + ".png", profesor[numProfesor].getNombre(), 650, 250, 160, 160, profesor[numProfesor].getSaludAct()); // COORDENADAS																											// DEL
		flashPersonaje(btnEnemigo);	
		
		while (situacionDelJuego != FIN_DEL_JUEGO) {
			System.out.println(profesor[numProfesor].getSaludAct());
			if (!botonActivo) {
				
				
				wait(2000);
				if (profesor[numProfesor].getSaludAct() > 0) {
				int numero = (int) (Math.random() * 100);

				if (numero < 25) {
					
					lblPizarra.setText(profesor[numProfesor].getNombre() + ", ATACA CON " + profesor[numProfesor].getNombreAtaque1());
					switch (profesor[numProfesor].ataque1(jugador)) {
					case RESULTADO_ATAQUE_FALLO:
						lblPizarra2.setText("EL ATAQUE HA FALLADO");
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_NORMAL:
						lblPizarra2.setText(profesor[numProfesor].getNombre() + " LE HA CAUSADO " + profesor[numProfesor].getDanAtaq1() + "PUNTOS DE DAÑO A " + jugador.getNombre());
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_OBJETIVOMUERE:
						lblPizarra2.setText("HAS SIDO DERROTADO");
						situacionDelJuego = FIN_DEL_JUEGO;
					}
				} else if (numero >= 25 && numero < 50) {
					lblPizarra.setText(profesor[numProfesor].getNombre() + ", ATACA CON " + profesor[numProfesor].getNombreAtaque2());
					switch (profesor[numProfesor].ataque2(jugador)) {
					case RESULTADO_ATAQUE_FALLO:
						lblPizarra2.setText("EL ATAQUE HA FALLADO");
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_NORMAL:
						lblPizarra2.setText(profesor[numProfesor].getNombre() + " LE HA CAUSADO " + profesor[numProfesor].getDanAtaq2() + "PUNTOS DE DAÑO A " + jugador.getNombre());
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_OBJETIVOMUERE:
						lblPizarra2.setText("HAS SIDO DERROTADO");
						situacionDelJuego = FIN_DEL_JUEGO;
					}
				} else if (numero >= 50 && numero < 75) {
					lblPizarra.setText(profesor[numProfesor].getNombre() + ", ATACA CON " + profesor[numProfesor].getNombreAtaque3());
					switch (profesor[numProfesor].ataque1(jugador)) {
					case RESULTADO_ATAQUE_FALLO:
						lblPizarra2.setText("EL ATAQUE HA FALLADO");
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_NORMAL:
						lblPizarra2.setText(profesor[numProfesor].getNombre() + " LE HA CAUSADO " + profesor[numProfesor].getDanAtaq3() + "PUNTOS DE DAÑO A " + jugador.getNombre());
						situacionDelJuego = TODO_OK;
						break;
					case RESULTADO_ATAQUE_OBJETIVOMUERE:
						lblPizarra2.setText("HAS SIDO DERROTADO");
						situacionDelJuego = FIN_DEL_JUEGO;
					}
				} else {
					profesor[numProfesor].setSaludAct(profesor[numProfesor].getSaludAct() + profesor[numProfesor].pocion(profesor[numProfesor].getSaludAct()));
					lblPizarra.setText("EL PROFESOR SE TOMA UNA POCIÓN");
					lblPizarra2.setText("SU SALUD ES: " + profesor[numProfesor].getSaludAct());
					tapiz.repinta();
				}
				tapiz.repinta();
				botonActivo = true;
				}
			}
			if (situacionDelJuego == FIN_DEL_JUEGO) {
				break;
			}
			if (profesor[numProfesor].getSaludAct() <= 0) {
				if (numProfesor < 5) {
				flashPersonaje(btnEnemigo);
				
				situacionDelJuego = TODO_OK;
				numProfesor++;
				jugador.setSaludAct(jugador.getSaludMax());
				tapiz.remove(btnEnemigo);
				lblNombreProfesor.setText(profesor[numProfesor].getNombre());
				btnEnemigo = tapiz.anadirPersonaje("resources/images/PERSONAJES/" + imgProfesor[numProfesor] + ".png", profesor[numProfesor].getNombre(), 650, 250, 160, 160, profesor[numProfesor].getSaludAct()); // COORDENADAS PROFE
				flashPersonaje(btnEnemigo);	
				}
				else {
					situacionDelJuego = FIN_DEL_JUEGO;
				}
			}
		}
	
			btnAtaque1.setEnabled(false);
			btnAtaque2.setEnabled(false);
			btnAtaque3.setEnabled(false);
			btnPocion.setEnabled(false);
			wait(2000);
			if (numProfesor >= 5) {
			lblPizarra.setText("ENHORABUENA, HAS GANADO");
			lblPizarra2.setText("HAS DERROTADO A TODOS LOS PROFESORES");
			} else {
				lblPizarra.setText("HAS PERDIDO");
				lblPizarra2.setText("HAS SIDO DERROTADO POR LOS PROFESORES");
			}
		
	}

	// EFECTO PARA EL PERSONAJE
	static void flashPersonaje(JButton b) {
		for (int n = 0; n < 3; n++) {
			b.setEnabled(false);
			wait(100);
			b.setEnabled(true);
			wait(100);
		}
	}

	// ESPERAMOS N MILISEGUNDOS
	static void wait(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
