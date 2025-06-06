package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logica.SolverRobot;
import logica.TableroElectronico;

public class SolverRobotTest {

	private TableroElectronico tablero;
	private SolverRobot solverRobot;

	@Before
	public void setUp() {
		tablero = new TableroElectronico(4, 3);

		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(0, 1, -1);
		tablero.setearValorTablero(0, 2, 1);

		tablero.setearValorTablero(1, 0, -1);
		tablero.setearValorTablero(1, 1, 1);
		tablero.setearValorTablero(1, 2, 1);

		tablero.setearValorTablero(2, 0, 1);
		tablero.setearValorTablero(2, 1, 1);
		tablero.setearValorTablero(2, 2, -1);

		tablero.setearValorTablero(3, 0, -1);
		tablero.setearValorTablero(3, 1, -1);
		tablero.setearValorTablero(3, 2, 1);

		solverRobot = new SolverRobot(tablero);
	}

	@Test
	public void testResolverAlgoritmoConPoda() {
		solverRobot.resolverAlgoritmo(true); // usar poda

		assertEquals(1, solverRobot.obtenerSolver().getCaminosPosibles());
	}

	@Test
	public void testResolverAlgoritmoSinPoda() {
		solverRobot.resolverAlgoritmo(false); // sin poda

		assertEquals(1, solverRobot.obtenerSolver().getCaminosPosibles());
	}

	@Test
	public void testTiempoDeEjecucionEsMayorACero() {
		solverRobot.resolverAlgoritmo(true);

		double tiempo = solverRobot.obtenerSolver().obtenerTiempoEjecucionAlgoritmo();

		boolean mayorACero = tiempo > 0.0;
		assertEquals(true, mayorACero);
	}
}
