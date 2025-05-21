package logica;

public class Grilla {
	private int[][] matriz;
	private int filas;
	private int columnas;

	public Grilla(int n, int m) {
		this.filas = n;
		this.columnas = m;
		matriz = new int[n][m];
	}

	public boolean estaDentro(int fila, int columna) {
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

	public void SetearValor(int fila, int columna, int valor) {
		matriz[fila][columna] = valor;
	}

	// SYSOUT
	public void imprimir() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean esGrillaPar(int filas, int columnas) {
		return ((filas + columnas - 1) % 2 == 0);
	}

}
