import java.util.Scanner;

class Personaje{
	
	Scanner entradaTeclado = new Scanner();
	
	private String nombre;
	private int salud, ataque, defensa, pocion, ultra, power, puntos;
	
	//Metodo para establecer el nombre del personaje
	public String nombre() {
		System.out.println("Escribe el nombre del personaje:");
		nombre = entradaTeclado.nextLine();
		return nombre;
	}
	
	//Metodo para establecer salud maxima
	public int salud() {
		salud = 200;
		return salud;
	}
	
	//Metodo para almacenar los puntos logrados en la partida
	//puntos:
	//	(dañor echo - daño recibido) * número de enemigos
	public int puntos(int dañoProducido, int dañoRecibido, int numeroEnemigos) {
		puntos = numeroEnemigos * (dañoProducido - dañoRecibido);
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
	public int pocion() {
		
		if(salud >= salud * 0.70) {
			salud = (salud * 0.25) + salud;
		}else if (salud >= salud * 0.45) {
			salud = (salud * 0.50) + salud;
		}else if (salud >= salud * 0.20) {
			salud = salud + salud;
		}else if (salud > 0) {
			salud = (salud * 1.2) + salud;
		}
		
		return salud;
	}
	
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