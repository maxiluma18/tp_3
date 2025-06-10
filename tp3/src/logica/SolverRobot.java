package logica;

public class SolverRobot {
	private TableroElectronico tablero;
	private SolverAlgoritmos solverAlgoritmos;
	private int pasosTotales;
	private int valorInicial;
	//Parametro Formula(n+m-2):
	private int resta=2;

	public SolverRobot(TableroElectronico tableroo) {
		this.tablero = tableroo;
		solverAlgoritmos = new SolverAlgoritmos();
		valorInicial = tablero.obtenerValorTablero(0, 0);
		pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero()-resta;
	}

	public void resolverBacktrack() {
		solverAlgoritmos.ejecutarBackTrack(0, 0, valorInicial, pasosTotales, tablero);
	}
	
	public void resolverFuerzaBruta() {
		solverAlgoritmos.ejecutarFuerzaBruta(0, 0, valorInicial, pasosTotales, tablero);
	}

	public SolverAlgoritmos obtenerSolver() {
		return solverAlgoritmos;
	}

}
