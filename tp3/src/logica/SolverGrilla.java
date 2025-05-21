package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolverGrilla {
	private int caminosPosibles;
	private Grilla grilla;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;
	private int llamadasRecursivas;

	public SolverGrilla(Grilla grilla) {
		this.grilla = grilla;
		this.caminoActual = new ArrayList<>();
		this.caminosPosibles = 0;
		this.llamadasRecursivas = 0;
		this.caminosValidos = new HashMap<>();
	}

	public boolean resolver(boolean usarPoda) {
		caminoActual.clear();
		llamadasRecursivas = 0;
		caminosPosibles = 0;
		caminosValidos.clear();

		int valorInicial = grilla.ObtenerValorGrilla(0, 0);
		int pasosTotales = grilla.CantFilasGrilla() + grilla.CantColumnasGrilla() - 2;

		backtrack(0, 0, valorInicial, pasosTotales, usarPoda);

		return !caminosValidos.isEmpty();
	}

	private void backtrack(int fila, int columna, int suma, int pasosRestantes, boolean usarPoda) {
		llamadasRecursivas++;
		caminoActual.add(new Posicion(fila, columna));

		// Caso base: llegó al destino
		if (fila == grilla.CantFilasGrilla() - 1 && columna == grilla.CantColumnasGrilla() - 1) {
			if (suma == 0 && pasosRestantes == 0) {
				caminosPosibles++;
				caminosValidos.put(caminosValidos.size() + 1, new ArrayList<>(caminoActual));
				caminoActual.remove(caminoActual.size() - 1);
				return;
			}
			caminoActual.remove(caminoActual.size() - 1);
			return;
		}

		// Poda
		if (usarPoda && Math.abs(suma) > pasosRestantes) {
			caminoActual.remove(caminoActual.size() - 1);
			return;
		}

		// Movimiento hacia abajo
		if (grilla.estaDentro(fila + 1, columna)) {
			backtrack(fila + 1, columna, suma + grilla.ObtenerValorGrilla(fila + 1, columna), pasosRestantes - 1,
					usarPoda);
		}

		// Movimiento hacia derecha
		if (grilla.estaDentro(fila, columna + 1)) {
			backtrack(fila, columna + 1, suma + grilla.ObtenerValorGrilla(fila, columna + 1), pasosRestantes - 1,
					usarPoda);
		}

		caminoActual.remove(caminoActual.size() - 1); // backtrack
	}

	// Getters para estadísticas
	public int getLlamadasRecursivas() {
		return llamadasRecursivas;
	}

	public int getCaminosPosibles() {
		return caminosPosibles;
	}

	public Map<Integer, List<Posicion>> getCaminosValidos() {
		return caminosValidos;
	}
}
