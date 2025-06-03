package logica;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class TableroElectronico {

	private List<Posicion> caminoActual;
	private Map<Integer, List<Posicion>> caminosValidosFb;
	private Map<Integer, List<Posicion>> caminosValidosBt;
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
	public void CaminosValidosBackTrack(Map<Integer, List<Posicion>> caminos) {
		caminosValidosBt = caminos;
	}
	public void CaminosValidosFuerzaBruta(Map<Integer, List<Posicion>> caminos) {
		caminosValidosFb = caminos;
	}
	
	public void elegirCaminoActualFb(Integer num) {
		caminoActual = caminosValidosFb.get(num);
	}
	public void elegirCaminoActualBt(Integer num) {
		caminoActual = caminosValidosBt.get(num);
	}
	public Posicion obtenerCoordena(Integer num) {
		return caminoActual.get(num);
	}
	
}
