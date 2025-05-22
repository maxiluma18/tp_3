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
 
	public BackTrack() {
		caminoActual = new ArrayList<Posicion>();
		caminosValidos = new HashMap<Integer, List<Posicion>>();
		
	}

	private void realizarBackTrack(int fila, int columna, int suma, int pasosRestantes) {

		llamadasRecursivas++;
		caminoActual.add(new Posicion(fila, columna));

		// Caso base: llegó al destino
		if (fila == tablero.cantCaminosHorTablero() - 1 && columna == tablero.cantCaminosVertTablero() - 1) {
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
		if (Math.abs(suma) > pasosRestantes) {
			caminoActual.remove(caminoActual.size() - 1);
			return;
		}

		// Movimiento hacia abajo
		if (tablero.verificarLimitesTablero(fila + 1, columna)) {
			realizarBackTrack(fila + 1, columna, suma + tablero.obtenerValorTablero(fila + 1, columna),
					pasosRestantes - 1);
		}

		// Movimiento hacia derecha
		if (tablero.verificarLimitesTablero(fila, columna + 1)) {
			realizarBackTrack(fila, columna + 1, suma + tablero.obtenerValorTablero(fila, columna + 1),
					pasosRestantes - 1);
		}

		caminoActual.remove(caminoActual.size() - 1);
	}

	public void ejecutarBackTrack(int fila, int columna, int suma, int pasosRestantes) {
		realizarBackTrack(fila, columna, suma, pasosRestantes);
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