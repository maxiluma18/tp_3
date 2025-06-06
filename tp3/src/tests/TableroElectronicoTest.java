package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logica.TableroElectronico;

public class TableroElectronicoTest {

	private TableroElectronico tablero;

	@Before
	public void setUp() {
		tablero = new TableroElectronico(4, 3);
	}

	@Test
	public void testSetearYObtenerValorTablero() {
		tablero.setearValorTablero(0, 0, 1);
		tablero.setearValorTablero(1, 1, -1);
		tablero.setearValorTablero(3, 2, 1);

		assertEquals(1, tablero.obtenerValorTablero(0, 0));
		assertEquals(-1, tablero.obtenerValorTablero(1, 1));
		assertEquals(1, tablero.obtenerValorTablero(3, 2));
	}

	@Test
	public void testVerificarLimitesTablero() {
		// adentro de los limites
		assertTrue(tablero.verificarLimitesTablero(0, 0));
		assertTrue(tablero.verificarLimitesTablero(3, 2));

		// afuera de los limites
		assertFalse(tablero.verificarLimitesTablero(4, 0)); // fila invalida
		assertFalse(tablero.verificarLimitesTablero(0, 3)); // columna invalida
		assertFalse(tablero.verificarLimitesTablero(-1, 0)); // fila negativa
		assertFalse(tablero.verificarLimitesTablero(0, -1)); // columna negativa
	}

	@Test
	public void testCantidadCaminosHorizontalesYVerticales() {
		assertEquals(4, tablero.cantCaminosHorTablero());
		assertEquals(3, tablero.cantCaminosVertTablero());
	}

}
