package logica;

public class Grilla {
	private int[][] matriz;

	public Grilla(int fila, int columna) {
		matriz = new int[fila][columna];
	}

	private boolean verificarLimitesGrilla(int fila, int columna) {
		return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
	}

	private int valorGrilla(int fila, int columna) {
		return matriz[fila][columna];
	}

	private int cantFilasGrilla() {
		return matriz.length;
	}

	private int cantColumnasGrilla() {
		return matriz[0].length;
	}

	private void SetearValorGrilla(int fila, int columna, int valor) {
		matriz[fila][columna] = valor;
	}

	public boolean obtenerLimitesGrilla(int fila, int columna) {
		return verificarLimitesGrilla(fila, columna);
	}

	public int obtenerValorGrilla(int fila, int columna) {
		return valorGrilla(fila, columna);

	}

	public int obtenerCantFilasGrilla() {
		return cantFilasGrilla();
	}

	public int obtenerCantColumnasGrilla() {
		return cantColumnasGrilla();
	}

	public void obtenerSetValorGrilla(int fila, int columna, int valor) {
		SetearValorGrilla(fila, columna, valor);
	}


}
