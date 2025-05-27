package logica;

public class ParaProbar {

	public static void main(String[] args) {
		// Crear un tablero de 3x3 (por ejemplo)
		TableroElectronico tablero = new TableroElectronico(4, 3);

		if (!TableroElectronico.verificarParidadTablero(4, 3)) {
			System.out.println("La grilla no es válida: el camino mínimo no es par. No puede haber suma 0.");
			return;
		}

		// Grilla con muchos +1 y pocos -1, para que la poda descarte ramas imposibles
		int[][] valores = { { 1, -1, 1 }, { 1, 1, 1 }, { 1, -1, 1 }, { 1, 1, -1 } };

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				tablero.setearValorTablero(i, j, valores[i][j]);
			}
		}

		// Crear el solver
		SolverTableroElectronico solver = new SolverTableroElectronico(tablero);

		// Crear instancias de BackTrack y FuerzaBruta y configurar el tablero
		BackTrack backTrack = new BackTrack();

		backTrack.setTablero(tablero);
 
		FuerzaBruta fuerzaBruta = new FuerzaBruta();
		fuerzaBruta.setTablero(tablero);

		// Asignar al solver
		solver.backTrack = backTrack;
		solver.fuerzaBruta = fuerzaBruta;

		
		solver.resolveBacktrack();

		System.out.println("=== Resolviendo con Backtracking ===");
		System.out.println("tiempo BackTrack :"+backTrack.obtenerTiempoEjecucionBackTrack());
		System.out.println("Llamadas recursivas: " + backTrack.getLlamadasRecursivas());
		System.out.println("Caminos posibles: " + backTrack.getCaminosPosibles());

		
		
				for (Integer idx : solver.backTrack.getCaminosValidos().keySet()) {
					System.out.print("Camino " + idx + ": ");
					for (Posicion p : solver.backTrack.getCaminosValidos().get(idx)) {
						System.out.print(p + " ");
					}
					System.out.println();
				}
		
		solver.resolverFuerzaBruta();
		System.out.println("\n=== Resolviendo con Fuerza Bruta ===");
		
		System.out.println("tiempo Fuerza Bruta :"+fuerzaBruta.obtenerTiempoEjecucionFuerzaBruta());
		System.out.println("Llamadas recursivas: " + fuerzaBruta.getLlamadasRecursivas());
		System.out.println("Caminos posibles: " + fuerzaBruta.getCaminosPosibles());
		
		for (Integer idx : solver.fuerzaBruta.getCaminosValidos().keySet()) {
			System.out.print("Camino " + idx + ": ");
			for (Posicion p : solver.fuerzaBruta.getCaminosValidos().get(idx)) {
				System.out.print(p + " ");
			}
			System.out.println();
		}
		
	}
}
