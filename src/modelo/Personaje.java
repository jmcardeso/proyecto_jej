package modelo;

public class Personaje {

	private String nombre, nombreAtaque1, nombreAtaque2, nombreAtaque3, nombreUltra;
	private int saludAct, saludMax, danAtaq1, danAtaq2, danAtaq3, danUlt, defensa, pocion, ultra, puntos;
	int pro, rec, numero;
	private final int SUMA_CRITICO = 50;
	private final int RESULTADO_ATAQUE_FALLO = -1;
	private final int RESULTADO_ATAQUE_NORMAL = 0;
	private final int RESULTADO_ATAQUE_CRITICO = 1;
	private final int RESULTADO_ATAQUE_OBJETIVOMUERE = -10;
	private final int PUNTOS_NECESARIOS_ULTI = 200;
	private int puntosUlti = 0;

	// Constante salud
	private static int SALUD_MAX = 500;
	// Metodo para almacenar los puntos logrados en la partida
	// puntos:
	// (dano echo - dano recibido) * numero de enemigos

	// Constructos clase personaje
	public Personaje(String nombre, int saludMax, int defensa, String nomAtaq1, int danAtaq1, String nomAtaq2, int danAtaq2,
			String nomAtaq3, int danAtaq3, String nomUlt, int danUltra) {

		this.nombre = nombre;
		this.saludMax = saludMax;
		this.saludAct = saludMax;
		this.defensa = defensa;
		this.nombreAtaque1 = nomAtaq1;
		this.danAtaq1 = danAtaq1;
		this.nombreAtaque2 = nomAtaq2;
		this.danAtaq2 = danAtaq2;
		this.nombreAtaque3 = nomAtaq3;
		this.danAtaq3 = danAtaq3;
		this.nombreUltra = nomUlt;
		this.danUlt = danUltra;
	}

	public int puntos(int numeroEnemigos) {

		if (pro > rec) {
			puntos = numeroEnemigos * (pro - rec);
		} else {
			puntos = 0;
		}

		return puntos;
	}

	// Metodo para la defensa
	public int defensa() {
		return defensa;
	}

	// Metodo para la curacion
	// pocion aumenta la vida que tienes:
	// Si tu vida esta entre el 70 % y el 100 %:
	// (vida actual * 0.25) + vida actual -> 25 %
	// Si tu vida esta entre el 45 % y el 70 %:
	// (vida actual * 0.50) + vida actual -> 50 %
	// Si tu vida esta entre el 20 % y el 45 %:
	// (vida actual * 1) + vida actual -> 100 %
	// Si tu vida esta entre el 1 % y el 20 %:
	// (vida actual * 1.2) + vida actual -> 120 %
	public int pocion(int salud) {

		if (salud >= this.saludMax) {
			return this.saludMax;
		} else if (salud >= this.saludMax * 0.70) {
			return (int) (Math.round(salud * 0.25));
		} else if (salud >= this.saludMax * 0.45) {
			return (int) (Math.round(salud * 0.50));
		} else if (salud >= this.saludMax * 0.20) {
			return salud;
		} else if (salud > 0) {
			return (int) (Math.round(salud * 1.2));
		} else {
			return -1;
		}
	}

	// Metodos de los ataques
	public int ataque1(Personaje p) {
		numero = (int) (Math.random() * 100);
		int resultado;

		if (numero < 30) {
			// Ataque fallido
			resultado = this.RESULTADO_ATAQUE_FALLO;
		} else if (numero < 80) {
			// Ataque se ejecuta con normalidad
			p.setSaludAct(p.getSaludAct() - this.danAtaq1);
			p.puntosUlti = p.puntosUlti + this.danAtaq1;
			this.puntosUlti = this.puntosUlti + this.danAtaq1;
			resultado = this.RESULTADO_ATAQUE_NORMAL;
		} else {
			// Ataque crítico
			p.setSaludAct(p.getSaludAct() - (this.danAtaq1 + SUMA_CRITICO));
			p.puntosUlti = p.puntosUlti + (this.danAtaq1 + SUMA_CRITICO);
			this.puntosUlti = this.puntosUlti + (this.danAtaq1 + SUMA_CRITICO);
			resultado = this.RESULTADO_ATAQUE_CRITICO;
		}

		if (p.getSaludAct() <= 0) {
			resultado = this.RESULTADO_ATAQUE_OBJETIVOMUERE;
		}

		return resultado;
	}
	
