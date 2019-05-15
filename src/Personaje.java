class Personaje{
	
	private String nombre, nombreAtaque1, nombreAtaque2, nombreAtaque3, nombreUltra;
	private int saludAct, saludMax, danAtaq1, danAtaq2, danAtaq3, danUlt, defensa, pocion, ultra, power, puntos;
	int danoProducido = 0, danoRecibido = 0, pro, rec, numero;
	
	//Constante salud
	private static int SALUD_MAX = 500;
	//Metodo para almacenar los puntos logrados en la partida
	//puntos:
	//	(dano echo - dano recibido) * numero de enemigos
	
	//Constructos clase personaje
	Personaje(String nombre, int saludMax, int defensa, String nomAtaq1, int danAtaq1, String nomAtaq2,
			int danAtaq2, String nomAtaq3, int danAtaq3, String nomUlt, int danUltra){
		
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
		
		if(pro > rec) {
			puntos = numeroEnemigos * (pro - rec);
		}else {
			puntos = 0;
		}
		
		return puntos;
	}
	
	//Metodo para la defensa
	public int defensa() {return defensa;}
	
	//Metodo para la curacion
	//pocion aumenta la vida que tienes:
	//	Si tu vida esta entre el 70 % y el 100 %:
	//	(vida actual * 0.25) + vida actual -> 25 % 
	//	Si tu vida esta entre el 45 % y el 70 %:
	//	(vida actual * 0.50) + vida actual -> 50 %
	//	Si tu vida esta entre el 20 % y el 45 %:
	//	(vida actual * 1) + vida actual -> 100 %
	//	Si tu vida esta entre el 1 % y el 20 %:
	//	(vida actual * 1.2) + vida actual -> 120 %
	public int pocion(int salud) {
		
		if(salud >= this.saludMax) {
			return this.saludMax;
		}else if(salud >= this.saludMax * 0.70) {
			return (int) (Math.round(salud * 0.25));
		}else if (salud >= this.saludMax * 0.45) {
			return (int) (Math.round(salud * 0.50));
		}else if (salud >= this.saludMax * 0.20) {
			return salud;
		}else if (salud > 0) {
			return (int) (Math.round(salud * 1.2));
		}else {
			return -1;
		}
	}
	
	//Metodos de los ataques
	
	//Ataques de enemigos, hay un porcentaje de acierto entre un ataque fallido, normal o critico dado por un numero random
	public int ataqueEnemigoUno(String nombreEne, String nombreAtaUnoEne, int saludActJug, int danoAtaqUnoEn) {
		numero = (int) (Math.random() * 100);
		
		if(numero <= 30) {
			//Ataque fallido
			System.out.printf("%s fallo %s\n", nombreEne, nombreAtaUnoEne);
		}else if (numero <= 60) {							
			//Ataque normal
			saludActJug = saludActJug - danoAtaqUnoEn;
			System.out.printf("%s realizo ataque %s\n", nombreEne, nombreAtaUnoEne);
			this.danoRecibido = danoAtaqUnoEn;
			power();
		}else {
			//Ataque critico
			System.out.printf("%s realizo ataque %s y fue critico\n", nombreEne, nombreAtaUnoEne);
			saludActJug = saludActJug - (danoAtaqUnoEn + 25);
			this.danoRecibido = danoAtaqUnoEn + 25;
			power();
		}
		
		return saludActJug;
	}
	
	public int ataqueEnemigoDos(String nombreEne, String nombreAtaDosEne, int saludActJug, int danoAtaqDosEn) {
		
		numero = (int) (Math.random() * 100);
		
		if(numero <= 30) {
			//Ataque fallido
			System.out.printf("%s fallo %s\n", nombreEne, nombreAtaDosEne);
		}else if (numero <= 60) {
			//Ataque normal
			saludActJug = saludActJug - danoAtaqDosEn;
			System.out.printf("%s realizo ataque %s\n", nombreEne, nombreAtaDosEne);
			this.danoRecibido = danoAtaqDosEn;
			power();
		}else {
			//Ataque critico
			System.out.printf("%s realizo ataque %s y fue critico\n", nombreEne, nombreAtaDosEne);
			saludActJug = saludActJug - (danoAtaqDosEn + 25);
			this.danoRecibido = danoAtaqDosEn + 25;
			power();
		}
		
		return saludActJug;
	}
	
	public void ataqueEnemigoTres(String nombreEne, String nombreAtaDosEne, int saludActJug, int danoAtaqDosEn) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Metodo del ataque ultra
	public int ultra() {
		
		if(power > 200) {
			power = power - 200;
			return 200;
		}else if (power == 200) {
			power = 0;
			return power;
		}else {
			return 0;
		}
	}
	
	//Metodo power
	public void power() {
		pro += danoProducido;
		rec += danoRecibido;
		power += danoProducido * 0.30 + danoRecibido * 0.15;
	}
	
	//Getters
	public int getSaludAct() {
		return saludAct;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDanoRecibido() {
		return danoRecibido;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getDanoProducido() {
		return danoProducido;
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

	//Setters
	public void setSaludAct(int saludAct) {
		this.saludAct = saludAct;
	}
	
	public void setDanoProducido(int danoProducido) {
		this.danoProducido = danoProducido;
	}

	public void setDanoRecibido(int danoRecibido) {
		this.danoRecibido = danoRecibido;
	}

	
	
	
}