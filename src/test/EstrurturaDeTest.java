package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import estruturaDeDados.EstruradeDadosBuild;
import estruturaDeDados.EstruturaElementar;

public class EstrurturaDeTest {

    private EstruturaElementar e;

    @Before
    public void setUp() throws Exception {
        e = EstruradeDadosBuild.buildLista();
    }

    @Test
    public void testInsere() {
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
        e.insereElemento(0);
        e.insereElemento(1);
        e.insereElemento(2);
        e.insereElemento(3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
    }

    @Test
    public void testRemove() {
        e.insereElemento(0);
        e.insereElemento(1);
        e.insereElemento(2);
        e.insereElemento(3);
        assertTrue("Não encontrado " + 0, e.buscaElemento(0));
        assertTrue("Não encontrado " + 1, e.buscaElemento(1));
        assertTrue("Não encontrado " + 2, e.buscaElemento(2));
        assertTrue("Não encontrado " + 3, e.buscaElemento(3));

        e.remove(3);
        e.remove(5);
        e.remove(-1);
        assertFalse("Encontrado " + 3, e.buscaElemento(3));
        assertFalse("Encontrado " + 5, e.buscaElemento(5));
        assertFalse("Encontrado " + -1, e.buscaElemento(-1));
        e.remove(3);
        assertFalse("Encontrado " + 3, e.buscaElemento(3));
    }

    @Test
    public void testMaxMin() {
        e.insereElemento(0);
        e.insereElemento(1);
        e.insereElemento(2);
        e.insereElemento(3);
        assertEquals(3, e.maximo());
        assertEquals(0, e.minimo());
        e.insereElemento(10);
        e.insereElemento(-10);
        assertEquals(10, e.maximo());
        assertEquals(-10, e.minimo());
    }
}
