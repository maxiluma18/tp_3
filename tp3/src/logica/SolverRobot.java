package logica;

public class SolverRobot {
	private TableroElectronico tablero;
	private LogicaSolver logicaSolver;

	public SolverRobot(TableroElectronico tableroo) {
		this.tablero = tableroo;
		logicaSolver = new LogicaSolver();
	}

	public void resolverAlgoritmoPoda() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		logicaSolver.ejecutarAlgoritmo(0, 0, valorInicial, pasosTotales, tablero, true);
	}

	public void resolverAlgoritmoNoPoda() {

		int valorInicial = tablero.obtenerValorTablero(0, 0);
		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		logicaSolver.ejecutarAlgoritmo(0, 0, valorInicial, pasosTotales, tablero, false);
	}
	
	public LogicaSolver obtenerSolver() {
		return logicaSolver;
	}

}
