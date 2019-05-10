class Personaje{
	
	private String nombre, nombreAtaque1, nombreAtaque2, nombreAtaque3, nombreUltra;
	private int saludAct, saludMax, danAtaq1, danAtaq2, danAtaq3, danUlt, defensa, pocion, ultra, power, puntos;
	int danoProducido = 0, danoRecibido = 0, pro, rec;
	
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
	
	//Metodos de los ataques -> son getters y estan situados en la correspondiente seccion
	
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDanoProducido(int danoProducido) {
		this.danoProducido = danoProducido;
	}

	public void setDanoRecibido(int danoRecibido) {
		this.danoRecibido = danoRecibido;
	}

	
	
	
}