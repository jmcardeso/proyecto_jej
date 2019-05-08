class Personaje{
	
	private String nombre;
	private int salud, ataque, defensa, pocion, ultra, power, puntos;
	int danoProducido = 0, danoRecibido = 0, pro, rec;
	//Constante salud
	private static int SALUD_MAX = 500;
	//Metodo para almacenar los puntos logrados en la partida
	//puntos:
	//	(dano echo - dano recibido) * numero de enemigos
	
	//Constructos clase personaje
	Personaje(){
		this.salud = SALUD_MAX;
	}
	
	public int puntos(int numeroEnemigos) {
		
		if(rec < 0) {
			puntos = 0;
		}else {
			puntos = numeroEnemigos * (pro - rec);
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
		
		if(this.salud >= SALUD_MAX) {
			return SALUD_MAX;
		}else if(salud >= SALUD_MAX * 0.70) {
			return (int) (Math.round(salud * 0.25));
		}else if (salud >= SALUD_MAX * 0.45) {
			return (int) (Math.round(salud * 0.50));
		}else if (salud >= SALUD_MAX * 0.20) {
			return salud;
		}else if (salud > 0) {
			return (int) (Math.round(salud * 1.2));
		}else {
			return 0;
		}
	}
	
	//Metodos de los ataques
	
	public int ataque1() {
		ataque = 50;
		return ataque;
	}
	
	public int ataque2() {
		ataque = 75;
		return ataque;
	}
	
	public int ataque3() {
		ataque = 100;
		return ataque;
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
	public int getSalud() {
		return salud;
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
	
	//Setters
	public void setSalud(int salud) {
		this.salud = salud;
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