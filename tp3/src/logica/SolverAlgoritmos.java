package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//EN ESTA CLASE SE RESUELVEN LOS ALGORITMOS DE BACKTRACKING Y FUERZA BRUTA

public class SolverAlgoritmos {

	private int llamadasRecursivas;
	
	private long tiempoInicio, tiempoFinal;
	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;
	private boolean poda;
	//Setear: 
	private int ajusteIndice = 1;
	private double tiempoMilisegundos = 1_000_000.0;

	public SolverAlgoritmos() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();

	}

	private void realizarAlgoritmo(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {

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

		if (poda && Math.abs(suma) > pasosRestantes) {
			caminoActual.remove(caminoActual.size() - ajusteIndice);
			return;
		}

		// Movimiento p abajo
		if (tablero.verificarLimitesTablero(fila + ajusteIndice, columna)) {
			realizarAlgoritmo(fila + ajusteIndice, columna,
					suma + tablero.obtenerValorTablero(fila + ajusteIndice, columna), pasosRestantes - ajusteIndice,
					tablero);
		}

		// Movimiento p derecha
		if (tablero.verificarLimitesTablero(fila, columna + ajusteIndice)) {
			realizarAlgoritmo(fila, columna + ajusteIndice,
					suma + tablero.obtenerValorTablero(fila, columna + ajusteIndice), pasosRestantes - ajusteIndice,
					tablero);
		}

		caminoActual.remove(caminoActual.size() - ajusteIndice);
		
	}

	private double tiempoEjecucionAlgoritmo() {

		return (tiempoFinal - tiempoInicio) / tiempoMilisegundos;
	}

	public void ejecutarBackTrack(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {
		poda=true;
		tiempoInicio = System.nanoTime();
		realizarAlgoritmo(fila, columna, suma, pasosRestantes, tablero);
		tiempoFinal = System.nanoTime();
		tablero.CaminosValidos(caminosValidos);

	}
	public void ejecutarFuerzaBruta(int fila, int columna, int suma, int pasosRestantes, TableroElectronico tablero) {
		poda=false;
		tiempoInicio = System.nanoTime();
		realizarAlgoritmo(fila, columna, suma, pasosRestantes, tablero);		
		tiempoFinal = System.nanoTime();
		tablero.CaminosValidos(caminosValidos);

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

}