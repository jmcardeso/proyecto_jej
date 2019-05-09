class Texto {
	
	Personaje prs = new Personaje();
	Enemigo ene = new Enemigo();
	
	// Pruebas
	int saludEnemigo = 500, ataqueEnemigo = 100;
	
	public void menu() {
		
		System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
		System.out.println();
		System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
		System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
		
	}
	
	public void enemigoMiguelSaludo() {
		System.out.printf("Hola me llamo %s\n", ene.getNombre());
		System.out.println("Comenzamos la clase");
	}
	
	public void victoriaMiguel() {
		System.out.println("Has fracasado en tus estudios");
	}
	
	public void derrotaMiguel() {
		System.out.println("Has aprobado, pero lo que te espera a partir de ahora sera mas dificil");
	}
}