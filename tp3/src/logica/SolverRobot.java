package logica;

public class SolverRobot {
	private TableroElectronico tablero;
	BackTrack backTrack;
	FuerzaBruta fuerzaBruta;

	public SolverRobot(TableroElectronico tableroo) {
		this.tablero = tableroo;

	}

	public void resolveBacktrack() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		backTrack.ejecutarBackTrack(0, 0, valorInicial, pasosTotales, tablero);
		tablero.CaminosValidosBackTrack(backTrack.getCaminosValidos());
	}

	public void resolverFuerzaBruta() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		fuerzaBruta.ejecutarFuerzaBruta(0, 0, valorInicial, pasosTotales, tablero);
		tablero.CaminosValidosFuerzaBruta(fuerzaBruta.getCaminosValidos());
	}
}
