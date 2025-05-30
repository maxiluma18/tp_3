package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTrack {

	private TableroElectronico tablero;
	private int llamadasRecursivas;
	private int caminosPosibles;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;
	long tiempoInicio, tiempoFinal;
	double tiempoMilisegundos = 1_000_000.0;
	private int ajusteIndice = 1;

	public BackTrack() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();

	}

	private void realizarBackTrack(int fila, int columna, int suma, int pasosRestantes) {

		llamadasRecursivas++;
		caminoActual.add(new Posicion(fila, columna));

		// Caso base: llegó al destino
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
		} else {

			// Movimiento hacia abajo
			if (tablero.verificarLimitesTablero(fila + ajusteIndice, columna)) {
				realizarBackTrack(fila + ajusteIndice, columna,
						suma + tablero.obtenerValorTablero(fila + ajusteIndice, columna),
						pasosRestantes - ajusteIndice);
			}

			// Movimiento hacia derecha
			if (tablero.verificarLimitesTablero(fila, columna + ajusteIndice)) {
				realizarBackTrack(fila, columna + ajusteIndice,
						suma + tablero.obtenerValorTablero(fila, columna + ajusteIndice),
						pasosRestantes - ajusteIndice);
			}

			caminoActual.remove(caminoActual.size() - ajusteIndice);
		}
	}

	public void ejecutarBackTrack(int fila, int columna, int suma, int pasosRestantes) {
		tiempoInicio = System.nanoTime();
		realizarBackTrack(fila, columna, suma, pasosRestantes);
		tiempoFinal = System.nanoTime();

	}

	private double tiempoEjecucionBackTrack() {

		return (tiempoFinal - tiempoInicio) / tiempoMilisegundos;
	}

	public double obtenerTiempoEjecucionBackTrack() {
		return tiempoEjecucionBackTrack();
	}

	public void setTablero(TableroElectronico tablero) {
		this.tablero = tablero;
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