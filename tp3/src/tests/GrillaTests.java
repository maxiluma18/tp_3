package tests;

import logica.Grilla;
import static org.junit.Assert.*;

import org.junit.Test;

public class GrillaTests {
	@Test
	public void testSetearYObtenerValor() {
		Grilla g = new Grilla(2, 2);
		g.obtenerSetValorGrilla(0, 0, 1);
		g.obtenerSetValorGrilla(0, 1, -1);
		g.obtenerSetValorGrilla(1, 0, -1);
		g.obtenerSetValorGrilla(1, 1, 1);
		assertEquals(1, g.obtenerValorGrilla(0, 0));
		assertEquals(-1, g.obtenerValorGrilla(0, 1));
		assertEquals(-1, g.obtenerValorGrilla(1, 0));
		assertEquals(1, g.obtenerValorGrilla(1, 1));
	}

	@Test
	public void testEstaDentro() {
		Grilla g = new Grilla(3, 3);
		assertTrue(g.obtenerLimitesGrilla(0, 0));
		assertTrue(g.obtenerLimitesGrilla(2, 2));
		assertFalse(g.obtenerLimitesGrilla(-1, 0));
		assertFalse(g.obtenerLimitesGrilla(0, 3));
		assertFalse(g.obtenerLimitesGrilla(3, 0));
	}

	@Test
	public void testCantFilasYColumnas() {
		Grilla g = new Grilla(4, 5);
		assertEquals(4, g.obtenerCantFilasGrilla());
		assertEquals(5, g.obtenerCantColumnasGrilla());
	}

}
