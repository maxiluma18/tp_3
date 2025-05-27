package logica;

public class SolverTableroElectronico {
	private TableroElectronico tablero;
	BackTrack backTrack;
	FuerzaBruta fuerzaBruta;

	public SolverTableroElectronico(TableroElectronico tableroo) {
		this.tablero = tableroo;

	}

	public void resolveBacktrack() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		backTrack.ejecutarBackTrack(0, 0, valorInicial, pasosTotales);

	}

	public void resolverFuerzaBruta() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		fuerzaBruta.ejecutarFuerzaBruta(0, 0, valorInicial, pasosTotales);
	}

}
