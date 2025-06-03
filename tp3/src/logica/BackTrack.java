package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTrack {

	private int llamadasRecursivas;
	private int caminosPosibles;
	private int ajusteIndice = 1;
	private double tiempoMilisegundos = 1_000_000.0;
	private long tiempoInicio, tiempoFinal;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;

	public BackTrack() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();

	}

	private void realizarBackTrack(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {

		llamadasRecursivas++;
		caminoActual.add(new Posicion(fila, columna));

		// Caso base: llego al destino
		if (fila == tablero.cantCaminosHorTablero() - ajusteIndice
				&& columna == tablero.cantCaminosVertTablero() - ajusteIndice) {
			if (suma == 0 && pasosRestantes == 0) {
				caminosPosibles++;
				caminosValidos.put(caminosValidos.size() + ajusteIndice, new ArrayList<>(caminoActual));
				caminoActual.remove(caminoActual.size() - ajusteIndice);
				return;
			}
			caminoActual.remove(caminoActual.size() - ajusteIndice);
			return;
		}

		// Poda
		if (Math.abs(suma) > pasosRestantes) {
			caminoActual.remove(caminoActual.size() - ajusteIndice);
			return;
		}

			// Movimiento p abajo
			if (tablero.verificarLimitesTablero(fila + ajusteIndice, columna)) {
				realizarBackTrack(fila + ajusteIndice, columna,
						suma + tablero.obtenerValorTablero(fila + ajusteIndice, columna), pasosRestantes - ajusteIndice,
						tablero);
			}

			// Movimiento p derecha
			if (tablero.verificarLimitesTablero(fila, columna + ajusteIndice)) {
				realizarBackTrack(fila, columna + ajusteIndice,
						suma + tablero.obtenerValorTablero(fila, columna + ajusteIndice), pasosRestantes - ajusteIndice,
						tablero);
			}

			caminoActual.remove(caminoActual.size() - ajusteIndice);
		
	}

	public void ejecutarBackTrack(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {
		tiempoInicio = System.nanoTime();
		realizarBackTrack(fila, columna, suma, pasosRestantes, tablero);
		tiempoFinal = System.nanoTime();

	}

	private double tiempoEjecucionBackTrack() {

		return (tiempoFinal - tiempoInicio) / tiempoMilisegundos;
	}

	public double obtenerTiempoEjecucionBackTrack() {
		return tiempoEjecucionBackTrack();
	}

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