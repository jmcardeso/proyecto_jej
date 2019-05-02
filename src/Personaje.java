class Personaje{
	
	private int salud, ataque, defensa, pocion, ultra, power, puntos;
	
	//Metodo para almacenar los puntos logrados en la partida
	public int puntos() {return puntos;}
	
	//Metodo para la defensa
	public int defensa() {return defensa;}
	
	//Metodo para la curacion
	public int pocion() {return pocion;}
	
	//Metodos de los ataques
	public int ataque1() {return ataque;}
	public int ataque2() {return ataque;}
	public int ataque3() {return ataque;}
	
	//Metodo del ataque ultra
	public int ultra() {return ultra;}
	
	//Getters
	public int getSalud() {
		return salud;
	}
	
	//Setters
	public void setSalud(int salud) {
		this.salud = salud;
	}
}