package logica;

public class Grilla {
	private int[][] matriz;

	public Grilla(int fila, int columna) {
		matriz = new int[fila][columna];
	}

	public boolean verificarLimitesGrilla(int fila, int columna) {
		return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
	}

	public int ObtenerValorGrilla(int fila, int columna) {
		return matriz[fila][columna];
	}

	public int CantFilasGrilla() {
		return matriz.length;
	}

	public int CantColumnasGrilla() {
		return matriz[0].length;
	}

	public void SetearValorGrilla(int fila, int columna, int valor) {
		matriz[fila][columna] = valor;
	}

	public boolean verificarParidadGrilla(int filas, int columnas) {
		return ((filas + columnas - 1) % 2 == 0);
	}

}
