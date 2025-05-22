package tests;

import logica.Grilla;
import static org.junit.Assert.*;

import org.junit.Test;

public class GrillaTests {
	@Test
	public void testSetearYObtenerValor() {
		Grilla g = new Grilla(2, 2);
		g.SetearValorGrilla(0, 0, 1);
		g.SetearValorGrilla(0, 1, -1);
		g.SetearValorGrilla(1, 0, -1);
		g.SetearValorGrilla(1, 1, 1);
		assertEquals(1, g.ObtenerValorGrilla(0, 0));
		assertEquals(-1, g.ObtenerValorGrilla(0, 1));
		assertEquals(-1, g.ObtenerValorGrilla(1, 0));
		assertEquals(1, g.ObtenerValorGrilla(1, 1));
	}

	@Test
	public void testEstaDentro() {
		Grilla g = new Grilla(3, 3);
		assertTrue(g.verificarLimitesGrilla(0, 0));
		assertTrue(g.verificarLimitesGrilla(2, 2));
		assertFalse(g.verificarLimitesGrilla(-1, 0));
		assertFalse(g.verificarLimitesGrilla(0, 3));
		assertFalse(g.verificarLimitesGrilla(3, 0));
	}

	@Test
	public void testCantFilasYColumnas() {
		Grilla g = new Grilla(4, 5);
		assertEquals(4, g.CantFilasGrilla());
		assertEquals(5, g.CantColumnasGrilla());
	}

}
