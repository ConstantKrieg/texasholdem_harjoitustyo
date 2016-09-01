/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.Vertailu;
import casinoholdem.Peli;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import casinoholdem.domain.Arvo;
import casinoholdem.domain.Kasi;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Maa;
import casinoholdem.domain.Pakka;
import casinoholdem.domain.Pelaaja;
import casinoholdem.domain.Poyta;

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

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void voittajanPaattaminenToimii() {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti j2 = new Kortti(Maa.RUUTU, Arvo.A);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.RISTI, Arvo.K);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        p.paataVoittaja();
        int apu = p.getVoittaja();

        assertEquals(2, apu);
    }

    @Test
    public void voittajanPaattaminenToimiiJosJakajaPoydassa() {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti j2 = new Kortti(Maa.RUUTU, Arvo.Q);

        p.getPlayer().annaKortti(p1);
        p.getDealer().annaKortti(j1);
        p.getPlayer().annaKortti(p2);
        p.getDealer().annaKortti(j2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.RISTI, Arvo.K);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        p.paataVoittaja();
        int apu = p.getVoittaja();

        assertEquals(1, apu);
    }

    @Test
    public void voittajanPaattaminenToimiiJosJakajaVoittaa() {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.VIISI);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti j2 = new Kortti(Maa.RUUTU, Arvo.Q);

        p.getPlayer().annaKortti(j1);
        p.getDealer().annaKortti(p1);
        p.getPlayer().annaKortti(j2);
        p.getDealer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.RISTI, Arvo.K);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        p.paataVoittaja();
        int apu = p.getVoittaja();

        assertEquals(-1, apu);
    }
    
    
    @Test
    public void voittajanPaattaminenToimiiJosTasapeli() {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.Q);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.Q);
        Kortti j2 = new Kortti(Maa.RUUTU, Arvo.Q);

        p.getPlayer().annaKortti(j1);
        p.getDealer().annaKortti(p1);
        p.getPlayer().annaKortti(j2);
        p.getDealer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.SEISKA);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.YSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k4 = new Kortti(Maa.RISTI, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.RISTI, Arvo.K);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        p.paataVoittaja();
        int apu = p.getVoittaja();

        assertEquals(0, apu);
    }
    
    @Test
    public void korttienJakaminenToimii() throws Exception {
        Peli p = new Peli();
        p.jaaKortit();
        boolean testi = false;
        if(!p.getTable().getFlop().equals(null) && !p.getTable().getFlop().equals(null) && !p.getTable().getRiver().equals(null) && !p.getDealer().getTaskut().isEmpty() && !p.getPlayer().getTaskut().isEmpty()){
            testi = true;
        }

        assertEquals(true, testi);
    }
    
    @Test
    public void alustusToimii() throws Exception {
        Peli p = new Peli();
        p.getDealer().setKasi(Kasi.PARI);
        p.getPlayer().setKasi(Kasi.PARI);
        boolean testi = false;
        p.jaaKortit();
        if(p.getPlayer().getKasi().equals(Kasi.KICKER) && p.getDealer().getKasi().equals(Kasi.KICKER)){
            testi = true;
        }

        assertEquals(true, testi);
    }

}
