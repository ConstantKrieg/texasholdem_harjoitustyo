/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casinoholdem;

import casinoholdem.Vertailu;
import casinoholdem.KadenTarkistaja;
import casinoholdem.Peli;
import casinoholdem.domain.Arvo;
import casinoholdem.domain.Kortti;
import casinoholdem.domain.Maa;
import casinoholdem.domain.Pakka;
import casinoholdem.domain.Poyta;
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
public class KadenTarkistajaTest {

    public KadenTarkistajaTest() {
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
    public void kadenTarkastusToimiiJosPari() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.A);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.KUUSI);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 2 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosPari2() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.RUUTU, Arvo.Q);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.VIISI);
        Kortti j1 = new Kortti(Maa.PATA, Arvo.Q);
        Kortti j2 = new Kortti(Maa.RUUTU, Arvo.YSI);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.J);
        Kortti k2 = new Kortti(Maa.RISTI, Arvo.SEISKA);
        Kortti k3 = new Kortti(Maa.RUUTU, Arvo.KASI);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.RISTI, Arvo.KUUSI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();
        int apu2 = p.getDealer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 1) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosKicker() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.RUUTU, Arvo.K);
        Kortti p2 = new Kortti(Maa.RUUTU, Arvo.VIISI);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.RISTI, Arvo.KYMPPI);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.RUUTU, Arvo.KOLME);
        Kortti k4 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.KASI);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 1 && p.getPlayer().getKorkeinKortti() == 14) {
            x = true;
        }

        assertEquals(apu, 1);
    }

    @Test
    public void kadenTarkastusToimiiJosKaksiParia() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.KUUSI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 3 && p.getPlayer().getKorkeinKortti() == 13) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosKolmoset() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.A);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 4 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosSuora() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.KYMPPI);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 5 && p.getPlayer().getKorkeinKortti() == 14) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosVari() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        assertEquals(6, apu);

    }

    @Test
    public void kadenTarkastusToimiiJosTayskasi() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.PATA, Arvo.J);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 7 && p.getPlayer().getKorkeinKortti() == 11) {
            x = true;
        }

        assertEquals(true, x);
    }

    @Test
    public void kadenTarkastusToimiiJosNeloset() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.K);
        Kortti p2 = new Kortti(Maa.RISTI, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.RUUTU, Arvo.K);
        Kortti k2 = new Kortti(Maa.HERTTA, Arvo.KASI);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.NELJÄ);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 8 && p.getPlayer().getKorkeinKortti() == 13) {
            x = true;
        }

        assertEquals(true, x);

    }

    @Test
    public void kadenTarkastusToimiiJosVarisuora() throws Exception {
        Peli p = new Peli();
        Vertailu v = new Vertailu(p);
        KadenTarkistaja kt = new KadenTarkistaja(v);

        Kortti p1 = new Kortti(Maa.HERTTA, Arvo.J);
        Kortti p2 = new Kortti(Maa.HERTTA, Arvo.K);

        p.getPlayer().annaKortti(p1);
        p.getPlayer().annaKortti(p2);

        Kortti k1 = new Kortti(Maa.HERTTA, Arvo.A);
        Kortti k2 = new Kortti(Maa.RUUTU, Arvo.J);
        Kortti k3 = new Kortti(Maa.HERTTA, Arvo.KYMPPI);
        Kortti k4 = new Kortti(Maa.PATA, Arvo.K);
        Kortti k5 = new Kortti(Maa.HERTTA, Arvo.Q);

        p.getTable().setFlop(k1, k2, k3);
        p.getTable().setTurn(k4);
        p.getTable().setRiver(k5);

        kt.tarkistaKasi(p.getPlayer());
        int apu = p.getPlayer().getKasi().getKadenArvo();

        boolean x = false;
        if (apu == 9 && p.getPlayer().getKorkeinKortti() == 14) {
            x = true;
        }

        assertEquals(true, x);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
