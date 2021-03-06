/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim
 */
public class PelaajaTest {

    public PelaajaTest() {
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

    @After
    public void tearDown() {
    }

    @Test
    public void kortinAntaminenToimii() {
        Maa maa = Maa.HERTTA;
        Arvo a = Arvo.A;

        Kortti k = new Kortti(maa, a);
        Pelaaja p = new Pelaaja();

        p.annaKortti(k);

        assertEquals(p.getTaskut().get(0), k);
    }

    @Test
    public void kadenAntaminenToimii() {
        Kasi k = Kasi.NELOSET;
        Pelaaja p = new Pelaaja();

        p.setKasi(k);
        assertEquals(p.getKasi(), k);
    }
    
    @Test
    public void panoksenTarkistusToimiiJosEiSopiva() {
        Pelaaja p = new Pelaaja();
        boolean apu = p.onkoSopivaPanos(600);
        
        assertEquals(false, apu);
    }
    
    @Test
    public void panoksenTarkistusToimiiJosSopiva() {
        Pelaaja p = new Pelaaja();
        boolean apu = p.onkoSopivaPanos(400);
        
        assertEquals(true, apu);
    }
    
    @Test
    public void panoksenVastaanottaminenToimii() {
        Pelaaja p = new Pelaaja();
        p.vastaanotaVoitot(100);
        
        assertEquals(p.getPanokset(), 2100);
    }
}
