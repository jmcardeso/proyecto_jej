class Texto {
	
	public void menu(String nomEnem, int salActEnem, String nomAtaUno, String nomAtaDos, 
					String nomAtaTres, String nomAtaUlt, String nomJug, int salActJug, int power) {
		
		System.out.printf("================================Enemigo: %s Salud: %d\n", nomEnem, salActEnem);
		System.out.println();
		System.out.printf("(1) %s (2) %s (3) %s (4) %s (5) Pocion\n", nomAtaUno, nomAtaDos, nomAtaTres, nomAtaUlt);
		System.out.printf("Nombre: %s: Salud: %d Power: %d\n", nomJug, salActJug, power);
		System.out.println();
	}
}