package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//EN ESTA CLASE SE RESUELVEN LOS ALGORITMOS DE BACKTRACKING Y FUERZA BRUTA

public class SolverAlgoritmos {

	private int llamadasRecursivas;
	private int ajusteIndice = 1;
	private double tiempoMilisegundos = 1_000_000.0;
	private long tiempoInicio, tiempoFinal;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;

	public SolverAlgoritmos() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();

	}

	private void realizarAlgoritmo(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero,
			boolean usarPoda) {

		llamadasRecursivas++;
		caminoActual.add(new Posicion(fila, columna));

		// Caso base: llego al destino
		if (fila == tablero.cantCaminosHorTablero() - ajusteIndice
				&& columna == tablero.cantCaminosVertTablero() - ajusteIndice) {
			if (suma == 0 && pasosRestantes == 0) {
				caminosValidos.put(caminosValidos.size() + ajusteIndice, new ArrayList<>(caminoActual));
				caminoActual.remove(caminoActual.size() - ajusteIndice);
				return;
			}
			caminoActual.remove(caminoActual.size() - ajusteIndice);
			return;
		}

		// BACKTRACKING:
		// Lo que hace es que se fija si el total de la suma es mayor a los pasos
		// restantes, si es asi, corta la
		// recursividad y no termina
		if (usarPoda && Math.abs(suma) > pasosRestantes) {
			caminoActual.remove(caminoActual.size() - ajusteIndice);
			return;
		}

		// Movimiento p abajo
		if (tablero.verificarLimitesTablero(fila + ajusteIndice, columna)) {
			realizarAlgoritmo(fila + ajusteIndice, columna,
					suma + tablero.obtenerValorTablero(fila + ajusteIndice, columna), pasosRestantes - ajusteIndice,
					tablero, usarPoda);
		}

		// Movimiento p derecha
		if (tablero.verificarLimitesTablero(fila, columna + ajusteIndice)) {
			realizarAlgoritmo(fila, columna + ajusteIndice,
					suma + tablero.obtenerValorTablero(fila, columna + ajusteIndice), pasosRestantes - ajusteIndice,
					tablero, usarPoda);
		}

		caminoActual.remove(caminoActual.size() - ajusteIndice);

	}

	private double tiempoEjecucionAlgoritmo() {

		return (tiempoFinal - tiempoInicio) / tiempoMilisegundos;
	}

	public void ejecutarAlgoritmo(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero,
			boolean usarPoda) {
		tiempoInicio = System.nanoTime();
		realizarAlgoritmo(fila, columna, suma, pasosRestantes, tablero, usarPoda);
		tiempoFinal = System.nanoTime();

	}

	public double obtenerTiempoEjecucionAlgoritmo() {
		return tiempoEjecucionAlgoritmo();
	}

	public int getLlamadasRecursivas() {
		return llamadasRecursivas;
	}

	public int getCaminosPosibles() {
		return caminosValidos.size();
	}

	public Map<Integer, List<Posicion>> getCaminosValidos() {
		return caminosValidos;
	}
}