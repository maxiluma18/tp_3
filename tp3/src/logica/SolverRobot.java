package logica;

public class SolverRobot {
	private TableroElectronico tablero;
	private SolverAlgoritmos solverAlgoritmos;

	public SolverRobot(TableroElectronico tableroo) {
		this.tablero = tableroo;
		solverAlgoritmos = new SolverAlgoritmos();
	}

	public void resolverAlgoritmo(boolean usarPoda) {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		solverAlgoritmos.ejecutarAlgoritmo(0, 0, valorInicial, pasosTotales, tablero, usarPoda);
	}

	public SolverAlgoritmos obtenerSolver() {
		return solverAlgoritmos;
	}

}
