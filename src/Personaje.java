class Personaje{
	
	private String nombre;
	private int salud, ataque, defensa, pocion, ultra, power, puntos;
	
	//Metodo para almacenar los puntos logrados en la partida
	//puntos:
	//	(dañor echo - daño recibido) * número de enemigos
	public int puntos(int danoProducido, int danoRecibido, int numeroEnemigos) {
		puntos = numeroEnemigos * (danoProducido - danoRecibido);
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
	public void pocion(int salud) {
		
		if(salud >= 500 * 0.70) {
			this.salud = (int) (Math.round(salud * 0.25 + salud));
		}else if (salud >= 500 * 0.45) {
			this.salud = (int) (Math.round(salud * 0.50 + salud));
		}else if (salud >= 500 * 0.20) {
			this.salud = salud + salud;
		}else if (salud > 0) {
			this.salud = (int) (Math.round(salud * 1.2 + salud));
		}else {
			this.salud = 0;
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
	public int ultra(int danoRecibido, int danoProducido) {
		power = danoProducido + danoRecibido;
		
		if(power == 200) {
			return ultra;
		}
	}
	
	//Getters
	public int getSalud() {
		return salud;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	//Setters
	public void setSalud(int salud) {
		//Establecemos un maximo permitido en la salud
		if(salud <= this.salud) {
			this.salud = salud;
		}else {
			this.salud = salud;
		}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}