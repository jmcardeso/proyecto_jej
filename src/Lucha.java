class Lucha{
	public static void main(String[] args) {
		
		//Hacemos pruebas con varios parametros
		int saludPersonaje, saludEnemigo, numero;
		saludPersonaje = 100;
		saludEnemigo = 120;
		
		while(true) {
			
			//Mas pruebas
			saludEnemigo -= 1;
			saludPersonaje -= 1;
			
			//Generamos un número aleatorio
			numero = (int) (Math.random() * 100);
			
			if(numero <= 50) {
				System.out.println("Turno del enemigo");
			}else {
				System.out.println("Turno del personaje");
			}
			
			if(saludPersonaje == 0 || saludEnemigo == 0){
				break;
			}
		}
		
		System.out.println("Salimos del bucle");
	}
}