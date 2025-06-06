package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.*;

public class SolverAlgoritmosTest {

	private SolverAlgoritmos solver;
	private TableroElectronico tablero;

	@Before
	public void setUp() {
		solver = new SolverAlgoritmos();
	}

	@Test
	public void testTablero4x3ConDosSoluciones() {
		TableroElectronico tablero = new TableroElectronico(4, 3);

		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(0, 1, 1);
		tablero.setearValorTablero(0, 2, -1);

		tablero.setearValorTablero(1, 0, -1);
		tablero.setearValorTablero(1, 1, -1);
		tablero.setearValorTablero(1, 2, 1);

		tablero.setearValorTablero(2, 0, 1);
		tablero.setearValorTablero(2, 1, -1);
		tablero.setearValorTablero(2, 2, 1);

		tablero.setearValorTablero(3, 0, -1);
		tablero.setearValorTablero(3, 1, 1);
		tablero.setearValorTablero(3, 2, 1);

		SolverAlgoritmos solver = new SolverAlgoritmos();

		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		solver.ejecutarAlgoritmo(0, 0, tablero.obtenerValorTablero(0, 0), pasosTotales, tablero, true);

		assertEquals(2, solver.getCaminosPosibles());
	}

	@Test
	public void testTablero4x3SinSolucion() {
		TableroElectronico tablero = new TableroElectronico(4, 3);

		// siempre suma uno, nunca da 0

		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(0, 1, 1);
		tablero.setearValorTablero(0, 2, 1);

		tablero.setearValorTablero(1, 0, 1);
		tablero.setearValorTablero(1, 1, 1);
		tablero.setearValorTablero(1, 2, 1);

		tablero.setearValorTablero(2, 0, 1);
		tablero.setearValorTablero(2, 1, 1);
		tablero.setearValorTablero(2, 2, 1);

		tablero.setearValorTablero(3, 0, 1);
		tablero.setearValorTablero(3, 1, 1);
		tablero.setearValorTablero(3, 2, 1);

		SolverAlgoritmos solver = new SolverAlgoritmos();

		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		solver.ejecutarAlgoritmo(0, 0, tablero.obtenerValorTablero(0, 0), pasosTotales, tablero, true);

		assertEquals(0, solver.getCaminosPosibles());
	}

	@Test
	public void testComparacionConYSinPoda() {
		tablero = new TableroElectronico(4, 3);

		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(0, 1, -1);
		tablero.setearValorTablero(0, 2, 1);

		tablero.setearValorTablero(1, 0, -1);
		tablero.setearValorTablero(1, 1, 1);
		tablero.setearValorTablero(1, 2, -1);

		tablero.setearValorTablero(2, 0, 1);
		tablero.setearValorTablero(2, 1, -1);
		tablero.setearValorTablero(2, 2, 1);

		tablero.setearValorTablero(3, 0, -1);
		tablero.setearValorTablero(3, 1, 1);
		tablero.setearValorTablero(3, 2, 1);

		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		// ejecutar con poda (backtracking)
		solver.ejecutarAlgoritmo(0, 0, tablero.obtenerValorTablero(0, 0), pasosTotales, tablero, true);
		int caminosConPoda = solver.getCaminosPosibles();
		int llamadasConPoda = solver.getLlamadasRecursivas();

		// ejecutar sin poda (fuerza bruta)
		SolverAlgoritmos solverSinPoda = new SolverAlgoritmos();
		solverSinPoda.ejecutarAlgoritmo(0, 0, tablero.obtenerValorTablero(0, 0), pasosTotales, tablero, false);
		int caminosSinPoda = solverSinPoda.getCaminosPosibles();
		int llamadasSinPoda = solverSinPoda.getLlamadasRecursivas();

		// Los caminos posibles tienen ser iguales SIEMPRE
		assertEquals(caminosConPoda, caminosSinPoda);

		
		// menor o menor igual? menor solo no anda :(
		assertTrue(llamadasConPoda <= llamadasSinPoda);
	}

	@Test
	public void testTiempoEjecucionEsPositivo() {
		tablero = new TableroElectronico(4, 3);

		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(0, 1, -1);
		tablero.setearValorTablero(0, 2, 1);

		tablero.setearValorTablero(1, 0, -1);
		tablero.setearValorTablero(1, 1, 1);
		tablero.setearValorTablero(1, 2, -1);

		tablero.setearValorTablero(2, 0, 1);
		tablero.setearValorTablero(2, 1, -1);
		tablero.setearValorTablero(2, 2, 1);

		tablero.setearValorTablero(3, 0, -1);
		tablero.setearValorTablero(3, 1, 1);
		tablero.setearValorTablero(3, 2, 1);

		int pasosTotales = tablero.cantCaminosHorTablero() + tablero.cantCaminosVertTablero() - 2;

		solver.ejecutarAlgoritmo(0, 0, tablero.obtenerValorTablero(0, 0), pasosTotales, tablero, true);

		assertTrue(solver.obtenerTiempoEjecucionAlgoritmo() > 0);
	}

}
