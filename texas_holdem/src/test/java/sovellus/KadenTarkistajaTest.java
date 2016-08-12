/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import domain.Arvo;
import domain.Kortti;
import domain.Maa;
import domain.Pakka;
import domain.Poyta;
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
    public void kadenTarkastusToimiiJosKaksiParia() throws Exception {
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
        Pakka pa = new Pakka();
        Poyta po = new Poyta();

        Peli p = new Peli(pa, po);
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
