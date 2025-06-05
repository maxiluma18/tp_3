package logica;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class TableroElectronico {

	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;
	private static Grilla grilla;
	public TableroElectronico(int caminoHorizontal, int caminoVertical) {
		caminoHorizontal = verificarParidad(caminoHorizontal, caminoVertical);
		grilla = new Grilla(caminoHorizontal, caminoVertical);
	}

	public boolean verificarLimitesTablero(int caminoHorizontal, int caminoVertical) {
		return grilla.obtenerLimitesGrilla(caminoHorizontal, caminoVertical);

	}
	public int obtenerValorTablero(int caminoHorizontal, int caminoVertical) {
		return grilla.obtenerValorGrilla(caminoHorizontal, caminoVertical);
	}

	public int cantCaminosHorTablero() {
		return grilla.obtenerCantFilasGrilla();
	}

	public int cantCaminosVertTablero() {
		return grilla.obtenerCantColumnasGrilla();
	}

	public void setearValorTablero(int caminoHorizontal, int caminoVertical, int valor) {
		grilla.obtenerSetValorGrilla(caminoHorizontal, caminoVertical, valor);
	}

	private static boolean verificarParidadTablero(int caminoHorizontal, int caminoVertical) {
		return ((caminoHorizontal * caminoVertical) % 2 != 0);
	}
	private int verificarParidad(int caminoHo, int caminoVer) {
		if(verificarParidadTablero(caminoHo, caminoVer)) {
			caminoHo++;
		}
		return  caminoHo;
	}
	public void CaminosValidos(Map<Integer, List<Posicion>> caminos) {
		caminosValidos = caminos;
	}

	public void elegirCaminoActual(Integer num) {
		caminoActual = caminosValidos.get(num);
	}

	public Posicion obtenerCoordena(Integer num) {
		return caminoActual.get(num);
	}
	public int[][] generarYSetearValoresAleatorios(int filas, int columnas, RandomNumeros random) {
		int[][] valores = new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				int valor = random.darNumeroAleatorio0ò1(2);
				if (valor == 0)
					valor = -1;
				valores[i][j] = valor;
				setearValorTablero(i, j, valor);
			}
		}
		return valores;
	}
}
