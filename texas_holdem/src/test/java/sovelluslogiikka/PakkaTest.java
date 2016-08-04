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
public class PakkaTest {

    public PakkaTest() {
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
    public void pakkaOikeanKokoinen() {
        Pakka p = new Pakka();
        assertEquals(p.getKoko(), 52);
    }

    @Test
    public void kortinPolttoToimii() {
        Pakka p = new Pakka();
        p.poltaKortti();

        assertEquals(p.getKoko(), 51);
    }

    

    @After
    public void tearDown() {
    }

}