	public int ataque2(Personaje p) {
		numero = (int) (Math.random() * 100);
		int resultado;

		if (numero < 30) {
			// Ataque fallido
			resultado = this.RESULTADO_ATAQUE_FALLO;
		} else if (numero < 80) {
			// Ataque se ejecuta con normalidad
			p.setSaludAct(p.getSaludAct() - this.danAtaq2);
			p.puntosUlti = p.puntosUlti + this.danAtaq2;
			this.puntosUlti = this.puntosUlti + this.danAtaq2;
			resultado = this.RESULTADO_ATAQUE_NORMAL;
		} else {
			// Ataque crítico
			p.setSaludAct(p.getSaludAct() - (this.danAtaq2 + SUMA_CRITICO));
			p.puntosUlti = p.puntosUlti + (this.danAtaq2 + SUMA_CRITICO);
			this.puntosUlti = this.puntosUlti + (this.danAtaq2 + SUMA_CRITICO);
			resultado = this.RESULTADO_ATAQUE_CRITICO;
		}

		if (p.getSaludAct() <= 0) {
			resultado = this.RESULTADO_ATAQUE_OBJETIVOMUERE;
		}

		return resultado;
	}
	
	public int ataque3(Personaje p) {
		numero = (int) (Math.random() * 100);
		int resultado;

		if (numero < 30) {
			// Ataque fallido
			resultado = this.RESULTADO_ATAQUE_FALLO;
		} else if (numero < 80) {
			// Ataque se ejecuta con normalidad
			p.setSaludAct(p.getSaludAct() - this.danAtaq3);
			p.puntosUlti = p.puntosUlti + this.danAtaq3;
			this.puntosUlti = this.puntosUlti + this.danAtaq3;
			resultado = this.RESULTADO_ATAQUE_NORMAL;
		} else {
			// Ataque crítico
			p.setSaludAct(p.getSaludAct() - (this.danAtaq3 + SUMA_CRITICO));
			p.puntosUlti = p.puntosUlti + (this.danAtaq3 + SUMA_CRITICO);
			this.puntosUlti = this.puntosUlti + (this.danAtaq3 + SUMA_CRITICO);
			resultado = this.RESULTADO_ATAQUE_CRITICO;
		}

		if (p.getSaludAct() <= 0) {
			resultado = this.RESULTADO_ATAQUE_OBJETIVOMUERE;
		}

		return resultado;
	}
	
	// Metodo del ataque ultra
	public int ataqueUltra(Personaje p) {
		numero = (int) (Math.random() * 100);
		int resultado;

		if (numero < 15) {
			// Ataque fallido
			resultado = this.RESULTADO_ATAQUE_FALLO;
		} else {
			// Ataque se ejecuta con normalidad
			p.setSaludAct(p.getSaludAct() - this.danUlt);
			p.puntosUlti = p.puntosUlti + this.danUlt;
			this.puntosUlti = 0;
			resultado = this.RESULTADO_ATAQUE_NORMAL;
		}

		if (p.getSaludAct() <= 0) {
			resultado = this.RESULTADO_ATAQUE_OBJETIVOMUERE;
		}

		return resultado;
	}

	// Getters
	public int getSaludAct() {
		return saludAct;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDanAtaq1() {
		return danAtaq1;
	}

	public int getDanAtaq2() {
		return danAtaq2;
	}

	public int getDanAtaq3() {
		return danAtaq3;
	}

	public int getDefensa() {
		return defensa;
	}

	public String getNombreAtaque1() {
		return nombreAtaque1;
	}

	public String getNombreAtaque2() {
		return nombreAtaque2;
	}

	public String getNombreAtaque3() {
		return nombreAtaque3;
	}

	public String getNombreUltra() {
		return nombreUltra;
	}

	public int getDanUlt() {
		return danUlt;
	}

	// Setters
	public void setSaludAct(int saludAct) {
		this.saludAct = saludAct;
	}
}