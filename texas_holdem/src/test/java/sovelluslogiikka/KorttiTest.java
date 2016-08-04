/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tokito
 */
public class KorttiTest {

    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void tulostettuOikeinJosEiKuvakortti() {
        Maa m = Maa.RISTI;
        Arvo a = Arvo.KUUSI;

        Kortti k = new Kortti(m, a);
        assertEquals(k.toString(), "Risti 6");
    }

    @Test
    public void tulostettuOikeinJosKuvakortti() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);
        assertEquals(k.toString(), "Hertta J");
    }

    @Test
    public void kortinLuominenOnnistuu() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);

        assertEquals(k.getArvo(), 11);
    }

    @After
    public void tearDown() {
    }

}
