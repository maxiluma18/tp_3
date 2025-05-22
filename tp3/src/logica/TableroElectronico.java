package logica;

import java.util.List;
import java.util.Map;

public class TableroElectronico {

	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidos;
	private static Grilla tablero;

	public TableroElectronico(int caminoHorizontal, int caminoVertical) {
		tablero = new Grilla(caminoHorizontal, caminoVertical);

	}

	public boolean verificarLimitesTablero(int caminoHorizontal, int caminoVertical) {
		return tablero.verificarLimitesGrilla(caminoHorizontal, caminoVertical);

	}

	public int obtenerValorTablero(int caminoHorizontal, int caminoVertical) {
		return tablero.ObtenerValorGrilla(caminoHorizontal, caminoVertical);
	}

	public int cantCaminosHorTablero() {
		return tablero.CantFilasGrilla();
	}

	public int cantCaminosVertTablero() {
		return tablero.CantColumnasGrilla();
	}

	public void setearValorTablero(int caminoHorizontal, int caminoVertical, int valor) {
		tablero.SetearValorGrilla(caminoHorizontal, caminoVertical, valor);
	}

	public static boolean verificarParidadTablero(int caminoHorizontal, int caminoVertical) {
		return tablero.verificarParidadGrilla(caminoHorizontal, caminoVertical);
	}

	public List<Posicion> obtenerCaminoActual(){
		return caminoActual;
	}
	public Map<Integer,List<Posicion>> obtenerCaminosValidos(){
		return caminosValidos;
	}
}
