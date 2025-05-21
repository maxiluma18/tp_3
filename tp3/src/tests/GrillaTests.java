package tests;

import logica.Grilla;
import static org.junit.Assert.*;

import org.junit.Test;

public class GrillaTests {
    @Test
    public void testSetearYObtenerValor() {
        Grilla g = new Grilla(2, 2);
        g.SetearValor(0, 0, 1);
        g.SetearValor(0, 1, -1);
        g.SetearValor(1, 0, -1);
        g.SetearValor(1, 1, 1);
        assertEquals(1, g.ObtenerValorGrilla(0, 0));
        assertEquals(-1, g.ObtenerValorGrilla(0, 1));
        assertEquals(-1, g.ObtenerValorGrilla(1, 0));
        assertEquals(1, g.ObtenerValorGrilla(1, 1));
    }

    @Test
    public void testEstaDentro() {
        Grilla g = new Grilla(3, 3);
        assertTrue(g.estaDentro(0, 0));
        assertTrue(g.estaDentro(2, 2));
        assertFalse(g.estaDentro(-1, 0));
        assertFalse(g.estaDentro(0, 3));
        assertFalse(g.estaDentro(3, 0));
    }

    @Test
    public void testCantFilasYColumnas() {
        Grilla g = new Grilla(4, 5);
        assertEquals(4, g.CantFilasGrilla());
        assertEquals(5, g.CantColumnasGrilla());
    }

    @Test
    public void testEsGrillaPar() {
        assertTrue(Grilla.esGrillaPar(3, 2)); // 3+2-1=4 (par)
        assertFalse(Grilla.esGrillaPar(3, 3)); // 3+3-1=5 (impar)
        assertTrue(Grilla.esGrillaPar(4, 3)); // 4+3-1=6 (par)
    }
}
