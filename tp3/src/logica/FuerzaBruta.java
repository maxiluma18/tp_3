package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuerzaBruta {

	private int llamadasRecursivas;
	private int caminosPosibles;
	private int ajusteIndice = 1;
	private double tiempoMilisegundos = 1_000_000.0;
	private long tiempoInicio, tiempoFinal;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;

	public FuerzaBruta() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();

	}

	private void realizarFuerzaBruta(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {

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

		// Movimiento hacia abajo
		if (tablero.verificarLimitesTablero(fila + ajusteIndice, columna)) {
			realizarFuerzaBruta(fila + ajusteIndice, columna,
					suma + tablero.obtenerValorTablero(fila + ajusteIndice, columna), pasosRestantes - ajusteIndice,
					tablero);
		}

		// Movimiento hacia derecha
		if (tablero.verificarLimitesTablero(fila, columna + ajusteIndice)) {
			realizarFuerzaBruta(fila, columna + ajusteIndice,
					suma + tablero.obtenerValorTablero(fila, columna + ajusteIndice), pasosRestantes - ajusteIndice,
					tablero);
		}

		caminoActual.remove(caminoActual.size() - ajusteIndice);
	}

	public void ejecutarFuerzaBruta(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {
		tiempoInicio = System.nanoTime();
		realizarFuerzaBruta(fila, columna, suma, pasosRestantes, tablero);
		tiempoFinal = System.nanoTime();

	}

	private double tiempoEjecucionFuerzaBruta() {
		return (tiempoFinal - tiempoInicio) / tiempoMilisegundos;
	}

	public double obtenerTiempoEjecucionFuerzaBruta() {
		return tiempoEjecucionFuerzaBruta();
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
