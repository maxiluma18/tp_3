package logica;

public class ParaProbar {
	public static void main(String[] args) {
		// Ejemplo de grilla 4x3 donde la poda sí hace diferencia
		Grilla g = new Grilla(4, 3);

		if (!Grilla.esGrillaPar(4, 3)) {
			System.out.println("La grilla no es válida: el camino mínimo no es par. No puede haber suma 0.");
			return;
		}

		// Grilla con muchos +1 y pocos -1, para que la poda descarte ramas imposibles
		int[][] valores = {
				{ 1, 1, 1 },
				{ 1, 1, 1 },
				{ 1, -1, 1 },
				{ 1, 1, -1 }
		};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				g.SetearValor(i, j, valores[i][j]);
			}
		}

		// --- Ejecución sin poda ---
		SolverGrilla solver = new SolverGrilla(g);
		boolean existeSinPoda = solver.resolver(false);
		System.out.println("\n--- SIN PODA ---");
		if (existeSinPoda) {
			System.out.println("Se encontró al menos un camino válido:");
			for (Integer idx : solver.getCaminosValidos().keySet()) {
				System.out.print("Camino " + idx + ": ");
				for (Posicion p : solver.getCaminosValidos().get(idx)) {
					System.out.print(p + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("No se encontró ningún camino válido.");
		}
		System.out.println("Caminos válidos encontrados: " + solver.getCaminosPosibles());
		System.out.println("Llamadas recursivas: " + solver.getLlamadasRecursivas());

		// --- Ejecución con poda ---
		SolverGrilla solverPoda = new SolverGrilla(g);
		boolean existeConPoda = solverPoda.resolver(true);
		System.out.println("\n--- CON PODA ---");
		if (existeConPoda) {
			System.out.println("Se encontró al menos un camino válido:");
			for (Integer idx : solverPoda.getCaminosValidos().keySet()) {
				System.out.print("Camino " + idx + ": ");
				for (Posicion p : solverPoda.getCaminosValidos().get(idx)) {
					System.out.print(p + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("No se encontró ningún camino válido.");
		}
		System.out.println("Caminos válidos encontrados: " + solverPoda.getCaminosPosibles());
		System.out.println("Llamadas recursivas: " + solverPoda.getLlamadasRecursivas());
	}
}
