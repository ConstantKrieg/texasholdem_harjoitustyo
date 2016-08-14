/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Pakka;
import domain.Kortti;
import domain.Poyta;
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
public class PoytaTest {

    public PoytaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Poyta p = new Poyta();
    }

    @Test
    public void flopToimii() {
        Poyta p = new Poyta();
        Pakka pa = new Pakka();
        Kortti x = pa.getPakka().get(0);
        Kortti y = pa.getPakka().get(1);
        Kortti z = pa.getPakka().get(2);

        p.setFlop(x, y, z);

        assertEquals(p.getFlop()[1], y);

    }

    @After
    public void tearDown() {
    }

}
