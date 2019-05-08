class Texto {
	
	Personaje prs = new Personaje();
	
	public String menu() {
		
		Object saludEnemigo = null;
		
		System.out.printf("========================Vida de enemigo: %d\n", saludEnemigo);
		System.out.println();
		System.out.printf("(1) Ataque 1 (2) Ataque 2 (3) Ataque 3 (4) Ultra (5) Pocion===\n");
		System.out.printf("Vida de %s: %d====Power: %d=========================\n", prs.getNombre(), prs.getSalud(), prs.getPower());
		
		return null;
	}
}