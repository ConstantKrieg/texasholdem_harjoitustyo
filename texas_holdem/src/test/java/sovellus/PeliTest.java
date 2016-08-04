/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovelluslogiikka.Pakka;
import sovelluslogiikka.Pelaaja;
import sovelluslogiikka.Poyta;

/**
 *
 * @author Kim
 */
public class PeliTest {

    public PeliTest() {
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
    public void pelaajienMaaraOikea() {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po, 3);
        p.alustaPelaajat();
        List<Pelaaja> lista = p.getPlayers();
        assertEquals(lista.size(), 3);
    }
    
    @Test
    public void kortitMenevatOikenPelaajille() throws Exception{
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po, 3);
        p.alustaPelaajat();
        p.jaaKortit();
        
        Pelaaja pe = p.getPlayers().get(0);
        
        assertEquals(pe.getTaskut().size(), 2);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
