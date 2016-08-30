/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem.domain;

import java.awt.Color;
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
    public void kortinLuominenOnnistuu() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);

        assertEquals(k.getArvo(), 11);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosRistiJaKuvakortti() {
        Maa m = Maa.RISTI;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);
        String apu = "J" + "\u2663";

        assertEquals(k.toString(), apu);
    }
    
    
    @Test
    public void kortinTulostusOnnistuuJosHerttaJaKuvakortti() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);
        String apu = "J" + "\u2665";

        assertEquals(k.toString(), apu);
    }
    
    
    @Test
    public void kortinTulostusOnnistuuJosPataJaKuvakortti() {
        Maa m = Maa.PATA;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);
        String apu = "J" + "\u2660";

        assertEquals(k.toString(), apu);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosRuutuJaKuvakortti() {
        Maa m = Maa.RUUTU;
        Arvo a = Arvo.J;

        Kortti k = new Kortti(m, a);
        String apu = "J" + "\u2666";

        assertEquals(k.toString(), apu);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosHerttaJaEiKuvakortti() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.KASI;

        Kortti k = new Kortti(m, a);
        String apu = "8" + "\u2665";

        assertEquals(k.toString(), apu);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosRuutuJaEiKuvakortti() {
        Maa m = Maa.RUUTU;
        Arvo a = Arvo.KASI;

        Kortti k = new Kortti(m, a);
        String apu = "8" + "\u2666";

        assertEquals(k.toString(), apu);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosPataJaEiKuvakortti() {
        Maa m = Maa.PATA;
        Arvo a = Arvo.KASI;

        Kortti k = new Kortti(m, a);
        String apu = "8" + "\u2660";

        assertEquals(k.toString(), apu);
    }
    
    @Test
    public void kortinTulostusOnnistuuJosRISTIJaEiKuvakortti() {
        Maa m = Maa.RISTI;
        Arvo a = Arvo.KASI;

        Kortti k = new Kortti(m, a);
        String apu = "8" + "\u2663";

        assertEquals(k.toString(), apu);
    }
    
    
    @Test
    public void varinAsetusToimii() {
        Maa m = Maa.HERTTA;
        Arvo a = Arvo.KASI;

        Kortti k = new Kortti(m, a);
        

        assertEquals(k.getVari(), Color.RED);
    }
    
    
    

    @After
    public void tearDown() {
    }

}
